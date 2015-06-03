package com.bjtu.ses.service;

import java.util.List;

import com.bjtu.ses.entity.Course;

public interface TeacherCourseService {
	public List<Course> getTeaCourseList(String teacherNo);
}
