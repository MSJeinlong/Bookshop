<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>网上书店系统</title>
    <!-- <link
      rel="stylesheet"
      href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css"
    />
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script> -->
    
      <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css" />
      <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
      <script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
      <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
    <style type="text/css">
      #classOfBook {
        margin-top: 60px;
      }
    </style>
    <script>
        $(document).ready(function () {
            // $('[data-toggle="tooltip"]').tooltip();
            // var user = session.getAttribute("bsUser");
            // console.log(user);
            // console.log("hello");
            // if(user != null)
            //     alert(user.cellphone);
            // else
            //     alert("user：null");
        });
    </script>
  </head>
  <body>
    <div class="container-fluid">
      <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
        <a class="navbar-brand" href="#"></span>BOOKSHOP</a>
        <span class="navbar-text"
          >欢迎光临网上书店，请<a href="/toUserLogin" class="text-primary" data-toggle="tooltip" title="点击可进行登录或者注册!">登录</a
          >成为会员</span
        >
        <ul class="navbar-nav">
          <li class="nav-item active">
            <a class="nav-link" href="#"
            ><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>购物车<span class="badge badge-light">0</span></a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#"
              ><span class="glyphicon glyphicon-list" aria-hidden="true"></span>我的订单<span class="badge badge-light">0</span></a
            >
          </li>
        </ul>
        <form action="#" class="form-inline" method="post">
          <input class="form-control rounded-pill" type="search" placeholder="输入搜索内容" />
          <button class="btn btn-success" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
        </form>
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" href="#">高级搜索</a>
          </li>
        </ul>

        <ul class="navbar-nav nav-right">
            <li class="nav-item">
                <a class="nav-link" href="/toUserInfo"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                    我的账号<#if bsUser??>:${bsUser.cellphone!""}</#if>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/userExit"><span class="glyphicon glyphicon-off
" aria-hidden="true"></span>退出</a>
            </li>
        </ul>
      </nav>

      <div class="row" id="classOfBook">
          <div class="col-lg-2">
              <div class="card mb-4 shadow-sm" id="newbook">
                  <div class="card-header">
                      <h4 class="my-0 font-weight-normal">新书上架</h4>
                  </div>
                  <div class="card-body">
