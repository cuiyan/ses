package com.bjtu.ses.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.ses.entity.Teacher;
import com.bjtu.ses.model.JsonResultView;
import com.bjtu.ses.service.TeacherService;

@Controller
@RequestMapping("/manager/")
public class TeacherController {
	@Resource
	private TeacherService teacherService;

	@RequestMapping("managerTeacher")
	public ModelAndView managerTeacher() {
		return new ModelAndView("/manager/teacherList");
	}

	@RequestMapping("queryTeacherList")
	@ResponseBody
	public List<Teacher> queryTeacherList() {
		return teacherService.getList();
	}

	@RequestMapping("addOrModifyTeacherPre")
	@ResponseBody
	public ModelAndView addOrModifyTeacherPre(String teaNo) {
		Teacher teacher = new Teacher();
		if (!"".equals(teaNo) && teaNo != null) {
			teacher = teacherService.getTeacherByTeaNo(teaNo);
		}
		return new ModelAndView("/manager/teacherAddOrModify").addObject("teacher", teacher);
	}

	@RequestMapping("saveTeacher")
	@ResponseBody
	public Map<String, Object> saveTeacher(Teacher teacher) {
		String teaNo = teacher.getTeaNo();
		if (!"".equals(teaNo) && teaNo != null) {
			teacherService.updateTeacher(teacher);
		} else {
			teacherService.saveTeacher(teacher);
		}
		return JsonResultView.ofSeccess(0);
	}
}
