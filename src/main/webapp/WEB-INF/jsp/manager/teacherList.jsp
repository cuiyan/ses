<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div id="content">
	<form class="queryForm">
		<div >
			<span>教师姓名：<input type="text" id="teaName" name="teaName" class="easyui-textbox"></span>
			<span>所属学院：<input class="easyui-combobox " id="teaDepartNo" name="teaDepartNo"  data-options="valueField:'configKey',textField:'configVal',url:'${pageContext.request.contextPath}/manager/getDepart'"></span>
<!-- 		</div> -->
<!-- 		<div> -->
			<span>有效状态：<input type="text" id="isDisabled" name="isDisabled" class="easyui-combobox" 
				data-options="
				valueField: 'id',
				textField: 'text',
				panelHeight:'auto',
				data: [{
					id: 'TRUE',
					text: '有效',
<!-- 					selected:true -->
				},{
					id: 'FALSE',
					text: '无效'
				}]"
			></span>
			<input type="button" class="easyui-linkbutton queryBtn" value="查询">
		</div>
	</form>

<br>
<div style="height: 80%">
<table class="easyui-datagrid" style="overflow:hidden;"   id="queryTeacherList" >
</table>
</div>
<script>

var tab;
$(document).ready(function(){
	tab=$("#queryTeacherList").datagrid({
		url:"${pageContext.request.contextPath}/manager/queryTeacherList",//加载的URL
	   	//isField:"id","C:/Users/Administrator/Downloads/spring-security-samples-tutorial-3.1.0.CI-SNAPSHOT/WEB-INF/applicationContext-security.xml"
		pagination:true,//显示分页
		pageSize:10,//分页大小
		pageList:[5,10,15,20],//每页的个数
		toolbar:'#toolbar',
		rownumbers:true, //是否显示行号  
        rowStyler:function(value,row,index){return 'height:80px;';},
        fitColumns:true, //自动调整各列  
        fit:true, //自适应宽度
		columns:[[      //每个列具体内容
		          {field:'teaNo',title:'教师编号',width:100},
	              {field:'teaName',title:'教师姓名',width:100},   
	              {field:'teaDepart',title:'所属学院',width:100},
	              {field:'isDisabled',title:'有效状态',formatter:function(value){
	            	  if("TRUE"==value){
	            		  return "有效";
	            	  }else{
	            		  return "无效";
	            	  }
	              }}
	          ]],
	    toolbar:[{
	    	 text:'新增',  
	            iconCls:'icon-add',  
	            handler : function() {
	            	$('#winSrc')[0].src='${pageContext.request.contextPath}/manager/addOrModifyTeacherPre';
	            	$('#dataForm').dialog('open');
	            }
	     },'-',{ 
	           	 text:'修改',  
	                iconCls:'icon-edit',  
	                handler : function() {
	                    var row = $('#queryTeacherList').datagrid('getSelections');
	                    if (row.length == 0) {
	                        alert("请选择要修改的数据");
	                        return false;
	                    }
	                    if (row.length > 1) {
	                        alert("只能选择一条数据进行修改");
	                        return false;
	                    }
	                    $('#winSrc')[0].src='${pageContext.request.contextPath}/manager/addOrModifyTeacherPre?teaNo='+ row[0].teaNo;
	                	$('#dataForm').dialog('open');
	                }
	            }
// 	     ,'-',{
// 	            	text:'至无效',
// 	            	iconCls:'icon-remove',
// 	            	handler:function(){
// 	            		var row = $('#queryStudentList').datagrid('getSelections');
// 	            		if (row.length == 0) {
// 	                        alert("请选择要至无效的数据");
// 	                        return false;
// 	                    }
// 	                    if (row.length > 1) {
// 	                        alert("只能选择一条数据进行至无效");
// 	                        return false;
// 	                    }
	                  
// 	            	}
// 	            }
	     	,'-',{
	            	text:'导入',
	            	iconCls:'icon-ok',
	            	handler:function(){
	            		$('#winSrc')[0].src='${pageContext.request.contextPath}/manager/importStudentPre';
	                	$('#dataForm').dialog('open');
	            	}
	            }
	     
	     ],onLoadSuccess:function(){  
	            tab.datagrid('clearSelections');  
	        },
	        onLoadError:function(data){
	        	if(data.responseText) {
	        		parent.show(data.responseText);
	        	}
	        }
	})
	
//  	getDepart();
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
	var teaNameVal = $("#teaName").val();
	var teaDepartNoVal = $("#teaDepartNo").combobox("getValue");
	var idDisabledVal = $("#isDisabled").combobox("getValue");
	if(teaNameVal==null && teaDepartNoVal==null && idDisabledVal==null){
		alert("请至少输入一项进行查询");
		return false;
	}
	tab.datagrid("load",{
		"teaName" 		:teaNameVal,
		"teaDepartNo"	: teaDepartNoVal,
		"isDisabled"	: idDisabledVal
 	});
});
</script>
</div>

