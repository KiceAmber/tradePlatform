<%--
  Created by IntelliJ IDEA.
  User: amber
  Date: 2022/11/12
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>二手交易系统</title>
    <link rel="stylesheet" href="static/css/login.css">
</head>
<body>
<div class="loginBox">
    <h2>二手交易系统</h2>
    <form action="/login" method="post">
        <div class="message">${message}</div>
        <div class="item">
            <input type="text" name="userName" required>
            <label for="">用户名</label>
        </div>
        <div class="item">
            <input type="password" name="userPassword" required>
            <label for="">密码</label>
        </div>
        <button class="btn">登录
        </button>
        <a href="/template/HomePage.jsp" class="tourist">游客进入
        </a>
        <a href="/register.jsp" class="register">注册
        </a>
    </form>
</div>
</body>
</html>
