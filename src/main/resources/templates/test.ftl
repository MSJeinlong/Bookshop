<html>
<head>
    <title>Bootstrap 实例</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css">
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/util.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $("#toBk").click(function () {
                alert("click");
                return false;
            });
        });
    </script>
</head>
<body>

<div class="container">

    <nav class="navbar navbar-expand-sm bg-light navbar-light fixed-bottom">
        <form class="form-inline">
            <#--<label class="sr-only" for="inlineFormInputName2">Name</label>
            <input type="text" class="form-control mb-2 mr-sm-2" id="inlineFormInputName2" placeholder="Jane Doe">
-->
            <div class="row">
                <div class="input-group mb-2 mr-sm-2 col-md-6">
                    <div class="input-group-prepend">
                        <div class="input-group-text">总计(包括邮费)：</div>
                    </div>
                    <input type="text" class="form-control" readonly id="inlineFormInputGroupUsername2" style="color: red" value="￥20.00">
                </div>
                <button type="submit" class="btn btn-danger mb-2">结算</button>
            </div>


           <#-- <div class="form-check mb-2 mr-sm-2">
                <input class="form-check-input" type="checkbox" id="inlineFormCheck">
                <label class="form-check-label" for="inlineFormCheck">
                    Remember me
                </label>
            </div>-->


        </form>
    </nav>



    <h3>提示框实例</h3><br>
    <a href="/toBookshop" id="toBk" data-toggle="tooltip" title="我是提示内容!">鼠标移动到我这</a>
    <div style="position: absolute; top: 0; right: 0;">

        <!-- Then put toasts within -->
        <div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <img src="..." class="rounded mr-2" alt="...">
                <strong class="mr-auto">Bootstrap</strong>
                <small class="text-muted">just now</small>
                <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="toast-body">
                See? Just like this.
            </div>
        </div>
</div>
</div>
<script>
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>
</body>
</html>