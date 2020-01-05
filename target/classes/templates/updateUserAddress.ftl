<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>编辑地址</title>
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
            if($("button[type='submit']").click(function () {

                var province2 = $("#province2").val();
                var city2 = $("#city2").val();
                var district2 = $("#district2").val();
                var street2 = $("#street2").val();
                //alert(province2+":"+city2+":"+district2+":"+street2);
                //第二个地址要么全为空，要么全不为空！
                if(province2 != "" && city2 != "" && district2 != "" && street2 != ""){
                    return true;
                }
                else if(province2 == "" && city2 == "" && district2 == "" && street2 == ""){
                    return true;
                } else {
                    alert("请完善第二项地址的信息！");
                    return false;
                }

            }));
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
                    <form action="/updateAddress" method="post">
                        <div class="form-inline">
                            <div data-toggle="distpicker">
                                <div class="form-group">
                                    <label  for="province1" style="color: #0b2e13;">省/市/区:&nbsp;</label>
                                    <select name="province1" class="form-control" id="province1" data-province="${bsUser.province1!""}" required></select>
                                </div>
                                <div class="form-group">

                                    <select name="city1" class="form-control" id="city1" data-city="${bsUser.city1!""}" required></select>
                                </div>
                                <div class="form-group">

                                    <select name="district1" class="form-control" id="district1" data-district="${bsUser.district1!""}" required></select>
                                </div>
                            </div>
                        </div>
                        <br/>
                        <div class="form-group ">
                            <label for="street1" style="color: black">详细地址1：&nbsp;</label>
                            <textarea class="form-control" rows="5" cols="6" name="street1" required>${bsUser.street1!""}</textarea>
                        </div>

                        <div class="form-inline">
                            <div id="distpicker5">
                                <div class="form-group">
                                    <label  for="province1" style="color: #0b2e13;">省/市/区:&nbsp;</label>
                                    <label class="sr-only" for="province10">Province</label>
                                    <select name="province2" class="form-control" id="province2" data-province="${bsUser.province2!""}"></select>
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="city10">City</label>
                                    <select name="city2" class="form-control" id="city2" data-city="${bsUser.city2!""}"></select>
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="district10">District</label>
                                    <select name="district2" class="form-control" id="district2" data-district="${bsUser.district2!""}"></select>
                                </div>
                            </div>
                        </div>
                        <br/>
                        <div class="form-group ">
                            <label for="street1" style="color: black">详细地址2：&nbsp;</label>
                            <textarea class="form-control" rows="5" cols="6" name="street2" id="street2">${bsUser.street2!""}</textarea>
                        </div>
                        <div class="row">
                            <div class="col-sm-3">
                                <a href="/toUserInfo" class="btn btn-primary btn-block">返回</a>
                            </div>
                            <div class="col-sm-3">
                                <button type="submit" class="btn btn-success btn-block">提交</button>
                            </div>

                            <#if bsUser.province2??>
                                <div class="col-sm-3">
                                    <a href="/delAddr2" class="btn btn-danger btn-block">删除地址2</a>
                                </div>
                            </#if>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>