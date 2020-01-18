<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>管理员后台</title>

    <link rel="canonical" href="https://v4ing.bootcss.com/docs/4.3/examples/dashboard/">

    <!-- Bootstrap core CSS -->
    <#--<link href="/docs/4.3/dist/css/bootstrap.css" rel="stylesheet">-->
    <link href="/bootstrap-4.3.1/css/bootstrap.min.css" rel="stylesheet"/>


    <!-- Favicons -->
    <link rel="apple-touch-icon" href="/docs/4.3/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="/docs/4.3/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="/docs/4.3/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="/docs/4.3/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="/docs/4.3/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
    <link rel="icon" href="/docs/4.3/assets/img/favicons/favicon.ico">
    <meta name="msapplication-config" content="/docs/4.3/assets/img/favicons/browserconfig.xml">
    <meta name="theme-color" content="#563d7c">

    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <script>
        $(function () {
           // alert("hi");
            var nav_link_actived = $("#nav-link-actived").val();
            //alert(nav_link_actived);
            if(nav_link_actived == 1){
                $("#order-link").addClass("active");
                $("#product-link").removeClass("active");
                $("#user-link").removeClass("active");
                //alert("order-click");
                $("#Products").css("display", "none");
                $("#Users").css("display", "none")
                $("#Orders").css("display", "block");
            } else if(nav_link_actived == 2){
                $("#product-link").addClass("active");
                $("#user-link").removeClass("active");
                $("#order-link").removeClass("active");
                //alert("product-click");
                $("#Users").css("display", "none")
                $("#Products").css("display", "block");
                $("#Orders").css("display", "none");
            } else if(nav_link_actived == 3){
                $("#product-link").removeClass("active");
                $("#user-link").addClass("active");
                $("#order-link").removeClass("active");
                //alert("user-click");
                $("#Users").css("display", "block")
                $("#Products").css("display", "none");
                $("#Orders").css("display", "none");
            }

            var pills_nav_link_actived = $("#pills_nav_link_actived").val();
            if(pills_nav_link_actived == 1){
                $(".order-nav-link").removeClass("active");
                $("#allOrders").addClass("active");
            } else if(pills_nav_link_actived == 2){
                $(".order-nav-link").removeClass("active");
                $("#UnpaidOrder").addClass("active");
            } else if(pills_nav_link_actived == 3){
                $(".order-nav-link").removeClass("active");
                $("#UnDeliveryOrder").addClass("active");
            } else if(pills_nav_link_actived == 4){
                $(".order-nav-link").removeClass("active");
                $("#UnReceivedOrder").addClass("active");
            } else {
                $(".order-nav-link").removeClass("active");
                $("#OrderByTime").addClass("active");
            }

            var book_nav_link_actived = $("#book-nav-link-actived").val();
            if(book_nav_link_actived == 1){
                $(".book-nav-link").removeClass("active");
                $("#allBooks").addClass("active");
            } else if(book_nav_link_actived == 2){
                $(".book-nav-link").removeClass("active");
                $("#sortAscSales").addClass("active");
            } else if(book_nav_link_actived == 3){
                $(".book-nav-link").removeClass("active");
                $("#sortDescSales").addClass("active");
            } else if(book_nav_link_actived == 4){
                $(".book-nav-link").removeClass("active");
                $("#sortAscNumbers").addClass("active");
            } else if(book_nav_link_actived == 5){
                $(".book-nav-link").removeClass("active");
                $("#sortDescNumbers").addClass("active");
            } else if(book_nav_link_actived == 6){
                $(".book-nav-link").removeClass("active");
                $("#sortAscPrice").addClass("active");
            } else if(book_nav_link_actived == 7){
                $(".book-nav-link").removeClass("active");
                $("#sortDescPrice").addClass("active");
            }

            $("#order-link").click(function () {
                $("#order-link").addClass("active");
                $("#product-link").removeClass("active");
                $("#user-link").removeClass("active");
                //alert("order-click");
                $("#Products").css("display", "none");
                $("#Users").css("display", "none")
                $("#Orders").css("display", "block");
            });

            $("#product-link").click(function () {
                $("#product-link").addClass("active");
                $("#user-link").removeClass("active");
                $("#order-link").removeClass("active");
                //alert("product-click");
                $("#Users").css("display", "none")
                $("#Products").css("display", "block");
                $("#Orders").css("display", "none");
            });

            $("#user-link").click(function () {
                $("#product-link").removeClass("active");
                $("#user-link").addClass("active");
                $("#order-link").removeClass("active");
                //alert("user-click");
                $("#Users").css("display", "block")
                $("#Products").css("display", "none");
                $("#Orders").css("display", "none");
            });

            $("#deliveryBtn").click(function () {
                //设置提交的表单数据
                var orderId = $(this).val();
                $("#orderId").val(orderId);
            });

            $("#delivery").click(function () {
                if(confirm("确定发货吗?")){
                    $("#deliveryForm").submit();
                }
                return false;
            });
            $("#deleteBook").click(function () {
                if(confirm("确定删除该图书吗？")){
                    return true;
                } else
                    return false;
            });
        });
    </script>
    <!-- Custom styles for this template -->
    <link href="/dashboard/dashboard.css" rel="stylesheet">
