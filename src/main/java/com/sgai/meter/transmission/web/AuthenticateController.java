package com.sgai.meter.transmission.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgai.meter.transmission.token.AdminUserSubjectFactory;
import com.sgmart.auth.user.entity.User;
import com.sgmart.auth.user.service.UserService;
import com.szx.core.jwt.annotation.PermessionLimit;
import com.szx.core.jwt.bean.UserSubject;
import com.szx.core.jwt.util.JwtUtil;
import com.szx.core.web.support.CommonResponse;
import com.szx.core.web.support.CommonResponseUtil;
import com.szx.core.web.support.UserServletContext;

import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

@Api(value = "系统登录退出", tags = "系统登录接口")
@RestController
@RequestMapping(value = "/sys")
public class AuthenticateController {

	@Autowired
	private UserService userService;

	@ApiOperation(value="用户登录", notes="用户登录接口")
	@PostMapping(value = "/login", produces = "application/json;charset=utf8")
	@PermessionLimit(limit = false)
	public CommonResponse doLogin(String userName, String password) {
		try {
			if(userName == null || "".equals(userName) || password == null || "".endsWith(password)) {
				return CommonResponseUtil.exception("用户或密码不正确");
			}
			
			System.out.println("pre userName login:" + userName);
			System.out.println("pre userPassword login:" + password);
			User user = userService.selectUserByNameAndPassword(userName, password);
			if (user == null) {
				return CommonResponseUtil.exception("用户或密码不正确");
			}

			UserSubject atsubject = AdminUserSubjectFactory.createSubjectByUser(user);
			String token = JwtUtil.createJWT(JwtUtil.JWT_ID, atsubject.toJsonString(), JwtUtil.JWT_TTL);
			return CommonResponseUtil.success(token);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtil.unKonwException();
		}
	}
	
	@PostMapping(value = "/refreshToken")
	public CommonResponse refreshToken(HttpServletRequest request, HttpServletResponse response) {
		Claims claims;
		try {
			claims = JwtUtil.parseJWT(UserServletContext.getUserSubject().getToken());
			String userType = UserServletContext.getUserSubject().getUserType();
			if (claims.getExpiration().before(DateTime.now().plusHours(3).toDate())) {
				//还有三小时就过期，刷新token
				String token = JwtUtil.createJWT(JwtUtil.JWT_ID, claims.getSubject(), JwtUtil.JWT_TTL);
				JSONObject jo = new JSONObject();
				jo.put("authToken", token);
				jo.put("userType", userType);
				return CommonResponseUtil.success(jo);
			}
			return CommonResponseUtil.custom(CommonResponseUtil.RESCODE_SUCCESS_MSG, userType);
		} catch (Exception e) {
			return CommonResponseUtil.unKonwException();
		}
	}

	@PostMapping(value = "/logout")
	public String doLogout(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

}
