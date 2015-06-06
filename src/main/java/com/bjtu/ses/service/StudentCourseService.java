package com.bjtu.ses.service;

import java.util.List;

import com.bjtu.ses.entity.Course;
import com.bjtu.ses.entity.StudentCourse;
import com.bjtu.ses.entity.StudentCourseVO;

public interface StudentCourseService {
	/**
	 * @Description 查询学生选课列表
	 * @return
	 * @see 需要参考的类或方法
	 */
	public List<Course> getList(String studentNo);
	public List<Course> getStuCourseList(String stuNo);
	public void saveStudentCourse(StudentCourse studentCourse);
	public void deleteStudentCourse(StudentCourse studentCourse);
	/**
	 * 查询选择该课程的学生
	 * 
	 * @param courseNo
	 * @return
	 */
	public List<StudentCourseVO> getStudentCourseList(String courseNo);
}
