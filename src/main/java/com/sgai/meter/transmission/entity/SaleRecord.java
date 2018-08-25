package com.sgai.meter.transmission.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sale_record")
public class SaleRecord implements Serializable {

	@Id
	private Long id;

	private Long householdId;

	private Long deviceId;

	private String energyConsumption;

	private Double price;

	private Integer timeNumber;

	private Double rechargeAmount;

	private Double purchaseQuantity;

	private Date createTime;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHouseholdId() {
		return householdId;
	}

	public void setHouseholdId(Long householdId) {
		this.householdId = householdId;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public String getEnergyConsumption() {
		return energyConsumption;
	}

	public void setEnergyConsumption(String energyConsumption) {
		this.energyConsumption = energyConsumption == null ? null : energyConsumption.trim();
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getTimeNumber() {
		return timeNumber;
	}

	public void setTimeNumber(Integer timeNumber) {
		this.timeNumber = timeNumber;
	}

	public Double getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(Double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public Double getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(Double purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}