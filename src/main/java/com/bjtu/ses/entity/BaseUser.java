package com.bjtu.ses.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.bjtu.ses.enums.Status;
import com.bjtu.ses.enums.UserRole;

@Entity
@Table(name = "SES_USER")
public class BaseUser extends AutoIDEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private UserRole userRole;
	private Date validateTime;
	/**
	 * 状态
	 */
	private Status status;
	@Column(name = "USERNAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(value = EnumType.STRING)
	@Column(name = "USERROLE")
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	@Column(name = "VALIDATETIME")
	public Date getValidateTime() {
		return validateTime;
	}
	public void setValidateTime(Date validateTime) {
		this.validateTime = validateTime;
	}
	@Enumerated(value = EnumType.STRING)
	@Column(name = "STATUS", columnDefinition = "VARCHAR(10)")
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

}
