<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>中国省市区地址三级联动jQuery插件|DEMO_jQuery之家-自由分享jQuery、html5、css3的插件库</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/css/htmleaf-demo.css">
	<link href="/css/main.css" rel="stylesheet">


    <script src="http://libs.useso.com/js/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
    <script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="/js/distpicker.data.js"></script>
    <script src="/js/distpicker.js"></script>
    <script src="/js/main.js"></script>
</head>
<body>
	<!--[if lt IE 8]>
	    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	  <![endif]-->
	<div class="htmleaf-container">
		<header class="htmleaf-header">
			<h1>中国省市区地址三级联动jQuery插件 <span>A simple jQuery plugin for picking provinces, cities and districts of China</span></h1>
			<div class="htmleaf-links">
				<a class="htmleaf-icon icon-htmleaf-home-outline" href="http://www.htmleaf.com/" title="jQuery之家" target="_blank"><span> jQuery之家</span></a>
				<a class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="http://www.htmleaf.com/jQuery/jquery-tools/201606023549.html" title="返回下载页" target="_blank"><span> 返回下载页</span></a>
			</div>
		</header>
		<div class="container">
			<h3>Basic</h3>

    <h5>HTML:</h5>
    <pre class="prettyprint">&lt;div data-toggle="distpicker"&gt;
  &lt;select&gt;&lt;/select&gt;
  &lt;select&gt;&lt;/select&gt;
  &lt;select&gt;&lt;/select&gt;
&lt;/div&gt;</pre>

    <h5>Demo:</h5>
    <form class="form-inline">
      <div data-toggle="distpicker">
        <div class="form-group">
          <label class="sr-only" for="province1">Province</label>
          <select class="form-control" id="province1"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="city1">City</label>
          <select class="form-control" id="city1"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="district1">District</label>
          <select class="form-control" id="district1"></select>
        </div>
      </div>
    </form>

    <h3>Custom placeholders</h3>
    <h5>HTML:</h5>
    <pre class="prettyprint">&lt;div data-toggle="distpicker"&gt;
  &lt;select data-province=&quot;---- 选择省 ----&quot;&gt;&lt;/select&gt;
  &lt;select data-city=&quot;---- 选择市 ----&quot;&gt;&lt;/select&gt;
  &lt;select data-district=&quot;---- 选择区 ----&quot;&gt;&lt;/select&gt;
&lt;/div&gt;</pre>

    <h5>Demo:</h5>
    <form class="form-inline">
      <div data-toggle="distpicker">
        <div class="form-group">
          <label class="sr-only" for="province2">Province</label>
          <select class="form-control" id="province2" data-province="---- 选择省 ----"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="city2">City</label>
          <select class="form-control" id="city2" data-city="---- 选择市 ----"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="district2">District</label>
          <select class="form-control" id="district2" data-district="---- 选择区 ----"></select>
        </div>
      </div>
    </form>

    <h3>Custom districts</h3>
    <h5>HTML:</h5>
    <pre class="prettyprint">&lt;div data-toggle="distpicker"&gt;
  &lt;select data-province=&quot;浙江省&quot;&gt;&lt;/select&gt;
  &lt;select data-city=&quot;杭州市&quot;&gt;&lt;/select&gt;
  &lt;select data-district=&quot;西湖区&quot;&gt;&lt;/select&gt;
&lt;/div&gt;</pre>

    <h5>Demo:</h5>
    <form class="form-inline">
      <div data-toggle="distpicker">
        <div class="form-group">
          <label class="sr-only" for="province3">Province</label>
          <select class="form-control" id="province3" data-province="广东省"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="city3">City</label>
          <select class="form-control" id="city3" data-city="广州市"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="district3">District</label>
          <select class="form-control" id="district3" data-district="番禺区"></select>
        </div>
      </div>
    </form>
    <br>
    <p class="alert alert-warning"><i class="glyphicon glyphicon-exclamation-sign"></i> The districts must be existed in the <strong class="text-primary">distpicker.data.js</strong> file!</p>

    <h2 class="page-header">Initialize with <code>$.fn.distpicker</code> method</h2>

    <h3>Basic</h3>

    <h5>HTML:</h5>
    <pre class="prettyprint">&lt;div id="distpicker1"&gt;
  &lt;select&gt;&lt;/select&gt;
  &lt;select&gt;&lt;/select&gt;
  &lt;select&gt;&lt;/select&gt;
&lt;/div&gt;</pre>

    <h5>JavaScript:</h5>
    <pre class="prettyprint">$(&quot;#distpicker1&quot;).distpicker();</pre>

    <h5>Demo:</h5>
    <form class="form-inline">
      <div id="distpicker1">
        <div class="form-group">
          <label class="sr-only" for="province4">Province</label>
          <select class="form-control" id="province4"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="city4">City</label>
          <select class="form-control" id="city4"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="district4">District</label>
          <select class="form-control" id="district4"></select>
        </div>
      </div>
    </form>

    <h3>Custom placeholders</h3>

    <h5>HTML:</h5>
    <pre class="prettyprint">&lt;div id="distpicker2"&gt;
  &lt;select&gt;&lt;/select&gt;
  &lt;select&gt;&lt;/select&gt;
  &lt;select&gt;&lt;/select&gt;
&lt;/div&gt;</pre>

    <h5>JavaScript:</h5>
    <pre class="prettyprint">$(&quot;#distpicker2&quot;).distpicker({
  province: &quot;---- 所在省 ----&quot;,
  city: &quot;---- 所在市 ----&quot;,
  district: &quot;---- 所在区 ----&quot;
});</pre>

    <h5>Demo:</h5>
    <form class="form-inline">
      <div id="distpicker2">
        <div class="form-group">
          <label class="sr-only" for="province5">Province</label>
          <select class="form-control" id="province5"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="city5">City</label>
          <select class="form-control" id="city5"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="district5">District</label>
          <select class="form-control" id="district5"></select>
        </div>
      </div>
    </form>

    <h3>Custom districts</h3>

    <h5>HTML:</h5>
    <pre class="prettyprint">&lt;div id="distpicker3"&gt;
  &lt;select&gt;&lt;/select&gt;
  &lt;select&gt;&lt;/select&gt;
  &lt;select&gt;&lt;/select&gt;
