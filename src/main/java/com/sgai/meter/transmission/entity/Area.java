package com.sgai.meter.transmission.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "area")
@ApiModel(value = "com.sgai.meter.transmission.entity.Area", description = "区域实体")
public class Area implements Serializable {
	@Id
	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "区域编号")
	private String areaCode;

	@ApiModelProperty(value = "区域名称")
	private String areaName;

	@ApiModelProperty(value = "上级编号")
	private String parentCode;

	@ApiModelProperty(value = "上级名称")
	private String parentName;

	@ApiModelProperty(value = "id")
	private Integer areaLevel;

	@ApiModelProperty(value = "id")
	private Date createTime;

	@ApiModelProperty(value = "id")
	private String operationRecord;

	@ApiModelProperty(value = "id")
	private Long operationUserId;

	@ApiModelProperty(value = "id")
	private Date operationTime;

	@ApiModelProperty(value = "id")
	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode == null ? null : areaCode.trim();
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName == null ? null : areaName.trim();
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode == null ? null : parentCode.trim();
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName == null ? null : parentName.trim();
	}

	public Integer getAreaLevel() {
		return areaLevel;
	}

	public void setAreaLevel(Integer areaLevel) {
		this.areaLevel = areaLevel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getOperationRecord() {
		return operationRecord;
	}

	public void setOperationRecord(String operationRecord) {
		this.operationRecord = operationRecord == null ? null : operationRecord.trim();
	}

	public Long getOperationUserId() {
		return operationUserId;
	}

	public void setOperationUserId(Long operationUserId) {
		this.operationUserId = operationUserId;
	}

	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}
}