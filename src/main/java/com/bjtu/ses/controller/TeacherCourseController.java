package com.bjtu.ses.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.ses.entity.Course;
import com.bjtu.ses.entity.CourseEX;
import com.bjtu.ses.entity.StudentCourseVO;
import com.bjtu.ses.service.StudentCourseService;
import com.bjtu.ses.service.TeacherCourseService;
import com.google.common.collect.Lists;

@Controller
@RequestMapping("teacher")
public class TeacherCourseController extends BaseController {
	@Autowired
	private TeacherCourseService teacherCourseService;
	@Autowired
	private StudentCourseService studentCourseService;
	@RequestMapping("teacherCourseManager")
	public ModelAndView managerTeacher() {
		return new ModelAndView("/teacher/teacherCourseList");
	}
	@RequestMapping("queryTeacherCourseList")
	@ResponseBody
	public List<Course> queryTeacherCourseList(HttpServletRequest request) {
		List<Course> newList = new ArrayList<Course>();
		String teacherNo = (String) request.getSession(true).getAttribute("userName");
		List<Course> list = teacherCourseService.getTeaCourseList(teacherNo);
		list.forEach(c -> {
			Course course = new Course();

			List<CourseEX> exList = c.getCourseEX();
			String courseTime = "";
			for (CourseEX ex : exList) {
				courseTime += ex.getCourseWeekCN() + "&nbsp;&nbsp;" +
						ex.getCourseDayCN() + "&nbsp;&nbsp;" + ex.getCourseTimeCN() +
						"&nbsp;&nbsp;" + ex.getCourseAddress() + "<br/>";
			}
			// exList.forEach(ex -> {
			// courseTime =ex.getCourseWeek() + ex.getCourseDay() +
			// ex.getCourseTime() + ex.getCourseAddress();
			// });
			course.setCourseNo(c.getCourseNo());
			course.setCourseName(c.getCourseName());
			course.setCourseTime(courseTime);
			course.setTeaName(c.getTeaName());
			course.setCourseInfo(c.getCourseInfo());

			newList.add(course);
		});
		return newList;
	}
	@RequestMapping("queryStudentCourseList")
	@ResponseBody
	public List<StudentCourseVO> queryStudentCourseList(String courseNo) {
		List<StudentCourseVO> list = Lists.newArrayList();
		list = studentCourseService.getStudentCourseList(courseNo);
		return list;
	}
}
