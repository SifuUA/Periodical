<%@include file="../templates/header.jspf" %>
<title>Main page</title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" role="navigation">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/servlet/home"><fmt:message
                key="main.button.home"/></a>
        <button class="navbar-toggler border-0" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">
            &#9776;
        </button>
        <div class="collapse navbar-collapse" id="exCollapsingNavbar">
            <ul class="nav navbar-nav">
                <div class="dropdown">
                    <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <fmt:message key="main.button.categories"/>
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <c:forEach var="categ" items="${applicationScope.editionCategories}">
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/servlet/home?catId=${categ.categoryId}">${categ.category}
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </ul>
            <ul class="nav navbar-nav">
                <div class="dropdown">
                    <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton1"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <fmt:message key="main.button.lang"/>
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                        <a class="dropdown-item" href="?locale=en"><fmt:message key="label.lang.en"/></a>
                        <a class="dropdown-item" href="?locale=ua"><fmt:message key="label.lang.ua"/></a>
                    </div>
                </div>
            </ul>
            <ul class="nav navbar-nav flex-row justify-content-between ml-auto">
                <li class="nav-item order-2 order-md-1"><a href="#" class="nav-link" title="settings"><i
                        class="fa fa-cog fa-fw fa-lg"></i></a></li>
                <li class="dropdown order-1">
                    <button type="button" id="dropdownMenu1" data-toggle="dropdown"
                            class="btn btn-outline-secondary dropdown-toggle"><fmt:message key="main.button.login"/>
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu dropdown-menu-right mt-2">
                        <li class="px-3 py-2">
                            <form class="form" role="form" action="${pageContext.request.contextPath}/servlet/login"
                                  method=get>
                                <div class="form-group">
                                    <input id="emailInput" placeholder=
                                    <fmt:message key="main.form.email"/> class="form-control form-control-sm"
                                    type="text" required="" name="email">
                                </div>
                                <div class="form-group">
                                    <input id="passwordInput" placeholder=
                                    <fmt:message key="main.form.password"/>
                                            class="form-control form-control-sm type="text" required="" name="password">
                                </div>
                                <div class="form-group">
                                    <button type="submit" value="Login" class="btn btn-success" id="login"
                                            name="loginButton"><fmt:message key="main.button.login"/>
                                    </button>
                                </div>
                            </form>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/servlet/registration" class="nav-link">
                        <fmt:message key="main.button.registration"/>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
    <div id="modalPassword" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3>Forgot password</h3>
                    <button type="button" class="close font-weight-light" data-dismiss="modal" aria-hidden="true">×
                    </button>
                </div>
                <div class="modal-body">
                    <p>Reset your password..</p>
                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                    <button class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="container" style="margin-top: 100px">
    <div class="row">
        <c:forEach var="imgBase" items="${sessionScope.encodeImages}">
            <div class="col-lg-2 col-md-6 col-xs-6">
                <a href="${pageContext.request.contextPath}/servlet/home?imageIndex=${imgBase.key.id}"
                   class="d-block mb-4 h-100">
                    <img class="img-fluid img-thumbnail" src="data:image/jpeg;base64,${imgBase.value}" alt="">
                    <h6>${imgBase.key.editionName}</h6>
                </a>
            </div>
        </c:forEach>
    </div>
</div>

<hr>
<br/>

<table align="center">
    <tr>
        <c:if test="${sessionScope.currentPage != 1}">
            <td><a class="page-link"
                   href="${pageContext.request.contextPath}/servlet/home?page=${sessionScope.currentPage - 1}"><fmt:message
                    key="button.previous"/></a>
            </td>
        </c:if>
        <c:forEach begin="1" end="${sessionScope.numberOfPages}" var="i">
            <c:choose>
                <c:when test="${sessionScope.currentPage eq i}">
                    <td><a class="page-link">${i}</a></td>
                </c:when>
                <c:otherwise>
                    <td><a class="page-link" href="${pageContext.request.contextPath}/servlet/home?page=${i}">${i}</a>
                    </td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${sessionScope.currentPage lt sessionScope.numberOfPages}">
            <td><a class="page-link"
                   href="${pageContext.request.contextPath}/servlet/home?page=${sessionScope.currentPage + 1}"><fmt:message
                    key="button.next"/></a>
            </td>
        </c:if>
    </tr>
</table>
<%@include file="../templates/footer.jspf" %>
