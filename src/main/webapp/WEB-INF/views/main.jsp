<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
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
        <a class="navbar-brand" href="${pageContext.request.contextPath}/servlet/home">Home</a>
        <button class="navbar-toggler border-0" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">
            &#9776;
        </button>
        <div class="collapse navbar-collapse" id="exCollapsingNavbar">
            <ul class="nav navbar-nav">
                <div class="dropdown">
                    <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Categories
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <c:forEach var="categ" items="${applicationScope.editionCategories}">
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/servlet/home/${categ.category}">${categ.category}
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </ul>
            <ul class="nav navbar-nav flex-row justify-content-between ml-auto">
                <li class="nav-item order-2 order-md-1"><a href="#" class="nav-link" title="settings"><i
                        class="fa fa-cog fa-fw fa-lg"></i></a></li>
                <li class="dropdown order-1">
                    <button type="button" id="dropdownMenu1" data-toggle="dropdown"
                            class="btn btn-outline-secondary dropdown-toggle">Login <span class="caret"></span></button>
                    <ul class="dropdown-menu dropdown-menu-right mt-2">
                        <li class="px-3 py-2">
                            <form class="form" role="form" action="${pageContext.request.contextPath}/servlet/login"
                                  method=get>
                                <div class="form-group">
                                    <input id="emailInput" placeholder="Email" class="form-control form-control-sm"
                                           type="text" required="" name="email">
                                </div>
                                <div class="form-group">
                                    <input id="passwordInput" placeholder="Password"
                                           class="form-control form-control-sm" type="text" required="" name="password">
                                </div>
                                <div class="form-group">
                                    <button type="submit" value="Login" class="btn btn-success" id="login"
                                            name="loginButton">Login
                                    </button>
                                </div>
                            </form>
                        </li>
                    </ul>
                </li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/servlet/registration" class="nav-link">Registration</a>
                </li>
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
       <%-- <c:forEach var="imgBase" items="${applicationScope.encodeImages}">
            <div class="col-lg-2 col-md-6 col-xs-6">
                <a href="#" class="d-block mb-4 h-100">
                    <img class="img-fluid img-thumbnail" src="data:image/jpeg;base64,${imgBase}" alt="">
                </a>
            </div>
        </c:forEach>--%>
            <c:forEach var="imgBase" items="${sessionScope.encodeImages}">
                <div class="col-lg-2 col-md-6 col-xs-6">
                    <a href="${pageContext.request.contextPath}/servlet/home/${imgBase.key.id}" class="d-block mb-4 h-100">
                        <img class="img-fluid img-thumbnail" src="data:image/jpeg;base64,${imgBase.value}" alt="">
                        <h6>${imgBase.key.editionName}</h6>
                        <%--<h6>${imgBase.key.id}</h6>--%>
                    </a>
                </div>
            </c:forEach>
    </div>
</div>

<hr>
<br/>

<table <%--border="1" cellpadding="5" cellspacing="5"--%> align="center">
    <tr>
        <c:if test="${sessionScope.currentPage != 1}">
            <td><a class="page-link" href="${pageContext.request.contextPath}/servlet/home?page=${sessionScope.currentPage - 1}">Previous</a></td>
        </c:if>
        <c:forEach begin="1" end="${sessionScope.numberOfPages}" var="i">
            <c:choose>
                <c:when test="${sessionScope.currentPage eq i}">
                    <td> <a class="page-link">${i}</a> </td>
                </c:when>
                <c:otherwise>
                    <td><a class="page-link" href="${pageContext.request.contextPath}/servlet/home?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${sessionScope.currentPage lt sessionScope.numberOfPages}">
            <td><a class="page-link" href="${pageContext.request.contextPath}/servlet/home?page=${sessionScope.currentPage + 1}">Next</a></td>
        </c:if>
    </tr>
</table>
<br/>

<footer id="footer" class="card-footer">
    <div class="row" align="center">
        <div class="col-lg-12">
            <p>Copyright &copy; Company 2018</p>
        </div>
    </div>
</footer>

<script language="javascript" type="text/javascript"><c:import url="../../bootstrap/js/jquery-3.3.1.min.js"/></script>
<script language="javascript" type="text/javascript"><c:import url="../../bootstrap/js/bootstrap.min.js"/></script>
</body>
</html>
