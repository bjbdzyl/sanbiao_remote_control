package com.sgai.meter.transmission.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgai.meter.transmission.entity.Device;
import com.sgai.meter.transmission.service.DeviceService;
import com.szx.core.web.BaseController;

import io.swagger.annotations.Api;

@Api(value = "设备管理", tags = "水/电表设备管理接口")
@RestController
@RequestMapping(value = "admin/device")
public class DeviceController extends BaseController<Device> {

	@Autowired
	private DeviceService deviceService;
}
