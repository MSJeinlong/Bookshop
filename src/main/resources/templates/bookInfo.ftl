<!DOCTYPE html>
<html lang="zh">
<head>
    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css" />
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
    <script>
        //判断用户时立即购买还是加入购物车
        $(function () {
            $('[data-toggle="tooltip"]').tooltip();
            $("#buyNow").click(function () {
                $("#isBuyNow").val("1");
            });
        });
    </script>
</head>
<body>
<div class="container">

    <#if addToMyCartTips??>
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>${addToMyCartTips!""}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>

    <div class="card mb-3" style="width: auto;">
        <div class="card-header">
            <a class="btn btn-success" href="/toBookshop">返回</a>&nbsp;&nbsp;
            <span class="text-dark">图书详情</span>
        </div>
        <div class="row no-gutters">
            <div class="col-md-2">
                <img src="${book.image!""}" class="card-img" style="height: 250px; width: 180px"/>
            </div>
            <div class="col-md-10">
               <#-- <div class="card-header">
                    <a class="btn btn-success" href="/toBookshop">返回</a>&nbsp;&nbsp;
                    <p class="card-text">图书详情</p>
                </div>-->
                <div class="card-body">
                    <h5 class="card-title"><a href="#" class="card-link">《${book.bookName!""}》</a>&nbsp;&nbsp;&nbsp;<small class="text-muted">销量：${book.sales!""}</small>&nbsp;&nbsp;<small class="text-muted">库存：${book.numbers!""}</small></h5>
                    <p class="card-text">作者：<span class="text-primary">${book.author!""}</span>&nbsp;&nbsp;&nbsp;[译者]：<span class="text-muted">${book.translator!"无"}</span>&nbsp;&nbsp;&nbsp;出版社：<span class="text-primary">${book.publisher!""}&nbsp;&nbsp;&nbsp;</span>出版时间：<span class="text-muted">${book.publishDate?string("yyyy-MM-dd")}</span></p>
                    <p class="card-text"><span class="text-info">[简述]:&nbsp;</span>${book.description!""}</p>

                    <h5 class="card-title pricing-card-title">销售价：&nbsp;<span style="color: red">￥${book.price?string("0.00")}</span><small class="text-muted">&nbsp;[定价]:<del>￥${(book.price/0.95)?string("0.00")}</del>(9.5折)</small></h5>

                    <form action="/buyNowOrAdd2Cart" method="post">
                        <input type="hidden" name="isBuyNow" id="isBuyNow" value="0"/>
                        <input type="hidden" name="bookId" value="${book.bookId!""}"/>
                        <div class="form-group form-inline">
                            <label for="amount">数量：</label>&nbsp;
                            <input type="number" class="form-control" name="amount" id="amount" min="1"
                                   <#if book.numbers < 10>
                                        max="${book.numbers}"
                                       <#else >
                                           max="10"
                                   </#if>
                                   value="${RequestParameters['amount']?default("1")}" required/>
                        </div>
                        <small class="text-muted">每个用户最多购买<strong style="color: red;">10</strong>件</small>
                        <div class="row">
                            <div class="col-sm-3">
                                <#if book.numbers == 0>
                                    <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="抱歉，该商品暂时无货！">
                                        <button class="btn btn-danger" style="pointer-events: none;" type="submit" disabled>加入购物车</button>
                                    </span>
                                <#else >
                                    <button type="submit" class="btn btn-danger" id="addToCart">加入购物车</button>
                                </#if>
                            </div>
                            <div class="col-sm-3">
                                <#if book.numbers == 0>
                                    <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="抱歉，该商品暂时无货！">
                                        <button class="btn btn-danger" style="pointer-events: none;" type="submit" disabled>立即购买</button>
                                    </span>
                                <#else >
                                    <button type="submit" class="btn btn-danger" id="buyNow" >立即购买</button>
                                </#if>
                            </div>
                            <#--<div class="col-sm-3">
                                <a class="btn btn-success btn-block" href="/toBookshop">返回</a>
                            </div>-->
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <nav>
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
            <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">规格属性</a>
            <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">售后政策</a>
            <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">累计评价<span class="badge badge-secondary">0</span></a>
        </div>
    </nav>
    <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
            <table class="table table-sm table-hover table-light">
                <thead class="thead-light table-bordered">
                <tr>
                   <th colspan="2" class="text-center">普通信息</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>商品编码（ISBN）</td>
                    <td>${book.isbn!""}</td>
                </tr>
                <tr>
                    <td>出版社</td>
                    <td>${book.publisher!""}</td>
                </tr>
                <tr>
                    <td>出版时间</td>
                    <td>${book.publishDate?string("yyyy-MM-dd")}</td>
                </tr>
                <tr>
                    <td>作者</td>
                    <td>${book.author!""}</td>
                </tr>
                <tr>
                    <td>发行范围</td>
                    <td>公开发行</td>
                </tr>
                <tr>
                    <td>页数</td>
                    <td>${book.pages!""}</td>
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
        <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
            <h5>正品行货</h5>
            <p>网上书店向您保证所售商品均为正品行货，所有商品开具电子发票。</p>
            <br/>
            <h5>售后服务承诺</h5>
            <ul class="list-unstyled">
                <li>1) 网上书店支持商品7天内无理由退换货（不影响二次销售），15天内可以换货，以客户收到商品第二日起计算。（食品、酒类商品等图书商品非质量问题不予退换）</li>
                <li>2) 平台售后审核人员在客户提交申请后72小时之内完成审核。</li>
                <li>3) 退换货业务均会在自接收到问题商品之日起7日之内处理完成，国家法定节假日不计算在内。</li>
            </ul>
        </div>
        <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">该商品还没有评价~</div>
    </div>
</div>
</body>
</html>