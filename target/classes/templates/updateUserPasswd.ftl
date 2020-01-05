<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css" />
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
    <title>密码修改</title>
    <script>
        $(function () {
            $("small").hide();
            $("#oldpassword").click(function () {
                $("#help1").show();
                $("small[id!='help1']").hide();
            });
            $("#newpassword").click(function () {
                $("#help2").show();
                $("small[id!='help2']").hide();
            });
            $("#confirmpassword").click(function () {
                $("#help3").show();
                $("small[id!='help3']").hide();
            });
            $("button[type='submit']").click(function () {
                alert("click submit");
                var oldpassword = $("#oldpassword").val();
                var newpassword = $("#newpassword").val();
                var confirmpassword = $("#confirmpassword").val();
                if(oldpassword.length < 6 || newpassword.length < 6 || confirmpassword.length < 6){
                    alert("密码长度必须大于等于6位！");
                    return false;
                }
                else if(newpassword != confirmpassword){
                    alert("两次输入的密码不一致！");
                    return false;
                }
                else
                    return true;
            });
        });
    </script>
    <style>
        .card{
            margin-top: 50px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="card border-primary mb-3" style="max-width: 25rem;">
                        <div class="card-header bg-transparent border-primary">
                            <p class="font-weight-bold">修改密码&nbsp;</p>
                        </div>
                        <div class="card-body text-primary">
                            <!-- <h5 class="card-title">请输入账号和密码</h5> -->
                            <form action="/updateUserPassword" method="post">
                                <div class="form-group">
                                    <label for="oldpassword">原密码</label>
                                    <input
                                            type="password"
                                            name="oldPassword"
                                            class="form-control"
                                            id="oldpassword"
                                            aria-describedby="emailHelp"
                                            required
                                            placeholder="请输入原来的旧密码"
                                            value="${RequestParameters['oldPassword']?default("")}"
                                    />
                                    <small id="help1" class="form-text text-muted">请输入6-20位长度的旧密码</small>
                                </div>
                                <div class="form-group">
                                    <label for="newpassword">新密码</label>
                                    <input
                                            type="password"
                                            class="form-control"
                                            name="newPassword"
                                            id="newpassword"
                                            required
                                            placeholder="请输入新密码"
                                            value="${RequestParameters['newPassword']?default("")}"
                                    />
                                    <small id="help2" class="form-text text-muted">请输入6-20位长度的新密码</small>
                                </div>
                                <div class="form-group">
                                    <label for="confirmpassword">确认新密码</label>
                                    <input
                                            type="password"
                                            class="form-control"
                                            name="confirmPassword"
                                            id="confirmpassword"
                                            required
                                            placeholder="请输入新密码"
                                            value="${RequestParameters['confirmPassword']?default("")}"
                                    />
                                    <small id="help3" class="form-text text-muted">请再次确认新密码</small>
                                </div>
                                <div class="row">
                                    <div class="col-sm-4">
                                        <a href="/toUserInfo" class="btn btn-success btn-block">返回</a>
                                    </div>
                                    <div class="col-sm-4">
                                        <button type="submit" class="btn btn-primary btn-block">
                                            提交
                                        </button>
                                    </div>
                                    <div class="col-sm-4">
                                        <button type="reset" class="btn btn-warning btn-block">
                                            重置
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                       <#-- <div class="card-footer bg-transparent border-primary">
                            <p class="">
                                没有账号?&nbsp;<a href="/toRegister">立刻注册</a>
                            </p>
                        </div>-->
                    </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 offset-md-3">
                <#if updateUserInfo??>
                    <div class="alert alert-info alert-dismissible" style="width: 400px">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>${updateUserInfo}</strong>
                    </div>
                </#if>
            </div>
        </div>
    </div>
</body>
</html>