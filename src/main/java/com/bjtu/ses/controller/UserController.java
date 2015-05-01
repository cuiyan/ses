package com.bjtu.ses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 用户登陆及用户信息管理
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manager/")
public class UserController {

	@RequestMapping("index")
	public String managerIndex() {
		return "manager/index";
	}
}
