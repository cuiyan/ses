package com.bjtu.ses.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.ses.entity.Course;
import com.bjtu.ses.entity.CourseEX;
import com.bjtu.ses.entity.StudentCourse;
import com.bjtu.ses.service.StudentCourseService;

@Controller
@RequestMapping("student")
public class StudentCourseController extends BaseController {
	@Resource
	private StudentCourseService studentCourseService;
	@RequestMapping("studentCourseManager")
	public ModelAndView managerTeacher() {
		return new ModelAndView("/student/studentCourseList");
	}
	@RequestMapping("queryStudentCourseList")
	@ResponseBody
	public List<Course> queryStudentCourseList(Integer page, Integer rows, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		String studentNo = (String) request.getSession(true).getAttribute("userName");
		List<Course> list = studentCourseService.getStuCourseList(studentNo);

		List<Course> newList = new ArrayList<Course>();
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
		// result.put("rows", getByCursor(newList, page, rows));
		// result.put("total", list.size());
		// return result;
		return newList;

		// result.put("rows", getByCursor(list, page, rows));
		// result.put("total", list.size());
		// return result;
	}
	/**
	 * 已选课程
	 * 
	 * @return
	 */
	@RequestMapping("studentHadCourse")
	public ModelAndView studentHadCourse() {
		return new ModelAndView("/student/studentHadCourseList");
	}
	@RequestMapping("queryStudentHadCourseList")
	@ResponseBody
	public List<Course> queryStudentHadCourseList(Integer page, Integer rows, HttpServletRequest request) {
		// Map<String, Object> result = new HashMap<String, Object>();
		String studentNo = (String) request.getSession(true).getAttribute("userName");
		List<Course> list = studentCourseService.getList(studentNo);
		List<Course> newList = new ArrayList<Course>();
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
		// result.put("rows", getByCursor(newList, page, rows));
		// result.put("total", list.size());
		// return result;
		return newList;
		// result.put("rows", getByCursor(list, page, rows));
		// result.put("total", list.size());
		// return result;
	}
	@RequestMapping("checkCourse")
	@ResponseBody
	public Map<String, Object> checkCourse(String courseNo, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String studentNo = (String) request.getSession(true).getAttribute("userName");
		StudentCourse sc = new StudentCourse();
		sc.setCourseNo(courseNo);
		sc.setStudentNo(studentNo);
		studentCourseService.saveStudentCourse(sc);
		map.put("errorMsg", true);
		return map;
	}
	@RequestMapping("deleteCourse")
	@ResponseBody
	public Map<String, Object> deleteCourse(String courseNo, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String studentNo = (String) request.getSession(true).getAttribute("userName");
		StudentCourse sc = new StudentCourse();
		sc.setCourseNo(courseNo);
		sc.setStudentNo(studentNo);
		studentCourseService.deleteStudentCourse(sc);
		map.put("errorMsg", true);
		return map;
	}
}
