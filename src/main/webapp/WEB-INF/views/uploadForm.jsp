<%@include file="../templates/header.jspf" %>
<title>Upload</title>
</head>
<body>

<div class="row">
    <%--1--%>
    <div class="container mt-3 col-sm-6">
        <h3><fmt:message key="admin.upload"/></h3>
        <form action="${pageContext.request.contextPath}/servlet/admin/upload" method="post"
              enctype="multipart/form-data">
            <div class="form-group">
                <label class="col-md-7 control-label" for="editionName"><fmt:message key="admin.editionname"/></label>
                <div class="col-md-7">
                    <input id="editionName" name="editionName" type="text" placeholder=
                    <fmt:message key="admin.editionname.hint"/>
                            class="form-control input-md"
                    required="">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-7 control-label" for="category"><fmt:message key="admin.editioncategory"/></label>
                <div class="col-md-7">
                    <input id="category" name="category" type="text" placeholder=
                    <fmt:message key="admin.editioncategory.hint"/>
                            class="form-control input-md"
                    required="">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-7 control-label" for="price"><fmt:message key="admin.editionprice"/></label>
                <div class="col-md-7">
                    <input id="price" name="price" type="text" placeholder="100"
                           class="form-control input-md"
                           required="">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-7 control-label" for="price"><fmt:message key="admin.editionnotation"/></label>
                <div class="col-md-7">
                    <input id="notation" name="notation" type="text" placeholder=
                    <fmt:message key="admin.editionnotation.hint"/>
                            class="form-control input-md"
                    required="">
                </div>
            </div>

            <div class="custom-file form-group col-md-7">
                <input type="file" class="custom-file-input" id="customFile" name="filename" required="">
                <label class="custom-file-label" for="customFile"><fmt:message key="admin.editionimage"/></label>
            </div>
            <div class="mt-3">
                <button type="submit" class="btn btn-primary"><fmt:message key="admin.upload.submit"/></button>
                <a href="${pageContext.request.contextPath}/servlet/admin" class="btn btn-info" role="button"
                   style="margin-top: 20px; margin-left: 300px"><fmt:message key="admin.home"/></a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
