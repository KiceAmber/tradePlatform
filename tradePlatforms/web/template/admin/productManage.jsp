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
				<tr>
					<td><img src="/static/images/list.png" width="25" height="25"></td>
					<td>1</td>
					<td>����</td>
					<td>���Ӳ�Ʒ</td>
					<td>5000Ԫ</td>
					<td>2022</td>
					<td><a href="./productManage.jsp">�¼�</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>