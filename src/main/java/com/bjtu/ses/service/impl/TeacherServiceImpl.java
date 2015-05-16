package com.bjtu.ses.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.ses.dao.SESConfigDao;
import com.bjtu.ses.dao.TeacherDao;
import com.bjtu.ses.dao.UserDao;
import com.bjtu.ses.entity.BaseUser;
import com.bjtu.ses.entity.SESConfig;
import com.bjtu.ses.entity.Teacher;
import com.bjtu.ses.enums.ConfigType;
import com.bjtu.ses.enums.Status;
import com.bjtu.ses.enums.UserRole;
import com.bjtu.ses.service.TeacherService;
import com.bjtu.ses.util.DigestUtil;
import com.bjtu.ses.util.StringUtils;
@Service
public class TeacherServiceImpl implements TeacherService {
	@Resource
	private TeacherDao teacherDao;
	@Resource
	private SESConfigDao sesConfigDao;
	@Resource
	private UserDao userDao;
	@Override
	public List<Teacher> getList() {
		return teacherDao.getList();
	}
	public List<Map<String, Object>> getList(Teacher teacher) {
		return teacherDao.getList(teacher);
	}
	@Override
	public void saveTeacher(Teacher teacher) {
		SESConfig ses = sesConfigDao.getByConfigKey(teacher.getTeaDepartNo(), 0, ConfigType.DEPARWMT);
		if (ses != null) {
			teacher.setTeaDepart(ses.getConfigVal());
		}
		int count = teacherDao.getCount();
		count++;
		String lastRemark = StringUtils.getFiveLengthCode(count);
		String teaNo = "t" + lastRemark;
		teacher.setTeaNo(teaNo);
		teacherDao.add(teacher);
		BaseUser baseUser = new BaseUser();
		baseUser.setUserName(teaNo);
		baseUser.setUserRole(UserRole.TEACHER);
		baseUser.setPassword(DigestUtil.md5DigestAsHex(teaNo.getBytes()));
		baseUser.setStatus(Status.TRUE);
		userDao.add(baseUser);
	}
	@Override
	public Teacher getTeacherByTeaNo(String teaNo) {
		return teacherDao.getTeacherByTeaNo(teaNo);
	}
	/**
	 * 根据教师姓名，模糊查询教师名称
	 * 
	 * @param teaName
	 * @return
	 */
	public List<Teacher> getTeacherByTeaName(String teaName) {
		return teacherDao.getTeacherByTeaName(teaName);
	}
	@Override
	public void updateTeacher(Teacher teacher) {
		SESConfig ses = sesConfigDao.getByConfigKey(teacher.getTeaDepartNo(), 0, ConfigType.DEPARWMT);
		if (ses != null) {
			teacher.setTeaDepart(ses.getConfigVal());
		}
		teacher.setModifyId("");
		teacher.setModifyName("");
		teacher.setModifyTime(new Date());
		teacherDao.updateTeacher(teacher);
	}

}
