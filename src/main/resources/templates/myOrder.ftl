<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css" />
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $("#confirmPay").click(function () {
                $("form[name='toPayForm']").submit();
            });
        });
    </script>
    <title>我的订单</title>
</head>
<body>
<div class="container">

    <h2 class="text-info">我的订单 &nbsp;&nbsp;&nbsp;
        <a href="/toBookshop" class="btn btn btn-primary">返回</a></h2>
    <br>
    <!-- 订单分类栏和搜索栏 -->
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" data-toggle="tab" href="#home">全部订单<span class="badge badge-pill badge-primary">${countAllOrder!"0"}</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu1">待付款<span class="badge badge-pill badge-danger">${countUnPaid!"0"}</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu2">待发货<span class="badge badge-pill badge-info">${countUnDelivery!"0"}</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu3">待收货<span class="badge badge-pill badge-success">${countUnReceived!"0"}</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#menu4">待评价<span class="badge badge-pill badge-secondary">${countReceived!"0"}</span></a>
        </li>
    </ul>

    <#if updateOrderTips??>
        <div class="alert alert-success alert-dismissible">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <strong>${updateOrderTips!""}</strong>
        </div>
    </#if>

    <!-- Tab panes -->
    <div class="tab-content">
        <div id="home" class="container tab-pane active"><br>
            <#if (orderMasterList?size != 0)>
                <table class="table table-striped table-hover">
                    <thead class="table-secondary">
                    <tr>
                        <th>订单编号</th>
                        <th>下单时间</th>
                        <th>收货人</th>
                        <th>金额</th>
                        <th>支付方式</th>
                        <th>订单状态</th>
                        <th>订单详情</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <#list orderMasterList as orderMaster>
                    <tr>
                        <td>${orderMaster.orderId!""}</td>
                        <td>${orderMaster.createTime?string("yyyy-MM-dd hh:MM:ss")}</td>
                        <td>${orderMaster.userName!""}</td>
                        <td><span style="color: red">￥${orderMaster.totalPrice?string("0.00")}</span></td>
                        <td>
                            <#if orderMaster.payWay == 1>
                                银行卡支付
                            <#elseif orderMaster.payWay == 2>
                                支付宝支付
                            <#elseif orderMaster.payWay == 3>
                                微信支付
                            </#if>
                        </td>
                        <td>
                            <#if orderMaster.orderStatus == 0>

                                <span class="badge badge-danger">待付款</span>
                            <#elseif orderMaster.orderStatus == 1>
                                <span class="badge badge-info">待发货</span>
                            <#elseif orderMaster.orderStatus == 2>
                                <span class="badge badge-success">待收货</span>
                            <#elseif orderMaster.orderStatus == 3>
                                <span class="badge badge-secondary">待评价</span>
                            </#if>
                        </td>
                        <td><a href="/toOrderDetail?orderId=${orderMaster.orderId!""}">查看订单详情</a></td>
                        <td>
                            <#if orderMaster.orderStatus == 0>
                                <form action="/updateOrderStatus" method="post" name="toPayForm">
                                    <input type="hidden" name="orderId" value="${orderMaster.orderId!""}"/>
                                    <input type="hidden" name="orderStatus" value="1"/>
                                    <button class="btn btn-sm btn-primary" type="button" data-toggle="modal" data-target="#payModel">去支付</button>
                                </form>
                            <#elseif orderMaster.orderStatus == 1>
                                ---
                            <#elseif orderMaster.orderStatus == 2>
                                <a href="#" class="btn btn-sm btn-primary">确认收货</a>
                            <#elseif orderMaster.orderStatus == 3>
                                <a href="#" class="btn btn-sm btn-primary">去评价</a>
                            </#if>
                        </td>
                    </tr>
                    </#list>

                    </tbody>
                </table>
                <#else>
                    <div class="card">
                        <div class="card-body">
                            <h3 class="text-muted">您还没有下过订单哦~</h3>
                        </div>
                    </div>
            </#if>
        </div>

        <div id="menu1" class="container tab-pane fade"><br>
            <#if countUnPaid != 0>
                <table class="table table-striped table-borderless table-hover">
                    <thead class="table-secondary">
                    <tr>
                        <th>订单编号</th>
                        <th>下单时间</th>
                        <th>收货人</th>
                        <th>金额</th>
                        <th>支付方式</th>
                        <th>订单状态</th>
                        <th>订单详情</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <#list orderMasterList as orderMaster>
                        <#if orderMaster.orderStatus == 0>
                            <tr>
                                <td>${orderMaster.orderId!""}</td>
                                <td>${orderMaster.createTime?string("yyyy-MM-dd hh:MM:ss")}</td>
                                <td>${orderMaster.userName!""}</td>
                                <td><span style="color: red">￥${orderMaster.totalPrice?string("0.00")}</span></td>
                                <td>
                                    <#if orderMaster.payWay == 1>
                                    银行卡支付
                                    <#elseif orderMaster.payWay == 2>
                                    支付宝支付
                                    <#elseif orderMaster.payWay == 3>
                                    微信支付
                                    </#if>
                                </td>
                                <td><span class="badge badge-danger">待付款</span></td>
                                <td><a href="#">查看订单详情</a></td>
                                <td>
                                    <form action="/updateOrderStatus" method="post" name="toPayForm">
                                        <input type="hidden" name="orderId" value="${orderMaster.orderId!""}"/>
                                        <input type="hidden" name="orderStatus" value="1"/>
                                        <button class="btn btn-sm btn-primary" type="button" data-toggle="modal" data-target="#payModel">去支付</button>
                                    </form>
                                </td>
                            </tr>
                        </#if>
                    </#list>

                    </tbody>
                </table>

                <#else >
                    <div class="card">
                        <div class="card-body">
                            <h3 class="text-muted">没有待付款的订单哦~</h3>
                        </div>
                    </div>
            </#if>


        </div>
        <div id="menu2" class="container tab-pane fade"><br>
            <#if countUnDelivery != 0>
                <table class="table table-striped table-borderless table-hover">
                    <thead class="table-secondary">
                    <tr>
                        <th>订单编号</th>
                        <th>下单时间</th>
                        <th>收货人</th>
                        <th>金额</th>
                        <th>支付方式</th>
                        <th>订单状态</th>
                        <th>订单详情</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list orderMasterList as orderMaster>
                        <#if orderMaster.orderStatus == 1>
                            <tr>
                                <td>${orderMaster.orderId!""}</td>
                                <td>${orderMaster.createTime?string("yyyy-MM-dd hh:MM:ss")}</td>
                                <td>${orderMaster.userName!""}</td>
                                <td><span style="color: red">￥${orderMaster.totalPrice?string("0.00")}</span></td>
                            <td>
                                <#if orderMaster.payWay == 1>
                                    银行卡支付
                                <#elseif orderMaster.payWay == 2>
                                    支付宝支付
                                <#elseif orderMaster.payWay == 3>
                                    微信支付
                                </#if>
                            </td>
                            <td><span class="badge badge-info">待发货</span></td>
                            <td><a href="#">查看订单详情</a></td>
                            <td>
                                ---
                            </td>
                            </tr>
                        </#if>
                    </#list>
                    </tbody>
                </table>
                <#else >
                    <div class="card">
                        <div class="card-body">
                            <h3 class="text-muted">没有待发货的订单哦~</h3>
                        </div>
                    </div>
            </#if>

        </div>
        <div id="menu3" class="container tab-pane fade"><br>
            <#if countUnReceived != 0>
                <table class="table table-striped table-borderless table-hover">
                    <thead class="table-secondary">
                    <tr>
                        <th>订单编号</th>
                        <th>下单时间</th>
                        <th>收货人</th>
                        <th>金额</th>
                        <th>支付方式</th>
                        <th>订单状态</th>
                        <th>订单详情</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list orderMasterList as orderMaster>
                        <#if orderMaster.orderStatus == 2>
                            <tr>
                                <td>${orderMaster.orderId!""}</td>
                                <td>${orderMaster.createTime?string("yyyy-MM-dd hh:MM:ss")}</td>
                                <td>${orderMaster.userName!""}</td>
                                <td><span style="color: red">￥${orderMaster.totalPrice?string("0.00")}</span></td>
                            <td>
                                <#if orderMaster.payWay == 1>
                                    银行卡支付
                                <#elseif orderMaster.payWay == 2>
                                    支付宝支付
                                <#elseif orderMaster.payWay == 3>
                                    微信支付
                                </#if>
                            </td>
                            <td><span class="badge badge-success">待收货</span></td>
                            <td><a href="#">查看订单详情</a></td>
                            <td><a href="#" class="btn btn-sm btn-primary">确认收货</a></td>
                            </tr>
                        </#if>
                    </#list>
                    </tbody>
                </table>
                <#else >
                    <div class="card">
                        <div class="card-body">
                            <h3 class="text-muted">没有待收货的订单哦~</h3>
                        </div>
                    </div>
            </#if>

        </div>

        <div id="menu4" class="container tab-pane fade"><br>
            <#if countReceived != 0>
                <table class="table table-striped table-borderless table-hover">
                    <thead class="table-secondary">
                    <tr>
                        <th>订单编号</th>
                        <th>下单时间</th>
                        <th>收货人</th>
                        <th>金额</th>
                        <th>支付方式</th>
                        <th>订单状态</th>
                        <th>订单详情</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list orderMasterList as orderMaster>
                        <#if orderMaster.orderStatus == 2>
                            <td>${orderMaster.orderId!""}</td>
                            <td>${orderMaster.createTime?string("yyyy-MM-dd hh:MM:ss")}</td>
                            <td>${orderMaster.orderUser!""}</td>
                            <td>${orderMaster.totalPrice!""}</td>
                            <td>
                                <#if orderMaster.payWay == 1>
                                    银行卡支付
                                <#elseif orderMaster.payWay == 2>
                                    支付宝支付
                                <#elseif orderMaster.payWay == 3>
                                    微信支付
                                </#if>
                            </td>
                            <td><span class="badge badge-primary">待评价</span></td>
                            <td><a href="#">查看订单详情</a></td>
                            <td><a href="#" class="btn btn-sm btn-primary">去评价</a></td>
                        </#if>
                    </#list>
                    </tbody>
                </table>
                <#else >
                    <div class="card">
                        <div class="card-body">
                            <h3 class="text-muted">没有待评价的订单哦~</h3>
                        </div>
                    </div>
            </#if>
        </div>
    </div>
</div>

<!-- 模态框 -->
<div class="modal fade" id="payModel">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">请输入支付密码</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
               <label>支付密码:</label><input type="password" class="form-control" maxlength="6" required/>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="confirmPay" data-dismiss="modal">确定</button>
            </div>

        </div>
    </div>
</div>

</div>
</body>
</html>
