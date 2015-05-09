package com.bjtu.ses.dao;

import java.util.List;

import com.bjtu.ses.entity.Course;

public interface CourseDao {
	/**
	 * @Description 查询学生列表
	 * @return
	 * @see 需要参考的类或方法
	 */
	public List<Course> getList();

	/**
	 * @Description 创建操作员
	 * @param manager
	 * @see 需要参考的类或方法
	 */
	public void add(Course course);

	/**
	 * 根据学号获取学生信息
	 * 
	 * @param stuNo学号
	 * @return
	 */
	public Course getCourseByCourseNo(String courseNo);
	/**
	 * 更新学生信息
	 * 
	 * @param Course
	 */
	public void updateCourse(Course course);
}
