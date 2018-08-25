package com.sgai.meter.transmission.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgai.meter.transmission.entity.FeeScale;
import com.sgai.meter.transmission.service.FeeScaleService;
import com.szx.core.web.BaseController;

import io.swagger.annotations.Api;

@Api(value = "计费管理", tags = "计费标准管理接口")
@RestController
@RequestMapping(value = "admin/feeScale")
public class FeeScaleController extends BaseController<FeeScale> {

	@Autowired
	private FeeScaleService feeScaleService;
}
