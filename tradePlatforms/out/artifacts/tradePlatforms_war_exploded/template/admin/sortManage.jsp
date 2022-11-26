<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>
<html>

<head>
<title>后台管理</title>
<link rel="stylesheet" type="text/css" href="/static/css/sortManage.css">
</head>

<body>

	<div class="header">
		<h3>欢迎来到二手交易后台管理</h3>
		<a href="/user/logout">退出</a>
	</div>

	<div class="nav">
		<ul>
			<li id='nav1'><a href="/admin/queryAllUser">用户管理</a></li>
			<li id='nav2'><a href="/admin/queryAllProduct">商品管理<br></a></li>
			<li id='nav3'><a href="/admin/queryAllSort">商品分类管理<br></a></li>
		</ul>
	</div>

	<div class="contend">
		<div class=" contend1">
			<p>商品分类显示
			<p>
		</div>
		<div class="contend2">
			<form action="/admin/addSort" method="post">
				分类名称:<input type="text" id="sortName" name="sortName"/>
				<input type="submit" value="增加" name='addSort' id="add"/>
			</form>
		</div>
		<div class="contend3">
			<table>
				<tr>
					<th><img src="/static/images/list.png" width="25" height="25"></th>
					<th>分类ID</th>
					<th>分类名</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${sort_list}" var="sort">
					<tr>
						<td><img src="/static/images/list.png" width="25" height="25"></td>
						<td>${sort.getSortID()}</td>
						<td>${sort.getSortName()}</td>
						<td><button onclick="deleteSort()">删除</button></td>
					</tr>
				</c:forEach>
				<tr>
				</tr>
			</table>
		</div>
	</div>
</body>
<script>
	let deleteSort = function (event) {
		let res = confirm("确认删除该分类？");
		if (res) {
			let tds = document.getElementsByTagName("td");
			window.location.href = "/admin/deleteSort";
		} else {
			event.preventDefault();
		}
	}
</script>
</html>