<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<html>

<head>
<title>后台管理</title>
<link rel="stylesheet" type="text/css" href="/static/css/sortManage.css">
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
			<p>商品分类显示
			<p>
		</div>
		<div class="contend2">
			<form>
				分类ID:<input type="text" name="sortID" /> 
				分类名称:<input type="text" name="sortName" />
				 <input type="submit" value="增加" name='sortrAdd' id="add" /> 
				 <input type="button" value="显示所有分类" name='sortShow' id="show" />
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
				<tr>
					<td><img src="/static/images/list.png" width="25" height="25"></td>
					<td>1</td>
					<td>电子产品</td>
					<td><a href="./sortManage.jsp">删除</a></td>
				</tr>
				<tr>

				</tr>
			</table>
		</div>
	</div>
</body>
</html>