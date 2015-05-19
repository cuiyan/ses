<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div id="content">
	<form class="queryForm">
		<div >
			<span>课程名称：<input type="text" id="courseName" name="courseName" class="easyui-textbox"></span>
			<span>开课学院：<input type="text" id="courseName" name="courseName" class="easyui-textbox"></span>
			<span>教师姓名：<input type="text" id="courseName" name="courseName" class="easyui-textbox"></span>
			<input type="button" class="easyui-linkbutton queryBtn" value="查询">
		</div>
	</form>

<br>
<div style="height: 80%">
	<table class="easyui-datagrid"  id="queryStudentHadCourseList" >
</table>
</div>
<script>

var tab;
$(document).ready(function(){
	tab=$("#queryStudentHadCourseList").datagrid({
		url:"${pageContext.request.contextPath}/student/queryStudentHadCourseList",//加载的URL
	   	//isField:"id","C:/Users/Administrator/Downloads/spring-security-samples-tutorial-3.1.0.CI-SNAPSHOT/WEB-INF/applicationContext-security.xml"
		pagination:true,//显示分页
		pageSize:10,//分页大小
		pageList:[5,10,15,20],//每页的个数
		rownumbers:true, //是否显示行号  
        rowStyler:function(value,row,index){return 'height:80px;';},
        fitColumns:true, //自动调整各列  
        fit:true, //自适应宽度
		toolbar:'#toolbar',
		columns:[[      //每个列具体内容
		          {field:'courseNo',title:'课程编号',width:100},
	              {field:'courseName',title:'课程名称',width:100},   
// 	              {field:'teaNo',title:'教师编号',width:100},
	              {field:'teaName',title:'教师姓名',width:100},
				  {field:'courseTime',title:'时间地点',width:100},
	              {field:'courseInfo',title:'课程简介',width:100},
	              {field:'选课',title:'选课',width:30,formatter:function(value,row,index){
	            	  return "<input type='button' class='easyui-linkbutton queryBtn' onclick='deleteCourse("+row.courseNo+");' value='退选'>";
	              }}
	              
	          ]]
			,onLoadSuccess:function(){  
	            tab.datagrid('clearSelections');  
	        },
	        onLoadError:function(data){
	        	if(data.responseText) {
	        		parent.show(data.responseText);
	        	}
	        }
	})
	
// 	getDepart();
// 	getClass(n);
//getStuGrade();
	
});
// getStuGrade();
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
	console.log(dataBox);
	$("#stuGradeaa").combobox("loadData", dataBox);
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
$(".queryBtn").click(function(){
	var courseNameVal = $("#courseName").val();
	if(courseNameVal ==null){
		alert("请输入课程名称");
		return false;
	}
	tab.datagrid("load",{
		"courseName" :courseNameVal,
 	});
});
/**
 * 退选
 */
function deleteCourse(courseNo){
	$.ajax({
		type:"post",
// 		async:false,
		url:"${pageContext.request.contextPath}/student/deleteCourse",
		data:"courseNo="+courseNo,
		success:function(data){
			console.log(tab);
			tab.datagrid('reload');
// 			if(data.errorMsg){
// 				$(this).val("已选择");
// 			}
		}
	});
}
</script>
</div>

