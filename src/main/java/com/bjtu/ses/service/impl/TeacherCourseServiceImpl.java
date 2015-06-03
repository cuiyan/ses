package com.bjtu.ses.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjtu.ses.dao.TeacherCoursedao;
import com.bjtu.ses.entity.Course;
import com.bjtu.ses.service.TeacherCourseService;
@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {
	@Autowired
	private TeacherCoursedao teacherCoursedao;
	public List<Course> getTeaCourseList(String teacherNo) {
		return teacherCoursedao.getTeaCourseList(teacherNo);
	}
}