</head>
<body>
<input type="hidden" id="nav-link-actived" value="${nav_link!"1"}"/>
<input type="hidden" id="book-nav-link-actived" value="${book_nav_link_actived!"1"}"/>
<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">BOOKSHOP</a>
    <input class="form-control form-control-dark w-90" type="text" placeholder="Search" aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="/adminExit">退出</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" id="order-link" href="#">
                            <span data-feather="file"></span>
                            Orders
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="product-link" href="#">
                            <span data-feather="shopping-cart"></span>
                            Products
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" id="user-link">
                            <span data-feather="users"></span>
                            Customers
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <input type="hidden" id="pills_nav_link_actived"  name="pills_nav_link_actived" value="${pills_nav_link_actived!"1"}"/>
            <div id="Orders" style="display: none">
            <h6>订单数据 &nbsp;&nbsp;共 <span class="badge badge-pill badge-secondary">${pageInfo_orders.total!"0"}</span> 条记录</h6>
                <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link order-nav-link" id="allOrders"  href="/allOrders"  >全部订单</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link order-nav-link" id="UnpaidOrder"  href="/findUnpaidOrder">待付款</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link order-nav-link" id="UnDeliveryOrder" href="/findUnDeliveryOrder">待发货</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link order-nav-link" id="UnReceivedOrder"  href="/findUnReceivedOrder" >待收货</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link order-nav-link" id="OrderByTime"  href="/OrderByTime">下单时间↓</a>
                    </li>
                    <li class="nav-item">
                        <form class="form-inline" action="/findByOrderIdAndUserName" method="post">
                            <input type="search" name="userName" class="form-control" value="${userName!""}" placeholder="收货人"/>
                            <input type="search" name="orderId" class="form-control" value="${orderId!""}" placeholder="订单编号"/>
                            <button type="submit" class="btn btn-sm btn-primary">搜索</button>
                        </form>
                    </li>
                </ul>
             <#if updateOrderTips??>
                 <div class="row">
                     <div class="alert alert-success alert-dismissible col-md-3">
                         <button type="button" class="close" data-dismiss="alert">&times;</button>
                         <strong>${updateOrderTips!""}</strong>
                     </div>
                 </div>
             </#if>
            <div class="table-responsive">
                <table class="table table-striped table-hover table-sm">
                   <thead class="table-secondary">
                   <tr>
                       <th>订单编号</th>
                       <th>下单时间</th>
                       <th>收货人</th>
                       <th>金额</th>
                       <th>支付方式</th>
                       <th>订单状态</th>
                       <th>订单详情</th>
                       <th>操作</th>
                   </tr>
                   </thead>
                    <tbody>
                    <#list pageInfo_orders.list as orderMaster>
                        <tr>
                            <td>${orderMaster.orderId!""}</td>
                            <td>${orderMaster.createTime?string("yyyy-MM-dd hh:MM:ss")}</td>
                            <td>${orderMaster.userName!""}</td>
                            <td><span style="color: red">￥${orderMaster.totalPrice?string("0.00")}</span></td>
                            <td>
                                <#if orderMaster.payWay == 1>
                                    银行卡支付
                                <#elseif orderMaster.payWay == 2>
                                    支付宝支付
                                <#elseif orderMaster.payWay == 3>
                                    微信支付
                                </#if>
                            </td>
                            <td>
                                <#if orderMaster.orderStatus == 0>

                                    <span class="badge badge-danger">待付款</span>
                                <#elseif orderMaster.orderStatus == 1>
                                    <span class="badge badge-info">待发货</span>
                                <#elseif orderMaster.orderStatus == 2>
                                    <span class="badge badge-success">待收货</span>
                                <#elseif orderMaster.orderStatus == 3>
                                    <span class="badge badge-secondary">待评价</span>
                                </#if>
                            </td>
                            <td><a href="/toOrderDetail?orderId=${orderMaster.orderId!""}&role=2">查看详情</a></td>
                            <td>
                               <#if orderMaster.orderStatus == 1>

                                   <form action="/adminUpdateOrder" method="post" id="deliveryForm">
                                        <input type="hidden" name="orderId" value="${orderMaster.orderId}"/>
                                        <input type="hidden" name="orderStatus" value="2"/>
                                   </form>
                                   <a href="#" id="delivery" ><span class="badge badge-primary">确认发货</span></a>
                               <#else >
                                    ---
                               </#if>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>

                <nav aria-label="...">
                    <ul class="pagination">
                        <li class="page-item disabled">
                            <a href="#" class="page-link">第${pageInfo_orders.pageNum!"0"}/${pageInfo_orders.pages!"0"}页</a>
                        </li>
                        <li class="page-item ">
                            <a class="page-link" href="/toOrderPage?pageNum=1">首页</a>
                        </li>
                        <li class="page-item ">
                            <a class="page-link" href="/toOrderPage?pageNum=${pageInfo_orders.prePage}">上一页</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="/toOrderPage?pageNum=${pageInfo_orders.nextPage}">下一页</a>
                        </li>
                        <li class="page-item ">
                            <a class="page-link" href="/toOrderPage?pageNum=${pageInfo_orders.pages}">尾页</a>
                        </li>
                        <li class="page-item">
                            <form class="form-inline"  action="/toOrderPage" method="post">
                                &nbsp;&nbsp;共&nbsp;<strong class="text-muted">${pageInfo_orders.pages}</strong>&nbsp;页
                                &nbsp;到第<input type="number" name="pageNum" class="form-control" min="1" value="${pageNum!"1"}" max="${pageInfo_orders.pages}"/>页 &nbsp;
                                <button type="submit" class="btn btn-sm btn-primary">确定</button>
                            </form>
                        </li>
                    </ul>

                </nav>
            </div>


            <div id="Products" style="display: none;">
                <#if addNewBookTips??>
                    <div class="alert alert-info alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>${addNewBookTips}</strong>
                    </div>
                </#if>
                <#if updateBookTips??>
                    <div class="alert alert-info alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>${updateBookTips}</strong>
                    </div>
                </#if>

                <h6>图书数据 &nbsp;&nbsp;共 <span class="badge badge-pill badge-secondary">${pageInfo_books.total!"0"}</span> 条记录</h6>

                <ul class="nav nav-pills">
                    <li class="nav-item">
                        <a class="nav-link active book-nav-link" id="allBooks" href="/adminFindAllBooks">全部图书</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link book-nav-link" id="sortAscSales" href="/sortSecSales">销量↑</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link book-nav-link" id="sortDescSales" href="/sortDesSales">销量↓</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link book-nav-link" id="sortAscNumbers" href="/sortSecNumbers">库存↑</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link book-nav-link" id="sortDescNumbers" href="/sortDesNumbers">库存↓</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link book-nav-link" id="sortAscPrice" href="/sortSecPrice">单价↑</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link book-nav-link" id="sortDescPrice" href="/sortDesPrice">单价↓</a>
                    </li>
                    <li class="nav-item">
                        <form class="form-inline" action="/findBookByBAP" method="post">
                            <input type="search" name="bookName" class="form-control" value="${RequestParameters['bookName']?default("")}" placeholder="书名"/>
                            <input type="search" name="author" class="form-control" value="${RequestParameters['author']?default("")}" placeholder="作者"/>
                            <input type="search" name="publisher" class="form-control" value="${RequestParameters['publisher']?default("")}" placeholder="出版社"/>
                            <button type="submit" class="btn btn-primary">搜索</button>
                        </form>
                    </li>
                    <li class="page-item">
                        &nbsp; &nbsp;<a class="btn btn-success" href="/toAddBook">添加图书</a>
                    </li>
                </ul>

                <div class="table-responsive">
                    <table class="table table-striped table-hover table-sm">
                        <thead class="table-secondary">
                        <th>书名</th>
                        <th>作者</th>
                        <th>出版社</th>
                        <th>出版时间</th>
                        <th>单价</th>
                        <th>库存</th>
                        <th>销量</th>
                        <th>详情</th>
                        <th>修改</th>
                        <th>删除</th>
                        </thead>
                        <tbody>
                        <#list pageInfo_books.list as book>
                            <tr>
                            <td>《${book.bookName!""}》</td>
                            <td>${book.author!""}</td>
                            <td>${book.publisher!""}</td>
                            <td>${book.publishDate?string("yyyy-MM-dd")}</td>
                            <td><span style="color: red">￥${book.price?string("0.00")}</span></td>
                            <td><span class="text-primary">${book.numbers!"0"}</span></td>
                            <td><span class="text-info">${book.sales!"0"}</span></td>
                            <td><a href="/adminBookInfo?bookId=${book.bookId}">详情</a></td>
                            <td><a href="/toUpdateBook?bookId=${book.bookId}">修改</a></td>
                            <td><a id="deleteBook" href="/deleteBookByBookId?bookId=${book.bookId}">删除</a></td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

                <nav aria-label="...">
                    <ul class="pagination">
                        <li class="page-item disabled">
                            <a href="#" class="page-link">第${pageInfo_books.pageNum!"0"}/${pageInfo_books.pages!"0"}页</a>
                        </li>
                        <li class="page-item ">
                            <a class="page-link" href="/toBookPage?book_pageNum=1">首页</a>
                        </li>
                        <li class="page-item ">
                            <a class="page-link" href="/toBookPage?book_pageNum=${pageInfo_books.prePage}">上一页</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="/toBookPage?book_pageNum=${pageInfo_books.nextPage}">下一页</a>
                        </li>
                        <li class="page-item ">
                            <a class="page-link" href="/toBookPage?book_pageNum=${pageInfo_books.pages}">尾页</a>
                        </li>
                        <li class="page-item">
                            <form class="form-inline"  action="/toBookPage" method="post">
                                &nbsp;&nbsp;共&nbsp;<strong class="text-muted">${pageInfo_books.pages}</strong>&nbsp;页
                                &nbsp;到第<input type="number" name="book_pageNum" class="form-control" min="1" value="${book_pageNum!"1"}" max="${pageInfo_books.pages}"/>页 &nbsp;
                                <button type="submit" class="btn btn-sm btn-primary">确定</button>
                            </form>
                        </li>
                    </ul>

                </nav>
            </div>

            <div id="Users" style="display: none">
                <h6>用户数据 &nbsp;&nbsp;共 <span class="badge badge-pill badge-secondary">${pageInfo_users.total!"0"}</span> 条记录</h6>

                <ul class="nav nav-pills">
                    <li class="nav-item active">
                        <a href="/adminFindAllUsers" class="btn btn-primary">全部用户</a>&nbsp;&nbsp;
                    </li>
                    <li class="nav-item">
                        <form class="form-inline" action="/adminFindUser" method="post">
                            <input type="search" name="nickname" class="form-control" value="${RequestParameters['bookName']?default("")}" placeholder="用户名"/>
                            <input type="search" name="cellphone" class="form-control" value="${RequestParameters['author']?default("")}" placeholder="手机号码"/>
                            <button type="submit" class="btn btn-primary">搜索</button>
                        </form>
                    </li>
                </ul>

                <div class="table-responsive">
                    <table class="table table-striped table-hover table-sm">
                        <thead class="table-secondary">
                            <th>用户名</th>
                            <th>手机号码</th>
                            <th>邮箱</th>
                            <th>性别</th>
                            <th>最近登录时间</th>
                            <th>详情</th>
                            <th>删除</th>
                        </thead>
                        <tbody>
                            <#list pageInfo_users.list as user>
                                <tr>
                                    <td>${user.nickname!""}</td>
                                    <td>${user.cellphone!""}</td>
                                    <td>${user.email!""}</td>
                                    <td>${user.gender!""}</td>
                                    <td>${user.loginTime?string("yyyy-MM-dd hh:mm:ss")}</td>
                                    <td><a href="/toUserInfoAdmin?userId=${user.userId!""}">详情</a></td>
                                    <td><a href="/deleteUser?userId=${user.userId!""}">删除</a></td>
                                </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>

                <nav aria-label="...">
                    <ul class="pagination">
                        <li class="page-item disabled">
                            <a href="#" class="page-link">第${pageInfo_users.pageNum!"0"}/${pageInfo_users.pages!"0"}页</a>
                        </li>
                        <li class="page-item ">
                            <a class="page-link" href="/toUserPage?user_pageNum=1">首页</a>
                        </li>
                        <li class="page-item ">
                            <a class="page-link" href="/toUserPage?user_pageNum=${pageInfo_users.prePage}">上一页</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="/toUserPage?user_pageNum=${pageInfo_users.nextPage}">下一页</a>
                        </li>
                        <li class="page-item ">
                            <a class="page-link" href="/toUserPage?user_pageNum=${pageInfo_users.pages}">尾页</a>
                        </li>
                        <li class="page-item">
                            <form class="form-inline"  action="/toUserPage" method="post">
                                &nbsp;&nbsp;共&nbsp;<strong class="text-muted">${pageInfo_users.pages}</strong>&nbsp;页
                                &nbsp;到第<input type="number" name="user_pageNum" class="form-control" min="1" value="${user_pageNum!"1"}" max="${pageInfo_users.pages}"/>页 &nbsp;
                                <button type="submit" class="btn btn-sm btn-primary">确定</button>
                            </form>
                        </li>
                    </ul>

                </nav>
            </div>
        </main>
    </div>

</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
<script src="/dashboard/dashboard.js"></script></body>
</html>
