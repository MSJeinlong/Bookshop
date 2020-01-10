<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css" />
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
    <title>购物车</title>
    <style>
        .card{
            top:60px;
        }
    </style>
    <script>
        $(function () {
            $('[data-toggle="popover"]').popover();
            /*全选控制*/
            $("input[name='allCheck']").click(function () {
                $("input[type='checkbox']").prop("checked",this.checked);
                if(this.checked){
                    var prices = [];
                    var priceSum = 0.00;
                    $("span[class='priceSum']").each(function(){
                        prices.push($(this).text());
                    });
                    //alert("prices[0]="+parseFloat(prices[0]));
                    for (var i = 0; i < prices.length; i++) {
                        priceSum += Number(prices[i]);
                        //alert(sum+" ");
                    }
                    //alert("sum:"+sum);
                    $("span[class='allPriceSum']").text(priceSum.toFixed(2));
                } else {
                    priceSum = 0.00;
                    $("span[class='allPriceSum']").text(priceSum);
                }
            });

            //单个checkBox 控制
            $("input[name='subtotals']").click(function () {
                //var prices = [];
                var priceSum = 0.00;
                var allCheck = true;
                $("input[name='subtotals']").each(function () {
                    //alert("click");
                    if(this.checked){
                        var cartId = $(this).val();
                        //alert(cartId);
                        var subtotal = Number($("#subtotal"+cartId).text());
                        //subtotal = subtotal.toFixed(2);
                        //alert("subtotal="+subtotal);
                        priceSum += subtotal;
                        //alert("priceSum="+priceSum);
                    }
                    else{
                        $("input[name='allCheck']").prop("checked", this.checked);
                        allCheck = false;
                    }
                });
                if(allCheck)
                    $("input[name='allCheck']").prop("checked", true);
                $("span[class='allPriceSum']").text(priceSum.toFixed(2));
            });

            /*删除单个商品*/
            $("#delOne").click(function () {
                //alert("click");
               if(confirm("您确定删除该商品？")){
                   return true;
               } else
                   return false;
            });

            /*清空购物车*/
            $("#clearMyCart").click(function () {
                //alert("click");
                if(confirm("您确定清空购物车的所有商品？")){
                    return true;
                } else
                    return false;
            });

            /*删除选中的商品*/
            $("#delSelected").click(function () {
                /*获取选中的 商品的 cartIds*/
                var cartIds = "";
                $("input[name='subtotals']").each(function () {
                    if(this.checked){
                        cartIds += ($(this).val()+",");
                    }
                });
                if(cartIds == ""){
                    alert("请至少选中一件商品！")
                    return false;
                } else if(confirm("确定删除所选中的商品吗？")){
                   //用户点击了是
                    $(this).attr("href", "/deleteMyCart?cartIds="+cartIds);
                    return true;
                } else {
                    //用户取消删除
                    return false;
                }
            });

            /*用户点击了结算*/
            $("#settlement").click(function () {
                /*获取选中的 商品的 cartIds*/
                var cartIds = "";
                $("input[name='subtotals']").each(function () {
                    if(this.checked){
                        cartIds += ($(this).val()+",");
                    }
                });
                if(cartIds == ""){
                    alert("请至少选中一件商品！")
                    return false;
                } else {
                    cartIds = cartIds.substring(0, cartIds.length - 1);
                    $(this).attr("href", "/settlement?cartIds="+cartIds);
                    return true;
                }
            });
        });
    </script>
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="#">全部商品<span class="badge badge-pill badge-info">${cartCount!"0"}</span></a>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <form class="form-inline" action="/findMyCartByBookName" method="post">
                <div class="input-group">
                    <input type="search" class="form-control" name="bookName" value="${RequestParameters['bookName']?default("")}" placeholder="请输入商品名称" aria-label="Search" />
                    <div class="input-group-append">
                     <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
                    </div>
                </div>
            </form>
            &nbsp;&nbsp;
             <ul class="navbar-nav mr-auto">
               <li class="nav-item">
                   <a class="btn btn-primary" href="/toBookshop">返回</a>
               </li>
           </ul>
        </div>
    </nav>
    <div class="card ">

        <div class="card-body">

            <table class="table table-striped table-borderless table-hover">
                <caption></caption>
                <thead class="table-secondary">
                <tr>
                    <th>
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="allCheckTop" name="allCheck"/>
                            <label class="custom-control-label" for="allCheckTop">全选</label>
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
                <#list myCartList as myCart>
                    <tr>
                        <td>
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" name="subtotals" class="custom-control-input" id="customCheck${myCart.cartId!""}" value="${myCart.cartId!""}"/>
                                <label class="custom-control-label" for="customCheck${myCart.cartId!""}">选中</label>
                            </div>
                        </td>
                        <td>
                            <img src="${myCart.bookImage!"#"}" style="width: 40px;height: 50px;"/>
                        &nbsp;   《${myCart.bookName!""}》
                        </td>
                        <td><span style="color: red">￥${myCart.bookPrice?string("0.00")}</span></td>
                        <td>
                            <div class="form-group row">
                                <div class="col-sm-6">
                                    <input type="number" class="form-control" name="amount" min="1" max="10" value="${myCart.bookAmount!"1"}" maxlength="2" readonly/>
                                </div>
                            </div>
                        </td>
                        <td>
                            <span style="color: red">￥</span><span class="priceSum" id="subtotal${myCart.cartId!""}" style="color: red">${(myCart.bookPrice * myCart.bookAmount)?string("0.00")}</span>
                        </td>
                        <td>
                            <a href="/deleteMyCart?cartIds=${myCart.cartId!""}" class="btn btn-sm btn-danger" id="delOne">删除</a>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>

    <!-- 结算栏固定在底部 -->
    <nav class="navbar navbar-expand-sm bg-light navbar-light fixed-bottom">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="allCheckBottom" name="allCheck">
            <label class="custom-control-label" for="allCheckBottom">全选</label>
        </div>
        &nbsp;
        <span class="navbar-text">
            <a href="#" class="btn btn-warning" id="delSelected">删除选中的商品</a>
        </span>
        &nbsp;
        <span class="navbar-text">
            <a href="/clearMyCart" class="btn btn-outline-danger" id="clearMyCart">清空购物车</a>
        </span>
        &nbsp;   <ul class="navbar-nav mr-auto">
            </ul>
        <form>

        </form>
        <span class="navbar-text">
          总价(包括邮费)：
            &nbsp;<span style="color: red">￥</span><span class="allPriceSum" style="color: red">0.00</span>
          <a href="#" class="btn btn-danger text-white" id="settlement">结算</a>
        </span>
    </nav>
</div>
</body>
</html>
