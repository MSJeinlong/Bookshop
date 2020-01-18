<!DOCTYPE html>
<html>
<head>
    <title>订单详情</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css">
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/util.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h5 class="card-title text-info">订单详情 &nbsp;&nbsp;&nbsp;
                    <#if role == 1>
                        <a href="/toMyOrder" class="btn btn-sm btn-primary">返回</a>
                        <#else >
                            <a href="/toAdminManage" class="btn btn-sm btn-primary">返回</a>
                    </#if>

                </h5>
                <p class="card-subtitle text-secondary">收货人信息</p>
                <p class="text-muted">收货人姓名：${thisOrder.userName!""}</p>
                <p class="text-muted">收货人手机号码：${thisOrder.userPhone!""}</p>
                <p class="text-muted">收货人地址：${thisOrder.userAddress!""}</p>
                <p class="text-muted">支付方式：
                    <#if thisOrder.payWay == 1>
                        银行卡支付
                    <#elseif thisOrder.payWay == 2>
                        支付宝支付
                    <#elseif thisOrder.payWay == 3>
                        微信支付
                    </#if>
                </p>
                <p class="text-muted">订单编号：${thisOrder.orderId!""}</p>
                <p class="text-muted">下单时间：${thisOrder.createTime?string("yyyy-MM-dd hh:MM:ss")}</p>
            </div>
            <div class="card-body">
                <h6 class="card-subtitle text-info">商品详情</h6>
                <table class="table table-striped table-borderless table-hover">
                    <thead class="table-secondary">
                    <tr>
                        <th>商品信息</th>
                        <th>单价</th>
                        <th>购买数量</th>
                        <th>小计</th>
                    </tr>
                    </thead>
                    <tbody>
                       <#list orderDetailList as orderDetail>
                            <tr>
                                <td><img src="${orderDetail.bookImage!"#"}" style="width: 40px;height: 50px;"/>
                                    &nbsp;   《${orderDetail.bookName!""}》</td>
                                <td><span style="color: red">￥${orderDetail.bookPrice!"0.00"}</span></td>
                                <td><span class="text-info">${orderDetail.amount!""}</span></td>
                                <td><span style="color: red">￥${(orderDetail.bookPrice * orderDetail.amount)?string("0.00")}</span></td>
                            </tr>
                       </#list>
                        <tr>
                            <td colspan="3"></td>
                            <td>总额：<span style="color: red">￥${thisOrder.totalPrice}</span></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>