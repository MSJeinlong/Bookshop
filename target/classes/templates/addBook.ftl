<!DOCTYPE html>
<html lang="zh">
<head>
    <link rel="stylesheet" href="/bootstrap-4.3.1/css/bootstrap.min.css" />
    <script src="/jQuery-3.4.1/jquery-3.4.1.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.bundle.min.js"></script>
    <script src="/bootstrap-4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="card offset-md-3 col-md-6">
            <div class="card-header">
                <h5>添加图书</h5>
            </div>
            <div class="card-body">
                <form action="/addNewBook" method="post">
                    <div class="form-group row">
                        <label class="col-form-label col-sm-3">图书名称</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="bookName" value="${RequestParameters['bookName']?default("")}" required placeholder="书名"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-form-label col-sm-3">作者</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="author" value="${RequestParameters['author']?default("")}" required placeholder="作者"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-form-label col-sm-3">译者</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="translator" value="${RequestParameters['translator']?default("")}" placeholder="译者"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-form-label col-sm-3">ISBN</label>
                        <div class="col-sm-9">
                            <input type="number" class="form-control" name="ISBN" value="${RequestParameters['ISBN']?default("")}" required placeholder="ISBN"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-form-label col-sm-3">出版社</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="publisher" value="${RequestParameters['publisher']?default("")}" required placeholder="出版社"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-form-label col-sm-3">出版时间</label>
                        <div class="col-sm-9">
                            <input type="date" class="form-control" name="publishDate" value="${(RequestParameters['publishDate']?default(""))}" required placeholder="出版时间"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-form-label col-sm-3">单价</label>
                        <div class="col-sm-9">
                            <input type="number" min="0.01" step="0.01" class="form-control" name="price" value="${RequestParameters['price']?default("")}" required placeholder="单价"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-form-label col-sm-3">库存数量</label>
                        <div class="col-sm-9">
                            <input type="number" min="1" class="form-control" name="numbers" value="${RequestParameters['numbers']?default("")}" required placeholder="库存数量"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-form-label col-sm-3">图书简述</label>
                        <div class="col-sm-9">
                            <textarea name="description" class="form-control" rows="5" placeholder="图书简述">
                                ${RequestParameters['description']?default("")}
                            </textarea>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-form-label col-sm-3" for="categoryId">图书类型</label>
                        <div class="col-sm-9">
                            <select class="form-control" name="categoryId">
                               <#list bookCategories as bc>
                                <option value="${bc.categoryId}"
                                <#if categoryId??>
                                    <#if categoryId == bc.categoryId>selected</#if>
                                </#if>
                                > ${bc.categoryAttr!""}&nbsp;&nbsp;${bc.categoryName!""}</option>
                               </#list>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-form-label col-sm-3">图片URL</label>
                        <div class="col-sm-9 input-group">
                            <input type="text" name="image" class="form-control" value="${RequestParameters['image']?default("")}" placeholder="图片URL" required/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-form-label col-sm-3">图书页数</label>
                        <div class="col-sm-9">
                            <input type="number" min="1" class="form-control" name="pages" value="${RequestParameters['pages']?default("")}" required placeholder="图书页数"/>
                        </div>
                    </div>

                    <div class="form-group row form-inline">
                        <label class="col-form-label col-sm-3">是否为电子书</label>
                        <div class="col-sm-9">
                            <div class="custom-control custom-radio custom-control-inline">
                                <input type="radio" id="customRadioInline1" name="isEbook" class="custom-control-input" value="1"/>
                                <label class="custom-control-label" for="customRadioInline1">是</label>
                            </div>
                            <div class="custom-control custom-radio custom-control-inline">
                                <input type="radio" id="customRadioInline2" name="isEbook" class="custom-control-input" value="0" checked/>
                                <label class="custom-control-label" for="customRadioInline2">否</label>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="offset-md-3 col-md-3">
                            <button class="btn btn-primary btn-block" type="submit">提交</button>
                        </div>
                        <div class="col-md-3">
                            <button class="btn btn-warning btn-block" type="reset">重置</button>
                        </div>
                        <div class="col-md-3">
                            <a href="/toAdminManage" class="btn btn-outline-success btn-block">返回</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>