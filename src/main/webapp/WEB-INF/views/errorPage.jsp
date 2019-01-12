<%@include file="../templates/header.jspf" %>
<title>ACCESS DENIED</title>
</head>
<body>
<div>
    <h2>ACCESS DENIED!!!</h2>
    <h3>You are not authorized. Please login.</h3>
</div>

<div class="container-fluid">
    <a href="${pageContext.request.contextPath}/servlet/home" class="btn btn-dark" role="button"
       style="margin: 20px; padding: 10px"><fmt:message key="reader.subsc.back"/></a>
</div>
</body>
</html>
