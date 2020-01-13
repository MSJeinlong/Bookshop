<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>网上书店系统</title>
      <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css" />
      <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
      <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
      <script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
      <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
    <style type="text/css">
      #classOfBook {
        margin-top: 60px;
      }
    </style>
    <script>
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
            bindKeyEvent($("#lowestPrice"));
            bindKeyEvent($("#highestPrice"));
            //alert("binfKeyEvent");
            $("#submit").click(function () {
                var lowest = $("#lowestPrice").val();
                var highest = $("#highestPrice").val();
                //防止上溢
                if(lowest > 99999999.99)
                    lowest = 99999999.99;
                if(highest > 99999999.99)
                    highest = 99999999.99;
                //最低价大于最高价，交换两者数值
                if(lowest > highest){
                    $("#lowestPrice").val(highest);
                    $("#highestPrice").val(lowest);
                }
            });

            $("#myCart").click(function () {
                $("#myOrder").attr("class", "nav-item");
                $(this).attr("class", "nav-item active");
            });
            $("#myOrder").click(function () {
                $("#myCart").attr("class", "nav-item");
                $(this).attr("class", "nav-item active");
            });

            $("#checkStock").click(function () {
                //alert("click");
                if(this.checked){
                    $("#stockStatus").val("1");
                } else {
                    $("#stockStatus").val("0");
                }
                $("#stockForm").submit();
            });
        });
        function bindKeyEvent(obj) {
            obj.keyup(function () {
                var reg = $(this).val().match(/\d+\.?\d{0,2}/);
                var txt = '';
                if (reg != null) {
                    txt = reg[0];
                }
                $(this).val(txt);
            }).change(function () {
                $(this).keypress();
                var v = $(this).val();
                if (/\.$/.test(v)) {
                    $(this).val(v.substr(0, v.length - 1));
                }
            });
        }
    </script>
  </head>
  <body>
    <div class="container-fluid">
      <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
        <a class="navbar-brand" href="#"></span>BOOKSHOP</a>
        <span class="navbar-text"
          >欢迎光临网上书店
            <#if bsUser??>

                <#else >
                    ，请<a href="/toUserLogin" class="text-primary" data-toggle="tooltip" title="点击可进行登录或者注册!">登录</a>成为会员
            </#if>

        </span>
        <ul class="navbar-nav">
          <li class="nav-item active"  id="myCart">
            <a class="nav-link" href="/toMyCart"
            >购物车<span class="badge badge-pill badge-info">${cartCount!"0"}</span></a
            >
          </li>
          <li class="nav-item" id="myOrder">
            <a class="nav-link" href="/toMyOrder"
              >我的订单<span class="badge badge-pill badge-info">${countAllOrder!"0"}</span></a
            >
          </li>
        </ul>
        <form action="/findBook" class="form-inline" method="post">
            <div class="input-group">
                <input type="search" name="keyName" class="form-control"  value="${RequestParameters['keyName']?default("")}" placeholder="请输入书名/作者"/>
                <div class="input-group-append">
                    <button class="btn btn-outline-success " type="submit" >搜索</button>
                </div>
            </div>
        </form>
      <#--  <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" href="#">高级搜索</a>
          </li>
        </ul>-->

        <ul class="navbar-nav nav-right">
            <li class="nav-item">
                <a class="nav-link" href="/toUserInfo"></span>
                    我的账号<#if bsUser??>:${bsUser.cellphone!""}</#if>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/userExit">退出</a>
            </li>
        </ul>
      </nav>

      <div class="row" id="classOfBook">
          <div class="col-lg-3">
              <div class="card mb-4 shadow-sm" id="newbook">
                  <div class="card-header">
                      <h4 class="my-0 font-weight-normal">新书上架</h4>
                  </div>
                  <div class="card-body">
