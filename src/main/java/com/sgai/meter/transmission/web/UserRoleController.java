package com.sgai.meter.transmission.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.sgmart.auth.user.entity.Role;
import com.sgmart.auth.user.entity.UserRole;
import com.sgmart.auth.user.service.RoleService;
import com.sgmart.auth.user.service.UserRoleService;
import com.szx.core.web.BaseController;
import com.szx.core.web.support.CommonResponse;
import com.szx.core.web.support.CommonResponseUtil;

import io.swagger.annotations.Api;
import tk.mybatis.mapper.entity.Example;

/**
 * 用户角色中间表
 * libaozhong
 * 2017年8月9日14:43:50
 */
@Api(value = "用户角色管理", tags = "用户分配角色接口")
@RestController
@RequestMapping(value = "/sys/user_role")
public class UserRoleController extends BaseController<UserRole> {
	
	@Resource
	UserRoleService userRoleService;
	@Resource
	RoleService roleService;
	
	/**
	 * 查询用户已选中的角色
	 * @param request
	 * @param userId
	 * @param page
	 * @param pagesize
	 * @return
	 */
	@RequestMapping(value = "/selectUserRole", method = RequestMethod.POST)
	public PageInfo<Role> selectUserRole(HttpServletRequest request, Long userId,
			@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pagesize) {
		
		List<Role> list = new ArrayList<Role>();
		PageInfo<Role> data = new PageInfo<Role>(list);
		List<Long> roleIds = userRoleService.selectRoleIdsByUserId(userId);
		if(roleIds.size()>0) {
			Example e = new Example(Role.class);
			e.createCriteria().andIn("id", roleIds);
			RowBounds r = new RowBounds(page,pagesize);
			data = roleService.selectByExample(e,r);
		}
		return data;
		
	}
	
	/**
	 * 查询用户未选角色
	 * @param request
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/selectOtherRole", method = RequestMethod.POST)
	public PageInfo<Role> selectOtherRole(HttpServletRequest request, Long userId,
			@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pagesize) {
		
		PageInfo<Role> data = null;
		List<Long> roleIds = userRoleService.selectRoleIdsByUserId(userId);
		Example e = new Example(Role.class);
		RowBounds r = new RowBounds(page,pagesize);
		if(roleIds.size()>0) {
			e.createCriteria().andNotIn("id", roleIds);
			data = roleService.selectByExample(e,r);
		}else {
			data = roleService.selectByExample(e, r);
		}
		return data;
		
	}
	
	/**
	 * 删除用户角色
	 * @param request
	 * @param userId
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/removeUserRole", method = RequestMethod.POST)
	public CommonResponse removeUserRole(HttpServletRequest request, Long userId, Long roleId) {
		
		if(null == userId) {
			return CommonResponseUtil.exception("userId不能为空！");
		}
		
		if(null == roleId) {
			return CommonResponseUtil.exception("roleId不能为空！");
		}
		Example e = new Example(UserRole.class);
		e.createCriteria().andEqualTo("userId", userId).andEqualTo("roleId",roleId);
		userRoleService.deleteByExample(e);
		return CommonResponseUtil.success("删除成功！");
		
	}
	
	/**
	 * 为用户添加角色
	 * @param request
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	@RequestMapping(value = "/addUserRole", method = RequestMethod.POST)
	public CommonResponse addUserRole(HttpServletRequest request, Long userId, String roleIds) {
		
		if(null == userId) {
			return CommonResponseUtil.exception("userId不能为空！");
		}
		
		if(null == roleIds || "".equals(roleIds)) {
			return CommonResponseUtil.exception("roleId不能为空！");
		}
		
		String [] ids=roleIds.split(",");
		Long[] str = new Long[ids.length];
		for (int i = 0; i < ids.length; i++) {
			str[i] = Long.valueOf(ids[i]);
	    }
		userRoleService.addRoles(userId, str);
		return CommonResponseUtil.success("添加成功！");
		
	}
}
