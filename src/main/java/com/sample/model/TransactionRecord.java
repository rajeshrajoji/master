package com.sample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactionRecord")
public class TransactionRecord implements Serializable {

	

	private static final long serialVersionUID = 1L;

	@Id
	//@GenericGenerator(name = "increment", strategy = "increment")
	//@GeneratedValue(generator = "increment")
	@Column(name = "transactionRecordId")
	private Long id;

	@Column(name = "bankName")
	private String bankName;

	@Column(name = "nameCL")
	private String nameCL;

	@Column(name = "country")
	private String country;

	@Column(name = "countryCL")
	private String countryCL;

	@Column(name = "transactionId")
	private String transactionId;

	@Column(name = "address")
	private String address;

	@Column(name = "cleanseLevelId")
	private Integer cleanseLevelId;
	
	@Column(name = "regionId")
	private Integer regionId;
	
	@Column(name = "subregionId")
	private Integer subRegionId;
	
	@Column(name="locationId")
	private Integer locationId;
	
	
	

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Integer getSubRegionId() {
		return subRegionId;
	}

	public void setSubRegionId(Integer subRegionId) {
		this.subRegionId = subRegionId;
	}

	public Integer getCleanseLevelId() {
		return cleanseLevelId;
	}

	public void setCleanseLevelId(Integer cleanseLevelId) {
		this.cleanseLevelId = cleanseLevelId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getNameCL() {
		return nameCL;
	}

	public void setNameCL(String nameCL) {
		this.nameCL = nameCL;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCL() {
		return countryCL;
	}

	public void setCountryCL(String countryCL) {
		this.countryCL = countryCL;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "TransactionRecord [id=" + id + ", bankName=" + bankName + ", nameCL=" + nameCL + ", country=" + country
				+ ", countryCL=" + countryCL + ", transactionId=" + transactionId + ", address=" + address
				+ ", cleanseLevelId=" + cleanseLevelId + ", regionId=" + regionId + ", subRegionId=" + subRegionId
				+ "]";
	}
	

}