<#--                      <h4 class="card-title">新书上架</h4>-->
                      <table class="table table-light table-borderless table-hover table-responsive">
                          <thead class="thead-light">
                          <tr>
                              <th scope="col">#</th>
                              <th scope="col">书名</th>
                          </tr>
                          </thead>
                          <tbody>
                          <tr>
                              <th scope="row">1</th>
                              <td><a href="#">《数学》</a></td>
                          </tr>
                          <tr>
                              <th scope="row">2</th>
                              <td><a href="#">《数学》</a></td>
                          </tr>
                          <tr>
                              <th scope="row">3</th>
                              <td><a href="#">《数学》</a></td>
                          </tr>
                          <tr>
                              <th scope="row">4</th>
                              <td><a href="#">《数学》</a></td>
                          </tr>
                          </tbody>
                      </table>
                  </div>
              </div>
          </div>
          <div class="col-lg-7">
          <div id="demo" class="carousel slide" data-ride="carousel">
            <!-- 指示符 -->
            <ul class="carousel-indicators">
              <li data-target="#demo" data-slide-to="0" class="active"></li>
              <li data-target="#demo" data-slide-to="1"></li>
              <li data-target="#demo" data-slide-to="2"></li>
            </ul>

            <!-- 轮播图片 -->
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img
                  src="https://static.runoob.com/images/mix/img_fjords_wide.jpg"
                />
                <!-- 轮播图片说明 -->
                <div class="carousel-caption">
                  <h5>First slide label</h5>
                  <p>
                    Nulla vitae elit libero, a pharetra augue mollis interdum.
                  </p>
                </div>
              </div>
              <div class="carousel-item">
                <img
                  src="https://static.runoob.com/images/mix/img_nature_wide.jpg"
                />
                <!-- 轮播图片说明 -->
                <div class="carousel-caption">
                  <h5>Second slide label</h5>
                  <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  </p>
                </div>
              </div>
              <div class="carousel-item">
                <img
                  src="https://static.runoob.com/images/mix/img_mountains_wide.jpg"
                />
                <div class="carousel-caption">
                  <h5>Third slide label</h5>
                  <p>
                    Praesent commodo cursus magna, vel scelerisque nisl
                    consectetur.
                  </p>
                </div>
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
                            Et et consectetur ipsum labore excepteur est proident excepteur ad
                            velit occaecat qui minim occaecat veniam. Fugiat veniam incididunt
                            anim aliqua enim pariatur veniam sunt est aute sit dolor anim.
                            Velit non irure adipisicing aliqua ullamco irure incididunt irure
                            non esse consectetur nostrud minim non minim occaecat.
                        </div>
                        <div
                                class="tab-pane fade"
                                id="contact"
                                role="tabpanel"
                                aria-labelledby="contact-tab"
                        >
                            Sint sit mollit irure quis est nostrud cillum consequat Lorem esse
                            do quis dolor esse fugiat sunt do. Eu ex commodo veniam Lorem
                            aliquip laborum occaecat qui Lorem esse mollit dolore anim
                            cupidatat. Deserunt officia id Lorem nostrud aute id commodo elit
                            eiusmod enim irure amet eiusmod qui reprehenderit nostrud tempor.
                        </div>
                    </div>
                </div>
            </div>
        </div>
      </div>

    <br/>

        <div class="nav-scroller bg-white shadow-sm">
            <nav class="nav nav-underline text-dark">
                <a class="nav-link active" href="#">Dashboard</a>
                <a class="nav-link" href="#">
                    Friends
                    <span class="badge badge-pill bg-light align-text-bottom">27</span>
                </a>
                <a class="nav-link" href="#">Explore</a>
                <a class="nav-link" href="#">Suggestions</a>
                <a class="nav-link" href="#">Link</a>
                <a class="nav-link" href="#">Link</a>
                <a class="nav-link" href="#">Link</a>
                <a class="nav-link" href="#">Link</a>
                <a class="nav-link" href="#">Link</a>
            </nav>
        </div>

        <br/>
    <div class="row">
        <div class="col-md-3">
            <div class="card mb-4 shadow-sm">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Pro</h4>
                </div>
                <div class="card-body">
                    <h1 class="card-title pricing-card-title">$15 <small class="text-muted">/ mo</small></h1>
                    <ul class="list-unstyled mt-3 mb-4">
                        <li>20 users included</li>
                        <li>10 GB of storage</li>
                        <li>Priority email support</li>
                        <li>Help center access</li>
                    </ul>
                    <button type="button" class="btn btn-lg btn-block btn-primary">加入购物车</button>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card mb-4 shadow-sm">
<#--                <div class="card-header">-->
<#--                    <h4 class="my-0 font-weight-normal">Enterprise</h4>-->
<#--                </div>-->
                <img class="card-img-top" src="https://static.runoob.com/images/mix/img_avatar.png" alt="Card image"
                     style="width:100%">
                <div class="card-body">
                    <h4 class="card-title">John Doe</h4>
<#--                    <h4 class="card-title">John Doe</h4>-->
                    <p class="card-text">Some example text some example text. John Doe is an architect and engineer</p>
                    <h4 class="card-title pricing-card-title">$29 <small class="text-muted">/ mo</small></h4>
                    <a href="#" class="btn btn-primary btn-block btn-clock">加入购物车</a>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card" style="height:150px;">
                <img class="card-img-top" src="https://static.runoob.com/images/mix/img_avatar.png" alt="Card image"
                    style="width:100%">
                <div class="card-body">
                    <h4 class="card-title">John Doe</h4>
                    <p class="card-text">Some example text some example text. John Doe is an architect and engineer</p>
                    <a href="#" class="btn btn-primary">See Profile</a>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card" style="height:150px;">
                <img class="card-img-top" src="https://static.runoob.com/images/mix/img_avatar.png" alt="Card image"
                    style="width:100%">
                <div class="card-body">
                    <h4 class="card-title">John Doe</h4>
                    <p class="card-text">Some example text some example text. John Doe is an architect and engineer</p>
                    <a href="#" class="btn btn-primary">See Profile</a>
                </div>
            </div>
        </div>
    </div>
      </div>
    </div>
  </body>
</html>
