<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/color.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manager_main.css">
</head>
<body>
	<form id="courseAddForm" class="courseAddForm">
		<table class="courseTable">
			<tr>
				<td>
					课程名称：
				</td>
				<td>
					<input name="courseName" value="${course.courseName}" class="easyui-textbox w170">
				</td>
			</tr>
			<tr>
				<td>
					教师姓名：
				</td>
				<td>
					<input  class="w170 easyui-combobox" id="courseTeacher">
<!-- 					<input type="button"  style="cursor: hand;" value="查询"> -->
					<input type="hidden" name="teaNo" id="teaNo">
					<input type="hidden" name="teaName" id="teaName">
				</td>
			</tr>
			<tr>
				<td>
					时间地点：
				</td>
				<td>
					<div class="courseTDiv">
						<input name="courseEX[0].courseWeek" id="courseWeek" value="${course.courseTime}" class="easyui-combobox w70" data-options="valueField:'id', textField:'text', panelHeight:'auto'">
						<input name="courseEX[0].courseDay" id="courseDay" value="${course.courseTime}" class="easyui-combobox w70"  data-options="valueField:'id', textField:'text', panelHeight:'auto'">
						<input name="courseEX[0].courseTime" id="courseTime" value="${course.courseTime}" class="easyui-combobox w70" data-options="valueField:'id', textField:'text', panelHeight:'auto'">
						<input name="courseEX[0].courseAddress" id="courseAddress" value="${course.courseAddress}" class="easyui-combobox w70" data-options="valueField:'id', textField:'text', panelHeight:'auto'">
						<input type="button" class="add" style="cursor: hand;" value="增加">
					</div>
					
					
				</td>
			</tr>
			<tr>
				<td>
					开课学院：
				</td>
				<td>
					<input name="courseDepartNo" value="${course.courseDepartNo}" id="courseDepartNo" class="easyui-combobox w170" data-options="valueField:'id', textField:'text', panelHeight:'auto'">
				</td>
			</tr>
			<tr>
				<td>
					课程简介：
				</td>
				<td>
					<textarea rows="" cols="" name="courseInfo"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<div class="addStuBtn">
					<input type="button" id="submitBtn"  value="确认" class="w70">
					<input type="button" id="cancelBtn"  value="取消" class="w70">
				</div>
				</td>
				
			</tr>
			
		</table>
		
<%-- 		<div>课程名称：<span>&nbsp;<input name="courseName" value="${course.courseName}" class="easyui-textbox w170"></span></div> --%>
<!-- 		<div>教师姓名：<span> -->
<%-- 			<input name="teaName" value="${teacher.teaName}" class="easyui-textbox w170"> --%>
<!-- 			<input type="button" style="cursor: hand;" value="查询"> -->
<!-- 			<input type="hidden" name="teaNo"> -->
<!-- 			<input type="hidden" name="teaName"> -->
<!-- 			</span> -->
				
<!-- 		</div> -->
<%-- 		<div>上课时间：<span>&nbsp;<input name="courseWeek" id="courseWeek" value="${course.courseTime}" class="easyui-combobox w60" data-options="valueField:'id', textField:'text', panelHeight:'auto'">周 --%>
<%-- 			<input name="courseDay" id="courseDay" value="${course.courseTime}" class="easyui-combobox w60"  data-options="valueField:'id', textField:'text', panelHeight:'auto'">天 --%>
<%-- 			<input name="courseTime" id="courseTime" value="${course.courseTime}" class="easyui-combobox w60" data-options="valueField:'id', textField:'text', panelHeight:'auto'">节 --%>
<!-- 			<input type="button" style="cursor: hand;" value="增加"> -->
<!-- 			</span> -->
<!-- 		</div> -->
<%-- 		<div>上课地点：<span>&nbsp;<input name="courseAddress" value="${course.courseAddress}" class="easyui-textbox w170"></span></div> --%>
<!-- 		<div>课程简介：<span>&nbsp;<textarea rows="" cols="" name="course"></textarea></span></div> -->
<!-- 		<div class="addStuBtn"> -->
<!-- 			<input type="button" id="submitBtn" value="确认" class="w70"> -->
<!-- 			<input type="button" id="cancelBtn" value="取消" class="w70"> -->
<!-- 		</div> -->
	</form>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/module.min.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/studentManager.js"></script> --%>

