package com.bjtu.ses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.ses.dao.CourseDao;
import com.bjtu.ses.dao.SESConfigDao;
import com.bjtu.ses.entity.Course;
import com.bjtu.ses.entity.CourseEX;
import com.bjtu.ses.entity.SESConfig;
import com.bjtu.ses.enums.ConfigType;
import com.bjtu.ses.service.CourseService;
import com.bjtu.ses.util.StringUtils;
@Service
public class CourseServiceImpl implements CourseService {
	@Resource
	private CourseDao courseDao;
	@Resource
	private SESConfigDao sesConfigDao;
	@Override
	public List<Course> getList() {
		return courseDao.getList();
	}
	public List<Course> getList(Course course) {
		return courseDao.getList(course);
	}
	// public List<Map<String, Object>> getList(Course course) {
	// return courseDao.getList(course);
	// }
	@Override
	public void saveCourse(Course course) {
		SESConfig ses = sesConfigDao.getByConfigKey(course.getCourseDepartNo(), 0, ConfigType.DEPARWMT);
		if (ses != null) {
			course.setCourseDepartName((ses.getConfigVal()));
		}

		int count = courseDao.getCount(course);
		count++;
		String courseNo = course.getCourseDepartNo() + StringUtils.getFiveLengthCode(count);
		course.setCourseNo(courseNo);
		List<CourseEX> exList = course.getCourseEX();
		exList.forEach(ex -> {
			ex.setCourse(course);
			SESConfig ses1 = sesConfigDao.getByConfigKey(ex.getCourseWeek(), 0, ConfigType.COURSEWEEK);
			ex.setCourseWeekCN(ses1.getConfigVal());
			ses1 = sesConfigDao.getByConfigKey(ex.getCourseDay(), 0, ConfigType.COURSEDAY);
			ex.setCourseDayCN(ses1.getConfigVal());
			ses1 = sesConfigDao.getByConfigKey(ex.getCourseTime(), 0, ConfigType.COURSETIME);
			ex.setCourseTimeCN(ses1.getConfigVal());
		});
		courseDao.add(course);
	}
	@Override
	public Course getCourseByCourseNo(String teaNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCourse(Course Course) {
		// TODO Auto-generated method stub

	}

}
