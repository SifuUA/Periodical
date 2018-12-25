<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
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
        <h3>Magazine: ${edition.key.editionName}</h3>
        <h4>Category: ${edition.key.notation}</h4>
        <h4>Price: ${edition.key.price} $ / 1 month</h4>

        <div class="container">
            <a href="${pageContext.request.contextPath}/servlet/subscribe" class="btn btn-dark" role="button"
               style="margin: 20px; padding: 10px">Subscribe</a>
        </div>

        <div class="container">
            <a href="${pageContext.request.contextPath}/servlet/home" class="btn btn-dark" role="button"
               style="margin: 20px; padding: 10px">Move back</a>
        </div>
    </div>
</div>

</c:forEach>

</div>
</body>
</html>