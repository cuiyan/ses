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
	<form id="importStudent"  method="post" enctype="multipart/form-data" class="importForm">  
	   	<div>
	   	选择文件：　<input id="uploadExcel" name="uploadExcel" class="easyui-filebox" style="width:200px" data-options="prompt:'请选择文件...'">  
	    </div>
	    <div> 
	       　　<span><a href="#" class="easyui-linkbutton"  onclick="uploadExcel()" >导入学生信息</a></span>
	       　　<span><a href="#" class="easyui-linkbutton cancel" >取消</a></span>
	  	</div>
	</form>

</body>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/module.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-form.js"></script>

<script>
   function uploadExcel(){   
	 //得到上传文件的全路径
	 var fileName= $('#uploadExcel').filebox('getValue');
	 //进行基本校验
	 if(fileName==""){   
		$.messager.alert('提示','请选择上传文件！','info'); 
	 }else{
		 //对文件格式进行校验
		 var d1=/\.[^\.]+$/.exec(fileName); 
		 if(d1==".xls"){
			 $("#importStudent").ajaxSubmit({
				 url: "${pageContext.request.contextPath}/manager/importStudent",
				 cache: false,
				// data:$("#importStudent").serialize(),
				 success: function(data){
				  	if(data.errorMsg){
						alert("导入失败，请重新选择文件，导入");
					}else{
						parent.tab.datagrid('reload');//刷新列表
		            	parent.$('#dataForm').dialog('close');
					}
				  }
			 });
	    }else{
	        $.messager.alert('提示','请选择xls格式文件！','info'); 
	    	$('#uploadExcel').filebox('setValue',''); 
	    }
	 }
   }
	$(".cancel").click(function(){
		parent.tab.datagrid('reload');//刷新列表
		parent.$('#dataForm').dialog('close');
	});
</script>
</html>