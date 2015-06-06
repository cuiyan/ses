package com.bjtu.ses.dao;

import java.util.List;

import com.bjtu.ses.entity.Course;
import com.bjtu.ses.entity.StudentCourse;
import com.bjtu.ses.entity.StudentCourseVO;

public interface StudentCourseDao {
	/**
	 * @Description 查询学生选课列表
	 * @return
	 * @see 需要参考的类或方法
	 */
	public List<Course> getList(String studentNo);
	/**
	 * 查询学生未选择的课程
	 * 
	 * @param stuNo
	 * @return
	 */
	public List<Course> getStuCourseList(String stuNo);
	public void add(StudentCourse studentCourse);
	public void deleteStudentCourse(StudentCourse studentCourse);

	public List<StudentCourseVO> getStudentCourseList(String courseId);
}
