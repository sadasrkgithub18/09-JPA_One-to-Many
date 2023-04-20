package com.ait.otm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="tbl_products1")
public class ProductEntity {
	@Id
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Lob
	@Column(name = "product_image")
	private byte[] productImage;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	
	
	

}
