package com.sgai.meter.transmission.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgai.meter.transmission.entity.Area;
import com.sgai.meter.transmission.service.AreaService;
import com.szx.core.web.BaseController;

import io.swagger.annotations.Api;

@Api(value = "区域管理", tags = "区域管理接口")
@RestController
@RequestMapping(value = "admin/area")
public class AreaController extends BaseController<Area> {

	@Autowired
	private AreaService areaService;
}
