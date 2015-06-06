package com.bjtu.ses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.ses.dao.StudentCourseDao;
import com.bjtu.ses.entity.Course;
import com.bjtu.ses.entity.StudentCourse;
import com.bjtu.ses.entity.StudentCourseVO;
import com.bjtu.ses.service.StudentCourseService;
@Service
public class StudentCourseServiceImpl implements StudentCourseService {
	@Resource
	private StudentCourseDao studentCoursedao;

	@Override
	public List<Course> getList(String studentNo) {
		return studentCoursedao.getList(studentNo);
	}
	public List<Course> getStuCourseList(String stuNo) {
		return studentCoursedao.getStuCourseList(stuNo);
	}
	public void saveStudentCourse(StudentCourse studentCourse) {
		studentCoursedao.add(studentCourse);
	}
	public void deleteStudentCourse(StudentCourse studentCourse) {
		studentCoursedao.deleteStudentCourse(studentCourse);
	}

	/**
	 * 查询选择该课程的学生
	 * 
	 * @param courseNo
	 * @return
	 */
	public List<StudentCourseVO> getStudentCourseList(String courseNo) {
		return studentCoursedao.getStudentCourseList(courseNo);
	}
}
