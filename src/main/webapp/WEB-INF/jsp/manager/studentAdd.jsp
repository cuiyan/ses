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
	<form id="studentAddForm" class="addForm">
		<input type="hidden" value="${student.stuNo}" name="stuNo">
		<div>学生姓名：<span>&nbsp;<input name="stuName" value="${student.stuName}" class="easyui-textbox w170"></span></div>
		<div>所属学院：<span>
			<input class="easyui-combobox w170" id="stuDepartNo" name="stuDepartNo"  value="${student.stuDepart}"  data-options="valueField:'id', textField:'text', panelHeight:'auto'">
			</span>
		</div>
		<div>所属班级：<span>
				<input class="easyui-combobox w170" id="stuClassNo" name="stuClassNo"  value="${student.stuClass}" data-options="valueField:'id', textField:'text', panelHeight:'auto'">  
			</span>
		</div>
		<div>所属年级：
			<span>
				<input class="easyui-combobox w170" id="stuGrade" name="stuGrade"  value="${student.stuGrade}" data-options="valueField:'id', textField:'text', panelHeight:'auto'">
			</span>
<!-- 			<select  name="stuGrade" id="stuGrade" class="easyui-combobox w170"> -->
<!-- 				<option value="2013">2013</option> -->
<!-- 			</select> -->
		</div>
		<div class="addStuBtn">
			<input type="button" id="submitBtn" value="确认" class="w70">
			<input type="button" id="cancelBtn" value="取消" class="w70">
		</div>
	</form>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/module.min.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/studentManager.js"></script> --%>

<script type="text/javascript">
$("#submitBtn").click(function(){
	$("#studentAddForm").form('submit',{
	        url: "${pageContext.request.contextPath}/manager/saveStudent",
	        onSubmit: function(){
	            return $(this).form('validate');
	        },
	        success: function(result){
	            console.log(result);// {"errorMsg":false} todo has a bug
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
	getDepart();
	var n = $("#stuDepartNo").combobox('getValue');//学院
	if(n!=null){
		getClass(n);
	}
	getStuGrade();
})
/**
 * 设置学年
 */
function getStuGrade(){
	var myDate = new Date();
	myDate.getYear();        //获取当前年份(2位)
	var fullYear = myDate.getFullYear();    //获取完整的年份(4位,1970-????)
	var dataBox=[];
	for(var i=0;i<6;i++){
		dataBox.push({"text":fullYear-i,"id":fullYear-i});
	}
	$("#stuGrade").combobox("loadData", dataBox);
}
/**
 * 获取学院
 */
function getDepart(){
	$.ajax({
		type:"post",
		async:false,
		url:"${pageContext.request.contextPath}/manager/getDepart",
		success:function(data){
			var data2 = [];
			$.each(data,function(i,n){
				data2.push({"text":n.configVal,"id":n.configKey});
			});
			$("#stuDepartNo").combobox("loadData", data2);
		}
	});
}
/**
 * 设置专业
 */
function getClass(n){
	var data2 = [];
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/manager/getClasses",
		data:"departMent="+n,
		success:function(data){
			$.each(data,function(i,n){
				data2.push({"text":n.configVal,"id":n.configKey});
			});
			$("#stuClassNo").combobox("loadData", data2);
		}
	});
}
$("#stuDepartNo").combobox({
	onChange: function (n,o) {
		var data2 = [];
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/manager/getClasses",
			data:"departMent="+n,
			success:function(data){
				$.each(data,function(i,n){
					data2.push({"text":n.configVal,"id":n.configKey});
				});
				$("#stuClassNo").combobox("loadData", data2);
			}
		});
	}
});
</script>
</html>