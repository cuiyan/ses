package com.bjtu.ses.entity;

public class StudentCourseVO {
	private String studentNo;
	private String stuName;
	private String stuDepart;
	private String stuClass;
	private String stuGrade;
	private Integer courseScore;
	public StudentCourseVO(String studentNo, String stuName, String stuDepart, String stuClass, String stuGrade, Integer courseScore) {
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.stuDepart = stuDepart;
		this.stuClass = stuClass;
		this.stuGrade = stuGrade;
		this.courseScore = courseScore;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuDepart() {
		return stuDepart;
	}
	public void setStuDepart(String stuDepart) {
		this.stuDepart = stuDepart;
	}
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	public String getStuGrade() {
		return stuGrade;
	}
	public void setStuGrade(String stuGrade) {
		this.stuGrade = stuGrade;
	}
	public Integer getCourseScore() {
		return courseScore;
	}
	public void setCourseScore(Integer courseScore) {
		this.courseScore = courseScore;
	}

}
