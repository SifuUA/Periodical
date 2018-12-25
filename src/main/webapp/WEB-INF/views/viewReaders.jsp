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

<div class="container-fluid">
    <a href="${pageContext.request.contextPath}/servlet/admin" class="btn btn-dark" role="button"
       style="margin: 20px; padding: 10px">Back Home</a>
</div>


<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Phone number</th>
        <th>Email</th>
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
