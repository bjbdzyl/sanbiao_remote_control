package com.sgai.meter.transmission.entity;

import java.io.Serializable;
import java.util.Date;

public class StatisticKey implements Serializable {
    private String deviceCode;

    private Date time;

    private static final long serialVersionUID = 1L;

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}