package com.sgai.meter.transmission.web;

import com.sgai.meter.transmission.entity.Statistic;
import com.sgai.meter.transmission.service.AreaService;
import com.sgai.meter.transmission.service.DeviceService;
import com.sgai.meter.transmission.service.HouseholdService;
import com.sgai.meter.transmission.service.StatisticService;
import com.szx.core.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "数据分析", tags = "数据分析接口")
@RestController
@RequestMapping(value = "admin/statistic")
public class StatisticController extends BaseController<Statistic> {
    @Autowired
    StatisticService statisticService;

    @ApiOperation(value="查询统计数据") // 尝试支持分页逻辑
    @RequestMapping(value = "/queryStatisticInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Statistic> queryStatisticInfo(@RequestParam(value = "fromTime") DateTime fromTime,
                                              @RequestParam(value = "toTime") DateTime toTime,
                                              @RequestParam(value = "areaCode") String areaCode,
                                              @RequestParam(value = "buildingCode", required = false) String buildingCode,
                                              @RequestParam(value = "unitCode", required = false) String unitCode,
                                              @RequestParam(value = "doorCode", required = false) String doorCode,
                                              @RequestParam(value = "houseHolderName", required = false) String houseHolderName,
                                              @RequestParam(value = "houseHolderPhoneNum", required = false) String houseHolderPhoneNum){

        // TODO 用时加区号，查区表、统计表，再根据设备号查设备表得到户号，再通过户号查人。用数据库view？
        /*
        select * from
         */
        return null;
    }
}
