package com.kaligandaki.vo;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = -4277420740786929091L;

	private int productId;
	private String productName;
	private String productCategory;

	public Product(int productId, String productName, String productCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + "]";
	}

}
