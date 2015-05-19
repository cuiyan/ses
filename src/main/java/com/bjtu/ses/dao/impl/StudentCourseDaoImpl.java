package com.bjtu.ses.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bjtu.ses.dao.StudentCourseDao;
import com.bjtu.ses.entity.Course;
import com.bjtu.ses.entity.StudentCourse;
@Repository
public class StudentCourseDaoImpl implements StudentCourseDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Course> getList(String studentNo) {
		String hql = "from Course where courseNo in (select courseNo from StudentCourse where studentNo=?) ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, studentNo);
		return query.list();
	}
	public List<Course> getStuCourseList(String stuNo) {
		String hql = "from Course c where courseNo not in(select courseNo from StudentCourse where studentNo=?)";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, stuNo);
		return query.list();

	}
	public void add(StudentCourse studentCourse) {
		Session session = sessionFactory.getCurrentSession();
		session.save(studentCourse);
	}
	public void deleteStudentCourse(StudentCourse studentCourse) {
		String hql = "delete from StudentCourse where studentNo=? and courseNo=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, studentCourse.getStudentNo());
		query.setParameter(1, studentCourse.getCourseNo());
		query.executeUpdate();
	}

}
