package com.bjtu.ses.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bjtu.ses.dao.CourseDao;
import com.bjtu.ses.entity.Course;
@Repository
public class CourseDaoImpl implements CourseDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Course> getList() {
		String hql = "from Course";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public void add(Course course) {
		Session session = sessionFactory.getCurrentSession();
		session.save(course);
	}

	@Override
	public Course getCourseByCourseNo(String courseNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub

	}

}
