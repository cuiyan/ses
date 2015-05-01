package com.bjtu.ses.controller.result;

import java.io.Serializable;

import com.bjtu.ses.enums.UserRole;

/**
 * @Description: 管理员登录状态bean
 * @see: ManagerBean 此处填写需要参考的类
 */
public class ManagerBean implements Serializable {

	private static final long serialVersionUID = 354698552151657399L;

	String userName; // 用户名
	String loginKey; // 登录状态码
	UserRole role; // 用户角色

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginKey() {
		return loginKey;
	}

	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ManagerBean [userName=");
		builder.append(userName);
		builder.append(", loginKey=");
		builder.append(loginKey);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}

}
