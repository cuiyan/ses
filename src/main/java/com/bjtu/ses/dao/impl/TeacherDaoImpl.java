package com.bjtu.ses.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bjtu.ses.dao.TeacherDao;
import com.bjtu.ses.entity.Teacher;
@Repository
public class TeacherDaoImpl implements TeacherDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Teacher> getList() {
		String hql = "from Teacher";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public void add(Teacher teacher) {
		Session session = sessionFactory.getCurrentSession();
		session.save(teacher);
	}

	@Override
	public int getMaxRemark(Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 获取教师总数量
	 * 
	 * @return
	 */
	public int getCount() {
		String hql = "select count(1) from Teacher";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		int count = ((Long) query.iterate().next()).intValue();
		return count;
	}
	/**
	 * 根据教师编号获取教师信息
	 */
	@Override
	public Teacher getTeacherByTeaNo(String teaNo) {
		String hql = "from Teacher where teaNo=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, teaNo);
		return (Teacher) query.uniqueResult();
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		String hql = "update Teacher set teaName=?,teaDepartNo=?,teaDepart=?  where teaNo=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, teacher.getTeaName());
		query.setParameter(1, teacher.getTeaDepartNo());
		query.setParameter(2, teacher.getTeaDepart());
		query.setParameter(3, teacher.getTeaNo());
		query.executeUpdate();
	}

}
