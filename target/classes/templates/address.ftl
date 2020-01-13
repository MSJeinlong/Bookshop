<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>填写地址</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/htmleaf-demo.css">
    <link href="/css/main.css" rel="stylesheet">


    <script src="http://libs.useso.com/js/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
    <script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="/js/distpicker.data.js"></script>
    <script src="/js/distpicker.js"></script>
    <script src="/js/main.js"></script>
    <style>
        .panel{
            margin-top: 50px;
        }
    </style>
    <script>
        $(function () {
            $("button[type='submit']").click(function () {
                var cardno1 = $("#cardno1").val();
                var cardno2 = $("#cardno2").val();
                if(cardno1 != cardno2)
                {
                    alert("两次输入的密码不一致！");
                    return false;
                } else if(cardno1.length < 6){
                    alert("密码长度小于6!");
                    return false;
                }  else
                    return true;
            });

        });
    </script>
</head>
<body>
    <div class="htmleaf-container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">填写地址</h3>
                    </div>
                    <div class="panel-body">
                        <form action="/userRegister" method="post">
                            <input type="hidden" name="userName" value="${RequestParameters['userName']?default("")}"/>
                            <input type="hidden" name="cellphone" value="${RequestParameters['cellphone']?default("")}"/>
                            <input type="hidden" name="password" value="${RequestParameters['password1']?default("")}"/>
                            <div class="form-inline">
                                <div data-toggle="distpicker">
                                    <div class="form-group">
                                        <label  for="province3" style="color: #0b2e13;">省/市/区:&nbsp;</label>
                                        <select name="province" class="form-control" id="province3" data-province="广东省"></select>
                                    </div>
                                    <div class="form-group">

                                        <select name="city" class="form-control" id="city3" data-city="广州市"></select>
                                    </div>
                                    <div class="form-group">

                                        <select name="district" class="form-control" id="district3" data-district="番禺区"></select>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="form-group ">
                                <label for="street1" style="color: black">详细地址：&nbsp;</label>
                                <textarea class="form-control" rows="5" cols="6" name="street1" required></textarea>
                            </div>

                            <div class="form-group row">
                                <label for="cardno1" class="col-form-label col-sm-3">设置支付密码</label>
                                <input type="password" class="form-control" name="cardno" id="cardno1" maxlength="6" required placeholder="设置6位支付密码"/>
                            </div>
                            <div class="form-group row">
                                <label for="cardno2" class="col-form-label col-sm-3">确认支付密码</label>
                                <input type="password" class="form-control"  id="cardno2" required maxlength="6" placeholder="确认6位支付密码"/>
                            </div>
                            <button type="submit" class="btn btn-success">提交</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>