<#--                      <h4 class="card-title">新书上架</h4>-->
                      <table class="table table-sm table-light table-borderless table-hover table-responsive">
                          <thead class="thead-light">
                          <tr>
                              <th scope="col">#</th>
                              <th scope="col">书名</th>
                          </tr>
                          </thead>
                          <tbody>
                          <#list newTop10 as book>
                              <#if book_index == 4>
                                  <#break>
                              </#if>
                              <tr>
                                  <td>${(book_index + 1)!""}</td>
                                  <td><a href="/toBookInfo?bookId=${book.bookId!""}">《${book.bookName!""}》</a><span class="badge badge-pill badge-secondary">new</span></td>
                              </tr>
                          </#list>
                          </tbody>
                      </table>
                      <button class="btn btn-sm btn-success" data-toggle="modal" data-target="#newTop10">查看更多</button>
                  </div>
              </div>
          </div>
          <div class="col-lg-6">
          <div id="demo" class="carousel slide" data-ride="carousel">
            <!-- 指示符 -->
            <ul class="carousel-indicators">
              <li data-target="#demo" data-slide-to="0" class="active"></li>
              <li data-target="#demo" data-slide-to="1"></li>
              <li data-target="#demo" data-slide-to="2"></li>
                <li data-target="#demo" data-slide-to="3"></li>
                <li data-target="#demo" data-slide-to="4"></li>
                <li data-target="#demo" data-slide-to="5"></li>
                <li data-target="#demo" data-slide-to="6"></li>
            </ul>

            <!-- 轮播图片 -->
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img
                  src="/image/slide/ppt1.jpg"
                />
                <!-- 轮播图片说明 -->

              </div>
              <div class="carousel-item">
                <img
                  src="/image/slide/ppt2.jpg"
                />

              </div>
              <div class="carousel-item">
                <img
                  src="/image/slide/ppt3.jpg"
                />

              </div>
                <div class="carousel-item">
                    <img src="/image/slide/ppt4.jpg"/>

                </div>
                <div class="carousel-item">
                    <img src="/image/slide/ppt5.jpg"/>

                </div>
                <div class="carousel-item">
                    <img src="/image/slide/ppt6.jpg"/>
                   
                </div>
            </div>

            <!-- 左右切换按钮 -->
            <a class="carousel-control-prev" href="#demo" data-slide="prev">
              <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#demo" data-slide="next">
              <span class="carousel-control-next-icon"></span>
            </a>
          </div>
        </div>
        <div class="col-lg-3">

            <div class="card mb-4 shadow-sm">
                <div class="card-header">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a
                                    class="nav-link active"
                                    id="home-tab"
                                    data-toggle="tab"
                                    href="#home"
                                    role="tab"
                                    aria-controls="home"
                                    aria-selected="true"
                            >销售排行</a
                            >
                        </li>

                        <li class="nav-item">
                            <a
                                    class="nav-link"
                                    id="contact-tab"
                                    data-toggle="tab"
                                    href="#contact"
                                    role="tab"
                                    aria-controls="contact"
                                    aria-selected="false"
                            >网站公告</a
                            >
                        </li>
                    </ul>
                </div>

                <div class="card-body">
                    <div class="tab-content" id="myTabContent">
                        <div
                                class="tab-pane fade show active"
                                id="home"
                                role="tabpanel"
                                aria-labelledby="home-tab"
                        >
                            <table class="table table-sm table-light table-borderless table-hover table-responsive">
                                <thead class="thead-light">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">书名</th>
                                </tr>
                                </thead>
                                <tbody>
                                 <#list salesTop10 as book>
                                     <#if book_index == 4>
                                         <#break>
                                     </#if>
                                        <tr>
                                            <td>${(book_index + 1)!""}</td>
                                            <td><a href="/toBookInfo?bookId=${book.bookId!""}">《${book.bookName!""}》</a><span class="badge badge-pill badge-danger">Hot!</span></td>
                                        </tr>
                                 </#list>
                                </tbody>
                            </table>
                            <button class="btn btn-sm btn-success" data-toggle="modal" data-target="#salesTop10">查看更多</button>
                        </div>
                        <div
                                class="tab-pane fade"
                                id="contact"
                                role="tabpanel"
                                aria-labelledby="contact-tab"
                        >
                            <h7 class="text-info">全民阅读，点亮中国梦！</h7>
                            <p class="text-muted">知识改变命运，阅读收获财富！网上书店竭诚为您服务！</p>
                            <small class="text-muted">读书的目的，不在于取得多大的成就，而在于，当你被生活打回原形，陷入泥潭时，给你一种内心的力量。
                            读书的两个作用：一是让我自以为非，一是让我有一间自己的房子，有内心生活。
                           在一个夜晚，因为一本书，内心的激情突然如潮水一样蔓延出来。</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      </div>

    <br/>

        <div class="nav-scroller bg-white shadow-sm">
            <nav class="nav nav-underline text-dark">
                <#--<a class="nav-link active" href="#">商品详情</a>-->
                <a class="nav-link active" href="#">
                    商品件数
                    <span class="badge badge-pill badge-primary">${books?size}</span>
                </a>
                <a class="nav-link sort" href="/findAllProduct"
                        <#if activeCode == 0>
                            style="color: red"
                        </#if>
                >全部商品</a>
                <a class="nav-link sort" href="/comprehensiveSort"
                        <#if activeCode == 1>
                        style="color: red"
                        </#if>
                >综合排序</a>
                <a class="nav-link sort" href="/ascSortBookByPrice"
                        <#if activeCode == 2>
                            style="color: red"
                        </#if>
                >价格↑</a>
                <a class="nav-link sort" href="/descSortBookByPrice"
                        <#if activeCode == 3>
                            style="color: red"
                        </#if>
                >价格↓</a>
                <a class="nav-link sort" href="/descSortBookBySales"
                        <#if activeCode == 4>
                            style="color: red"
                        </#if>
                >销量↓</a>
                <a class="nav-link sort" href="/publishDateSort"
                        <#if activeCode == 5>
                            style="color: red"
                        </#if>
                >出版时间↓</a>
                <form class="form-inline" action="/findBookByLHPrice" method="post">
                    <input type="search" name="lowestPrice" id="lowestPrice"  maxlength="11" class="form-control" value="${RequestParameters['lowestPrice']?default("")}" placeholder="￥请输入最低价"/>-
                    <input type="search" name="highestPrice" id="highestPrice"  maxlength="11" class="form-control" value="${RequestParameters['highestPrice']?default("")}" placeholder="￥请输入最高价" aria-label="Text input with dropdown button"/>
                    <div class="input-group-append">
                    <button type="submit" class="btn btn-primary" id="submit">确定</button>
                    </div>
                </form>
                &nbsp;&nbsp;
                <form action="/isEnoughStock" method="post" id="stockForm">
                    <div class="custom-control custom-checkbox">
                        <input type="hidden" name="stockStatus" id="stockStatus" value="0" />
                        <input type="checkbox" class="custom-control-input" id="checkStock"
                          <#if stockStatus??>
                              <#if stockStatus == "1">
                                  checked
                                  </#if>
                          </#if>
                        />
                        <label class="custom-control-label" for="checkStock">仅看有货</label>
                    </div>
                </form>
            </nav>
        </div>

        <br/>

        <div class="row">
            <div class="col-md-3">
                <#if addToMyCartTips??>
                    <div class="alert alert-success alert-dismissible" style="width:auto">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>${addToMyCartTips}</strong>
                    </div>
                </#if>
            </div>
        </div>


        <#if (books?size==0)>
            <div class="card">
                <div class="card-body">
                    <h3 class="card-title text-muted">抱歉，没有找到该商品~~</h3>
                    <h5 class="card-subtitle text-muted">建议您重新输入搜索关键字！</h5>
                </div>
            </div>
        <#else >
            <#list books as book>
                <div class="card mb-3" style="width: auto;">
                    <div class="row no-gutters">
                        <div class="col-md-2">
                            <img src="${book.image!""}" class="card-img" style="height: 250px; width: 180px"/>
                        </div>
                        <div class="col-md-10">
                            <div class="card-body">
                                <h5 class="card-title"><a href="/toBookInfo?bookId=${book.bookId!""}" class="card-link" data-toggle="tooltip" title="点击查看商品详情!">《${book.bookName!""}》</a></h5>
                                <h5 class="card-title pricing-card-title " style="color: red">￥${book.price?string("0.00")}&nbsp;&nbsp;<small class="text-muted">&nbsp;[定价]:<del>￥${(book.price/0.95)?string("0.00")}</del></small>&nbsp;&nbsp;<small style="color: red">(9.5折)</small>
                                    &nbsp;&nbsp;<small class="text-muted">销量：${book.sales!""}</small>&nbsp;&nbsp;
                                    <small class="text-muted">库存：${book.numbers!""}</small>
                                </h5>
                                <p class="card-text"><span class="text-primary">${book.author!""}</span>&nbsp;著/<span class="text-muted">${book.publishDate?string("yyyy-MM-dd")}</span>/<span class="text-primary">${book.publisher!""}/${book.publishDate?string("yyyy-MM-dd")}</span></p>
                                <p class="card-text"><span class="text-info">[简述]:&nbsp;</span>${book.description!""}</p>
                                <#--<a href="/addToMyCart?bookId=${book.bookId!""}" class="btn btn-danger">加入购物车</a>-->
                                <#--<a href="#" class="btn btn-outline-danger">收藏</a>-->

                                <form action="/addToMyCart" method="post">
                                    <input type="hidden" name="bookId" value="${book.bookId!""}"/>
                                    <input type="hidden" name="amount" value="1"/>
                                    <input type="hidden" name="flag" value="1"/>
                                    <#if book.numbers == 0>
                                        <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="抱歉，该商品暂时无货！">
                                            <button class="btn btn-danger" style="pointer-events: none;" type="submit" disabled>加入购物车</button>
                                        </span>
                                        <#else >
                                            <button type="submit" class="btn btn-danger">加入购物车</button>
                                    </#if>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </#list>


                <div class="offset-md-3 col-md-6">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="#">首页</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">上一页</span>
                                </a>
                            </li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">下一页</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">尾页</a></li>
                        </ul>
                    </nav>
                </div>
        </#if>

        <#--NewTop10 Model-->
        <div class="modal fade" id="newTop10">
            <div class="modal-dialog">
                <div class="modal-content">
                    <#--模态框头部-->
                    <div class="modal-header">
                        <h5 class="modal-title">新书上架Top10</h5>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <#--模态框主体-->
                    <div class="modal-body">
                        <table class="table table-sm table-light table-borderless table-hover table-responsive">
                            <thead class="thead-light">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">书名</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list newTop10 as book>
                                <tr>
                                    <td>${(book_index + 1)!""}</td>
                                    <td><a href="/toBookInfo?bookId=${book.bookId!""}">《${book.bookName!""}》</a><span class="badge badge-pill badge-secondary">new</span></td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>

                    <#--模态框底部-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                    </div>
                </div>
            </div>
        </div>

        <#--SalesTop10 Model-->
        <div class="modal fade" id="salesTop10">
            <div class="modal-dialog">
                <div class="modal-content">
                    <#--模态框头部-->
                    <div class="modal-header">
                        <h5 class="modal-title">热销排行Top10</h5>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <#--模态框主体-->
                    <div class="modal-body">
                        <table class="table table-sm table-light table-borderless table-hover table-responsive">
                            <thead class="thead-light">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">书名</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list salesTop10 as book>
                                <tr>
                                    <td>${(book_index + 1)!""}</td>
                                    <td><a href="/toBookInfo?bookId=${book.bookId!""}">《${book.bookName!""}》</a><span class="badge badge-pill badge-secondary">new</span></td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>

                    <#--模态框底部-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                    </div>
                </div>
            </div>
        </div>

      </div>

  </body>
</html>
