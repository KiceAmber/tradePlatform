<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<html>

<head>
<title>��̨����</title>
<link rel="stylesheet" type="text/css" href="/static/css/sortManage.css">
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
			<p>��Ʒ������ʾ
			<p>
		</div>
		<div class="contend2">
			<form>
				����ID:<input type="text" name="sortID" /> 
				��������:<input type="text" name="sortName" />
				 <input type="submit" value="����" name='sortrAdd' id="add" /> 
				 <input type="button" value="��ʾ���з���" name='sortShow' id="show" />
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
				<tr>
					<td><img src="/static/images/list.png" width="25" height="25"></td>
					<td>1</td>
					<td>���Ӳ�Ʒ</td>
					<td><a href="./sortManage.jsp">ɾ��</a></td>
				</tr>
				<tr>

				</tr>
			</table>
		</div>
	</div>
</body>
</html>