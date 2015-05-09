package com.bjtu.ses.dao;

import java.util.List;

import com.bjtu.ses.entity.Teacher;

public interface TeacherDao {
	/**
	 * @Description 查询学生列表
	 * @return
	 * @see 需要参考的类或方法
	 */
	public List<Teacher> getList();

	/**
	 * @Description 创建操作员
	 * @param manager
	 * @see 需要参考的类或方法
	 */
	public void add(Teacher teacher);
	/**
	 * 获取教师编号
	 * 
	 * @param Teacher
	 * @return
	 */
	public int getMaxRemark(Teacher teacher);
	/**
	 * 获取教师总数量
	 * 
	 * @return
	 */
	public int getCount();
	/**
	 * 根据学号获取学生信息
	 * 
	 * @param stuNo学号
	 * @return
	 */
	public Teacher getTeacherByTeaNo(String teaNo);
	/**
	 * 更新学生信息
	 * 
	 * @param Teacher
	 */
	public void updateTeacher(Teacher teacher);
}
