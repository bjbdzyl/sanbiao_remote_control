package com.sgai.meter.transmission.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "household")
public class Household implements Serializable {

	@Id
	private Long id;

	private String householderName;

	private Integer population;

	private Long houseAreaId;

	private String householderPhone;

	private Date createTime;

	private Double houseArea;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHouseholderName() {
		return householderName;
	}

	public void setHouseholderName(String householderName) {
		this.householderName = householderName == null ? null : householderName.trim();
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Long getHouseAreaId() {
		return houseAreaId;
	}

	public void setHouseAreaId(Long houseAreaId) {
		this.houseAreaId = houseAreaId;
	}

	public String getHouseholderPhone() {
		return householderPhone;
	}

	public void setHouseholderPhone(String householderPhone) {
		this.householderPhone = householderPhone == null ? null : householderPhone.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Double getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(Double houseArea) {
		this.houseArea = houseArea;
	}
}