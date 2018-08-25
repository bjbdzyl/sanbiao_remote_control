package com.sgai.meter.transmission.token;

import com.alibaba.fastjson.JSONObject;
import com.sgmart.auth.user.entity.User;
import com.szx.core.jwt.bean.UserSubject;
import com.szx.core.jwt.util.CannotParseJwtException;
import com.szx.core.jwt.util.JwtUtil;

import io.jsonwebtoken.Claims;

public abstract class AdminUserSubjectFactory {

	/**
	 * 通过jwt字符串创建{@link UserSubject} 对象
	 * @param jwt
	 * @return
	 * @throws CannotParseJwtException
	 */
	public static UserSubject createSubjectByJwt(String jwt) throws CannotParseJwtException{
		AdminUserSubject subject;
		Claims claims;
		try {
			claims = JwtUtil.parseJWT(jwt);
			String json = claims.getSubject();
			subject = JSONObject.parseObject(json, AdminUserSubject.class);
			subject.setToken(jwt);
		} catch (Exception e) {
			throw new CannotParseJwtException(e);
		}
		return subject;
	}
	
	public static UserSubject createSubjectByUser(User user){
		AdminUserSubject subject = new AdminUserSubject();
		subject.setUserId(user.getId());
		subject.setUserName(user.getUserName());
		subject.setUserType("USER");
		return subject;
	}
	
}
