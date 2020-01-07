<!DOCTYPE html>
<html lang="zh">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>用户登录</title>
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
        $(function(){
            $("small").hide();
            $("#UserName").click(function(){
                $("#usernameHelp").show();
                $("small[id!='usernameHelp']").hide();
                // alert("点击");
            });
            $("#Password").click(function(){
                $("#passwordHelp").show();
                $("small[id!='passwordHelp']").hide();
                //  alert("点击");
            });
            $("#UserName").focus();
          $("#usernameHelp").show();
           // alert("hello");
        });
    </script>
  </head>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-md-7">
          <img id="img1" src="/image/userlogin.png" alt="Chania" />
          <#--<img id="img1" src="/image/ppt1.jpg" alt="Chania" />-->
        </div>
        <div class="col-md-5 ">
          <div class="card border-primary mb-3" style="max-width: 25rem;">
            <div class="card-header bg-transparent border-primary">
              <p class="font-weight-bold"> 用户登录</p>
            </div>
            <div class="card-body text-primary">
              <!-- <h5 class="card-title">请输入账号和密码</h5> -->
              <form action="/loginUser" method="post">
                <div class="form-group">
                  <label for="UserName">用户名</label>
                  <input
                    type="tel"
                    name="userName"
                    class="form-control"
                    id="UserName"
                    aria-describedby="emailHelp"
                    required
                    placeholder="手机号码/邮箱/昵称"
                    value="${RequestParameters['userName']?default("")}"
                  />
                  <small id="usernameHelp" class="form-text text-muted"
                    >请输入手机号码/邮箱/昵称</small
                  >
                </div>
                <div class="form-group">
                  <label for="Password">密码</label>
                  <input
                    type="password"
                    class="form-control"
                    name="password"
                    id="Password"
                    required
                    placeholder="密码"
                    value="${RequestParameters['password']?default("")}"
                  />
                <small id="passwordHelp" class="form-text text-muted">请输入6-20位长度的密码</small>
                </div>
                <div class="form-group form-check">
                  <input
                    type="checkbox"
                    class="form-check-input"
                    id="exampleCheck1"
                  />
                  <label class="form-check-label" for="exampleCheck1"
                    >记住我的登录信息</label
                  >
                </div>
                <button type="submit" class="btn btn-primary btn-block">
                  登录
                </button>
              </form>
            </div>
            <div class="card-footer bg-transparent border-primary">
              <p class="">
                没有账号?&nbsp;<a href="/toRegister">立刻注册</a>
              </p>
            </div>
          </div>

          <#--登录失败提示-->
          <#if loginTips??>
            <div class="alert alert-danger alert-dismissible" style="width: auto">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <strong>登录失败！原因：</strong> ${loginTips!}
            </div>
          </#if>

          <#--注册成功提示-->
          <#if registerTips??>
            <div class="alert alert-success alert-dismissible" style="width:auto">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <strong>${registerTips!}</strong>
            </div>
          </#if>
        </div>
      </div>


    </div>
  </body>
</html>
