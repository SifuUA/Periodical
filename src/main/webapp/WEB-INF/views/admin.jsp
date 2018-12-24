<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <!--    автоматическая подстройка сайта под разные девайсы-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Main page</title>

    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
    <%--<link rel="stylesheet" href="main.css">--%>
</head>

<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" role="navigation">
        <%--<div class="container">--%>
        <a class="navbar-brand" href="#">Home</a>
        <button class="navbar-toggler border-0" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">
            &#9776;
        </button>
        <div class="collapse navbar-collapse" id="exCollapsingNavbar">
            <%--<ul class="nav navbar-nav">
                <li class="nav-item"><a href="#" class="nav-link">My subscriptions</a></li>
            </ul>--%>
            <ul class="nav navbar-nav flex-row justify-content-between ml-auto">
                <li class="nav-item order-2 order-md-1"><a href="#" class="nav-link" title="settings"><i
                        class="fa fa-cog fa-fw fa-lg"></i></a></li>
                <li class="navbar-brand">Hello ${sessionScope.name}</li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/servlet/logout"
                                        class="nav-link">Logout</a></li>
                <%--<li class="nav-item"><a href="registration.jsp" class="nav-link">Registration</a></li>--%>
            </ul>
        </div>
        <%--</div>--%>
    </nav>
</header>
<div class="container-fluid" style="margin-top: 100px">
    <div class="row">
        <div class="col-sm-6">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/servlet/admin/uploadForm" role="button">Add new edition</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/servlet/admin/uploadForm" role="button">View readers</a>
            <a class="btn btn-primary" href="#" role="button">View subscriptions</a>
            <a class="btn btn-primary" href="#" role="button">Accept payments</a>
        </div>
    </div>
</div>

<div class="container" style="margin-top: 100px">
    <div class="row">
        <c:forEach var="imgBase" items="${sessionScope.encodeImages}">
            <div class="col-lg-2 col-md-6 col-xs-6">
                <a href="#" class="d-block mb-4 h-100">
                    <img class="img-fluid img-thumbnail" src="data:image/jpeg;base64,${imgBase}" alt="">
                </a>
            </div>
        </c:forEach>
    </div>
</div>

<script language="javascript" type="text/javascript"><c:import url="../../bootstrap/js/jquery-3.3.1.min.js"/> </script>
<script language="javascript" type="text/javascript"><c:import url="../../bootstrap/js/bootstrap.min.js"/></script>
</body>
</html>
