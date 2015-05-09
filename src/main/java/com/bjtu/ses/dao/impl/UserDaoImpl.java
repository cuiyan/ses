package com.bjtu.ses.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bjtu.ses.dao.UserDao;
import com.bjtu.ses.entity.BaseUser;
import com.bjtu.ses.enums.Status;
@Repository
public class UserDaoImpl implements UserDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<BaseUser> getList() {
		String hql = "from User where status = ?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, Status.TRUE);
		return query.list();
	}

	@Override
	public BaseUser findByUsername(String userName) {
		String hql = "from BaseUser where userName = ? and status = ?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, userName);
		query.setParameter(1, Status.TRUE);

		return (BaseUser) query.uniqueResult();
	}

	@Override
	public void add(BaseUser manager) {
		Session session = sessionFactory.getCurrentSession();
		session.save(manager);
	}
	/**
	 * 更新密码
	 * 
	 * @param baseUser
	 */
	public void updatePassword(BaseUser baseUser) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "update BaseUser set password=? where userName=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, baseUser.getPassword());
		query.setParameter(1, baseUser.getUserName());
		query.executeUpdate();
	}
}
