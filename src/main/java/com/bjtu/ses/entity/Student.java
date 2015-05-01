package com.bjtu.ses.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.bjtu.ses.enums.Status;

@Entity
@Table(name = "SES_STUDENT")
public class Student extends AutoIDEntity {
	/**
	 * 学号
	 */
	private String stuNo;
	/**
	 * 学生姓名
	 */
	private String stuName;
	/**
	 * 院系代码
	 */
	private String stuDepartNo;
	/**
	 * 院系
	 */
	private String stuDepart;
	/**
	 * 年级
	 */
	private String stuGrade;
	/**
	 * 班级代码
	 */
	private String stuClassNo;
	/**
	 * 班级
	 */
	private String stuClass;
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
	 * 备用
	 */
	private String remark;
	/**
	 * 是否有效
	 */
	private Status idDisabled;
	@Column(name = "STUNAME")
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	@Column(name = "STUDEPART")
	public String getStuDepart() {
		return stuDepart;
	}
	public void setStuDepart(String stuDepart) {
		this.stuDepart = stuDepart;
	}
	@Column(name = "STUGRADE")
	public String getStuGrade() {
		return stuGrade;
	}
	public void setStuGrade(String stuGrade) {
		this.stuGrade = stuGrade;
	}
	@Column(name = "STUCLASS")
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	@Column(name = "STUNO")
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	@Column(name = "STUDEPARTNO")
	public String getStuDepartNo() {
		return stuDepartNo;
	}
	public void setStuDepartNo(String stuDepartNo) {
		this.stuDepartNo = stuDepartNo;
	}
	@Column(name = "STUCLASSNO")
	public String getStuClassNo() {
		return stuClassNo;
	}
	public void setStuClassNo(String stuClassNo) {
		this.stuClassNo = stuClassNo;
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
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Enumerated(value = EnumType.STRING)
	@Column(name = "IS_DISABLED")
	public Status getIdDisabled() {
		return idDisabled;
	}
	public void setIdDisabled(Status idDisabled) {
		this.idDisabled = idDisabled;
	}

}
