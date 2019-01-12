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
