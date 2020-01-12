<#--填写核对订单信息-->
<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap 实例</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css">
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/util.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
    <title>结算页</title>
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h5 class="card-title text-info">BOOKSHOP 结算页</h5>
                <p class="card-subtitle">填写并核对订单信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/toMyCart" class="btn btn btn-primary">返回修改购物车</a>
                </p>
            </div>
            <div class="card-body">
                <form action="/myCartToOrder" method="post">
                <h6 class="card-subtitle text-info">收货人信息</h6><br/>
                <p class="card-text">收货人姓名：<span class="text-muted">${bsUser.nickname!""}</span></p>
                <p class="card-text">收货人手机号码：<span class="text-muted">${bsUser.cellphone!""}</span></p>
                    <div class="row">
                        <div class="input-group mb-3 col-md-7">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="address">收货人地址</label>
                            </div>
                            <select class="custom-select" id="address" name="address">
                                <option value="${bsUser.province1!""}${bsUser.city1!""}${bsUser.district1!""}${bsUser.street1!""}">${bsUser.province1!""}${bsUser.city1!""}${bsUser.district1!""}${bsUser.street1!""}</option>
                                <#if bsUser.province2??>
                                    <option value="${bsUser.province2!""}${bsUser.city2!""}${bsUser.district2!""}${bsUser.street2!""}">${bsUser.province2!""}${bsUser.city2!""}${bsUser.district2!""}${bsUser.street2!""}</option>
                                </#if>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-group mb-3 col-md-3">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="payWay">支付方式</label>
                            </div>
                            <select class="custom-select" id="payWay" name="payWay">
                                <option selected value="1">银行卡支付</option>
                                <option value="2">支付宝支付</option>
                                <option value="3">微信支付</option>
                            </select>
                        </div>
                    </div>
                    <br/>
                    <h6 class="text-info">订单详情：</h6>
                    <table class="table table-striped table-borderless table-hover">
                        <thead class="table-secondary">
                        <tr>
                            <th>商品信息</th>
                            <th>单价(元)</th>
                            <th>数量</th>
                            <th>小计(元)</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list readyOrders as order>
                            <tr>
                                <td>
                                    <img src="${order.bookImage!"#"}" style="width: 40px;height: 50px;"/>
                                    &nbsp;   《${order.bookName!""}》
                                </td>
                                <td><span style="color: red">￥${order.bookPrice?string("0.00")}</span></td>
                                <td>
                                    <span class="text-info">${order.bookAmount!""}</span>
                                </td>
                                <td>
                                    <span style="color: red">￥</span><span class="priceSum" id="subtotal${order.cartId!""}" style="color: red">${(order.bookPrice * order.bookAmount)?string("0.00")}</span>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>

                    <!-- 结算栏固定在底部 -->
                    <nav class="navbar navbar-expand-sm bg-light navbar-light fixed-bottom">
                        <ul class="navbar-nav mr-auto">
                        </ul>
                        <span class="navbar-text">
                        应付总额(包括邮费)：
            &nbsp;           <span style="color: red">￥</span><span class="allPriceSum" style="color: red">${totalPrice?string("0.00")}</span>
                       <#-- <a href="#" class="btn btn-danger text-white">提交订单</a>-->
                            <button class="btn btn-danger" type="submit">提交订单</button>
                        </span>
                    </nav>
                </form>
            </div>
        </div>
    </div>
</body>
</html>