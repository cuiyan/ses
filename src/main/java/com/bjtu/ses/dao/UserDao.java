package com.bjtu.ses.dao;

import java.util.List;

import com.bjtu.ses.entity.BaseUser;
/**
 * 用户管理Dao
 * 
 * @author Administrator
 *
 */
public interface UserDao {
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

}
