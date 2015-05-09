package com.bjtu.ses.controller;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.ses.entity.Student;
import com.bjtu.ses.service.StudentService;

@Controller
@RequestMapping("/manager/")
public class StudentController {
	@Resource
	private StudentService studentService;

	@RequestMapping("managerStudent")
	public String managerStudent() {
		return "/manager/studentList";
	}
	@RequestMapping("queryStudentList")
	@ResponseBody
	public List<Student> queryStudentList() {
		List<Student> list = studentService.getList();
		return list;
	}
	/**
	 * 添加学生
	 * 
	 * @return
	 */
	@RequestMapping("addOrModifyStudentPre")
	@ResponseBody
	public ModelAndView addStudentPre(String stuNo) {
		Student student = new Student();
		if (!"".equals(stuNo) && stuNo != null) {
			student = studentService.getStudentByStuNo(stuNo);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取学院
		// List<SESConfig> depList =
		// sesConfigService.getList(ConfigType.DEPARWMT);
		// map.put("depList", depList);
		return new ModelAndView("/manager/studentAdd")
				// .addObject("depList", depList)
				.addObject("student", student);
	}
	/**
	 * 保存学生信息
	 * 
	 * @param student
	 * @return
	 */
	@RequestMapping("saveStudent")
	@ResponseBody
	public Map<String, Object> saveStudent(Student student) {
		Map<String, Object> map = new HashMap<String, Object>();
		String stuNo = student.getStuNo();
		if (!"".equals(stuNo) && stuNo != null) {
			studentService.updateStudent(student);
		} else {
			studentService.saveStudent(student);
		}
		map.put("errorMsg", false);
		return map;
	}

	/**
	 * 导入学生信息
	 * 
	 * @return
	 */
	@RequestMapping("importStudentPre")
	public ModelAndView importStudentPre() {
		return new ModelAndView("/manager/studentImport");
	}

	/**
	 * 导入题库Excel
	 * 
	 * @param uploadExcel
	 *            上传的excel文件
	 * @param request
	 *            请求
	 * @param resposne
	 *            响应
	 * @throws UnsupportedEncodingException
	 *             编码异常
	 */
	@RequestMapping("importStudent")
	@ResponseBody
	public Map<String, Object> importStudent(
			@RequestParam MultipartFile uploadExcel,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		System.out.println(uploadExcel.getOriginalFilename());
		InputStream in;
		boolean flag = false;
		// try {
		// // 获取前台exce的输入流
		// in = uploadExcel.getInputStream();
		//
		// //获取sheetName名字
		// String sheetName =
		// leadToInQuestionTypesManageBean.getSheetName(questionTypeNameId);
		// // excel的表头与文字对应，获取excel表头
		// LinkedHashMap<String, String> map =
		// leadToInQuestionTypesManageBean.getMapLeadInExcelQuestionBank(questionTypeNameId);
		// //获取组合excle表头数组，防止重复用的
		// String[] uniqueFields =new String[] { "题干内容", "正确答案" };
		// //获取需要导入的具体的表
		// Class
		// class1=leadToInQuestionTypesManageBean.getClassName(questionTypeNameId);
		// //excel转化成的list集合
		// List list = null;
		// try {
		// //调用excle共用类，转化成list
		// list=ExcelUtil.excelToList(in, sheetName, class1, map, uniqueFields);
		// } catch (ExcelException e) {
		// e.printStackTrace();
		// }
		// //保存实体集合
		// flag=
		// leadToInQuestionTypesManageBean.leadInExcelQuestionBank(questionTypeNameId,
		// courseTypeId, list);
		// } catch (IOException e1) {
		// e1.printStackTrace();
		// }

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errorMsg", false);
		return map;

	}

}
