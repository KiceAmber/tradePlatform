<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<html>
<head>
<meta charset="GBK">
<title>�޸���Ʒ</title>
<link rel="stylesheet" href="/static/css/product.css">
</head>
<body>
	<!-- ��ݵ��� -->
	<div class="shortcut">
		<div class="wrapper">
			<ul>
				<li><a href="userInfo.jsp ">��������</a></li>
			</ul>
		</div>
	</div>
	<!-- ������Ϣ -->
	<div class="personalInfo">
		<div class="section1">
			<img alt="ͷ��" src="/static/images/user/default.png">
		</div>
		<div class="section2">
			<ul>
				<li><h1 style="color: rgb(235, 225, 225);">${user_session.userName}</h1></li>
				<li><h4 style="color: whitesmoke;">�ֻ��ţ�${user_session.userPhone}</h4></li>
				<li><h4 style="color: whitesmoke;">ע��ʱ�䣺${user_session.useRegistrationTime}</h4></li>
			</ul>
		</div>
		<div class="section3">
			<ul>
				<li><a
						href="/template/user/changePersonal.jsp"
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
			<h3 style="display: inline-block;">�ҵķ���</h3>
			<span class="from1">
				<form action="#" method="post" name="searchInfo">
					<input type="text" name="searchText" placeholder="��������Ʒ����">
					<input type="submit" name="search" value="Search"
						onclick="return formCheck()">
				</form>
			</span>
		</div>
	</div>
	<div class="productInfo1">
		<!-- �޸���Ʒ��Ϣ -->
		<div class="contend3">
			<form action="/user/modifyProduct" method="post" name="changeform2">
				<div class="message">${message}</div>
				<div class="title1">
					<p style="font-size: 30px;">��Ʒԭ����</p>
				</div>
				<div class="addname">
					<input type="text" name="productOldName">
				</div>
				<div class="title2">
					<p style="font-size: 30px;">��Ʒ������</p>
				</div>
				<div class="addstyle">
					<input type="text" name="productNewName">
				</div>
				<div class="title3">
					<p style="font-size: 30px;">��Ʒ�ַ���</p>
				</div>
				<div class="addprice">
					<input type="text" name="productNewSort">
				</div>
				<div class="title4">
					<p style="font-size: 30px;">��Ʒ�ּ۸�</p>
				</div>
				<div class="addprice2">
					<input type="text" name="productNewPrice">
				</div>
				<!-- �޸İ�ť -->
				<div class="but1">
					<input type="submit" value="ȷ��" name="submitProduct">
				</div>
				<div class="but2">
					<input type="reset" value="����" name="resetProduct">
				</div>
			</form>
		</div>
		<div class="contend4">
			<table>
				<tr>
					<th>��ƷID</th>
					<th>��Ʒ����</th>
					<th>���</th>
					<th>�۸�</th>
					<th>��Ʒ������</th>
					<th>����</th>
				</tr>

				<c:forEach items="${user_session.productList}" var="product">
					<tr>
						<td>${product.productID}</td>
						<td>${product.productName}</td>
						<td>${product.sort.sortName}</td>
						<td>${product.productPrice}</td>
						<td>${product.productCommentCount}</td>
						<td><a
								href="/user/modifyProduct">�޸�</a>
							<a onclick="myDel()"
							   href="/user/deleteProduct">�¼�</a>
						</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>

</body>
<script>
	let model = document.querySelector(".contend3");//��ȡģ̬��
	let close = document.querySelector(".close");//��ȡ�رհ�ť

	close.addEventListener("click", function() {
		model.style.display = "none";//ģ̬�����ò��ɼ�
	})
	function myDel(event) {
		let del = confirm('�Ƿ��¼ܴ���Ʒ��');
		if(del){
			window.location.href ="/user/deleteProduct";
		} else {
			event.preventDefault();
		}
	}
    function formCheck(){
		if(document.searchInfo.searchText.value==""){
			alert('��������Ʒ����');
			return false;
		}	
	}
    </script>
</html>