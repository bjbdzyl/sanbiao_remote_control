package com.sgai.meter.transmission.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fee_scale")
public class FeeScale implements Serializable {

	@Id
	private Long id;

	private String energyConsumption;

	private Double intervalStart;

	private Double intervalEnd;

	private String intervalUnit;

	private Double price;

	private String priceUnit;

	private Date createTime;

	private String description;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnergyConsumption() {
		return energyConsumption;
	}

	public void setEnergyConsumption(String energyConsumption) {
		this.energyConsumption = energyConsumption == null ? null : energyConsumption.trim();
	}

	public Double getIntervalStart() {
		return intervalStart;
	}

	public void setIntervalStart(Double intervalStart) {
		this.intervalStart = intervalStart;
	}

	public Double getIntervalEnd() {
		return intervalEnd;
	}

	public void setIntervalEnd(Double intervalEnd) {
		this.intervalEnd = intervalEnd;
	}

	public String getIntervalUnit() {
		return intervalUnit;
	}

	public void setIntervalUnit(String intervalUnit) {
		this.intervalUnit = intervalUnit == null ? null : intervalUnit.trim();
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit == null ? null : priceUnit.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
}