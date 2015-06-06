<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div id="content">
	<form class="queryForm">
		<div >
			<span>课程名称：<input type="text" id="courseName" name="courseName" class="easyui-textbox"></span>
			<input type="button" class="easyui-linkbutton queryBtn" value="查询">
		</div>
	</form>

<br>
<div style="height: 80%">
	<table class="easyui-datagrid"  id="queryTeacherCourseList" >
</table>
</div>
   <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/datagrid-defaultview.js"></script>
<script>

var tab;
$(document).ready(function(){
	tab=$("#queryTeacherCourseList").datagrid({
		 view: detailview,//注意1  
		url:"${pageContext.request.contextPath}/teacher/queryTeacherCourseList",//加载的URL
	   	//isField:"id","C:/Users/Administrator/Downloads/spring-security-samples-tutorial-3.1.0.CI-SNAPSHOT/WEB-INF/applicationContext-security.xml"
		singleSelect:true,
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
				  {field:'courseTime',title:'时间地点',width:100},
	              {field:'courseInfo',title:'课程简介',width:100}
	          ]]
			,onLoadSuccess:function(){  
	            tab.datagrid('clearSelections');  
	        },
	        onLoadError:function(data){
	        	if(data.responseText) {
	        		parent.show(data.responseText);
	        	}
	        },
	        detailFormatter:function(index,row){
	    		return '<div style="padding:2px"><table class="courseStudent" id="courseStudent"></table></div>';
	    	},
	    	onExpandRow: function(index,row){
	    		var ddv = $(this).datagrid('getRowDetail',index).find('table.courseStudent');
	    		ddv.datagrid({
	    			url:'${pageContext.request.contextPath}/teacher/queryStudentCourseList?courseNo='+row.courseNo,
	    			fitColumns:true,
	    			singleSelect:true,
	    			iconCls: 'icon-edit',
	    			rownumbers:true,
	    			onClickCell: onClickCell,
	    			loadMsg:'',
	    			height:'auto',
	    			columns:[[
	    				{field:'studentNo',title:'学号',width:100},
	    				{field:'stuName',title:'学生姓名',width:100},
	    				{field:'stuGrade',title:'所属年级',width:100},
	    				{field:'stuDepart',title:'所属学院',width:100},
	    				{field:'stuClass',title:'所属班级',width:100},
	    				{field:'courseScore',title:'分数',width:100}
	    			]],
	    			onResize:function(){
	    				$('#queryTeacherCourseList').datagrid('fixDetailRowHeight',index);
	    			},
	    			onLoadSuccess:function(){
	    				setTimeout(function(){
	    					$('#queryTeacherCourseList').datagrid('fixDetailRowHeight',index);
	    				},0);
	    			}
	    		});
	    		$('#queryTeacherCourseList').datagrid('fixDetailRowHeight',index);
	    	}
	})
	

	
});


$.extend($.fn.datagrid.methods, {
	editCell: function(jq,param){
		console.log("sasa");
// 		return jq.each(function(){
// 			console.log($(this));
// 			var opts = $(this).datagrid('options');
// 			var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
			
// 			for(var i=0; i<fields.length; i++){
// 				var col = $(this).datagrid('getColumnOption', fields[i]);
// 				col.editor1 = col.editor;
// 				if (fields[i] != param.field){
// 					col.editor = null;
// 				}
// 			}
// 			$(this).datagrid('beginEdit', param.index);
// 			for(var i=0; i<fields.length; i++){
// 				var col = $(this).datagrid('getColumnOption', fields[i]);
// 				col.editor = col.editor1;
// 			}
// 		});
	}
});
var editIndex = undefined;
function endEditing(){
	if (editIndex == undefined){return true}
	if ($('#courseStudent').datagrid('validateRow', editIndex)){
		$('#courseStudent').datagrid('endEdit', editIndex);
		editIndex = undefined;
		return true;
	} else {
		return false;
	}
}
function onClickCell(index, field){
	
	if (endEditing()){
		$('#courseStudent').datagrid('selectRow', index)
				.datagrid('editCell', {index:index,field:field});
		editIndex = index;
	}
}
</script>
</div>

