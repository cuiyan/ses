package com.bjtu.ses.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.ses.entity.Course;
import com.bjtu.ses.entity.CourseEX;
import com.bjtu.ses.model.JsonResultView;
import com.bjtu.ses.service.CourseService;

@Controller
@RequestMapping("/manager/")
public class CourseController extends BaseController {
	@Resource
	private CourseService courseService;

	@RequestMapping("managerCourse")
	public ModelAndView managerCourse() {
		return new ModelAndView("/manager/courseList");
	}
	@RequestMapping("queryCourseList")
	@ResponseBody
	public List<Course> queryCourseList(Integer page, Integer rows, String courseName) {
		Map<String, Object> result = new HashMap<String, Object>();
		Course queryCou = new Course();
		queryCou.setCourseName(courseName);
		List<Course> list = courseService.getList(queryCou);
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
