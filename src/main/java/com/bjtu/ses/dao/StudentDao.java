package com.bjtu.ses.dao;

import java.util.List;

import com.bjtu.ses.entity.Student;
/**
 * 学生管理dao
 * 
 * @author Administrator
 *
 */
public interface StudentDao {
	/**
	 * @Description 查询学生列表
	 * @return
	 * @see 需要参考的类或方法
	 */
	public List<Student> getList();

	/**
	 * @Description 创建操作员
	 * @param manager
	 * @see 需要参考的类或方法
	 */
	public void add(Student student);
	/**
	 * 获取学生编号
	 * 
	 * @param student
	 * @return
	 */
	public int getMaxRemark(Student student);
	/**
	 * 根据学号获取学生信息
	 * 
	 * @param stuNo学号
	 * @return
	 */
	public Student getStudentByStuNo(String stuNo);
	/**
	 * 更新学生信息
	 * 
	 * @param student
	 */
	public void updateStudent(Student student);
}
