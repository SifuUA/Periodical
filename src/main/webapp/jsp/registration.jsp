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

    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container py-5">
    <div class="row">
        <div class="col-md-12">
            <h5 class="text-center text-white mb-4">Login Form</h5>
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <div class="card rounded-0">
                        <div class="card-header">
                            <h4 class="mb-0">Registration From</h4>
                        </div>
                        <div class="card-body">
                            <form method="post" class="form-horizontal" style="width: 800px">
                                <fieldset>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-7 control-label" for="fname">First Name</label>
                                        <div class="col-md-7">
                                            <input id="fname" name="fname" type="text" placeholder="John"
                                                   class="form-control input-md"
                                                   required="">
                                        </div>
                                    </div>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-7 control-label" for="lname">Last Name</label>
                                        <div class="col-md-7">
                                            <input id="lname" name="lname" type="text" placeholder="Doe"
                                                   class="form-control input-md"
                                                   required="">
                                        </div>
                                    </div>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-7 control-label" for="phone">Phone number</label>
                                        <div class="col-md-7">
                                            <input id="phone" name="email" type="text" placeholder="380677777777"
                                                   class="form-control input-md" required="">
                                        </div>
                                    </div>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-7 control-label" for="email">Email</label>
                                        <div class="col-md-7">
                                            <input id="email" name="email" type="text" placeholder="johndoe@example.com"
                                                   class="form-control input-md" required="">
                                        </div>
                                    </div>
                                    <!-- Password input-->
                                    <div class="form-group">
                                        <label class="col-md-7 control-label" for="password">Password</label>
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
                                            <button id="save" name="save" class="btn btn-success">Register</button>
                                            <button id="clear" name="clear" class="btn btn-danger">Reset</button>
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
