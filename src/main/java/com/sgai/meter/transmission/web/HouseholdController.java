package com.sgai.meter.transmission.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgai.meter.transmission.entity.Household;
import com.sgai.meter.transmission.service.HouseholdService;
import com.szx.core.web.BaseController;

import io.swagger.annotations.Api;

@Api(value = "住户管理", tags = "住户管理接口")
@RestController
@RequestMapping(value = "admin/household")
public class HouseholdController extends BaseController<Household> {

	@Autowired
	private HouseholdService householdService;
}
