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
    <title>Registration</title>

    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
</head>
<body>

<div class="container-fluid">
    <a href="${pageContext.request.contextPath}/servlet/admin" class="btn btn-dark" role="button"
       style="margin: 20px; padding: 10px"><fmt:message key="edition.moveback"/></a>
</div>


<table class="table">
    <thead class="thead-dark">
    <tr>
        <th><fmt:message key="admin.viewreaders.firstname"/></th>
        <th><fmt:message key="admin.viewreaders.lastname"/></th>
        <th><fmt:message key="admin.viewreaders.phone"/></th>
        <th><fmt:message key="admin.viewreaders.email"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="reader" items="${sessionScope.readerList}">
        <tr>
            <td>${reader.firstName}</td>
            <td>${reader.lastName}</td>
            <td>${reader.phoneNumber}</td>
            <td>${reader.emailAddress}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</div>
</body>
</html>
