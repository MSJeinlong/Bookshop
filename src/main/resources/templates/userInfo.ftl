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
    <title>用户信息</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="card text-center col-md-6 offset-md-3">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal">
                    当前账号：${bsUser.cellphone!""}
                </h4>
            </div>
            <div class="card-body">
                <h5 class="card-title">用户个人资料</h5>
                <form action="/updateUserInfo" method="post">
                    <div class="form-group row">
                        <label for="nickName" class="col-sm-3 col-form-label"
                        >昵称:</label>
                        <div class="col-sm-9">
                            <input
                                    type="text"
                                    class="form-control"
                                    id="nickName"
                                    placeholder="输入你的昵称"
                                    value="${bsUser.nickname!""}"
                                    name="nickname"
                            />
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="gender" class="col-sm-3 col-form-label">性别:</label>
                        <div class="col-sm-9">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="male" value="男"
                                <#if bsUser.gender == "男">checked</#if>
                                />
                                <label class="form-check-label" for="male">男</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="female" value="女"
                                       <#if bsUser.gender == "女">checked</#if>
                                />
                                <label class="form-check-label" for="female">女</label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="birthday" class="col-sm-3 col-form-label">出生日期:</label>
                        <div class="col-sm-9">
                            <input type="date" name="birthday" id="birthday" class="form-control" value="${bsUser.birthday?string("yyyy-MM-dd")}">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="qq" class="col-sm-3 col-form-label">
                            QQ：
                        </label>
                        <div class="col-sm-9">
                            <input type="number" name="qq" id="qq" class="form-control" value="${bsUser.qq!""}">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="wechat" class="col-sm-3 col-form-label">
                            微信：
                        </label>
                        <div class="col-sm-9">
                            <input type="text" name="wechat" id="wechat" class="form-control" value="${bsUser.wechat!""}">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="email" class="col-sm-3 col-form-label"
                        >邮箱:</label
                        >
                        <div class="col-sm-9">
                            <input type="email" name="email" class="form-control" id="email" value="${bsUser.email!""}" placeholder="电子邮件" />
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="address" class="col-sm-3 col-form-label"
                        >地址1:</label
                        >
                        <div class="col-sm-9">
                            <input type="text" readonly class="form-control-plaintext" value="${bsUser.province1!""}${bsUser.city1!""}${bsUser.district1!""}${bsUser.street1!""}"/>
                           <#-- <label class="col-form-label">${bsUser.province1!""}${bsUser.city1!""}${bsUser.district1!""}${bsUser.street1!""}</label>
                        --></div>
                    </div>

                    <div class="form-group row">
                        <label for="address" class="col-sm-3 col-form-label"
                        >地址2:</label
                        >
                        <div class="col-sm-9">
                            <input type="text" readonly class="form-control-plaintext"  value="${bsUser.province2!""}${bsUser.city2!""}${bsUser.district2!""}${bsUser.street2!""}"/>
                            <#--<label class="col-form-label">${bsUser.province2!""}${bsUser.city2!""}${bsUser.district2!""}${bsUser.street2!""}</label>
                     -->   </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-3 ">
                            <a href="/toBookshop" class="btn btn-success btn-block">返回</a>
                        </div>
                        <div class="col-sm-3">
                            <button type="submit" class="btn btn-primary btn-block">保存信息</button>
                            <#--<a href="/updateUserInfo" class="btn btn-primary btn-block"></a>-->
                        </div>
                        <div class="col-sm-3">
                            <a href="/toUpdateUserPassword" class="btn btn-warning btn-block">修改密码</a>
                        </div>
                        <div class="col-sm-3">
                            <a href="/toUpdateAddress" class="btn btn-info btn-block">编辑地址</a>
                        </div>
                    </div>
                </form>

            </div>
            <div class="card-footer text-muted">
                请完善您的信息，以便我们更好为您服务！
            </div>
        </div>
    </div>

<#--    <p class="text-danger">updateUserInfo: ${updateUserInfo!""}</p>-->
    <br/>
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
