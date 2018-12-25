<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <!--    автоматическая подстройка сайта под разные девайсы-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Registration</title>

    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
</head>
<body>

<%--<div class="container">
    <a href="${pageContext.request.contextPath}/servlet/admin" class="btn btn-info" role="button"
       style="margin-top: 20px; margin-left: 300px">Home</a>
</div>--%>
<div class="row">
    <%--1--%>
    <div class="container mt-3 col-sm-6">
        <h3>Upload edition</h3>
        <form action="${pageContext.request.contextPath}/servlet/admin/upload" method="post"
              enctype="multipart/form-data">
            <div class="form-group">
                <label class="col-md-7 control-label" for="editionName">Edition Name</label>
                <div class="col-md-7">
                    <input id="editionName" name="editionName" type="text" placeholder="Sport News"
                           class="form-control input-md"
                           required="">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-7 control-label" for="category">Edition Category</label>
                <div class="col-md-7">
                    <input id="category" name="category" type="text" placeholder="1-Sport; 2-Cooking; 3-Knitting; 4-Nature; 5-Since"
                           class="form-control input-md"
                           required="">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-7 control-label" for="price">Edition Price $$$</label>
                <div class="col-md-7">
                    <input id="price" name="price" type="text" placeholder="100"
                           class="form-control input-md"
                           required="">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-7 control-label" for="price">Short notation about magazine </label>
                <div class="col-md-7">
                    <input id="notation" name="notation" type="text" placeholder="Very interesting magazine ..."
                           class="form-control input-md"
                           required="">
                </div>
            </div>

            <div class="custom-file form-group col-md-7">
                <input type="file" class="custom-file-input" id="customFile" name="filename" required="">
                <label class="custom-file-label" for="customFile">Choose file</label>
            </div>
            <div class="mt-3">
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href="${pageContext.request.contextPath}/servlet/admin" class="btn btn-info" role="button"
                   style="margin-top: 20px; margin-left: 300px">Home</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
