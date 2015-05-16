<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="panel-fit">
<head>
    <meta charset="UTF-8">
    <title>学生选课管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manager_main.css">
   
</head>
<body class="easyui-layout layout panel-noscroll">
    <div class="easyui-layout" border="false" fit="true">
        <div data-options="region:'north'" class="nav_box" style="height:50px">
        	<div class="logo"></div>
        	<ul>
        		<li><a href="#" class="modifyPwd">修改密码</a></li>
        		<li><a href="#" class="loginOut">退出</a></li>
        	</ul>
        </div>
        <div data-options="region:'south',split:true" style="height:50px;"></div>
        <div data-options="region:'west',split:true" title="菜单" style="width:200px;">
        <ul class="easyui-tree tree">
        <li><div id="_easyui_tree_137" class="tree-node" onclick="open1('managerStudent','学生信息管理')"><span class="tree-title">学生信息管理</span></div></li>
        <li><div id="_easyui_tree_137" class="tree-node" onclick="open1('managerTeacher','教师信息管理')"><span class="tree-title">教师信息管理</span></div></li>
        <li><div id="_easyui_tree_137" class="tree-node" onclick="open1('managerCourse','课程管理')"><span class="tree-title">课程管理</span></div></li>
        </ul>
        </div>
        <div data-options="region:'center'" class="panel-body panel-body-noheader layout-body panel-noscroll">
        	<div id="tt" class="easyui-tabs tabs-container easyui-fluid" border="false" fit="true">
		        <div title="欢迎" style="padding:10px">
		            <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
		            <ul>
		                <li>easyui is a collection of user-interface plugin based on jQuery.</li>
		                <li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
		                <li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
		                <li>complete framework for HTML5 web page.</li>
		                <li>easyui save your time and scales while developing your products.</li>
		                <li>easyui is very easy but powerful.</li>
		            </ul>
		        </div>
		    </div>
        </div>
		
    </div>
    <!-- 弹出窗口 -->
	<div id="dataForm"  class="easyui-window"  closed="true" modal="true" style="overflow:hidden;font-size:10px;width:500px;height:350px;" title="功能编辑" >
		<div id="load" style="display:none;position:absolute;top:50%;left:50%;margin:-40px 0 0 -50px;width:100px;height:100px;border:0px solid #008800;">
			<img id="loadImg" src="${pageContext.request.contextPath}/img/load.gif"/>
		</div>
		<iframe id="winSrc" frameborder="0" width="100%" height="100%"></iframe>
	</div>
   	<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/manager_main.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<%-- 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/studentManager.js"></script> --%>
</body>
</html>