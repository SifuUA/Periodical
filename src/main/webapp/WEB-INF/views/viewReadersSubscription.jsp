<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <!--    автоматическая подстройка сайта под разные девайсы-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Payments</title>

    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
</head>
<body>

<div class="container-fluid">
    <a href="${pageContext.request.contextPath}/servlet/reader" class="btn btn-dark" role="button"
       style="margin: 20px; padding: 10px">Back Home</a>
</div>


<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Phone number</th>
        <th>Magazine name</th>
        <th>Price</th>
        <th>Confirmation</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="readerPayments" items="${sessionScope.readerPayments}">
        <tr>
            <c:forEach var="redpay" items="${readerPayments.value}">
                <td>${redpay}</td>
            </c:forEach>
        </tr>

    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
