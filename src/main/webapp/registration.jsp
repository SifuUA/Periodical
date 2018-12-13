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

    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<%--<div class="container">
    <form class="form" role="form">
        <div class="form-group">
            <label for="email">Email</label>
            <!--placeholder - надпись на заднем фоне-->
            <input type="email" class="form-control" id="email" placeholder="Введите email">
            <p class="help-block">Какая то подсказка</p>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <!--placeholder - надпись на заднем фоне-->
            <input type="email" class="form-control" id="password" placeholder="Введите password">
            <p class="help-block">Какая то подсказка</p>
        </div>
        <div class="checkbox">
            <label for="password">
                <input type="checkbox"> Чекбокс
            </label>
        </div>
        <button class="btn btn-success">Регистрация</button>
        <div class="radio">
            <label>
                <input type="radio" name="optionsRadios" id="radio1" value="option1" checked>
                First element
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="optionsRadios" id="radio2" value="option2">
                Second element
            </label>
        </div>
        <select class="form-control">
            <option>1</option>
            <option>2</option>
            <option>3</option>
        </select>
    </form>
</div>--%>
<%--<div class="d-flex justify-content-center align-items-center container ">
            <form class="form-horizontal" style="width: 800px">
                <fieldset>

                    <!-- Form Name -->
                    <legend>Register Yourself</legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="fname">First Name</label>
                        <div class="col-md-4">
                            <input id="fname" name="fname" type="text" placeholder="John" class="form-control input-md"
                                   required="">
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="lname">Last Name</label>
                        <div class="col-md-4">
                            <input id="lname" name="lname" type="text" placeholder="Doe" class="form-control input-md"
                                   required="">
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="email">Email</label>
                        <div class="col-md-4">
                            <input id="email" name="email" type="text" placeholder="johndoe@example.com"
                                   class="form-control input-md" required="">
                        </div>
                    </div>

                    <!-- Password input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="password">Password</label>
                        <div class="col-md-4">
                            <input id="password" name="password" type="password" placeholder=""
                                   class="form-control input-md"
                                   required="">
                        </div>
                    </div>

                    <!-- Button (Double) -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="save"></label>
                        <div class="col-md-8">
                            <button id="save" name="save" class="btn btn-success">Register</button>
                            <button id="clear" name="clear" class="btn btn-danger">Reset</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>--%>

<div class="container py-5">
    <div class="row">
        <div class="col-md-12">
            <h2 class="text-center text-white mb-4">Login Form</h2>
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <div class="card rounded-0">
                        <div class="card-header">
                            <h3 class="mb-0">Register Yourself</h3>
                        </div>
                        <div class="card-body">
                            <form class="form-horizontal" style="width: 800px">
                                <fieldset>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-7 control-label" for="fname">First Name</label>
                                        <div class="col-md-7">
                                            <input id="fname" name="fname" type="text" placeholder="John" class="form-control input-md"
                                                   required="">
                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-7 control-label" for="lname">Last Name</label>
                                        <div class="col-md-7">
                                            <input id="lname" name="lname" type="text" placeholder="Doe" class="form-control input-md"
                                                   required="">
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
                            <%--<form class="form" role="form" autocomplete="off" id="formLogin" novalidate=""
                                  method="POST">
                                <div class="form-group">
                                    <label for="uname1">Username</label>
                                    <input type="text" class="form-control form-control-lg rounded-0" name="uname1"
                                           id="uname1" required="">
                                    <div class="invalid-feedback">Oops, you missed this one.</div>
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input type="password" class="form-control form-control-lg rounded-0" id="pwd1"
                                           required="" autocomplete="new-password">
                                    <div class="invalid-feedback">Enter your password too!</div>
                                </div>
                                <div>
                                    <label class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input">
                                        <span class="custom-control-indicator"></span>
                                        <span class="custom-control-description small text-dark">Remember me on this computer</span>
                                    </label>
                                </div>
                                <button type="submit" class="btn btn-success btn-lg float-right" id="btnLogin">Login
                                </button>
                            </form>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
