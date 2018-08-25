package com.sgai.meter.transmission.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "device")
public class Device implements Serializable {
	@Id
	private Long id;

	private String deviceCode;

	private String type;

	private String modelNumber;

	private String postalAddress;

	private Long areaId;

	private Date installTime;

	private String serialPort;

	private Boolean onOff;

	private String collectorCode;

	private String concentratorCode;

	private Date openingTime;

	private Boolean onlineState;

	private Double activeElectricalEnergy;

	private Double cumulativeElectricalEnergy;

	private Double surplusWater;

	private Double instantaneousWaterFlow;

	private Double cumulativeWaterFlow;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode == null ? null : deviceCode.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber == null ? null : modelNumber.trim();
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress == null ? null : postalAddress.trim();
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Date getInstallTime() {
		return installTime;
	}

	public void setInstallTime(Date installTime) {
		this.installTime = installTime;
	}

	public String getSerialPort() {
		return serialPort;
	}

	public void setSerialPort(String serialPort) {
		this.serialPort = serialPort == null ? null : serialPort.trim();
	}

	public Boolean getOnOff() {
		return onOff;
	}

	public void setOnOff(Boolean onOff) {
		this.onOff = onOff;
	}

	public String getCollectorCode() {
		return collectorCode;
	}

	public void setCollectorCode(String collectorCode) {
		this.collectorCode = collectorCode == null ? null : collectorCode.trim();
	}

	public String getConcentratorCode() {
		return concentratorCode;
	}

	public void setConcentratorCode(String concentratorCode) {
		this.concentratorCode = concentratorCode == null ? null : concentratorCode.trim();
	}

	public Date getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(Date openingTime) {
		this.openingTime = openingTime;
	}

	public Boolean getOnlineState() {
		return onlineState;
	}

	public void setOnlineState(Boolean onlineState) {
		this.onlineState = onlineState;
	}

	public Double getActiveElectricalEnergy() {
		return activeElectricalEnergy;
	}

	public void setActiveElectricalEnergy(Double activeElectricalEnergy) {
		this.activeElectricalEnergy = activeElectricalEnergy;
	}

	public Double getCumulativeElectricalEnergy() {
		return cumulativeElectricalEnergy;
	}

	public void setCumulativeElectricalEnergy(Double cumulativeElectricalEnergy) {
		this.cumulativeElectricalEnergy = cumulativeElectricalEnergy;
	}

	public Double getSurplusWater() {
		return surplusWater;
	}

	public void setSurplusWater(Double surplusWater) {
		this.surplusWater = surplusWater;
	}

	public Double getInstantaneousWaterFlow() {
		return instantaneousWaterFlow;
	}

	public void setInstantaneousWaterFlow(Double instantaneousWaterFlow) {
		this.instantaneousWaterFlow = instantaneousWaterFlow;
	}

	public Double getCumulativeWaterFlow() {
		return cumulativeWaterFlow;
	}

	public void setCumulativeWaterFlow(Double cumulativeWaterFlow) {
		this.cumulativeWaterFlow = cumulativeWaterFlow;
	}
}