<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<html>
<head>
<meta charset="GBK">
<title>修改资料</title>
 <link rel="stylesheet" href="/static/css/personal.css">
</head>
<body>
	<!-- 快捷导航 -->
	<div class="shortcut">
		<div class="wrapper">
			<ul>
				<li><a href=" ">个人中心</a></li>
			</ul>
		</div>
	</div>
	<!-- 个人信息 -->
	<div class="personalInfo">
		<div class="section1">
			<img alt="头像"
				src="/static/images/user/default.png">
		</div>
		<div class="section2">
			<ul>
				<li><h1 style="color: rgb(235, 225, 225);">${user_session.userName}</h1></li>
				<li><h4 style="color: whitesmoke;">手机号：&nbsp;${user_session.userPhone}</h4></li>
				<li><h4 style="color: whitesmoke;">注册时间：&nbsp;${user_session.useRegistrationTime}</h4></li>
			</ul>
		</div>
		<div class="section3">
			<ul>
				<li><a
					href="changePersonal.jsp"
					style="color: aliceblue;">修改资料</a></li>
			</ul>
		</div>
		<div class="section4">
			<ul>
				<li><a href="/user/logout" style="color: aliceblue;">注销用户</a></li>
			</ul>
		</div>

	</div>

	<!-- 发布商品信息 -->
	<div class="productInfo">
		<div class="section1">
			<h3 style="display: inline-block;">修改个人信息</h3>
		</div>
	</div>
	<div class="productInfo1">
		<div class="contend3">
			<form action="/user/modifyUser" method="post" name="changeform">
				<div class="message">${message}</div>
				<div class="title1">
					<p style="font-size: 30px;">用户名</p>
				</div>
				<div class="setname">
					<input type="text" name="userName">
				</div>
				<div class="title2">
					<p style="font-size: 30px;">手机号</p>
				</div>
				<div class="setnum">
					<input type="text" name="userPhone">
				</div>
				<div class="title3">
					<p style="font-size: 30px;">密码</p>
				</div>
				<div class="setpswd1">
					<input type="password" name="userPassword">
				</div>
				<div class="title4">
					<p style="font-size: 30px;">确认密码</p>
				</div>
				<div class="setpswd2">
					<input type="password" name="rePassword">
				</div>
				<!-- 修改按钮 -->
				<div class="but1">
					<input type="submit" value="确认" name="submitInfo">
				</div>
				<div class="but2">
					<input type="reset" value="重设" name="resetInfo">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
