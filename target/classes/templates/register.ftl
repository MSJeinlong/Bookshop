<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>用户注册</title>
    <!-- <link
      rel="stylesheet"
      href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css"
    />
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script> -->

    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css" />
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
    <style type="text/css">
        #img1 {
            width: 650px;
            height: 450px;
        }

        .row {
            margin-top: 20px;
        }
    </style>
    <script>
        $(function() {
            $("small").hide();
            $("#UserName").focus();
            $("#telHelp").show();
            $("#UserName").click(function() {
                $("#telHelp").show();
                $("small[id!='telHelp']").hide();
                if(!$("#clause").attr("checked"))
                    $("#clauseHelp").show();
            });
            $("#Password1").click(function() {
                $("#passwdHelp1").show();
                $("small[id!='passwdHelp1']").hide();
                if(!$("#clause").attr("checked"))
                    $("#clauseHelp").show();
            });
            $("#Password2").click(function() {
                $("#passwdHelp2").show();
                $("small[id!='passwdHelp2']").hide();
                if(!$("#clause").attr("checked"))
                    $("#clauseHelp").show();
            });
            $("#clause").click(function () {
                if($(this).attr("checked")){
                    $("#clauseHelp").show();
                    // alert("checked");
                     $(this).removeAttr("checked");
                     $("#submit").attr("disabled", "disabled");
                }
                else {
                    //alert("hide");
                    $(this).attr("checked", "checked");
                    $("#clauseHelp").hide();
                    $("#submit").removeAttr("disabled");
                }
            });

            $("button[type='submit']").click(function () {
                if(!$("#clause").attr("checked")){
                    alert("您必须同意书店条款，才能进行注册！");
                    return false;
                }
                else{
                    var tel = $("#Cellphone").val();
                    var password1 = $("#Password1").val();
                    var password2 = $("#Password2").val();
                    if( tel == null || tel.length < 11 || isNaN(tel)) {
                        alert("手机号码格式错误！");
                        return false;
                    } else if(password1 != password2){
                        alert("两次输入的密码不一致！");
                        return false;
                    } else if(password1.length < 6){
                        alert("密码长度小于6");
                        return false;
                    }
                    return true;
                }
            });
        });
    </script>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-7">
            <img id="img1" src="/image/userlogin.png" alt="Chania" />
        </div>
        <div class="col-md-5 ">
            <div class="card border-primary mb-3" style="max-width: 25rem;">
                <div class="card-header bg-transparent border-primary">
                    <p class="font-weight-bold">用户注册</p>
                </div>
                <div class="card-body text-primary">
                    <!-- <h5 class="card-title">请输入账号和密码</h5> -->
                    <form action="/toAddress" method="post">
                        <div class="form-group">
                            <label for="UserName">手机号码</label>
                            <input
                                    type="tel"
                                    class="form-control"
                                    id="Cellphone"
                                    aria-describedby="emailHelp"
                                    required
                                    placeholder="手机号码"
                                    value="${RequestParameters['cellphone']?default("")}"
                                    name="cellphone"
                            />
                            <small id="telHelp" class="form-text text-muted"
                            >手机号可用于登录、找回密码、接收订单通知等服务</small
                            >
                        </div>
                        <div class="form-group">
                            <label for="Password1">登录密码</label>
                            <input
                                    type="password"
                                    class="form-control"
                                    id="Password1"
                                    name="password1"
                                    required
                                    placeholder="登录密码"
                                    value="${RequestParameters['password1']?default("")}"
                            />
                            <small id="passwdHelp1" class="form-text text-muted"
                            >密码为6-20个字符，可由英文、数字和符号组成</small
                            >
                        </div>

                        <div class="form-group">
                            <label for="Password2">确认密码</label>
                            <input
                                    type="password"
                                    class="form-control"
                                    id="Password2"
                                    name="password2"
                                    required
                                    placeholder="确认密码"
                                    value="${RequestParameters['password2']?default("")}"
                            />
                            <small id="passwdHelp2" class="form-text text-muted"
                            >请再次输入密码</small
                            >
                        </div>

                        <div class="form-group form-check">
                            <input
                                    type="checkbox"
                                    class="form-check-input"
                                    id="clause"
                                    checked
                            />
                            <label class="form-check-label " for="exampleCheck1"
                            >我已同意 <a href="/toClause">《网上书店条款》</a></label
                            >
                            <small id="clauseHelp" class="form-text text-danger"
                            >您必须同意书店条款，才能进行注册</small
                            >
                        </div>
                        <button type="submit" class="btn btn-primary btn-block" id="submit">
                            立即注册
                        </button>
                    </form>
                </div>

                <div class="card-footer bg-transparent border-primary">
                    <p>已有账号?&nbsp;<a href="/toUserLogin">返回登录页面</a></p>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="offset-md-7 col-md-5">
            <#if registerTips??>
                <div class="alert alert-danger alert-dismissible" style="width:auto">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>${registerTips}</strong>
                </div>
            </#if>
        </div>
    </div>
</div>
</body>
</html>
