package com.eksad.minpro.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="pos_mst_supplier")
public class SupplierModel {
	@Id
	@Column(name="ID", columnDefinition="serial")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_mst_supplier_seq")
	@TableGenerator(name = "pos_mst_supplier_seq", table = "tbl_squence", 
	pkColumnName = "seq_id", valueColumnName = "seq_value", 
	initialValue = 0, allocationSize=1)
	private Integer ida;

	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="province_id")
	private Integer provinceId;
	
	@Column(name="region_id")
	private Integer regionId;
	
	@Column(name="district_id")
	private Integer districtId;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="modified_by")
	private Integer modifiedBy;
	
	@Column(name="modified_on")
	private Date modifiedOn;
	
	@Column(name="active")
	private Boolean active;

	public Integer getId() {
		return ida;
	}

	public void setId(Integer id) {
		this.ida = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date co = null;
		try {
			co = format.parse(createdOn); 
		} catch (Exception e) {
			this.createdOn= null;
		}
		this.createdOn = co;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModeifiedOn() {
		return modifiedOn;
	}

	public void setModeifiedOn(String modifiedOn) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date mo = null;
		try {
			mo = format.parse(modifiedOn); 
			} catch (Exception e) {
				this.modifiedOn = null;
			}
		this.modifiedOn = mo;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
		
	}
	
	
	
	
	
	