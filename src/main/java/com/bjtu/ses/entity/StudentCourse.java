package com.bjtu.ses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "SES_STUDENT_COURSE")
public class StudentCourse extends AutoIDEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 学号
	 */
	private String studentNo;
	/**
	 * 课程序号
	 */
	private String courseNo;

	@Column(name = "STUNO")
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	@Column(name = "COURSE_NO")
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

}
