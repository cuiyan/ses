package com.bjtu.ses.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bjtu.ses.controller.result.LoginResultBean;
import com.bjtu.ses.controller.result.ManagerBean;
import com.bjtu.ses.enums.ResultType;
import com.bjtu.ses.exception.ManagerException;
import com.bjtu.ses.service.UserService;

@Controller
public class LoginController {
	@Resource
	private UserService userService;
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	/**
	 * @Description 登录验证
	 * @param userName
	 * @param userPwd
	 * @return
	 * @see 需要参考的类或方法
	 */
	@RequestMapping("/loginCheck")
	public @ResponseBody String loginCheck(String userName, String userPwd, HttpSession session) {

		LoginResultBean result = new LoginResultBean();
		ManagerBean manager = new ManagerBean();

		if (userName == null || "".equals(userName)) {
			result.setType(ResultType.ERROR);
			result.setReason("用户名不能为空");
			return JSON.toJSONString(result);
		}

		if (userPwd == null || "".equals(userPwd)) {
			result.setType(ResultType.ERROR);
			result.setReason("密码不能为空");
			return JSON.toJSONString(result);
		}

		try {
			manager = userService.loginCheck(userName, userPwd);
			session.setAttribute("manager", manager);

		} catch (ManagerException e) {
			result.setType(ResultType.ERROR);
			result.setReason(e.getMessage());
			return JSON.toJSONString(result);
		}

		result.setType(ResultType.SUCCESS);
		result.setReason(manager.getLoginKey());
		return JSON.toJSONString(result);
	}
}
