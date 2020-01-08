<!DOCTYPE html>
<html lang="zh">
<head>
    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css" />
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
    <title>添加图书类型</title>
    <style>
        #bookType{
            margin-top: 50px;
        }
    </style>

    <script>
        $(function () {
            $("#submit").click(function () {
                var isletter = /^[A-Z0-9]+$/.test($("#categoryAttr").val());
                if (!isletter){
                    alert("图书类型编号格式错误！(应为大写英文字母和数字组合)")
                    return false;
                }
                else
                    return true;
            });
            $("#categoryAttr").focus();
        });
    </script>
</head>
<body>
<div class="container">
    <div class="row" id="bookType">
        <div class="offset-md-3 col-md-6">
            <div class="card">
                <div class="card-header">
                    <h5>添加图书类型</h5>
                </div>
                <div class="card-body">
                    <form action="/addBookType" method="post">
                        <div class="form-group row">
                            <label for="category" class="col-sm-3 col-form-label">图书类型编号</label>
                            <div class="col-sm-9">
                                <input type="text" name="categoryAttr" id="categoryAttr" class="form-control" required value="${RequestParameters['category']?default("")}"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="category" class="col-sm-3 col-form-label">图书类型名称</label>
                            <div class="col-sm-9">
                                <input type="text" name="categoryName" id="categoryName" class="form-control" required value="${RequestParameters['category']?default("")}"/>
                            </div>
                        </div>
                        <br/>

                        <div class="row">
                            <div class="col-md-3 offset-md-3 ">
                                <button type="submit" id="submit" class="btn btn-primary btn-block">提交</button>
                            </div>

                            <div class="col-md-3">
                                <button type="reset" class="btn btn-warning btn-block">重置</button>
                            </div>

                            <div class="col-md-3">
                                <a href="#" class="btn btn-success btn-block">返回</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <#if addBookCategoryTips??>
        <div class="row">
            <div class="offset-md-3 col-md-6">
                <div class="alert alert-info alert-dismissible" style="width:auto">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>${addBookCategoryTips}</strong>
                </div>
            </div>
        </div>
    </#if>
</div>
</body>
</html>