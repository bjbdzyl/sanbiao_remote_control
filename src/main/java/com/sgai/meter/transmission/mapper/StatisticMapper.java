package com.sgai.meter.transmission.mapper;

import com.sgai.meter.transmission.entity.Statistic;
import com.szx.core.mybatis.mapper.MyBatisMapper;
import org.joda.time.DateTime;

import java.util.List;

public interface StatisticMapper extends MyBatisMapper<Statistic> {
    List<Statistic> queryStatistics(DateTime fromTime, DateTime toTime);
}
