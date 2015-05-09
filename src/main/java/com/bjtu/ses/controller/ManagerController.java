package com.bjtu.ses.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjtu.ses.entity.SESConfig;
import com.bjtu.ses.enums.ConfigType;
import com.bjtu.ses.service.SESConfigService;

@Controller
@RequestMapping("/manager/")
public class ManagerController {
	@Resource
	private SESConfigService sesConfigService;

	@RequestMapping("getDepart")
	@ResponseBody
	public List<SESConfig> getDepart() {
		return sesConfigService.getList(ConfigType.DEPARWMT);
	}
	@RequestMapping("getClasses")
	@ResponseBody
	public List<SESConfig> getClasses(String departMent) {
		return sesConfigService.getList(ConfigType.DEPARWMT, Integer.parseInt(departMent));
	}
	@RequestMapping("getCourseTime")
	@ResponseBody
	public List<SESConfig> getCourseTime() {
		return sesConfigService.getList(ConfigType.COURSETIME);
	}
	@RequestMapping("getCourseDay")
	@ResponseBody
	public List<SESConfig> getCourseDay() {
		return sesConfigService.getList(ConfigType.COURSEDAY);
	}
	@RequestMapping("getCourseWeek")
	@ResponseBody
	public List<SESConfig> getCourseWeek() {
		return sesConfigService.getList(ConfigType.COURSEWEEK);
	}
	@RequestMapping("getCourseAddress")
	@ResponseBody
	public List<SESConfig> getCourseAddress() {
		return sesConfigService.getList(ConfigType.COURSEADDRESS);
	}
}
