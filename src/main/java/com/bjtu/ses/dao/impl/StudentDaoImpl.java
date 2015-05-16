package com.bjtu.ses.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bjtu.ses.dao.StudentDao;
import com.bjtu.ses.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Student> getList() {
		String hql = "from Student";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		return query.list();
	}
	public List<Map<String, Object>> getList(Student student) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(Student.class);
		if (!"".equals(student.getStuName()) && student.getStuName() != null) {
			dc.add(Restrictions.like("stuName", "%" + student.getStuName() + "%"));
		}
		if (!"".equals(student.getStuDepartNo()) && student.getStuDepartNo() != null) {
			dc.add(Restrictions.eq("stuDepartNo", student.getStuDepartNo()));
		}
		if (!"".equals(student.getStuClassNo()) && student.getStuClassNo() != null) {
			dc.add(Restrictions.eq("stuClassNo", student.getStuClassNo()));
		}
		if (!"".equals(student.getStuGrade()) && student.getStuGrade() != null) {
			dc.add(Restrictions.eq("stuGrade", student.getStuGrade()));
		}
		if (!"".equals(student.getIdDisabled()) && student.getIdDisabled() != null) {
			dc.add(Restrictions.eq("idDisabled", student.getIdDisabled()));
		}
		Criteria cri = dc.getExecutableCriteria(session);
		List<Map<String, Object>> list = cri.list();
		// session.close();
		return list;
	}
	@Override
	public void add(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
	}
	/**
	 * 获取学生编号
	 * 
	 * @param student
	 * @return
	 */
	public int getMaxRemark(Student student) {
		String hql = "select count(1) from Student where stuGrade=? and stuDepartNo=? and stuClassNo=? order by id desc";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, student.getStuGrade());
		query.setParameter(1, student.getStuDepartNo());
		query.setParameter(2, student.getStuClassNo());
		int count = ((Long) query.iterate().next()).intValue();
		return count;
	}
	/**
	 * 根据学生证号获取学生信息
	 */
	public Student getStudentByStuNo(String stuNo) {
		String hql = "from Student where stuNo=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, stuNo);
		return (Student) query.uniqueResult();
	}
	/**
	 * 更新学生信息
	 * 
	 * @param student
	 */
	public void updateStudent(Student student) {
		String hql = "update Student set stuName=?,"
				+ "stuDepartNo=?,"
				+ "stuDepart=?,"
				+ "stuGrade=?,"
				+ "stuClassNo=?,"
				+ "stuClass=?,"
				+ "modifyId=?,"
				+ "modifyName=?,"
				+ "modifyTime=?"
				+ " where stuNo=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, student.getStuName());
		query.setParameter(1, student.getStuDepartNo());
		query.setParameter(2, student.getStuDepart());
		query.setParameter(3, student.getStuGrade());
		query.setParameter(4, student.getStuClassNo());
		query.setParameter(5, student.getStuClass());
		query.setParameter(6, student.getModifyId());
		query.setParameter(7, student.getModifyName());
		query.setParameter(8, student.getModifyTime());
		query.setParameter(9, student.getStuNo());
		query.executeUpdate();
	}
}
