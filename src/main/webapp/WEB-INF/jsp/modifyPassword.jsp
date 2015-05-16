<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/color.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manager_main.css">
</head>
<body>
<form id="pwdForm" class="pwdForm">
	<ul>
		<li>
			<div class="fm_left">现在的密码：</div>
			<div class="fm_right">
				<input type="password" id="oldPwd" name="oldPwd" class="easyui-textbox" />
				<span id="errPwd" class="err" style="display: inline-block;"></span>
			</div>
		</li>
		<li>
			<div class="fm_left">设置新的密码：</div>
			<div class="fm_right">
				<input type="password" id="newPwd" name="newPwd" class="easyui-textbox" />
				<span id="errNewPwd" class="err" style="display: inline-block;"></span>
			</div>
		</li>
		<li>
			<div class="fm_left">重复新的密码：</div>
			<div class="fm_right">
				<input type="password" id="reNewPwd" name="reNewPwd" class="easyui-textbox" />
				<span id="errReNewPwd" class="err" style="display: inline-block;"></span>
			</div>
		</li>
		<li>
			<div><input type="button" class="easyui-linkbutton submitBtn" value="确认"></div>
		</li>
	</ul>
</form>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/module.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>

<script type="text/javascript">
$(".submitBtn").click(function(){
	var oldPwdVal = $("#oldPwd").val();
	var newPwdVal = $("#newPwd").val();
	var reNewPwdVal = $("#reNewPwd").val();
	if(oldPwdVal==='' || oldPwdVal ===null){
		$("#errPwd").html("请输入您现在的密码");
		return false;
	}else{
		$("#errPwd").html("");
	}
	if(newPwdVal==='' || newPwdVal ===null){
		$("#errNewPwd").html("请输入新密码");
		return false;
	}else{
		$("#errNewPwd").html("");
	}
	if(reNewPwdVal!==newPwdVal){
		$("#errReNewPwd").html("两次输入的新密码不一致");
		return false;
	}else{
		$("#errReNewPwd").html("");
	}
	$("#pwdForm").form('submit',{
        url: "${pageContext.request.contextPath}/manager/modifyPwd",
        onSubmit: function(){
            return $(this).form('validate');
        },
        dataType:"json",
        success: function(data){
        	
           data = jQuery.parseJSON(data);
            if (!data.success){
                $.messager.show({
                    title: 'Error',
                    msg: data.msg
                });
            } else {
            	layer.msg('修改成功');
            	setTimeout(function () { 
            		parent.$('#dataForm').dialog('close');
            	}, 2000);
            }
        }
    });
});
</script>
</html>