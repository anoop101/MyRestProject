package com.kaligandaki.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name="PRICE")
	private double price;
	
	@ManyToOne(optional = false, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_CATEGORY")
	private ProductCategory category;

	@ManyToOne(optional = false, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "COMPANY")
	private MFDCompany mfdCompany;

	@Column(name = "COMMENT")
	private String comment;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

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

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public MFDCompany getMfdCompany() {
		return mfdCompany;
	}

	public void setMfdCompany(MFDCompany mfdCompany) {
		this.mfdCompany = mfdCompany;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category.getProductCategoryId()
				+ ", mfdCompany=" + mfdCompany.getCompanyId() + ", comment=" + comment + ", updatedBy=" + updatedBy + "]";
	}

}
