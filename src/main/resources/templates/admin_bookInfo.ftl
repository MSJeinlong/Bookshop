<!DOCTYPE html>
<html lang="zh">
<head>
    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css" />
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="card mb-3" style="width: auto;">
        <div class="card-header">
            <a class="btn btn-success" href="/toAdminManage">返回</a>&nbsp;&nbsp;
            <span class="text-dark">图书详情</span>
        </div>
        <div class="row no-gutters">
            <div class="col-md-2">
                <img src="${admin_book.image!""}" class="card-img" style="height: 250px; width: 180px"/>
            </div>
            <div class="col-md-10">
                <div class="card-body">
                    <h5 class="card-title"><a href="#" class="card-link">《${admin_book.bookName!""}》</a>&nbsp;&nbsp;&nbsp;<small class="text-muted">销量：${admin_book.sales!""}</small>&nbsp;&nbsp;<small class="text-muted">库存：${admin_book.numbers!""}</small></h5>
                    <p class="card-text">作者：<span class="text-primary">${admin_book.author!""}</span>&nbsp;&nbsp;&nbsp;[译者]：<span class="text-muted">${admin_book.translator!"无"}</span>&nbsp;&nbsp;&nbsp;出版社：<span class="text-primary">${admin_book.publisher!""}&nbsp;&nbsp;&nbsp;</span>出版时间：<span class="text-muted">${admin_book.publishDate?string("yyyy-MM-dd")}</span></p>
                    <p class="card-text"><span class="text-info">[简述]:&nbsp;</span>${admin_book.description!""}</p>

                    <h5 class="card-title pricing-card-title">销售价：&nbsp;<span style="color: red">￥${admin_book.price?string("0.00")}</span><small class="text-muted">&nbsp;[定价]:<del>￥${(admin_book.price/0.95)?string("0.00")}</del>(9.5折)</small></h5>
                </div>
            </div>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <table class="table table-sm table-hover table-light">
                <thead class="thead-light table-bordered">
                <tr>
                    <th colspan="2" class="text-center">普通信息</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>商品编码（ISBN）</td>
                    <td>${admin_book.isbn!""}</td>
                </tr>
                <tr>
                    <td>出版社</td>
                    <td>${admin_book.publisher!""}</td>
                </tr>
                <tr>
                    <td>出版时间</td>
                    <td>${admin_book.publishDate?string("yyyy-MM-dd")}</td>
                </tr>
                <tr>
                    <td>上架时间</td>
                    <td>${admin_book.createTime?string("yyyy-MM-dd hh:MM:ss")}</td>
                </tr>
                <tr>
                    <td>更新时间</td>
                    <td>${admin_book.updateTime?string("yyyy-MM-dd hh:MM:ss")}</td>
                </tr>
                <tr>
                    <td>作者</td>
                    <td>${admin_book.author!""}</td>
                </tr>
                <tr>
                    <td>发行范围</td>
                    <td>公开发行</td>
                </tr>
                <tr>
                    <td>页数</td>
                    <td>${admin_book.pages!""}</td>
                </tr>
                <tr>
                    <td>正文语种</td>
                    <td>汉</td>
                </tr>
                <tr>
                    <td>媒质</td>
                    <td>图书</td>
                </tr>
                <tr>
                    <td>用纸</td>
                    <td>普通纸</td>
                </tr>
                <tr>
                    <td>是否套装</td>
                    <td>单册</td>
                </tr>
                <tr>
                    <td>影印版本</td>
                    <td>原版</td>
                </tr>
                <tr>
                    <td>包装</td>
                    <td>平装</td>
                </tr>
                <tr>
                    <td>出版商国别</td>
                    <td>CN</td>
                </tr>
                <tr>
                    <td>读者对象</td>
                    <td>普通大众</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>