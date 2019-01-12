<%@include file="../templates/header.jspf" %>
<title>Admin page</title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" role="navigation">
        <%--<div class="container">--%>
        <a class="navbar-brand" href="#"><fmt:message key="admin.home"/></a>
        <button class="navbar-toggler border-0" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">
            &#9776;
        </button>
        <div class="collapse navbar-collapse" id="exCollapsingNavbar">
            <ul class="nav navbar-nav flex-row justify-content-between ml-auto">
                <li class="nav-item order-2 order-md-1"><a href="#" class="nav-link" title="settings"><i
                        class="fa fa-cog fa-fw fa-lg"></i></a></li>
                <li class="navbar-brand"><fmt:message key="admin.hello"/> ${sessionScope.name}</li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/servlet/logout"
                                        class="nav-link"><fmt:message key="admin.logout"/></a></li>
                <%--<li class="nav-item"><a href="registration.jsp" class="nav-link">Registration</a></li>--%>
            </ul>
        </div>
        <%--</div>--%>
    </nav>
</header>
<div class="container-fluid" style="margin-top: 100px">
    <div class="row">
        <div class="col-sm-6">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/servlet/admin/uploadForm" role="button"><fmt:message
                    key="admin.addnewedition"/> </a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/servlet/admin/viewReaders"
               role="button"><fmt:message key="admin.viewreaders"/></a>
            <a class="btn btn-primary"
               href="${pageContext.request.contextPath}/servlet/admin/viewReadersSubscriptionsByAdmin"
               role="button"><fmt:message key="admin.viewsubscriptions"/></a>
            <%--<a class="btn btn-primary" href="#" role="button">Accept payments</a>--%>
        </div>
    </div>
</div>

<div class="container" style="margin-top: 100px">
    <div class="row">
        <%--<c:forEach var="imgBase" items="${requestScope.encodeImages}">--%>
        <c:forEach var="imgBase" items="${sessionScope.encodeImages}">
            <div class="col-lg-2 col-md-6 col-xs-6">
                <a href="${pageContext.request.contextPath}/servlet/admin?imageIndex=${imgBase.key.id}"
                   class="d-block mb-4 h-100">
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
            <td><a class="page-link"
                   href="${pageContext.request.contextPath}/servlet/admin?page=${sessionScope.currentPage - 1}"><fmt:message key="button.previous"/></a>
            </td>
        </c:if>
        <c:forEach begin="1" end="${sessionScope.numberOfPages}" var="i">
            <c:choose>
                <c:when test="${sessionScope.currentPage eq i}">
                    <td><a class="page-link">${i}</a></td>
                </c:when>
                <c:otherwise>
                    <td><a class="page-link" href="${pageContext.request.contextPath}/servlet/admin?page=${i}">${i}</a>
                    </td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${sessionScope.currentPage lt sessionScope.numberOfPages}">
            <td><a class="page-link"
                   href="${pageContext.request.contextPath}/servlet/admin?page=${sessionScope.currentPage + 1}"><fmt:message key="button.next"/></a>
            </td>
        </c:if>
    </tr>
</table>

<script language="javascript" type="text/javascript"><c:import url="../../bootstrap/js/jquery-3.3.1.min.js"/> </script>
<script language="javascript" type="text/javascript"><c:import url="../../bootstrap/js/bootstrap.min.js"/></script>
</body>
</html>
