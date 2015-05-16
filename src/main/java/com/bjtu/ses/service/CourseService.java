package com.bjtu.ses.service;

import java.util.List;

import com.bjtu.ses.entity.Course;

public interface CourseService {
	public List<Course> getList();
	public List<Course> getList(Course course);
	// public List<Map<String, Object>> getList(Course course);
	/**
	 * 保存课程信息
	 * 
	 * @param course
	 */
	public void saveCourse(Course course);
	public Course getCourseByCourseNo(String teaNo);
	/**
	 * 更新课程信息
	 * 
	 * @param Course
	 */
	public void updateCourse(Course Course);
}
