package com.bjtu.ses.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 课程扩展
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "SES_COURSE_EX")
public class CourseEX extends AutoIDEntity {

	/**
	 * 上课周
	 */
	private String courseWeek;

	private String courseWeekCN;
	/**
	 * 上课天
	 */
	private String courseDay;

	private String courseDayCN;
	/**
	 * 上课时间
	 */
	private String courseTime;

	private String courseTimeCN;
	/**
	 * 上课地址
	 */
	private String courseAddress;

	private Course course;

	@Column(name = "COURSE_WEEK")
	public String getCourseWeek() {
		return courseWeek;
	}
	public void setCourseWeek(String courseWeek) {
		this.courseWeek = courseWeek;
	}
	@Column(name = "COURSE_DAY")
	public String getCourseDay() {
		return courseDay;
	}
	public void setCourseDay(String courseDay) {
		this.courseDay = courseDay;
	}
	@Column(name = "COURSE_TIME")
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	@Column(name = "COURSE_ADDRESS")
	public String getCourseAddress() {
		return courseAddress;
	}
	public void setCourseAddress(String courseAddress) {
		this.courseAddress = courseAddress;
	}
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "COURSE_NO")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Column(name = "COURSE_WEEK_CN")
	public String getCourseWeekCN() {
		return courseWeekCN;
	}
	public void setCourseWeekCN(String courseWeekCN) {
		this.courseWeekCN = courseWeekCN;
	}
	@Column(name = "COURSE_DAY_CN")
	public String getCourseDayCN() {
		return courseDayCN;
	}
	public void setCourseDayCN(String courseDayCN) {
		this.courseDayCN = courseDayCN;
	}
	@Column(name = "COURSE_TIME_CN")
	public String getCourseTimeCN() {
		return courseTimeCN;
	}
	public void setCourseTimeCN(String courseTimeCN) {
		this.courseTimeCN = courseTimeCN;
	}

}
