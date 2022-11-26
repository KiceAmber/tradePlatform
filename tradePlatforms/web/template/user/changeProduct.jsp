<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<html>
<head>
<meta charset="GBK">
<title>修改商品</title>
<link rel="stylesheet" href="/static/css/product.css">
</head>
<body>
	<!-- 快捷导航 -->
	<div class="shortcut">
		<div class="wrapper">
			<ul>
				<li><a href="userInfo.jsp ">个人中心</a></li>
			</ul>
		</div>
	</div>
	<!-- 个人信息 -->
	<div class="personalInfo">
		<div class="section1">
			<img alt="头像" src="/static/images/user/default.png">
		</div>
		<div class="section2">
			<ul>
				<li><h1 style="color: rgb(235, 225, 225);">${user_session.userName}</h1></li>
				<li><h4 style="color: whitesmoke;">手机号：${user_session.userPhone}</h4></li>
				<li><h4 style="color: whitesmoke;">注册时间：${user_session.useRegistrationTime}</h4></li>
			</ul>
		</div>
		<div class="section3">
			<ul>
				<li><a
						href="/template/user/changePersonal.jsp"
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
			<h3 style="display: inline-block;">我的发布</h3>
			<span class="from1">
				<form action="#" method="post" name="searchInfo">
					<input type="text" name="searchText" placeholder="请输入商品名称">
					<input type="submit" name="search" value="Search"
						onclick="return formCheck()">
				</form>
			</span>
		</div>
	</div>
	<div class="productInfo1">
		<!-- 修改商品信息 -->
		<div class="contend3">
			<form action="/user/modifyProduct" method="post" name="changeform2">
				<div class="message">${message}</div>
				<div class="title1">
					<p style="font-size: 30px;">商品原名称</p>
				</div>
				<div class="addname">
					<input type="text" name="productOldName">
				</div>
				<div class="title2">
					<p style="font-size: 30px;">商品新名称</p>
				</div>
				<div class="addstyle">
					<input type="text" name="productNewName">
				</div>
				<div class="title3">
					<p style="font-size: 30px;">商品现分类</p>
				</div>
				<div class="addprice">
					<input type="text" name="productNewSort">
				</div>
				<div class="title4">
					<p style="font-size: 30px;">商品现价格</p>
				</div>
				<div class="addprice2">
					<input type="text" name="productNewPrice">
				</div>
				<!-- 修改按钮 -->
				<div class="but1">
					<input type="submit" value="确认" name="submitProduct">
				</div>
				<div class="but2">
					<input type="reset" value="重设" name="resetProduct">
				</div>
			</form>
		</div>
		<div class="contend4">
			<table>
				<tr>
					<th>商品ID</th>
					<th>商品名称</th>
					<th>类别</th>
					<th>价格</th>
					<th>商品评论数</th>
					<th>操作</th>
				</tr>

				<c:forEach items="${user_session.productList}" var="product">
					<tr>
						<td>${product.productID}</td>
						<td>${product.productName}</td>
						<td>${product.sort.sortName}</td>
						<td>${product.productPrice}</td>
						<td>${product.productCommentCount}</td>
						<td><a
								href="/user/modifyProduct">修改</a>
							<a onclick="myDel()"
							   href="/user/deleteProduct">下架</a>
						</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>

</body>
<script>
	let model = document.querySelector(".contend3");//获取模态框
	let close = document.querySelector(".close");//获取关闭按钮

	close.addEventListener("click", function() {
		model.style.display = "none";//模态框设置不可见
	})
	function myDel(event) {
		let del = confirm('是否下架此商品？');
		if(del){
			window.location.href ="/user/deleteProduct";
		} else {
			event.preventDefault();
		}
	}
    function formCheck(){
		if(document.searchInfo.searchText.value==""){
			alert('请输入商品名称');
			return false;
		}	
	}
    </script>
</html>