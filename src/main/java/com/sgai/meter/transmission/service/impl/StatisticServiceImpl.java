package com.sgai.meter.transmission.service.impl;

import com.sgai.meter.transmission.dto.MonthStatisticItem;
import com.sgai.meter.transmission.dto.StatisticResult;
import com.sgai.meter.transmission.entity.Area;
import com.sgai.meter.transmission.entity.Device;
import com.sgai.meter.transmission.entity.Household;
import com.sgai.meter.transmission.entity.Statistic;
import com.sgai.meter.transmission.mapper.StatisticMapper;
import com.sgai.meter.transmission.service.AreaService;
import com.sgai.meter.transmission.service.DeviceService;
import com.sgai.meter.transmission.service.HouseholdService;
import com.sgai.meter.transmission.service.StatisticService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class StatisticServiceImpl extends AbstractMapperService<Statistic> implements StatisticService {

    public final static int AREA_LEVEL_STAGE = 0; // 一期二期等
    public final static int AREA_LEVEL_SECTION = 1;
    public final static int AREA_LEVEL_BUILDING = 2;
    public final static int AREA_LEVEL_UNIT = 3;
    public final static int AREA_LEVEL_DOOR = 4;

    @Autowired
    StatisticMapper statisticMapper;

    @Autowired
    DeviceService deviceService;

    @Autowired
    AreaService areaService;

    @Autowired
    HouseholdService householdService;

    private void setAreaInfo(String areaCode, StatisticResult result){ // 递归函数，仔细测试
        Area currArea = areaService.queryByCode(areaCode);
        if (currArea != null) {
            if (currArea.getAreaLevel() == AREA_LEVEL_STAGE){
                result.setAreaName(currArea.getAreaName());
                result.setAreaId(currArea.getId());
                return;
            }

            if (currArea.getAreaLevel() == AREA_LEVEL_SECTION){
                result.setSectionId(currArea.getId());
                result.setSectionName(currArea.getAreaName());
            }

            if (currArea.getAreaLevel() == AREA_LEVEL_UNIT){
                result.setUnitName(currArea.getAreaName());
                result.setUnitId(currArea.getId());
            }

            if (currArea.getAreaLevel() == AREA_LEVEL_DOOR){
                result.setDoorId(currArea.getId());
                result.setDoorName(currArea.getAreaName());
            }

            if (currArea.getAreaLevel() == AREA_LEVEL_BUILDING){
                result.setBuildingId(currArea.getId());
                result.setBuildingName(currArea.getAreaName());
            }

            setAreaInfo(currArea.getParentCode(), result);
        }
    }

    public List<StatisticResult> queryStatisticResults(DateTime fromTime, DateTime toTime,
                                                       String areaCode, String buildingCode,
                                                       String unitCode, String doorCode,
                                                       String houseHolderName, String houseHolderPhoneNum){

        List<StatisticResult> results = new ArrayList<>();

        for (Statistic item :
                statisticMapper.queryStatistics(fromTime, toTime)) {
            boolean bFinded = false;
            for (int i = 0; i < results.size(); i++) {
                if (item.getDeviceCode() == results.get(i).getDeviceCode()){
                    MonthStatisticItem monthStatisticItem = new MonthStatisticItem();
                    monthStatisticItem.setDate(item.getTime());
                    monthStatisticItem.setDeviceMonthValue(item.getDeviceValue());
                    monthStatisticItem.setMoneyCost(item.getMoneyCost());
                    results.get(i).addMonthStatisticItem(monthStatisticItem);
                    bFinded = true;
                    break;
                }
            }

            if (!bFinded){
                StatisticResult statisticResult = new StatisticResult();
                // 初始化首条月度统计
                MonthStatisticItem monthStatisticItem = new MonthStatisticItem();
                monthStatisticItem.setDate(item.getTime());
                monthStatisticItem.setDeviceMonthValue(item.getDeviceValue());
                monthStatisticItem.setMoneyCost(item.getMoneyCost());
                statisticResult.addMonthStatisticItem(monthStatisticItem);

                // 初始化其他字段
                statisticResult.setDeviceCode(item.getDeviceCode());

                Device device = deviceService.queryDeviceByDeviceCode(item.getDeviceCode()); // todo 查询函数待实现
                if (device != null) {
                    statisticResult.setDevState(device.getOnOff());
                    statisticResult.setDevType(device.getType());
                    statisticResult.setAreaId(device.getAreaId());

                    Area area = areaService.queryByAreaId(device.getAreaId());
                    if (area.getAreaCode() != areaCode){
                        continue;
                    }

                    setAreaInfo(area.getAreaCode(), statisticResult);
                    if (statisticResult.getDevType() == "水表"){
                        statisticResult.setCurrDevValue(device.getCumulativeWaterFlow());
                    } else if (statisticResult.getDevType() == "电表"){
                        statisticResult.setCurrDevValue(device.getCumulativeElectricalEnergy());
                    }
                }

                Household household = HouseholdService.queryHouseHolderByAreaId(device.getAreaId());
                if (household != null) {
                    statisticResult.setHouseHolderName(household.getHouseholderName());
                    statisticResult.setHouseHolderPhone(household.getHouseholderPhone());
                }

                // 如果可选条件过滤
                if ((buildingCode != null && statisticResult.getBuildingName() != buildingCode) ||
                        (unitCode != null && statisticResult.getUnitName() != unitCode) ||
                        (doorCode != null && statisticResult.getDoorName() != doorCode) ||
                        (houseHolderName != null && statisticResult.getHouseHolderName() != houseHolderName) ||
                        (houseHolderPhoneNum != null && statisticResult.getHouseHolderPhone() != houseHolderPhoneNum)) {

                    continue;
                }

                results.add(statisticResult);
            }
        }

        return null;
    }
}
