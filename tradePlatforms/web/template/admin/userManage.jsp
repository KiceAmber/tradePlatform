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
		<a href="#">�˳�</a>

	</div>

	<div class="nav">
		<ul>
			<li id='nav1'><a href="./userManage.jsp">�û�����</a></li>
			<li id='nav2'><a href="./productManage.jsp">��Ʒ����<br></a></li>
			<li id='nav3'><a href="./sortManage.jsp">��Ʒ�������<br></a></li>
		</ul>
	</div>

	<div class="contend">
		<div class=" contend1">
			<p>�û��б���ʾ</p>
		</div>
		<div class="contend2">
			<form>
				�û���:<input type="text" name="userName" /> 
				�û�ID:<input type="text" name="userId" /> 
				�ֻ�:<input type="text" name="phoneNum" />
				<input type="submit" value="��ѯ" name='userSearch' id="search" />
			</form>
		</div>
		<div class="contend3">
			<table>
				<tr>
					<th><img src="/static/images/list.png" width="25" height="25"></th>
					<th>�û�ID</th>
					<th>���ID</th>
					<th>�û���</th>
					<th>�ֻ���</th>
					<th>ע��ʱ��</th>
					<th>����</th>
				</tr>
				<tr>
					<td><img src="/static/images/list.png" width="25" height="25"></td>
					<td>1</td>
					<td>0</td>
					<td>suchengao</td>
					<td>13327617990</td>
					<td>2022-11-5</td>
					<td><a
						href="./userManage.jsp">ɾ��</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>