&lt;/div&gt;</pre>

    <h5>JavaScript:</h5>
    <pre class="prettyprint">$(&quot;#distpicker3&quot;).distpicker({
  province: &quot;浙江省&quot;,
  city: &quot;杭州市&quot;,
  district: &quot;西湖区&quot;
});</pre>

    <h5>Demo:</h5>
    <form class="form-inline">
      <div id="distpicker3">
        <div class="form-group">
          <label class="sr-only" for="province6">Province</label>
          <select class="form-control" id="province6"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="city6">City</label>
          <select class="form-control" id="city6"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="district6">District</label>
          <select class="form-control" id="district6"></select>
        </div>
      </div>
    </form>
    <br>
    <p class="alert alert-warning"><i class="glyphicon glyphicon-exclamation-sign"></i> The districts must be existed in the <strong class="text-primary">distpicker.data.js</strong> file!</p>

    <h2 class="page-header">Methods</h2>
    <div class="docs-methods">
      <form class="form-inline">
        <div id="distpicker">
          <div class="form-group">
            <label class="sr-only" for="province">Province</label>
            <select class="form-control" id="province"></select>
          </div>
          <div class="form-group">
            <label class="sr-only" for="city">City</label>
            <select class="form-control" id="city"></select>
          </div>
          <div class="form-group">
            <label class="sr-only" for="district">District</label>
            <select class="form-control" id="district"></select>
          </div>
          <div class="form-group">
            <button class="btn btn-primary" id="reset" type="button">Reset</button>
            <button class="btn btn-warning" id="reset-deep" type="button">Reset (deep)</button>
            <button class="btn btn-danger" id="destroy" type="button">Destroy</button>
          </div>
        </div>
      </form>
    </div>

    <h2 class="page-header">More examples</h2>

    <h3 class="page-header">Only province and city</h3>

    <h5>HTML:</h5>
    <pre class="prettyprint">&lt;div data-toggle="distpicker"&gt;
  &lt;select&gt;&lt;/select&gt;
  &lt;select&gt;&lt;/select&gt;
&lt;/div&gt;</pre>

    <h5>Demo:</h5>
    <form class="form-inline">
      <div data-toggle="distpicker">
        <div class="form-group">
          <label class="sr-only" for="province7">Province</label>
          <select class="form-control" id="province7"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="city7">City</label>
          <select class="form-control" id="city7"></select>
        </div>
      </div>
    </form>

    <h3 class="page-header">Only province</h3>

    <h5>HTML:</h5>
    <pre class="prettyprint">&lt;div data-toggle="distpicker"&gt;
  &lt;select&gt;&lt;/select&gt;
&lt;/div&gt;</pre>

    <h5>Demo:</h5>
    <form class="form-inline">
      <div data-toggle="distpicker">
        <div class="form-group">
          <label class="sr-only" for="province8">Province</label>
          <select class="form-control" id="province8"></select>
        </div>
      </div>
    </form>

    <h3 class="page-header">Without placeholders</h3>

    <h5>JavaScript:</h5>
    <pre class="prettyprint">$(&quot;#distpicker4&quot;).distpicker({
  placeholder: false
});</pre>

    <h5>Demo:</h5>
    <form class="form-inline">
      <div id="distpicker4">
        <div class="form-group">
          <label class="sr-only" for="province9">Province</label>
          <select class="form-control" id="province9"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="city9">City</label>
          <select class="form-control" id="city9"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="district9">District</label>
          <select class="form-control" id="district9"></select>
        </div>
      </div>
    </form>

    <h3 class="page-header">Without automatic selection</h3>

    <h5>JavaScript:</h5>
    <pre class="prettyprint">$(&quot;#distpicker5&quot;).distpicker({
  autoSelect: false
});</pre>

    <h5>Demo:</h5>
    <form class="form-inline">
      <div id="distpicker5">
        <div class="form-group">
          <label class="sr-only" for="province10">Province</label>
          <select class="form-control" id="province10"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="city10">City</label>
          <select class="form-control" id="city10"></select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="district10">District</label>
          <select class="form-control" id="district10"></select>
        </div>
      </div>
    </form>
		</div>
		<div class="related">
		    <h3>如果你喜欢这个插件，那么你可能也喜欢:</h3>
		    <a href="http://www.htmleaf.com/jQuery/jquery-tools/feature-js.html">
			  <img src="/related/1.jpg" width="300" alt="Feature.js-轻量级浏览器特性检测JavaScript库插件"/>
			  <h3>Feature.js-轻量级浏览器特性检测JavaScript库插件</h3>
			</a>
			<a href="http://www.htmleaf.com/jQuery/jquery-tools/201601283082.html">
			  <img src="/related/2.jpg" width="300" alt="实现HTML编码和解码的JavaScript工具类"/>
			  <h3>实现HTML编码和解码的JavaScript工具类</h3>
			</a>
		</div>
	</div>
	

</body>
</html>