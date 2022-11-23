<%@ page import="com.kice.models.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kice.common.Constants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<html>
<head>
	<title>后台管理</title>
	<link rel="stylesheet" type="text/css" href="/static/css/userManage.css">
</head>

<body>
	<div class="header">
		<h3>欢迎来到二手交易后台管理</h3>
		<a href="#">退出</a>

	</div>

	<div class="nav">
		<ul>
			<li id='nav1'><a href="./userManage.jsp">用户管理</a></li>
			<li id='nav2'><a href="./productManage.jsp">商品管理<br></a></li>
			<li id='nav3'><a href="./sortManage.jsp">商品分类管理<br></a></li>
		</ul>
	</div>

	<div class="contend">
		<div class=" contend1">
			<p>用户列表显示</p>
		</div>
		<div class="contend2">
			<form action="/admin/queryUser">
				用户名:<input type="text" name="userName" /> 
				用户ID:<input type="text" name="userId" />
				<input type="submit" value="查询" name='userSearch' id="search" />
			</form>
		</div>
		<div class="contend3">
			<table>
				<tr>
					<th><img src="/static/images/list.png" width="25" height="25"></th>
					<th>用户ID</th>
					<th>身份ID(0-管理员 1-用户)</th>
					<th>用户名</th>
					<th>手机号</th>
					<th>注册时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${user_list}" var="user">
					<tr>
						<td><img src="/static/images/list.png" width="25" height="25"></td>
						<td>${user.userID}</td>
						<td>${user.userRoleId}</td>
						<td>${user.userName}</td>
						<td>${user.userPhone}</td>
						<td>${user.useRegistrationTime}</td>
						<td><a href="./userManage.jsp">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
<script>

</script>
</html>