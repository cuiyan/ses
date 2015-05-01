<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div id="content">
<table class="easyui-datagrid"   id="queryAppointmentList" >
   
</table>
<script>
var tab=$("#queryAppointmentList").datagrid({
	url:"${pageContext.request.contextPath}/manager/queryAppointmentList",//加载的URL
   	//isField:"id","C:/Users/Administrator/Downloads/spring-security-samples-tutorial-3.1.0.CI-SNAPSHOT/WEB-INF/applicationContext-security.xml"
	pagination:true,//显示分页
	pageSize:5,//分页大小
	pageList:[5,10,15,20],//每页的个数
	fit:true,//自动补全
	fitColumns:true,
	rownumbers:true,
	columns:[[      //每个列具体内容
              {field:'babyName',title:'宝贝姓名',width:100},   
              {field:'birthday',title:'出生日期',width:100,formatter:function(value){
            	  var date = new Date(value);
                  return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
              }},
              {field:'telephone',title:'联系电话',width:100},
              {field:'listenWay',title:'获取途径',width:100}
              
          ]]
})

</script>
</div>

