package com.bjtu.ses.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.ses.controller.result.ManagerBean;
import com.bjtu.ses.service.UserService;

public class LoginCheck implements HandlerInterceptor {
	Log log = LogFactory.getLog(LoginCheck.class);

	@Resource
	private UserService userService;

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {

		Cookie[] cookies = request.getCookies();
		HttpSession session = request.getSession();

		String loginKey = "";
		ManagerBean manager = (ManagerBean) session.getAttribute("manager");

		if (cookies == null || cookies.length == 0) {
			log.error("尚未登录或登录超时");
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}

		for (Cookie cookie : cookies) {
			if ("LOGINKEY".equals(cookie.getName())) {
				loginKey = cookie.getValue();
				break;
			}
		}

		try {
			session.setAttribute("userName", manager.getUserName());
			userService.statusCheck(manager, loginKey);
		} catch (Exception e) {
			log.error(e.getMessage());
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		return true;
	}

}
