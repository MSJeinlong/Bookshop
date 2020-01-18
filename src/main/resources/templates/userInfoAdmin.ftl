<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />

    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css" />
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
            <div class="card ">
                <div class="card-header">
                    <h5 class="card-title text-info">用户详细信息 &nbsp; &nbsp; <a href="/toAdminManage" class="btn btn-sm btn-success">返回</a></h5>
                </div>
                <div class="card-body">
                    <p class="text-muted">用户昵称：${bsUser.nickname!""}</p>
                    <p class="text-muted">手机号码：${bsUser.cellphone!""}</p>
                    <p class="text-muted">性别：${bsUser.gender!""}</p>
                    <p class="text-muted">邮箱：${bsUser.email!""}</p>
                    <p class="text-muted">qq：${bsUser.qq!""}</p>
                    <p class="text-muted">微信：${bsUser.wechat!""}</p>
                    <p class="text-muted">生日：${bsUser.birthday?string("yyyy-MM-dd")}</p>
                    <p class="text-muted">地址1：${bsUser.province1}${bsUser.city1}${bsUser.district1}${bsUser.street1}</p>
                    <p class="text-muted">地址2：${bsUser.province2}${bsUser.city2}${bsUser.district2}${bsUser.street2}</p>
                    <p class="text-muted">最近登录时间：${bsUser.loginTime?string("yyyy-MM-dd hh:mm:ss")}</p>
                    <br />
                    <h6 class="card-subtitle text-info">用户的所有订单数据</h6>
                    <div class="table-responsive">
                        <table class="table table-striped table-hover table-sm">
                            <thead class="table-secondary">
                            <th>订单编号</th>
                            <th>下单时间</th>
                            <th>收货人</th>
                            <th>金额</th>
                            <th>支付方式</th>
                            <th>订单状态</th>
                            <th>订单详情</th>
                            </thead>
                            <tbody>
                                <#list userOrders as order>
                                    <tr>
                                        <td>${order.orderId!""}</td>
                                        <td>${order.createTime?string("yyyy-MM-dd hh:mm:ss")}</td>
                                        <td>${order.userName!""}</td>
                                        <td><span style="color: red">￥${order.totalPrice?string("0.00")}</span></td>
                                        <td>
                                            <#if order.payWay == 1>
                                                银行卡支付
                                            <#elseif order.payWay == 2>
                                                支付宝支付
                                            <#elseif order.payWay == 3>
                                                微信支付
                                            </#if>
                                        </td>
                                        <td>
                                            <#if order.orderStatus == 0>

                                                <span class="badge badge-danger">待付款</span>
                                            <#elseif order.orderStatus == 1>
                                                <span class="badge badge-info">待发货</span>
                                            <#elseif order.orderStatus == 2>
                                                <span class="badge badge-success">待收货</span>
                                            <#elseif order.orderStatus == 3>
                                                <span class="badge badge-secondary">待评价</span>
                                            </#if>
                                        </td>
                                        <td><a href="/toOrderDetail?orderId=${order.orderId}&role=3">订单详情</a></td>
                                    </tr>
                                </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
        </div>
    </div>
</body>
</html>