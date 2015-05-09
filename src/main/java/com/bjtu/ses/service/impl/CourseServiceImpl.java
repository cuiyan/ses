package com.bjtu.ses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.ses.dao.CourseDao;
import com.bjtu.ses.entity.Course;
import com.bjtu.ses.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {
	@Resource
	private CourseDao courseDao;
	@Override
	public List<Course> getList() {
		return courseDao.getList();
	}
	@Override
	public void saveCourse(Course course) {
		courseDao.add(course);
	}

	@Override
	public Course getCourseByCourseNo(String teaNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCourse(Course Course) {
		// TODO Auto-generated method stub

	}

}
