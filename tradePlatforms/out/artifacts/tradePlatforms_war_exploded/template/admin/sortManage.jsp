<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>
<html>

<head>
<title>��̨����</title>
<link rel="stylesheet" type="text/css" href="/static/css/sortManage.css">
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
			<p>��Ʒ������ʾ
			<p>
		</div>
		<div class="contend2">
			<form action="/admin/addSort" method="post">
				��������:<input type="text" id="sortName" name="sortName"/>
				<input type="submit" value="����" name='addSort' id="add"/>
			</form>
		</div>
		<div class="contend3">
			<table>
				<tr>
					<th><img src="/static/images/list.png" width="25" height="25"></th>
					<th>����ID</th>
					<th>������</th>
					<th>����</th>
				</tr>
				<c:forEach items="${sort_list}" var="sort">
					<tr>
						<td><img src="/static/images/list.png" width="25" height="25"></td>
						<td>${sort.getSortID()}</td>
						<td>${sort.getSortName()}</td>
						<td><button onclick="deleteSort()">ɾ��</button></td>
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
		let res = confirm("ȷ��ɾ���÷��ࣿ");
		if (res) {
			let tds = document.getElementsByTagName("td");
			window.location.href = "/admin/deleteSort";
		} else {
			event.preventDefault();
		}
	}
</script>
</html>