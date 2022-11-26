<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<html>
<head>
<title>��̨����</title>
<link rel="stylesheet" type="text/css" href="/static/css/productManage.css">
</head>

<body>

	<div class="header">
		<h3>��ӭ�������ֽ��׺�̨����</h3>
		<a href="/user/logout">�˳�</a>
	</div>

	<div class="nav">
		<ul>
			<li id='nav1'><a href="/admin/queryAllUser">�û�����</a></li>
			<li id='nav2'><a href="/admin/queryAllProduct">��Ʒ����<br></a></li>
			<li id='nav3'><a href="/admin/queryAllSort">��Ʒ�������<br></a></li>
		</ul>
	</div>

	<div class="contend">
		<div class=" contend1">
			<p>��Ʒ�б���ʾ</p>
		</div>
		<div class="contend2">
			<form>
				��ƷID:<input type="text" name="productID" /> 
			    ��Ʒ����:<input type="text" name="productName" /> 
				��Ʒ���:<input type="text" name="productSort" />
				<input type="submit" value="��ѯ" name='productSearch' id="search" />
			</form>
		</div>
		<div class="contend3">
			<table>
				<tr>
					<th><img src="/static/images/list.png" width="25" height="25"></th>
					<th>��ƷID</th>
					<th>��Ʒ����</th>
					<th>���</th>
					<th>�۸�</th>
					<th>��Ʒ������</th>
					<th>����</th>
				</tr>
				<c:forEach items="${product_list}" var="product">
					<tr>
						<td><img src="/static/images/list.png" width="25" height="25"></td>
						<td>${product.productID}</td>
						<td>${product.productName}</td>
						<td>${product.sort.sortName}</td>
						<td>${product.productPrice}</td>
						<td>${product.productCommentCount}</td>
						<td><button onclick="deleteProduct" id="deleteBtn">ɾ��</button></td>
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