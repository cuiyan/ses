<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>Fullscreen Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/supersized.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager_login.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1>管理员请登录</h1>
            <form action="" id="fm" method="post">
                <input type="text" name="userName" class="username" placeholder="用户名" autocomplete="off">
                <input type="password" name="password" class="password" placeholder="密码" autocomplete="off">
                <button type="button" id="submitBtn">登录</button>
                <div class="error"><span>+</span></div>
            </form>
        </div>

        <!-- Javascript -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
        <script src="${pageContext.request.contextPath}/js/supersized.3.2.7.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/supersized-init.js"></script>
        <script src="${pageContext.request.contextPath}/js/manager_login.js"></script>


    </body>

</html>