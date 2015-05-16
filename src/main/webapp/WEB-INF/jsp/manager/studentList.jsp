<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div id="content">
	<form class="queryForm">
		<div >
			<span>学生姓名：<input type="text" id="stuName" name="stuName" class="easyui-textbox"></span>
			<span>所属学院：<input class="easyui-combobox " id="stuDepartNo" name="stuDepartNo" 
			data-options="
			    valueField: 'configKey',
			    textField: 'configVal',
			    url: '${pageContext.request.contextPath}/manager/getDepart',
			    onSelect: function(rec){
			    console.log(rec);
			    var url = '${pageContext.request.contextPath}/manager/getClasses?departMent='+rec.configKey;
			    $('#stuClassNo').combobox('reload', url);
			    }"></span>
			<span>所属班级：<input class="easyui-combobox" id="stuClassNo" name="stuClassNo"   data-options="valueField:'configKey', textField:'configVal', panelHeight:'auto'"></span>
		</div>
		<div>
			<span>所属年级：<input class="easyui-combobox" id="stuGrade" name="stuGrade"
			data-options="
				valueField: 'id',
				textField: 'text',
				panelHeight:'auto',
				data: [{
					id: '2015',
					text: '2015'
				},{
					id: '2014',
					text: '2014'
				},{
					id: '2013',
					text: '2013'
				},{
					id: '2012',
					text: '2012'
				},{
					id: '2011',
					text: '2011'
				},{
					id: '2010',
					text: '2010'
				}]"
			 ></span>
			<span>有效状态：<input type="text" class="easyui-combobox" id="idDisabled" name="idDisabled"
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
<div style="height: 70%">
<table class="easyui-datagrid"  style="overflow:hidden;" id="queryStudentList" ></table>
</div>
<script>

var tab;
$(document).ready(function(){
	tab=$("#queryStudentList").datagrid({
		url:"${pageContext.request.contextPath}/manager/queryStudentList",//加载的URL
	   	//isField:"id","C:/Users/Administrator/Downloads/spring-security-samples-tutorial-3.1.0.CI-SNAPSHOT/WEB-INF/applicationContext-security.xml"
		pagination:true,//显示分页
		pageSize:10,//分页大小
		pageList:[5,10,15,20],//每页的个数
		rownumbers:true,
		toolbar:'#toolbar',
		rownumbers:true, //是否显示行号  
        rowStyler:function(value,row,index){return 'height:80px;';},
        fitColumns:true, //自动调整各列  
        fit:true, //自适应宽度
		columns:[[      //每个列具体内容
		          {field:'stuNo',title:'学号',width:100},
	              {field:'stuName',title:'学生姓名',width:100},   
	              {field:'stuDepart',title:'所属学院',width:100},
	              {field:'stuClass',title:'所属班级',width:100},
	              {field:'stuGrade',title:'年级',width:100},
	              {field:'idDisabled',title:'有效状态',formatter:function(value){
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
	            	$('#winSrc')[0].src='${pageContext.request.contextPath}/manager/addOrModifyStudentPre';
	            	$('#dataForm').dialog('open');
//	             	$('#win').window('open');  
//	                 openWin("新增", "${pageContext.request.contextPath}/manager/addStudentPre", 960, 500);
	            }
	     },'-',{ 
	           	 text:'修改',  
	                iconCls:'icon-edit',  
	                handler : function() {
	                    var row = $('#queryStudentList').datagrid('getSelections');
	                    if (row.length == 0) {
	                        alert("请选择要修改的数据");
	                        return false;
	                    }
	                    if (row.length > 1) {
	                        alert("只能选择一条数据进行修改");
	                        return false;
	                    }
	                    $('#winSrc')[0].src='${pageContext.request.contextPath}/manager/addOrModifyStudentPre?stuNo='+ row[0].stuNo;
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
	
// 	getDepart();
// 	getClass(n);
// getStuGrade();

});
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
	$("#stuGradeaa").combobox("reload", dataBox);
}

$(".queryBtn").click(function(){
	var stuNameVal = $("#stuName").val();
	var stuDepartNoVal = $("#stuDepartNo").combobox("getValue");
	var stuClassNoVal = $("#stuClassNo").combobox("getValue");
	var stuGradeVal = $("#stuGrade").combobox("getValue");
	var idDisabledVal = $("#idDisabled").combobox("getValue");
	if(stuNameVal==null && stuDepartNoVal==null && stuClassNoVal==null && stuGradeVal==null && idDisabledVal==null){
		alert("请至少输入一项进行查询");
		return false;
	}
	tab.datagrid("load",{
		"stuName" 		:stuNameVal,
		"stuDepartNo"	: stuDepartNoVal,
		"stuClassNo"	: stuClassNoVal,
		"stuGrade"		: stuGradeVal,
		"idDisabled"	: idDisabledVal
 	});
});
</script>
</div>

