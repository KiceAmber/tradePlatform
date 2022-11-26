<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<html>
<head>
<title>后台管理</title>
<link rel="stylesheet" type="text/css" href="/static/css/productManage.css">
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
			<p>商品列表显示</p>
		</div>
		<div class="contend2">
			<form>
				商品ID:<input type="text" name="productID" /> 
			    商品名称:<input type="text" name="productName" /> 
				商品类别:<input type="text" name="productSort" />
				<input type="submit" value="查询" name='productSearch' id="search" />
			</form>
		</div>
		<div class="contend3">
			<table>
				<tr>
					<th><img src="/static/images/list.png" width="25" height="25"></th>
					<th>商品ID</th>
					<th>商品名称</th>
					<th>类别</th>
					<th>价格</th>
					<th>商品评论数</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${product_list}" var="product">
					<tr>
						<td><img src="/static/images/list.png" width="25" height="25"></td>
						<td>${product.productID}</td>
						<td>${product.productName}</td>
						<td>${product.sort.sortName}</td>
						<td>${product.productPrice}</td>
						<td>${product.productCommentCount}</td>
						<td><button onclick="deleteProduct" id="deleteBtn">删除</button></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
<script>
	function esc() {

	}
</script>
</html>