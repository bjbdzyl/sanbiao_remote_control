package com.sgai.meter.transmission.web;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sgmart.auth.user.entity.Role;
import com.sgmart.auth.user.service.RoleService;
import com.szx.core.exception.DuplicateDataException;
import com.szx.core.exception.ReferencedDataException;
import com.szx.core.web.QueryController;
import com.szx.core.web.support.CommonResponse;
import com.szx.core.web.support.CommonResponseUtil;

import io.swagger.annotations.Api;
/**
 * 角色管理.
 * 
 * @author ppliu
 *
 */
@Api(value = "系统角色管理", tags = "系统角色管理接口")
@RestController
@RequestMapping(value = "/sys/role")
public class RoleController extends QueryController<Role>{
	
	@Resource
	RoleService roleService;

	@RequestMapping(value = "getRoleByUserName", method = RequestMethod.POST)
	public List<Role> getRoleByUserName(String userName) {
		List<Role> list = roleService.getRoleByUserName(userName);
		return list;
	}
	
	@RequestMapping(value = "getRoleByUserId", method = RequestMethod.POST)
	public List<Role> getRoleByUserId(Long userId) {
		List<Role> list = roleService.getRoleByUserId(userId);
		return list;
	}
	
	@RequestMapping(value = "addRole", method = RequestMethod.POST)
	public CommonResponse addRole(@RequestBody Role role) {
		try {
			Role r = roleService.addRole(role);
			return CommonResponseUtil.success(r);
		} catch (DuplicateDataException e) {
			return CommonResponseUtil.exception(e.getMessage());
		}
		
	}
	
	@RequestMapping(value = "updateRole", method = RequestMethod.POST)
	public CommonResponse updateRole(@RequestBody Role role) {
		try {
			roleService.updateByPrimaryKeySelective(role);
		} catch (Exception e) {
			return CommonResponseUtil.exception(e.getMessage());
		}
		return CommonResponseUtil.success(role) ;
	}
	
	@RequestMapping(value = "deleteRole", method = RequestMethod.POST)
	public CommonResponse deleteRole(Long roleId) {
		try {
			int i = roleService.deleteRole(roleId);
			return CommonResponseUtil.success(i);
		} catch (ReferencedDataException e) {
			return CommonResponseUtil.exception(e.getMessage());
		}
		
	}
	
	@RequestMapping(value = "deleteRoleByForce", method = RequestMethod.POST)
	public CommonResponse deleteRoleByForce(Long roleId, Boolean force) {
		try {
			int i = roleService.deleteRole(roleId, force);
			return CommonResponseUtil.success(i);
		} catch (ReferencedDataException e) {
			return CommonResponseUtil.exception(e.getMessage());
		}
		
	}
	
	
}
