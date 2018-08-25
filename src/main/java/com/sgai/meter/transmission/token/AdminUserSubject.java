package com.sgai.meter.transmission.token;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.szx.core.jwt.bean.UserSubject;

public class AdminUserSubject implements UserSubject{

	private Long userId;
	
	private String userName;
	
	private String userType;
	
	private String sid;
	
	@JSONField(serialize=false)   
	private String token;

	
	
	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserType() {
		return userType;
	}

	public String toJsonString() {
		return JSON.toJSONString(this);
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	
}
