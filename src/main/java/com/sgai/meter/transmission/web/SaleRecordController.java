package com.sgai.meter.transmission.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgai.meter.transmission.entity.SaleRecord;
import com.sgai.meter.transmission.service.SaleRecordService;
import com.szx.core.web.BaseController;

import io.swagger.annotations.Api;

@Api(value = "售出记录管理", tags = "售水/售电记录管理接口")
@RestController
@RequestMapping(value = "admin/saleRecord")
public class SaleRecordController extends BaseController<SaleRecord> {

	@Autowired
	private SaleRecordService saleRecordService;
}
