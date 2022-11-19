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
  <title>Document</title>
  <link rel="stylesheet" href="./css/base.css">
  <link rel="stylesheet" href="./css/buy.css">
</head>

<body>
<div class="header">
  <h2>校园二手交易平台</h2>
  <a href="index.html">首页</a>
  <a href="">登录</a>
  <a href="">注册</a>
</div>
<div class="body">
  <div id="hd">&nbsp;&nbsp;商品信息</div>
  <img src="./uploads/banner_1.png" alt="显示错误">
  <div class="content">
    <h2>商品名称</h2>
    <table cellspacing="15px">
      <tr>
        <td>￥</td>
        <td style="color: red; font-size:25px; "><b>价格</b></td>
      </tr>
      <tr>
        <td>卖家</td>
        <td>Bob</td>
      </tr>
      <tr>
        <td>商品类型</td>
        <td>电脑</td>
      </tr>
      <tr>
        <td>发布时间</td>
        <td>2020-09-09 09:09:09</td>
      </tr>
      <tr>
        <td>详情</td>
        <td> 价格亲民 物流无损 顶顶顶顶
        </td>
      </tr>
    </table>
    <button>购买</button>
  </div>
</div>
<div class="comment">
  <div id="hd">&nbsp;&nbsp;商品评价</div>
  <div id="comment">
    <b>留言（限150词）：</b>
    <form action="buy.html">
                <textarea name="USer_dialogue" id="typing" cols="57" rows="5"
                          style="border-radius:10px; resize:none; "></textarea>
      <button id="but">提交</button>
    </form>
  </div>
  <div class="dialogue">
    <span>用户</span>
    <div id="dialogue"></div>
  </div>

</div>
<script>

</script>
</body>

</html>
