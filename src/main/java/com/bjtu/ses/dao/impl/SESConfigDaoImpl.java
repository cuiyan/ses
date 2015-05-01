package com.bjtu.ses.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bjtu.ses.dao.SESConfigDao;
import com.bjtu.ses.entity.SESConfig;
import com.bjtu.ses.enums.ConfigType;
@Repository
public class SESConfigDaoImpl implements SESConfigDao {
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public List<SESConfig> getList(ConfigType configType) {
		String hql = "from SESConfig where configType=?  and level=0";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, configType);
		return query.list();
	}

	public List<SESConfig> getList(ConfigType configType, Integer pLevel) {
		String hql = "from SESConfig where configType=? and PLevel=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, configType);
		query.setParameter(1, pLevel);
		return query.list();
	}
	public SESConfig getByConfigKey(String configKey, Integer pLevel) {
		String hql = "from SESConfig where configKey=? and pLevel=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, configKey);
		query.setParameter(1, pLevel);
		return (SESConfig) query.uniqueResult();
	}
}
