package com.sgai.meter.transmission.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgmart.auth.user.entity.Function;
import com.sgmart.auth.user.service.FunctionService;
import com.szx.core.exception.DuplicateDataException;
import com.szx.core.exception.ReferencedDataException;
import com.szx.core.web.BaseController;
import com.szx.core.web.support.CommonResponse;
import com.szx.core.web.support.CommonResponseUtil;

import io.swagger.annotations.Api;

/**
 * @author ppliu
 */
@Api(value = "系统功能项管理", tags = "系统功能项管理接口")
@RestController
@RequestMapping(value = "/sys/function")
public class FunctionController extends BaseController<Function> {
	
	@Autowired
	FunctionService functionService;
	
	@RequestMapping(value = "addFunction", method = RequestMethod.POST)
	public CommonResponse addFunction(@RequestBody Function function) {
		try {
			Function f = functionService.addFunction(function);
			return CommonResponseUtil.success(f);
		} catch (DuplicateDataException e) {
			return CommonResponseUtil.exception(e.getMessage());
		}
		
	}
	
	@RequestMapping(value = "updateFunction", method = RequestMethod.POST)
	public CommonResponse updateFunction(@RequestBody Function function) {
		try {
			Function f = functionService.updateFunction(function);
			return CommonResponseUtil.success(f);
		} catch (DuplicateDataException e) {
			return CommonResponseUtil.exception(e.getMessage());
		}
		
	}
	
	@RequestMapping(value = "deleteFunction", method = RequestMethod.POST)
	public CommonResponse deleteFunction(Long functionId) {
		try {
			int i = functionService.deleteFunction(functionId);
			return CommonResponseUtil.success(i);
		} catch (ReferencedDataException e) {
			return CommonResponseUtil.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value = "deleteFunctionByForce", method = RequestMethod.POST)
	public CommonResponse deleteFunctionByForce(Long functionId, Boolean force) {
		if(null == force) {
			return CommonResponseUtil.exception("force不能为空值");
		}
		try {
			int i = functionService.deleteFunction(functionId, force);
			return CommonResponseUtil.success(i);
		} catch (ReferencedDataException e) {
			return CommonResponseUtil.exception(e.getMessage());
		}
		
	}
}
