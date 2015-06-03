package com.bjtu.ses.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bjtu.ses.dao.TeacherCoursedao;
import com.bjtu.ses.entity.Course;
@Repository
public class TeacherCoursedaoImpl implements TeacherCoursedao {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 查询教师课程
	 * 
	 * @param stuNo
	 * @return
	 */
	public List<Course> getTeaCourseList(String teacherNo) {
		String hql = "from Course where teaNo=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, teacherNo);
		return query.list();
	}
}
