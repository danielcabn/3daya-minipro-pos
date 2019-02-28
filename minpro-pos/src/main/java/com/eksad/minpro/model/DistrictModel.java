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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="pos_mst_district")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=DistrictModel.class)
public class DistrictModel {
	@Id
	@Column(name="ID", columnDefinition="serial", nullable=false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pos_mst_district_seq")
	@TableGenerator(name = "pos_mst_district_seq", table = "tbl_squence", 
	pkColumnName = "seq_id", valueColumnName = "seq_value", 
	initialValue = 0, allocationSize=1)
	private Long id;

	@Column(name="region_id", nullable=false)
	private Long regionId;
	
	@Column(name="name", nullable=false, length=50)
	private String name;
	
	@Column(name="created_by", nullable=true)
	private Long createdBy;
	
	@Column(name="created_on", nullable=true)
	private Date createdOn;
	
	@Column(name="modified_by", nullable=true)
	private Long modifiedBy;
	
	@Column(name="modified_on", nullable=true)
	private Date modifiedOn;
	
	@Column(name="active", nullable=false)
	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
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

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
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
