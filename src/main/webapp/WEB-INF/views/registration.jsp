<%@include file="../templates/header.jspf" %>
<title>Registration</title>
</head>
<body>

<div class="container">
    <a href="${pageContext.request.contextPath}/servlet/home" class="btn btn-info" role="button"
       style="margin-top: 20px"><fmt:message key="registration.home"/> </a>
</div>
<div class="container py-5">
    <div class="row">
        <div class="col-md-12">
            <h5 class="text-center text-white mb-4">Registration Form</h5>
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <div class="card rounded-0">
                        <div class="card-header">
                            <h4 class="mb-0"><fmt:message key="registration.title"/></h4>
                        </div>
                        <div class="card-body">
                            <form action="${pageContext.request.contextPath}/servlet/registerReader" method="get"
                                  class="form-horizontal" style="width: 800px">
                                <fieldset>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-7 control-label" for="fname"><fmt:message
                                                key="registration.firstname"/></label>
                                        <div class="col-md-7">
                                            <input id="fname" name="fname" type="text" placeholder=
                                            <fmt:message key="registration.firstname.hint"/>
                                                    class="form-control input-md"
                                            required="">
                                        </div>
                                    </div>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-7 control-label" for="lname"><fmt:message
                                                key="registration.lastname"/></label>
                                        <div class="col-md-7">
                                            <input id="lname" name="lname" type="text" placeholder=
                                            <fmt:message key="registration.lastname.hint"/>
                                                    class="form-control input-md"
                                            required="">
                                        </div>
                                    </div>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-7 control-label" for="phone"><fmt:message
                                                key="registration.phone"/></label>
                                        <div class="col-md-7">
                                            <input id="phone" name="phone" type="text" placeholder=
                                            <fmt:message key="registration.phone.hint"/>
                                                    class="form-control input-md" required="">
                                        </div>
                                    </div>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-7 control-label" for="email"><fmt:message
                                                key="registration.email"/></label>
                                        <div class="col-md-7">
                                            <input id="email" name="email" type="text" placeholder=
                                            <fmt:message key="registration.email.hint"/>
                                                    class="form-control input-md" required="">
                                        </div>
                                    </div>
                                    <!-- Password input-->
                                    <div class="form-group">
                                        <label class="col-md-7 control-label" for="password"><fmt:message
                                                key="registration.password"/></label>
                                        <div class="col-md-7">
                                            <input id="password" name="password" type="password" placeholder=""
                                                   class="form-control input-md"
                                                   required="">
                                        </div>
                                    </div>
                                    <!-- Button (Double) -->
                                    <div class="form-group">
                                        <label class="col-md-7 control-label" for="save"></label>
                                        <div class="col-md-8">
                                            <button id="save" name="save" class="btn btn-success"><fmt:message
                                                    key="registration.register"/></button>
                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
