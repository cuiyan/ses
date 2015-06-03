package com.bjtu.ses.dao;

import java.util.List;

import com.bjtu.ses.entity.Course;

public interface TeacherCoursedao {
	/**
	 * 查询教师课程
	 * 
	 * @param stuNo
	 * @return
	 */
	public List<Course> getTeaCourseList(String teacherNo);
}
