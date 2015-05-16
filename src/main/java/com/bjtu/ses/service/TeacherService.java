package com.bjtu.ses.service;

import java.util.List;
import java.util.Map;

import com.bjtu.ses.entity.Teacher;

public interface TeacherService {
	public List<Teacher> getList();
	public List<Map<String, Object>> getList(Teacher teacher);

	public void saveTeacher(Teacher teacher);
	public Teacher getTeacherByTeaNo(String teaNo);
	/**
	 * 根据教师姓名，模糊查询教师名称
	 * 
	 * @param teaName
	 * @return
	 */
	public List<Teacher> getTeacherByTeaName(String teaName);
	/**
	 * 更新教师信息
	 * 
	 * @param Teacher
	 */
	public void updateTeacher(Teacher Teacher);
}
