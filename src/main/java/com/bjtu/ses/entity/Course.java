package com.bjtu.ses.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
/**
 * 课程表
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "SES_COURSE")
public class Course extends AutoIDEntity {
	private String courseNo;
	private String teaNo;
	private String teaName;
	private String courseName;
	private List<CourseEX> courseEX;
	// private Date courseTime;
	// private String courseAddress;
	private String courseInfo;
	private String courseTime;
	/**
	 * 开课学院编号
	 */
	private String courseDepartNo;
	/**
	 * 开课学院名称
	 */
	private String courseDepartName;
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

	@Column(name = "COURSE_NO")
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
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
	@Column(name = "COURSE_NAME")
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<CourseEX> getCourseEX() {
		return courseEX;
	}
	public void setCourseEX(List<CourseEX> courseEX) {
		this.courseEX = courseEX;
	}
	@Transactional
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	// @Column(name = "COURSE_ADDTESS")
	// public String getCourseAddress() {
	// return courseAddress;
	// }
	// public void setCourseAddress(String courseAddress) {
	// this.courseAddress = courseAddress;
	// }
	@Column(name = "COURSE_INFO")
	public String getCourseInfo() {
		return courseInfo;
	}
	public void setCourseInfo(String courseInfo) {
		this.courseInfo = courseInfo;
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
	@Column(name = "COURSE_DEPART_NO")
	public String getCourseDepartNo() {
		return courseDepartNo;
	}
	public void setCourseDepartNo(String courseDepartNo) {
		this.courseDepartNo = courseDepartNo;
	}
	@Column(name = "COURSE_DEPART_NAME")
	public String getCourseDepartName() {
		return courseDepartName;
	}
	public void setCourseDepartName(String courseDepartName) {
		this.courseDepartName = courseDepartName;
	}

}
