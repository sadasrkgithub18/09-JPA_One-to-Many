package com.ait.otm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.ait.otm.dao.CategoryDAO;
import com.ait.otm.entities.CategoryEntity;

public class CategoryDAOImpl implements CategoryDAO {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

	@Override
	public void saveCategory(CategoryEntity entity) {
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		try {
			em.persist(entity);
			t.commit();
			System.out.println("Category with Products are persisted into Database...");
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		finally {
			em.close();
		}

	}

	@Override
	public CategoryEntity fetchCategory(Integer categoryId) {
		EntityManager em = factory.createEntityManager();
		CategoryEntity entity = em.find(CategoryEntity.class, categoryId);
		em.close();
		return entity;
	}

	@Override
	public void removeCategory(Integer categoryId) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		CategoryEntity entity = em.find(CategoryEntity.class, categoryId);
		t.begin();
		try {
			em.remove(entity);
			t.commit();
			System.out.println("category with products is removed from Database");
		}catch(Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}

	@Override
	public void testJoinQuery() 
	{
		EntityManager em = factory.createEntityManager();
		
		String jpqlQuery = "SELECT c.categoryName, "
				+ "p.productName from CategoryEntity c "
				+ "join c.lstOfProducts p";
		
		TypedQuery<Object[]> tq = em.createQuery(jpqlQuery, Object[].class);
		
		List<Object[]> lst = tq.getResultList();
		
		lst.forEach(obj ->
		{
			System.out.println(obj[0]+ "       "+obj[1]);
		}
		);
	  em.close();
	}
	
		
}
