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
	<form id="teacherAddForm" class="addForm">
		<input type="hidden" value="${teacher.teaNo}" name="teaNo">
		<div>教师姓名：<span>&nbsp;<input name="teaName" value="${teacher.teaName}" class="easyui-textbox w170"></span></div>
		<div>所属学院：<span>
			<input class="easyui-combobox w170" id="teaDepartNo" name="teaDepartNo"  value="${teacher.teaDepartNo}"  data-options="valueField:'id', textField:'text', panelHeight:'auto'">
			</span>
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
	$("#teacherAddForm").form('submit',{
	        url: "${pageContext.request.contextPath}/manager/saveTeacher",
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
	getDepart();
})

/**
 * 获取学院
 */
function getDepart(){
	$.ajax({
		type:"post",
		async:false,
		url:"${pageContext.request.contextPath}/manager/getDepart",
		success:function(data){
			console.log(data);
			var data2 = [];
			$.each(data,function(i,n){
				data2.push({"text":n.configVal,"id":n.configKey});
			});
			$("#teaDepartNo").combobox("loadData", data2);
		}
	});
}

</script>
</html>