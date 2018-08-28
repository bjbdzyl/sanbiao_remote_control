package com.sgai.meter.transmission.entity;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "statistic") // todo 水表电表分开，不放一个表里
public class Statistic implements Serializable {

    private Double moneyCost; // 费用

    private Double deviceValue; // 表读数，每个月的用量

    // todo 隐患：若15分钟一条记录，两个表30天下来就是5760条记录，一个小区200户的话就是1152000条记录。一年下来就是一千多万条数据，量太大了。
    // 两个解决办法：
    // 1、月为单位记录（每月最后一天主动读数，与上个月的相减得到这个月的，不接收定时上传的读数），这样每户每年两表合计24条数据，200户小区一年只需要4800条即可满足要求。
    // 2、接收上传读数，但读数相同时只更新时间，不新增记录。数据量依旧是千万级，不推荐。

    @Id
    private String deviceCode;
    @Id
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