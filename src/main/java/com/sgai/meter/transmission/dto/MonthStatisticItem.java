package com.sgai.meter.transmission.dto;

import java.util.Date;

public class MonthStatisticItem{
    private Date date;
    double deviceMonthValue; // 每月用量

    private double moneyCost;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getDeviceMonthValue() {
        return deviceMonthValue;
    }

    public void setDeviceMonthValue(double deviceMonthValue) {
        this.deviceMonthValue = deviceMonthValue;
    }

    public double getMoneyCost() {
        return moneyCost;
    }

    public void setMoneyCost(double moneyCost) {
        this.moneyCost = moneyCost;
    }
}

