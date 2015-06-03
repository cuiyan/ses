package com.bjtu.ses.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.ses.entity.BaseUser;
import com.bjtu.ses.model.JsonResultView;
import com.bjtu.ses.service.UserService;
import com.bjtu.ses.util.DigestUtil;
/**
 * 用户登陆及用户信息管理
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manager/")
public class UserController {
	@Resource
	private UserService userSerive;
	@RequestMapping("index")
	@ResponseBody
	public ModelAndView managerIndex(HttpServletRequest request) {
		String userName = (String) request.getSession(true).getAttribute("userName");
		String userRole = request.getSession(true).getAttribute("userRole").toString();
		return new ModelAndView("index").addObject("userName", userName).addObject("userRole", userRole);
	}
	@RequestMapping("modifyPassword")
	public ModelAndView modifyPassword() {
		return new ModelAndView("modifyPassword");
	}
	@RequestMapping("modifyPwd")
	@ResponseBody
	public Map<String, Object> modifyPwd(HttpServletRequest request, String oldPwd, String newPwd, String reNewPwd) {
		String userName = (String) request.getSession(true).getAttribute("userName");
		BaseUser user = userSerive.findByUsername(userName);
		if (!newPwd.equals(reNewPwd)) {
			return JsonResultView.ofFalse("两次输入密码不一致!");
		}
		if (user != null) {
			if (!user.getPassword().equals(DigestUtil.md5DigestAsHex(oldPwd.getBytes()))) {
				return JsonResultView.ofFalse("原始密码不正确!");
			}
			user.setPassword(DigestUtil.md5DigestAsHex(newPwd.getBytes()));
			userSerive.updatePassword(user);
		}

		return JsonResultView.ofSeccess(0);
	}
	@RequestMapping("loginOut")
	public void loginOut(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		try {
			response.sendRedirect(request.getContextPath() + "/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
