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
            <ul class="nav navbar-nav">
                <li class="nav-item"><a href="#" class="nav-link">My subscriptions</a></li>
            </ul>
            <ul class="nav navbar-nav flex-row justify-content-between ml-auto">
                <li class="nav-item order-2 order-md-1"><a href="#" class="nav-link" title="settings"><i
                        class="fa fa-cog fa-fw fa-lg"></i></a></li>
                <li class="navbar-brand">Hello ${sessionScope.name}</li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/servlet/logout"
                                        class="nav-link">Logout</a></li>
            </ul>
        </div>
        <%--</div>--%>
    </nav>
    <div id="modalPassword" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3>Forgot password</h3>
                    <button type="button" class="close font-weight-light" data-dismiss="modal" aria-hidden="true">×
                    </button>
                </div>
                <div class="modal-body">
                    <p>Reset your password..</p>
                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                    <button class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="container" style="margin-top: 100px">
    <div class="row">
        <div class="col-lg-3 col-md-4 col-xs-6">
            <a href="#" class="d-block mb-4 h-100">
                <img class="img-fluid img-thumbnail" src="http://placehold.it/400x300" alt="">
            </a>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
            <a href="#" class="d-block mb-4 h-100">
                <img class="img-fluid img-thumbnail" src="http://placehold.it/400x300" alt="">
            </a>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
            <a href="#" class="d-block mb-4 h-100">
                <img class="img-fluid img-thumbnail" src="http://placehold.it/400x300" alt="">
            </a>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
            <a href="#" class="d-block mb-4 h-100">
                <img class="img-fluid img-thumbnail" src="http://placehold.it/400x300" alt="">
            </a>
        </div>
    </div>
    <div class="row">

        <div class="col-lg-3 col-md-4 col-xs-6">
            <a href="#" class="d-block mb-4 h-100">
                <img class="img-fluid img-thumbnail" src="http://placehold.it/400x300" alt="">
            </a>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
            <a href="#" class="d-block mb-4 h-100">
                <img class="img-fluid img-thumbnail" src="http://placehold.it/400x300" alt="">
            </a>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
            <a href="#" class="d-block mb-4 h-100">
                <img class="img-fluid img-thumbnail" src="http://placehold.it/400x300" alt="">
            </a>
        </div>
        <div class="col-lg-3 col-md-4 col-xs-6">
            <a href="#" class="d-block mb-4 h-100">
                <img class="img-fluid img-thumbnail" src="http://placehold.it/400x300" alt="">
            </a>
        </div>
    </div>
</div>

<hr>
<br/>
<div class="row text-center">
    <div class="col-lg-12">
        <ul class="pagination justify-content-center">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </div>
</div>
<br/>
<footer id="footer" class="card-footer">
    <div class="row" align="center">
        <div class="col-lg-12">
            <p>Copyright &copy; Company 2018</p>
        </div>
    </div>
</footer>

<script language="javascript" type="text/javascript"><c:import url="../../bootstrap/js/jquery-3.3.1.min.js"/> </script>
<script language="javascript" type="text/javascript"><c:import url="../../bootstrap/js/bootstrap.min.js"/></script>
</body>
</html>