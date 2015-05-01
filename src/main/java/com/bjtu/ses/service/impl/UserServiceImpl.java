package com.bjtu.ses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.ses.controller.result.ManagerBean;
import com.bjtu.ses.controller.result.ResultCode;
import com.bjtu.ses.dao.UserDao;
import com.bjtu.ses.entity.BaseUser;
import com.bjtu.ses.exception.ManagerException;
import com.bjtu.ses.service.UserService;
import com.bjtu.ses.util.DigestUtil;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public List<BaseUser> getList() {
		return userDao.getList();
	}

	@Override
	public BaseUser findByUsername(String userName) {
		return userDao.findByUsername(userName);
	}

	@Override
	public void add(BaseUser manager) {
		userDao.add(manager);
	}

	@Override
	public ManagerBean loginCheck(String userName, String userPwd)
			throws ManagerException {

		ManagerBean result = new ManagerBean();
		BaseUser manager = userDao.findByUsername(userName);

		if (manager == null) {
			throw new ManagerException("操作员不存在", ResultCode.O02);
		}

		String userPwdMd5 = DigestUtil.md5DigestAsHex(userPwd.getBytes());
		if (!userPwdMd5.equals(manager.getPassword())) {
			throw new ManagerException("操作员密码错误", ResultCode.O03);
		}

		String createTime = String.valueOf(System.currentTimeMillis());
		String loginKey = DigestUtil.md5DigestAsHex((userName + createTime)
				.getBytes());

		result.setLoginKey(loginKey);
		result.setUserName(userName);
		result.setRole(manager.getUserRole());

		return result;
	}

	@Override
	public void statusCheck(ManagerBean manager, String loginKey) throws ManagerException {

		if (manager == null || loginKey == null) {
			throw new ManagerException("", ResultCode.O01);
		}

		if (!loginKey.equals(manager.getLoginKey())) {
			throw new ManagerException("", ResultCode.O01);
		}

	}

}
