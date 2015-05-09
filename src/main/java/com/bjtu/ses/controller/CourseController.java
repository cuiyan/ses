package com.bjtu.ses.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.ses.entity.Course;
import com.bjtu.ses.model.JsonResultView;
import com.bjtu.ses.service.CourseService;

@Controller
@RequestMapping("/manager/")
public class CourseController {
	@Resource
	private CourseService courseService;

	@RequestMapping("managerCourse")
	public ModelAndView managerCourse() {
		return new ModelAndView("/manager/courseList");
	}
	@RequestMapping("queryCourseList")
	@ResponseBody
	public List<Course> queryCourseList() {
		return courseService.getList();
	}

	@RequestMapping("addOrModifyCoursePre")
	public ModelAndView addOrModifyCoursePre(String courseNo) {
		return new ModelAndView("/manager/courseAddOrModify");
	}
	@RequestMapping("saveCourse")
	@ResponseBody
	public Map<String, Object> saveCourse(Course course) {
		courseService.saveCourse(course);
		return JsonResultView.ofSeccess(0);
	}

}
