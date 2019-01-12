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
    <title>MagazineDetails</title>

    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
</head>
<body>


<div class="row">
    <div class="col-sm-4">
        <c:forEach var="edition" items="${sessionScope.oneEdition}">
            <%--<div class="col-lg-3 col-md-6 col-xs-6">--%>
        <a href="#" class="d-block mb-4 h-100">
            <img class="img-fluid img-thumbnail" src="data:image/jpeg;base64,${edition.value}" alt="">
        </a>
            <%--</div>--%>
    </div>
    <div class="col-sm-8">
        <br/>
        <h3><fmt:message key="admin.edition.magazine"/>:  ${edition.key.editionName}</h3>
        <br/>
        <h4><fmt:message key="admin.edition.category"/>:  ${edition.key.notation}</h4>
        <br/>
        <h4><fmt:message key="admin.edition.price"/>:  ${edition.key.price} $ / 1 <fmt:message key="admin.edition.month"/></h4>

        <div class="container">
            <c:choose>
                <c:when test="${role eq 'READER'}">
                    <a href="${pageContext.request.contextPath}/servlet/subscribe" class="btn btn-dark" role="button"
                       style="margin: 20px; padding: 10px">Subscribe and register payment</a>
                </c:when>
                <c:when test="${role eq 'ADMIN'}">
                    <a href="${pageContext.request.contextPath}/servlet/admin/delete?iId=${edition.key.id}"
                       class="btn btn-dark" role="button"
                       style="margin: 20px; padding: 10px"><fmt:message key="admin.edition.delete"/> </a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/servlet/registration" class="btn btn-dark" role="button"
                       style="margin: 20px; padding: 10px"><fmt:message key="edition.info"/></a>
                </c:otherwise>
            </c:choose>

        </div>
        <div class="container">
            <a href="${pageContext.request.contextPath}/servlet/home" class="btn btn-dark" role="button"
               style="margin: 20px; padding: 10px"><fmt:message key="edition.moveback"/></a>
        </div>
    </div>
</div>

</c:forEach>

</div>
</body>
</html>
