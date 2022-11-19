<%--
  Created by IntelliJ IDEA.
  User: amber
  Date: 2022/11/19
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>商品上架</title>
  <link rel="stylesheet" href="./css/base.css">
  <link rel="stylesheet" href="./css/sell.css">
</head>
<body>
<div class="header">
  <h2>校园二手交易平台</h2>
  <a href="index.html"><p style="border-left:1px solid ;font-weight: bold;">用户名</p></a>
  <a href="index.html"><p style="border-left:1px solid ;font-weight: bold;">首页</p></a>
</div>
<div class="body">
  <form action="">
    <table>
      <tr>
        <td>商品名称：</td>
        <td><input type="text" name="goodsName" ></td>
      </tr>
      <tr>
        <td>商品价格：</td>
        <td><input type="text" name="goodsDetail" ></td>
      </tr>
      <tr>
        <td>商品图片：</td>
        <td><input type="file" name="goodsImage" ></td>
      </tr>
      <tr>
        <td>商品类别：</td>
        <td><select name="goodsSort" id="">
          <option value="书籍">书籍</option>
          <option value="电器商品">电器商品</option>
          <option value="化妆品">化妆品</option>
        </select></td>
      </tr>
      <tr>
        <td><input type="submit" value="提交"></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
