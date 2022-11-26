<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<html>
<head>
	<title>��̨����</title>
	<link rel="stylesheet" type="text/css" href="/static/css/userManage.css">
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
			<p>�û��б���ʾ</p>
		</div>
		<div class="contend2">
			<form action="/admin/queryUser">
				�û���:<input type="text" name="userName" /> 
				�û�ID:<input type="text" name="userId" />
				<input type="submit" value="��ѯ" name='userSearch' id="search" />
			</form>
		</div>
		<div class="contend3">
			<table>
				<tr>
					<th><img src="/static/images/list.png" width="25" height="25"></th>
					<th>�û�ID</th>
					<th>���ID(0-����Ա 1-�û�)</th>
					<th>�û���</th>
					<th>�ֻ���</th>
					<th>ע��ʱ��</th>
					<th>����</th>
				</tr>
				<c:forEach items="${user_list}" var="user">
					<tr>
						<td><img src="/static/images/list.png" width="25" height="25"></td>
						<td>${user.userID}</td>
						<td>${user.userRoleId}</td>
						<td>${user.userName}</td>
						<td>${user.userPhone}</td>
						<td>${user.useRegistrationTime}</td>
						<td><a href="./userManage.jsp">ɾ��</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
<script>

</script>
</html>