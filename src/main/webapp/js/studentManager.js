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
	$("#stuGrade").combobox("loadData", dataBox);
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
function getClass(){
	var data2 = [];
	var n = $("#stuDepartNo").combobox('getValue');//学院
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