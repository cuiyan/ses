package com.bjtu.ses.service;

import java.util.List;

import com.bjtu.ses.controller.result.ManagerBean;
import com.bjtu.ses.entity.BaseUser;
import com.bjtu.ses.exception.ManagerException;

public interface UserService {
	/**
	 * @Description 查询操作员列表
	 * @return
	 * @see 需要参考的类或方法
	 */
	public List<BaseUser> getList();

	/**
	 * @Description 根据用户名查找操作员
	 * @param userName
	 * @return
	 * @see 需要参考的类或方法
	 */
	public BaseUser findByUsername(String userName);

	/**
	 * @Description 创建操作员
	 * @param manager
	 * @see 需要参考的类或方法
	 */
	public void add(BaseUser manager);

	/**
	 * @Description 登录验证
	 * @param userName
	 * @param userPwd
	 * @return loginKey
	 * @throws ManagerException
	 * @see 需要参考的类或方法
	 */
	public ManagerBean loginCheck(String userName, String userPwd)
			throws ManagerException;

	/**
	 * 登录状态校验
	 * 
	 * @param loginKey
	 * @throws ManagerException
	 */
	public void statusCheck(ManagerBean manager, String loginKey) throws ManagerException;

}
