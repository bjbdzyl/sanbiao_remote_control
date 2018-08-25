package com.sgai.meter.transmission.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgmart.auth.user.entity.User;
import com.sgmart.auth.user.exception.UserNameDuplicateException;
import com.sgmart.auth.user.service.UserService;
import com.szx.core.exception.ReferencedDataException;
import com.szx.core.web.QueryController;
import com.szx.core.web.support.CommonResponse;
import com.szx.core.web.support.CommonResponseUtil;
import com.szx.core.web.support.UserServletContext;

import io.swagger.annotations.Api;
import tk.mybatis.mapper.entity.Example;

/**
 * 用户管理
 * libaozhong
 * 2017年7月31日13:27:20
 */
@Api(value = "系统用户管理", tags = "系统用户管理接口")
@RestController
@RequestMapping(value = "/sys/user")
public class UserController extends QueryController<User>{
	
	@Resource
	UserService userService;
	
	@PostMapping(value="/updatePassword")
	public CommonResponse updatePassword(@RequestBody List<User> user){
		Long userId = UserServletContext.getUserSubject().getUserId();
		User entity = new User();
		entity.setId(userId);
		entity.setPassword(user.get(0).getPassword());
		userService.updateByPrimaryKeySelective(entity);
		return CommonResponseUtil.success();
	}
	
	@PostMapping(value="/addUser")
	public CommonResponse addUser(@RequestBody User user){
		Long registerId = 1L;
		try {
			userService.registerUser(user, registerId);
		} catch (UserNameDuplicateException e) {
			CommonResponseUtil.exception(e.getMessage());
		}
		return CommonResponseUtil.success(user);
	}
	
	@PostMapping(value="/updateUser")
	public CommonResponse updateUser(@RequestBody User user){
	
		userService.updateByPrimaryKeySelective(user);
		return CommonResponseUtil.success(user);
	}
	
	@PostMapping(value="/deleteUser")
	public CommonResponse deleteUser(Long userId){
		
		try {
			int i = userService.deleteUser(userId);
			return CommonResponseUtil.success(i);
		} catch (ReferencedDataException e) {
			return CommonResponseUtil.exception(e.getMessage());
		}
		
	}
	
	@RequestMapping(value = "selectUserType", method = RequestMethod.POST)
	public Map<String, String> selectUserType(HttpServletRequest request) {
		
		Map<String, String>  map = new HashMap<>();
		Example e = new Example(User.class);
		e.createCriteria().andIsNotNull("userType");
		List<User> user = userService.selectByExample(e);
		for (User u : user) {
			String userTpye = u.getUserType();
			switch (userTpye) {
            case "USER":
            	map.put("USER", "普通用户");
            	break;
            case "SUPPLIER":
            	map.put("SUPPLIER", "供应商");
            	break;
            default:
                break;
			}
		}
		return map;
	}
}
