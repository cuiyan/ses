function open1(url,tabTitle){
	if ($('#tt').tabs('exists',tabTitle)){
		$('#tt').tabs('select', tabTitle);
	} else {
		$('#tt').tabs('add',{
			title:tabTitle,
			href: url,
			closable:true,
			extractor:function(data){
				data = $.fn.panel.defaults.extractor(data);
				var tmp = $('<div></div>').html(data);
				data = tmp.find('#content').html();
				tmp.remove();
				return data;
			}
		});
	}
}

$(".modifyPwd").click(function(){
	$('#winSrc')[0].src='modifyPassword';
	$('#dataForm').dialog('open');
});
$(".loginOut").click(function(){
	window.location.href="loginOut";
});