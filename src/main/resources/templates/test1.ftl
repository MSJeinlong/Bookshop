<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <title>跳转页面</title>
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script language="javascript">
        $(document).ready(function() {
            function jump(count) {
                window.setTimeout(function() {
                    count--;
                    if (count > 0) {
                        $("#num").text(count);
                        jump(count);
                    } else {
                        location.href = "toTest";
                    }
                }, 3000);
            }
            jump(5);
        });
    </script>
</head>
<body>
      <span style="color:red" mce_style="color:red">欢迎来到******！</span
      ><br />页面将在5秒后跳转...<br />还剩<span id="num">5</span>秒
</body>
</html>
</html>
