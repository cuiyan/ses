package com.bjtu.ses.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.ses.dao.SESConfigDao;
import com.bjtu.ses.dao.StudentDao;
import com.bjtu.ses.dao.UserDao;
import com.bjtu.ses.entity.BaseUser;
import com.bjtu.ses.entity.SESConfig;
import com.bjtu.ses.entity.Student;
import com.bjtu.ses.enums.ConfigType;
import com.bjtu.ses.enums.Status;
import com.bjtu.ses.enums.UserRole;
import com.bjtu.ses.service.StudentService;
import com.bjtu.ses.util.DigestUtil;
import com.bjtu.ses.util.StringUtils;
@Service
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentDao studentDao;
	@Resource
	private SESConfigDao sesConfigDao;
	@Resource
	private UserDao userDao;
	@Override
	public List<Student> getList() {
		return studentDao.getList();
	}
	public List<Map<String, Object>> getList(Student student) {
		return studentDao.getList(student);
	}
	public void saveStudent(Student student) {
		SESConfig ses = sesConfigDao.getByConfigKey(student.getStuDepartNo(), 0, ConfigType.DEPARWMT);
		if (ses != null) {
			student.setStuDepart(ses.getConfigVal());
		}
		ses = sesConfigDao.getByConfigKey(student.getStuClassNo(), Integer.parseInt(student.getStuDepartNo()), ConfigType.DEPARWMT);
		if (ses != null) {
			student.setStuClass(ses.getConfigVal());
		}
		int count = studentDao.getMaxRemark(student);
		count++;
		String lastRemark = StringUtils.getLastCode(count);
		String stuNo = student.getStuGrade() + student.getStuDepartNo() + student.getStuClassNo() + lastRemark;
		student.setStuNo(stuNo);
		student.setRemark(lastRemark);
		student.setCreateId("");
		student.setCreateName("admin");
		student.setCreateTime(new Date());
		student.setModifyId("");
		student.setModifyName("");
		student.setModifyTime(new Date());
		student.setIdDisabled(Status.TRUE);
		studentDao.add(student);
		// 插入用户表
		BaseUser baseUser = new BaseUser();
		baseUser.setUserName(stuNo);
		baseUser.setUserRole(UserRole.STUDENT);
		baseUser.setPassword(DigestUtil.md5DigestAsHex(stuNo.getBytes()));
		baseUser.setStatus(Status.TRUE);
		userDao.add(baseUser);
	}
	public Student getStudentByStuNo(String stuNo) {
		return studentDao.getStudentByStuNo(stuNo);
	}

	/**
	 * 更新学生信息
	 * 
	 * @param student
	 */
	public void updateStudent(Student student) {
		SESConfig ses = sesConfigDao.getByConfigKey(student.getStuDepartNo(), 0, ConfigType.DEPARWMT);
		if (ses != null) {
			student.setStuDepart(ses.getConfigVal());
		}
		ses = sesConfigDao.getByConfigKey(student.getStuClassNo(), Integer.parseInt(student.getStuDepartNo()), ConfigType.DEPARWMT);
		if (ses != null) {
			student.setStuClass(ses.getConfigVal());
		}
		student.setModifyId("");
		student.setModifyName("");
		student.setModifyTime(new Date());
		studentDao.updateStudent(student);
	}
}
