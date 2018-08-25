package com.sgai.meter.transmission.entity;

import java.io.Serializable;

public class Statistic extends StatisticKey implements Serializable {
    private Double moneyCost;

    private Double deviceValue;

    private static final long serialVersionUID = 1L;

    public Double getMoneyCost() {
        return moneyCost;
    }

    public void setMoneyCost(Double moneyCost) {
        this.moneyCost = moneyCost;
    }

    public Double getDeviceValue() {
        return deviceValue;
    }

    public void setDeviceValue(Double deviceValue) {
        this.deviceValue = deviceValue;
    }
}