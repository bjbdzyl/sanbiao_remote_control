package com.sgai.meter.transmission.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgmart.code.entity.CodeItem;
import com.sgmart.code.service.CodeItemService;
import com.szx.core.web.BaseController;

import io.swagger.annotations.Api;

@Api(value = "快码详细信息管理", tags = "快码详细信息管理接口")
@RestController
@RequestMapping(value = "admin/codeItem")
public class CodeItemController extends BaseController<CodeItem>{

	@Autowired
	private CodeItemService codeItemService;
	
	@RequestMapping(value = "deleteCodeItemsByStrIds", method = RequestMethod.POST)
	public String deleteCodeItemsByStrIds(String strIds) {
		String result = codeItemService.deleteByStrIds(strIds);
		return result;
	}
}
