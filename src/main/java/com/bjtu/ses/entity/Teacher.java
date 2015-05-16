package com.bjtu.ses.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.bjtu.ses.enums.Status;

/**
 * 教师表 教师ID规则：T00001
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "SES_TEACHER")
public class Teacher extends AutoIDEntity {
	private static final long serialVersionUID = 1L;
	private String teaNo;
	private String teaName;
	private String teaDepartNo;
	private String teaDepart;
	/**
	 * 创建人代码
	 */
	private String createId;
	/**
	 * 创建人名称
	 */
	private String createName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改人代码
	 */
	private String modifyId;
	/**
	 * 修改人名称
	 */
	private String modifyName;
	/**
	 * 修改时间
	 */
	private Date modifyTime;

	/**
	 * 是否有效
	 */
	private Status isDisabled;

	@Column(name = "TEA_NO")
	public String getTeaNo() {
		return teaNo;
	}
	public void setTeaNo(String teaNo) {
		this.teaNo = teaNo;
	}
	@Column(name = "TEA_NAME")
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	@Column(name = "TEA_DEPAER_NO")
	public String getTeaDepartNo() {
		return teaDepartNo;
	}
	public void setTeaDepartNo(String teaDepartNo) {
		this.teaDepartNo = teaDepartNo;
	}
	@Column(name = "TEA_DEPAER")
	public String getTeaDepart() {
		return teaDepart;
	}
	public void setTeaDepart(String teaDepart) {
		this.teaDepart = teaDepart;
	}
	@Column(name = "CREATEID")
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	@Column(name = "CREATENAME")
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	@Column(name = "CREATETIME")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "MODIFYID")
	public String getModifyId() {
		return modifyId;
	}
	public void setModifyId(String modifyId) {
		this.modifyId = modifyId;
	}
	@Column(name = "MODIFYNAME")
	public String getModifyName() {
		return modifyName;
	}
	public void setModifyName(String modifyName) {
		this.modifyName = modifyName;
	}
	@Column(name = "MODIFYTIME")
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	@Enumerated(value = EnumType.STRING)
	@Column(name = "IS_DISABLED")
	public Status getIsDisabled() {
		return isDisabled;
	}
	public void setIsDisabled(Status isDisabled) {
		this.isDisabled = isDisabled;
	}

}
