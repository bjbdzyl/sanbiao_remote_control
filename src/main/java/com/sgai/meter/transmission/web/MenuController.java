package com.sgai.meter.transmission.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgmart.auth.user.dto.LeftMenu;
import com.sgmart.auth.user.service.RoleFunctionService;
import com.sgmart.auth.user.service.UserRoleService;
import com.szx.core.jwt.bean.UserSubject;
import com.szx.core.web.support.UserServletContext;
import net.sf.json.JSONArray;

/**
 * 
 * @author hoocen
 */
@RestController
@RequestMapping(value = "/sys/menu")
public class MenuController{

	@Autowired
	private RoleFunctionService roleFunctionService;
	@Autowired
	private UserRoleService userRoleService;
	
	@GetMapping(value="/left/list")
	public Object list(HttpServletRequest request) throws Exception{
		
		UserSubject atsubject = UserServletContext.getUserSubject();
		
		List<Long> roleIds=userRoleService.selectRoleIdsByUserId(atsubject.getUserId());
		
		JSONArray objs = null;
		//查询根据id数组查询菜单
		if(roleIds.size()>0) {
			List<LeftMenu> menu=roleFunctionService.queryMenusOfRoles(roleIds);
			objs = JSONArray.fromObject(menu);
		}
		return objs;
	}
	
}
