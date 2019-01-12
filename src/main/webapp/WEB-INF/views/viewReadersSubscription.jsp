<%@include file="../templates/header.jspf" %>
<title>Payments</title>
</head>
<body>

<div class="container-fluid">
    <a href="${pageContext.request.contextPath}/servlet/reader" class="btn btn-dark" role="button"
       style="margin: 20px; padding: 10px"><fmt:message key="reader.subsc.back"/></a>
</div>


<table class="table">
    <thead class="thead-dark">
    <tr>
        <th><fmt:message key="reader.subsc.firstname"/></th>
        <th><fmt:message key="reader.subsc.lastname"/></th>
        <th><fmt:message key="reader.subsc.phone"/></th>
        <th><fmt:message key="reader.subsc.magazinename"/></th>
        <th><fmt:message key="reader.subsc.price"/></th>
        <th><fmt:message key="reader.subsc.confirmation"/></th>
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
