package com.kaligandaki.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mfd_company")
public class MFDCompanyDTO {

	@Id
	@Column(name = "COMPANY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "COMMENT")
	private String comment;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
