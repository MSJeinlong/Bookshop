<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css">
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/util.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
    <title>确认支付密码</title>
    <style>
        .payCart{
            top:60px;
        }
    </style>
    <script>
        $(function () {
            $("button").click(function () {
                var cardno = $("#password").val();
                var payPasswd = $("#payPasswd").val();
                if(cardno.length != 6){
                    alert("密码不足6位！");
                    return false;
                } else if(cardno != payPasswd){
                    alert("密码错误！请重试");
                    return false;
                }
                else {
                    return true;
                }
            });
        });
    </script>
</head>
<body>
    <div class="container">
        <div class="row payCart">
            <div class="offset-md-3 col-md-6">
                <div class="cart">
                    <div class="card-header">
                    <h5 class="card-title">确认密码</h5>
                    </div>
                    <div class="cart">
                        <div class="card-body">
                            <form action="/updateOrderStatus" method="post">
                                <input type="hidden" id="payPasswd" value="${bsUser.cardno!""}"/>
                                <input type="hidden" name="orderStatus" value="1"/>
                                <input type="hidden" name="orderId" value="${orderMasterID!""}">
                                <div class="row">
                                    <label class="col-form-label col-md-3">支付方式</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control-plaintext"
                                              <#if orderMaster??>
                                                  <#if orderMaster.payWay == 1>
                                                      value="银行卡支付"
                                                  </#if>
                                                  <#if orderMaster.payWay == 2>
                                                      value="支付宝支付"
                                                  </#if>
                                                  <#if orderMaster.payWay == 3>
                                                      value="微信支付"
                                                  </#if>
                                              </#if>
                                        />
                                    </div>
                                </div>
                                <div class="row">
                                    <label class="col-form-label col-md-3">支付密码</label>
                                    <div class="col-md-6">
                                        <input type="password" name="cardno" class="form-control" id="password" required maxlength="6" placeholder="输入6位支付密码"/>
                                    </div>
                                </div>
                                <br>
                                <button class="btn btn-primary " type="submit">确认</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>