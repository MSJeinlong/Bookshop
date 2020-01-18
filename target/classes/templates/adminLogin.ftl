<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>管理员登录</title>

    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css" />
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
    <style type="text/css">
        #img1 {
            width: 700px;
            height: 400px;
        }

        .row {
            margin-top: 20px;
        }
    </style>
    <script>
        $(function () {
            $("small").hide();
            $("#UserName").focus();
            $("#usernameHelp").show();
            $("#UserName").click(function () {
                $("#usernameHelp").show();
                $("small[id!='usernameHelp']").hide();

            });
            $("#Password").click(function () {
                $("#passwordHelp").show();
                $("small[id!='passwordHelp']").hide();
            });
            $("#Password").focus(function () {
                $("#passwordHelp").show();
                $("small[id!='passwordHelp']").hide();
            });
        });
    </script>
</head>

<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-7">
                <img id="img1" src="/image/admin.jpg" class="rounded" alt="Chania" />
            </div>
            <div class="col-md-5 ">
                <div class="card border-primary mb-3" style="max-width: 25rem;">
                    <div class="card-header bg-transparent border-primary">
                        <p class="font-weight-bold">后台管理员登录</p>
                    </div>
                    <div class="card-body text-primary">
                        <!-- <h5 class="card-title">请输入账号和密码</h5> -->
                        <form action="/loginAdmin" method="post">
                            <div class="form-group">
                                <label for="UserName">账号</label>
                                <input type="text" name="adminName" class="form-control" id="UserName" aria-describedby="emailHelp"
                                    required placeholder="管理员账号" value="${RequestParameters['adminName']?default("")}"/>
                                <small id="usernameHelp" class="form-text text-muted">请输入您的管理员账号</small>
                            </div>
                            <div class="form-group">
                                <label for="Password">密码</label>
                                <input type="password" name="password" class="form-control" id="Password" required placeholder="密码" value="${RequestParameters['password']?default("")}"/>
                                <small id="passwordHelp" class=" form-text text-muted">请输入6-20位长度的密码</small>
                            </div>
                            <div class="form-group form-check">
                                <input type="checkbox" class="form-check-input" id="exampleCheck1" />
                                <label class="form-check-label" for="exampleCheck1">记住我的登录信息</label>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">
                                登录
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="offset-md-7 col-md-5">
                <#if adminLoginTips??>
                    <div class="alert alert-dismissible alert-danger" style="width: 400px;">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>登录失败！</strong>原因：${adminLoginTips!""}
                    </div>
                </#if>
            </div>
        </div>
    </div>
</body>

</html>