<script type="text/javascript">
$("#submitBtn").click(function(){
	$("#teaNo").val($("#courseTeacher").combobox("getValue"));
	$("#teaName").val($("#courseTeacher").combobox("getText"));
	$("#courseAddForm").form('submit',{
	        url: "${pageContext.request.contextPath}/manager/saveCourse",
	        onSubmit: function(){
	            return $(this).form('validate');
	        },
	        success: function(result){
	        	result = jQuery.parseJSON(result);
	            if (result.errorMsg){
	                $.messager.show({
	                    title: 'Error',
	                    msg: result.errorMsg
	                });
	            } else {
	            	parent.tab.datagrid('reload');//刷新列表
	            	parent.$('#dataForm').dialog('close');
	            }
	        }
	    });
});
$("#cancelBtn").click(function(){
	parent.$('#dataForm').dialog('close');
});
$(function(){
	getCourseWeek();
	getCourseDay();
	getCourseTime();
// 	var n = $("#stuDepartNo").combobox('getValue');//学院
// 	if(n!=null){
// 		getClass(n);
// 	}
// 	getStuGrade();
	getCourseAddress();
	getCourseDepartNo();
})
function getCourseWeek(){
	$.ajax({
		type:"post",
		async:false,
		url:"${pageContext.request.contextPath}/manager/getCourseWeek",
		success:function(data){
			var data2 = [];
			$.each(data,function(i,n){
				data2.push({"text":n.configVal,"id":n.configKey});
			});
			$("#courseWeek").combobox("loadData", data2);
		}
	});
}
function getCourseDay(){
	$.ajax({
		type:"post",
		async:false,
		url:"${pageContext.request.contextPath}/manager/getCourseDay",
		success:function(data){
			var data2 = [];
			$.each(data,function(i,n){
				data2.push({"text":n.configVal,"id":n.configKey});
			});
			$("#courseDay").combobox("loadData", data2);
		}
	});
}

function getCourseTime(){
	$.ajax({
		type:"post",
		async:false,
		url:"${pageContext.request.contextPath}/manager/getCourseTime",
		success:function(data){
			var data2 = [];
			$.each(data,function(i,n){
				data2.push({"text":n.configVal,"id":n.configKey});
			});
			$("#courseTime").combobox("loadData", data2);
		}
	});
}
function getCourseAddress(){
	$.ajax({
		type:"post",
		async:false,
		url:"${pageContext.request.contextPath}/manager/getCourseAddress",
		success:function(data){
			var data2 = [];
			$.each(data,function(i,n){
				data2.push({"text":n.configVal,"id":n.configKey});
			});
			$("#courseAddress").combobox("loadData", data2);
		}
	});
}
function getCourseDepartNo(){
	$.ajax({
		type:"post",
		async:false,
		url:"${pageContext.request.contextPath}/manager/getDepart",
		success:function(data){
			var data2 = [];
			$.each(data,function(i,n){
				data2.push({"text":n.configVal,"id":n.configKey});
			});
			$("#courseDepartNo").combobox("loadData", data2);
		}
	});
	
}
$(".add").click(function(){
	var _id = $(".courseTDiv").length;
	$(this).parent().parent().append('<div class="courseTDiv">'+
			'<input name="courseEX['+_id+'].courseWeek" id="courseWeek_'+_id+'" value="${course.courseTime}" class=" w70" >'+
			'&nbsp;<input name="courseEX['+_id+'].courseDay" id="courseDay_'+_id+'" value="${course.courseTime}" class="w70"  >'+
			'&nbsp;<input name="courseEX['+_id+'].courseTime" id="courseTime_'+_id+'" value="${course.courseTime}" class="w70" >'+
			'&nbsp;<input name="courseEX['+_id+'].courseAddress" id="courseAddress_'+_id+'" value="${course.courseAddress}" class="w70">'+
			'&nbsp;<input type="button"  style="cursor: hand;" onclick="deleteCourseT(this);" value="删除">'+
			'</div>');
	$('#courseWeek_'+_id).combobox({
		  url:'${pageContext.request.contextPath}/manager/getCourseWeek',
		  valueField:'configKey',
		  textField:'configVal'
	});
	$('#courseDay_'+_id).combobox({
		  url:'${pageContext.request.contextPath}/manager/getCourseDay',
		  valueField:'configKey',
		  textField:'configVal'
	});
	$('#courseTime_'+_id).combobox({
		  url:'${pageContext.request.contextPath}/manager/getCourseTime',
		  valueField:'configKey',
		  textField:'configVal'
	});
	$('#courseAddress_'+_id).combobox({
		  url:'${pageContext.request.contextPath}/manager/getCourseAddress',
		  valueField:'configKey',
		  textField:'configVal'
	});
});
function deleteCourseT(obj){
	$(obj).parent().remove();
}

$('#courseTeacher').combobox({
	prompt:'输入关键字后自动搜索',
	required:true,
	mode:'remote',
	url:'getLikeTeacher',
	editable:true,
	hasDownArrow:false,
	valueField:'teaNo',
    textField:'teaName',
	onBeforeLoad: function(param){
// 		alert(param);
//  		alert(param.q);
		if(param == null || param.q == null || param.q == undefined || param.q.replace(/ /g, '') == ''){
			console.log("------------");
			var value = $(this).combobox('getValue');
			if(value){// 修改的时候才会出现q为空而value不为空
				param.id = value;
				return true;
			}
			return false;
		}
	},
	onLoadSuccess:function(data){
		console.log(data);
		var data2 = [];
		$.each(data,function(i,n){
			data2.push({"text":n.teaName,"id":n.teaNo});
		});
// 		console.log(data2);
// 		$("#courseTeacher").combobox(data2);
	}
});
</script>
</html>