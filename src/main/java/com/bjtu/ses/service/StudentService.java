package com.bjtu.ses.service;

import java.util.List;

import com.bjtu.ses.entity.Student;

public interface StudentService {
	public List<Student> getList();

	public void saveStudent(Student student);
	public Student getStudentByStuNo(String stuNo);
	/**
	 * 更新学生信息
	 * 
	 * @param student
	 */
	public void updateStudent(Student student);
}
