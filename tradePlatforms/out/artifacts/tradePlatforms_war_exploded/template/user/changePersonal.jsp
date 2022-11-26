<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<html>
<head>
<meta charset="GBK">
<title>�޸�����</title>
 <link rel="stylesheet" href="/static/css/personal.css">
</head>
<body>
	<!-- ��ݵ��� -->
	<div class="shortcut">
		<div class="wrapper">
			<ul>
				<li><a href=" ">��������</a></li>
			</ul>
		</div>
	</div>
	<!-- ������Ϣ -->
	<div class="personalInfo">
		<div class="section1">
			<img alt="ͷ��"
				src="/static/images/user/default.png">
		</div>
		<div class="section2">
			<ul>
				<li><h1 style="color: rgb(235, 225, 225);">${user_session.userName}</h1></li>
				<li><h4 style="color: whitesmoke;">�ֻ��ţ�&nbsp;${user_session.userPhone}</h4></li>
				<li><h4 style="color: whitesmoke;">ע��ʱ�䣺&nbsp;${user_session.useRegistrationTime}</h4></li>
			</ul>
		</div>
		<div class="section3">
			<ul>
				<li><a
					href="changePersonal.jsp"
					style="color: aliceblue;">�޸�����</a></li>
			</ul>
		</div>
		<div class="section4">
			<ul>
				<li><a href="/user/logout" style="color: aliceblue;">ע���û�</a></li>
			</ul>
		</div>

	</div>

	<!-- ������Ʒ��Ϣ -->
	<div class="productInfo">
		<div class="section1">
			<h3 style="display: inline-block;">�޸ĸ�����Ϣ</h3>
		</div>
	</div>
	<div class="productInfo1">
		<div class="contend3">
			<form action="/user/modifyUser" method="post" name="changeform">
				<div class="message">${message}</div>
				<div class="title1">
					<p style="font-size: 30px;">�û���</p>
				</div>
				<div class="setname">
					<input type="text" name="userName">
				</div>
				<div class="title2">
					<p style="font-size: 30px;">�ֻ���</p>
				</div>
				<div class="setnum">
					<input type="text" name="userPhone">
				</div>
				<div class="title3">
					<p style="font-size: 30px;">����</p>
				</div>
				<div class="setpswd1">
					<input type="password" name="userPassword">
				</div>
				<div class="title4">
					<p style="font-size: 30px;">ȷ������</p>
				</div>
				<div class="setpswd2">
					<input type="password" name="rePassword">
				</div>
				<!-- �޸İ�ť -->
				<div class="but1">
					<input type="submit" value="ȷ��" name="submitInfo">
				</div>
				<div class="but2">
					<input type="reset" value="����" name="resetInfo">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
