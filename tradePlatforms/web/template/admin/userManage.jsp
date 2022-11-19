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
			<form>
				用户名:<input type="text" name="userName" /> 
				用户ID:<input type="text" name="userId" /> 
				手机:<input type="text" name="phoneNum" />
				<input type="submit" value="查询" name='userSearch' id="search" />
			</form>
		</div>
		<div class="contend3">
			<table>
				<tr>
					<th><img src="/static/images/list.png" width="25" height="25"></th>
					<th>用户ID</th>
					<th>身份ID</th>
					<th>用户名</th>
					<th>手机号</th>
					<th>注册时间</th>
					<th>操作</th>
				</tr>
				<tr>
					<td><img src="/static/images/list.png" width="25" height="25"></td>
					<td>1</td>
					<td>0</td>
					<td>suchengao</td>
					<td>13327617990</td>
					<td>2022-11-5</td>
					<td><a
						href="./userManage.jsp">删除</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>