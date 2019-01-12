<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>


<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>
<!DOCTYPE html>
<html lang="${sessionScope.lang}">
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
        <a class="navbar-brand" href="${pageContext.request.contextPath}/servlet/reader"><fmt:message key="reader.main"/> </a>
        <button class="navbar-toggler border-0" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">
            &#9776;
        </button>
        <div class="collapse navbar-collapse" id="exCollapsingNavbar">
            <ul class="nav navbar-nav">
                <div class="dropdown">
                    <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <fmt:message key="reader.categories"/>
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <c:forEach var="categ" items="${applicationScope.editionCategories}">
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/servlet/reader?catId=${categ.categoryId}">${categ.category}
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </ul>
            <ul class="nav navbar-nav">
                <li class="nav-item"><a href="${pageContext.request.contextPath}/servlet/readerSubscription" class="nav-link"><fmt:message key="reader.subscriptions"/></a></li>
            </ul>

            <ul class="nav navbar-nav flex-row justify-content-between ml-auto">
                <li class="nav-item order-2 order-md-1"><a href="#" class="nav-link" title="settings"><i
                        class="fa fa-cog fa-fw fa-lg"></i></a></li>
                <li class="navbar-brand"><fmt:message key="reader.hello"/> ${sessionScope.name}</li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/servlet/logout"
                                        class="nav-link"><fmt:message key="reader.logout"/></a></li>
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
        <%--<c:forEach var="imgBase" items="${requestScope.encodeImages}">--%>
        <c:forEach var="imgBase" items="${sessionScope.encodeImages}">
            <div class="col-lg-2 col-md-6 col-xs-6">
                <a href="${pageContext.request.contextPath}/servlet/reader/${imgBase.key.id}" class="d-block mb-4 h-100">
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
            <td><a class="page-link" href="${pageContext.request.contextPath}/servlet/reader?page=${sessionScope.currentPage - 1}">Previous</a></td>
        </c:if>
        <c:forEach begin="1" end="${sessionScope.numberOfPages}" var="i">
            <c:choose>
                <c:when test="${sessionScope.currentPage eq i}">
                    <td> <a class="page-link">${i}</a> </td>
                </c:when>
                <c:otherwise>
                    <td><a class="page-link" href="${pageContext.request.contextPath}/servlet/reader?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${sessionScope.currentPage lt sessionScope.numberOfPages}">
            <td><a class="page-link" href="${pageContext.request.contextPath}/servlet/reader?page=${sessionScope.currentPage + 1}">Next</a></td>
        </c:if>
    </tr>
</table>
<br/>
<footer id="footer" class="card-footer">
    <div class="row" align="center">
        <div class="col-lg-12">
            <p><fmt:message key="main.footer.copyright"/> &copy; <fmt:message key="main.footer.company"/> 2019</p>
        </div>
    </div>
</footer>

<script language="javascript" type="text/javascript"><c:import url="../../bootstrap/js/jquery-3.3.1.min.js"/> </script>
<script language="javascript" type="text/javascript"><c:import url="../../bootstrap/js/bootstrap.min.js"/></script>
</body>
</html>
