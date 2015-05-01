<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="HandheldFriendly" content="True">
<meta name="MobileOptimized" content="320">
<meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>首页</title>

<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/unslider.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/app-style.css">

</head>
<body>
<div class="context_box">
<div class="banner">
	<ul class="banner_box">
		<li><img alt="banner01" src="${pageContext.request.contextPath}/img/banner03.jpg"></li>
		<li><img alt="banner01" src="${pageContext.request.contextPath}/img/banner02.jpg"></li>
		<li><img alt="banner01" src="${pageContext.request.contextPath}/img/banner01.jpg"></li>
	</ul>
</div>
	<div class="warp_box">
		<p class="link_us">联系电话：010-53011727</p>
		<p class="link_us">联系电话：010-53011728</p>
	</div>
	<div class="warp_box">
	<a href="education">
		<span class="fl nav_img nav01_img"></span>
		<span class="fr nav_title nav01_title">
			<h2>教育理念</h2>
			<p>我们的教育理念</p>
		</span>
	</a>
	</div>
	<div class="warp_box">
	<a href="timetable">
		<span class="fl nav_title nav02_title">
			<h2>课程列表</h2>
			<p>最新课程动态</p>
		</span>
		<span class="fr nav_img nav02_img"></span>
	</a>
	</div>
	<div class="warp_box">
	<a href="../appointment/getinfo">
		<span class="fl nav_img nav03_img"></span>
		<span class="fr nav_title nav03_title">
			<h2>预约免费体验</h2>
			<p>免费预约试听</p>
		</span>
	</a>
	</div>
	<div class="warp_box">
	<a href="aboutus">
		<span class="fl nav_title nav04_title">
			<h2>关于我们</h2>
			<p>更详细的了解我们</p>
		</span>
		<span class="fr nav_img nav04_img"></span>
	</a>
	</div>
	<jsp:include page="../include/footer.jsp"/>
</div>

<script type="text/javascript">
$(function() {
    $('.banner').unslider();
});
</script>
</body>
</html>