package com.sgai.meter.transmission.dto;

import java.util.ArrayList;
import java.util.List;

// todo 做为结果，以json列表的形式返回给前端。统计结果由多表联合查询得到
public class StatisticResult {

    private List<MonthStatisticItem> monthStatisticItemList = new ArrayList<>();
    private Long sectionId;
    private String sectionName;

    public boolean addMonthStatisticItem(MonthStatisticItem item){
        return monthStatisticItemList.add(item);
    }

    public List<MonthStatisticItem> getMonthStatisticItemList() {
        return monthStatisticItemList;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public String getHouseHolderName() {
        return houseHolderName;
    }

    public void setHouseHolderName(String houseHolderName) {
        this.houseHolderName = houseHolderName;
    }

    public String getHouseHolderPhone() {
        return houseHolderPhone;
    }

    public void setHouseHolderPhone(String houseHolderPhone) {
        this.houseHolderPhone = houseHolderPhone;
    }

    public long getAreaId() {
        return areaId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }

    public long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(long buildingId) {
        this.buildingId = buildingId;
    }

    public long getUnitId() {
        return unitId;
    }

    public void setUnitId(long unitId) {
        this.unitId = unitId;
    }

    public long getDoorId() {
        return doorId;
    }

    public void setDoorId(long doorId) {
        this.doorId = doorId;
    }

    public boolean getDevState() {
        return devState;
    }

    public void setDevState(boolean devState) {
        this.devState = devState;
    }

    public double getCurrDevValue() {
        return currDevValue;
    }

    public void setCurrDevValue(double currDevValue) {
        this.currDevValue = currDevValue;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    public boolean isDevState() {
        return devState;
    }

    private String deviceCode;
    private String devType;
    private String houseHolderName;
    private String houseHolderPhone;
    private long areaId;
    private long buildingId;
    private long unitId;
    private long doorId;
    private String areaName;
    private String buildingName;
    private String unitName;
    private String doorName;
    private boolean devState;
    private double currDevValue; // 表的当前读数

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionName() {
        return sectionName;
    }
}
