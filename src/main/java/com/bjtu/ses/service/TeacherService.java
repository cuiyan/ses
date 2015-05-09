package com.bjtu.ses.service;

import java.util.List;

import com.bjtu.ses.entity.Teacher;

public interface TeacherService {
	public List<Teacher> getList();

	public void saveTeacher(Teacher teacher);
	public Teacher getTeacherByTeaNo(String teaNo);
	/**
	 * 更新教师信息
	 * 
	 * @param Teacher
	 */
	public void updateTeacher(Teacher Teacher);
}
