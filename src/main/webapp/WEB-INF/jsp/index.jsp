<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
        	<div class="welcome">您好，${userName }</div>
        	<ul>
        		<li><a href="#" class="modifyPwd">修改密码</a></li>
        		<li><a href="#" class="loginOut">退出</a></li>
        	</ul>
        </div>
        <div data-options="region:'south',split:true" style="height:50px;"></div>
        <div data-options="region:'west',split:true" title="菜单" style="width:200px;">
        <ul class="easyui-tree tree">
        <c:if test="${userRole=='MANAGER'}">
        <li><div id="_easyui_tree_131" class="tree-node" onclick="open1('managerStudent','学生信息管理')"><span class="tree-title">学生信息管理</span></div></li>
        <li><div id="_easyui_tree_132" class="tree-node" onclick="open1('managerTeacher','教师信息管理')"><span class="tree-title">教师信息管理</span></div></li>
        <li><div id="_easyui_tree_133" class="tree-node" onclick="open1('managerCourse','课程管理')"><span class="tree-title">课程管理</span></div></li>
        
        </c:if>
        <c:if test="${userRole=='STUDENT' }">
        <li><div id="_easyui_tree_134" class="tree-node" onclick="open1('${pageContext.request.contextPath}/student/studentCourseManager','课程选择')"><span class="tree-title">课程选择</span></div></li>
        <li><div id="_easyui_tree_135" class="tree-node" onclick="open1('${pageContext.request.contextPath}/student/studentHadCourse','已选课程')"><span class="tree-title">已选课程</span></div></li>
        
        </c:if>
        <c:if test="${userRole=='TEACHER' }">
        
        <li><div id="_easyui_tree_136" class="tree-node" onclick="open1('${pageContext.request.contextPath}/teacher/teacherCourseManager','课程列表')"><span class="tree-title">课程列表</span></div></li>
        </c:if>
        
        </ul>
        </div>
        <div data-options="region:'center'" class="panel-body panel-body-noheader layout-body panel-noscroll">
        	<div id="tt" class="easyui-tabs tabs-container easyui-fluid" border="false" fit="true">
		        <div title="欢迎" style="padding:10px">
		            <p style="font-size:14px"> 欢迎使用，北京交通大学，学生选课系统</p>
		            
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