<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>二手交易市场</title>

    <link rel="stylesheet" href="/static/css/base.css">
    <link rel="stylesheet" href="/static/css/common.css">
    <link rel="stylesheet" href="/static/css/HomePage.css">
</head>
<body>

<div class="shortcut">
    <div class="wrapper">
        <ul>
            <li><a href="#">登录</a></li>
            <li><a href="#">注册</a></li>
        </ul>
    </div>
</div>

<!-- 头部 -->
<div class="header wrapper">
    <div class="search">
        <input type="text" placeholder="搜索">
        <!-- 定位 放大镜 -->
        <span></span>
    </div>
    <div class="car">
        <span>数量</span>
    </div>
</div>

<!-- banner -->
<div class="banner">
    <div class="wrapper">
        <!-- 有多少个图,就有都少个li -->
        <ul>
            <li>
                <a href="#"><img src="/static/images/banner_1.png" alt=""></a>
            </li>
        </ul>

        <!-- 侧导航 -->
        <div class="aside">
            <ul>
                <li><a href="#">类别<span>描述</span></a></li>
                <li><a href="#">类别<span>描述</span></a></li>
                <li><a href="#">类别<span>描述</span></a></li>
                <li><a href="#">类别<span>描述</span></a></li>
                <li><a href="#">类别<span>描述</span></a></li>
            </ul>
        </div>

        <!-- 箭头 -->
        <!-- prev: 上一个 -->
        <a href="#" class="prev"></a>
        <!-- next : 下一个 -->
        <a href="#" class="next"></a>

        <!-- 圆点: 当前状态: current / active -->
        <!-- js 找到用户点击的li 添加类名 li变成白色的 -->
        <ol>
            <li></li>
            <li></li>
            <li class="current"></li>
            <li></li>
            <li></li>
        </ol>
    </div>
</div>

<div class="goods wrapper">
    <c:forEach items="${sort_list}" var="sort">
        <div class="hd">
            <h2>${sort.sortName}</h2>
        </div>
        <!-- body -->
        <div class="bd clearfix">
            <ul>
                <c:forEach items="${sort.productList}" var="product">
                    <li>
                        <a href="#">
                            <img src="${product.productImage}" alt="">
                            <h3>${product.productName}</h3>
                            <div>￥<span>${product.productPrice}</span></div>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </c:forEach>
</div>

<!-- 最后区域 -->
<div class="footer">
    <div class="wrapper">
        <div class="top">
            <ul>
                <li>
                    <span>快速无损</span>
                </li>
                <li>
                    <span>以物交友</span>
                </li>
                <li>
                    <span>交换乐趣</span>
                </li>
            </ul>
        </div>
        <div class="bottom">
            <p>
                <a href="#">关于我们</a>
                <a href="#">帮助中心</a>
                <span>售后服务</span>
                <span>商务合作</span>
            </p>
            <p>跳蚤交易市场</p>
        </div>
    </div>
</div>
</body>

</html>
