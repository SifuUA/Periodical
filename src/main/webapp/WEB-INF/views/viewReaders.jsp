<%@include file="../templates/header.jspf" %>
<title>Readers</title>
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
