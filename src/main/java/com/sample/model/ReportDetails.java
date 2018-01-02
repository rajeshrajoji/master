package com.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ReportDetails")
public class ReportDetails {

	private static final long serialVersionUID = 1L;

	@Id
//	@GenericGenerator(name = "increment", strategy = "increment")
	//@GeneratedValue(generator = "increment")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer reportTypeId;

	@Column(name = "reportTypeName")
	private String reportTypeName;

	public Integer getReportTypeId() {
		return reportTypeId;
	}

	public void setReportTypeId(Integer reportTypeId) {
		this.reportTypeId = reportTypeId;
	}

	public String getReportTypeName() {
		return reportTypeName;
	}

	public void setReportTypeName(String reportTypeName) {
		this.reportTypeName = reportTypeName;
	}

}
