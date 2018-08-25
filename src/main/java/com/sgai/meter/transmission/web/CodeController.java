package com.sgai.meter.transmission.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgmart.code.entity.Code;
import com.sgmart.code.entity.CodeItem;
import com.sgmart.code.service.CodeService;
import com.szx.core.web.BaseController;
import com.szx.core.web.support.CommonResponse;

import io.swagger.annotations.Api;

@Api(value = "快码管理", tags = "快码管理接口")
@RestController
@RequestMapping(value = "admin/code")
public class CodeController extends BaseController<Code>{

	@Autowired
	private CodeService codeService;
	
	@RequestMapping(value = "selectItemsByCode", method = RequestMethod.POST)
	public List<CodeItem> selectItemsByCode(String code) {
		List<CodeItem> codeItem = codeService.selectItemsByCode(code);
		return codeItem;
	}
	
	@RequestMapping(value = "addCode", method = RequestMethod.POST)
	public Code addCode(@RequestBody Code code) {
		Code c =codeService.addCode(code);
		return c;
	}
	
	@RequestMapping(value = "updateCode", method = RequestMethod.POST)
	public Code updateCode(@RequestBody Code code) {
		Code c =codeService.updateCode(code);
		return c;
	}
	
	@RequestMapping(value = "deleteCodeAndCodeItems", method = RequestMethod.POST)
	public CommonResponse deleteCodeAndCodeItems(Long id) {
		CommonResponse c =  codeService.deleteOneCascade(id);
		return c;
	}
	
	@RequestMapping(value = "bachDeleteCodeAndCodeItems", method = RequestMethod.POST)
	public CommonResponse bachDeleteCodeAndCodeItems(String strIds) {
		CommonResponse c = codeService.bachDeleteCascade(strIds);
		return c;
	}
	
}
