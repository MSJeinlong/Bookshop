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
    <style>

    </style>

    <title>购物车</title>
</head>
<body>
<div class="container-fluid">
    <div class="card ">
        <div class="card-header">
            全部商品<span class="badge badge-pill badge-secondary">2</span>
        </div>
        <div class="card-body">
            <!-- <h5 class="card-title">Special title treatment</h5> -->
            <table class="table table-striped table-borderless table-hover">
                <caption></caption>
                <thead class="table-secondary">
                <tr>
                    <th>
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="customCheck">
                            <label class="custom-control-label" for="customCheck">全选</label>
                        </div>
                    </th>
                    <th>商品信息</th>
                    <th>单价(元)</th>
                    <th>数量</th>
                    <th>小计(元)</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="customCheck1">
                            <label class="custom-control-label" for="customCheck1">选中</label>
                        </div>
                    </td>
                    <td>
                        <img src="/image/book/jixianlinshanwenjixuan.png" style="width: 40px;height: 50px;"/>
                        &nbsp;《季羡林文学精选》
                    </td>
                    <td><span style="color: red">￥36.10</span></td>
                    <td>
                        <div class="form-group row">
                            <div class="col-sm-6">
                                <input type="number" class="form-control" name="amount" min="1" max="10" value="1" maxlength="2"/>
                            </div>
                        </div>
                    </td>
                    <td><span style="color: red;">￥36.10</span></td>
                    <td><a href="#">删除</a></td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>

    <!-- 结算栏固定在底部 -->
    <nav class="navbar navbar-expand-sm bg-light navbar-light fixed-bottom">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="navbar-allcheck">
            <label class="custom-control-label" for="navbar-allcheck">全选</label>
        </div>
        &nbsp;
        <span class="navbar-text">
            <a href="#" class="btn btn-warning ">删除选中的商品</a>
        </span>
        &nbsp;
        <span class="navbar-text">
            <a href="#" class="btn btn-outline-danger ">清空购物车</a>
        </span>
        &nbsp;
        <span class="navbar-text">
          总价(包括邮费)：<span style="color: red">￥1000</span>&nbsp;
            &nbsp;
          <a href="#" class="btn btn-danger text-white">结算</a>
        </span>
    </nav>
</div>
</body>
</html>
