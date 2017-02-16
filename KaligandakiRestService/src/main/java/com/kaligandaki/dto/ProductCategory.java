package com.kaligandaki.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_category")
public class ProductCategory {
	@Id
	@Column(name = "PRODUCT_CATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productCategoryId;

	@Column(name = "PRODUCT_CATEGORY")
	private String productCategory;

	@Column(name = "PRODUCT_SUBCATEGORY")
	private String productSubCategory;

	@Column(name = "MEASUREMENT")
	private String measurement;

	@Column(name = "COMMENT")
	private String comment;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductSubCategory() {
		return productSubCategory;
	}

	public void setProductSubCategory(String productSubCategory) {
		this.productSubCategory = productSubCategory;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
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

}
