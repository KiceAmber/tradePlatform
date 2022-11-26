<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品上架</title>
    <link rel="stylesheet" href="/static/css/base.css">
    <link rel="stylesheet" href="/static/css/sell.css">
    <link rel="stylesheet" href="/static/css/order.css">
</head>
<body>
    <div class="header">
        <h2>校园二手交易平台</h2>
        <a href="index.html"><p style="border-left:1px solid ;font-weight: bold;" name="Username">用户名</p></a>
        <a href="index.html"><p style="border-left:1px solid ;font-weight: bold;">首页</p></a>
    </div>
    <div class="body">
        <table>
            <tr>
                <td>商品名称：</td>
                <td name="goodsName"></td>
            </tr>
            <tr>
                <td>商品价格：</td>
                <td name="goodsPrice"></td>
            </tr>
            <tr>
                <td>商品卖家：</td>
                <td name="goodsSeller"></td>
            </tr>
            <tr>
                <td>商品类别：</td>
                <td name="goodsSort"></td>
            </tr>
            <tr>
                <td><div class="cancel"><a href="buy.html">&nbsp;&nbsp;取消</a></div></td>
                <td><button id="pay" style="border-radius: 3px;">确定</button></td>
            </tr>
        </table>
    </div>
</body>
<script>
    var btn = document.getElementById("pay");
    btn.onclick =function(){
        alert("你已经完成交易！");
    }
</script>
</html>