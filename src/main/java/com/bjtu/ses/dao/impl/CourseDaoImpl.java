package com.bjtu.ses.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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
	// public List<Map<String, Object>> getList(Course course) {
	// Session session = sessionFactory.getCurrentSession();
	// DetachedCriteria dc = DetachedCriteria.forClass(Course.class);
	// if (!"".equals(course.getCourseName()) && course.getCourseName() != null)
	// {
	// dc.add(Restrictions.like("courseName", "%" + course.getCourseName() +
	// "%"));
	// }
	// Criteria cri = dc.getExecutableCriteria(session);
	// List<Map<String, Object>> list = cri.list();
	// // session.close();
	// return list;
	// }
	public List<Course> getList(Course course) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(Course.class);
		if (!"".equals(course.getCourseName()) && course.getCourseName() != null) {
			dc.add(Restrictions.like("courseName", "%" + course.getCourseName() + "%"));
		}
		Criteria cri = dc.getExecutableCriteria(session);
		List<Course> list = cri.list();
		// session.close();
		return list;
	}
	@Override
	public void add(Course course) {
		Session session = sessionFactory.getCurrentSession();
		session.save(course);
	}
	/**
	 * 查询课程总数
	 * 
	 * @param course
	 * @return
	 */
	public int getCount(Course course) {
		String hql = "select count(1) from Course where courseDepartNo=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, course.getCourseDepartNo());
		int count = ((Long) query.iterate().next()).intValue();
		return count;

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
