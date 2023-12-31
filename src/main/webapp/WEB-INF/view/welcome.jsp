<%--
  Created by IntelliJ IDEA.
  User: antonvesnin
  Date: 19.08.2023
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Приветствие</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<div class="container-fluid">
    <%--Название игры--%>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <br><br>
            <div class="container">
                <h1 align="center" style="color: red">Сдохни или умри!</h1>
            </div>
            <hr>
            <br>
        </div>
        <div class="col-md-1"></div>
    </div>
    <%--Текстовый комментарий--%>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-body" align="center">Предлагаю тебе испытать свои силы в увлекательнейшей игре
                    тысячилетия! Для
                    продолжения тебе нужно войти в аккаунт или зарегистрироваться.
                </div>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
    <br><br>
    <%--Блок с вводом информации и кнопками--%>
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form action="login" method="post">
                <%--Поле ввода логина--%>
                <div class="row">
                    <input class="text" id="textinput" name="username" type="text" placeholder="Введите логин"
                           required="">
                    <div class="container">
                        <c:if test="${isExist == true}">
                            <div class="alert alert-danger alert-sm mt-1">Неверный логин.</div>
                        </c:if>
                    </div>
                </div>
                <c:if test="${isExist != true}">
                    <br>
                </c:if>
                <%--Поле ввода пароля--%>
                <div class="row">
                    <input id="passwordinput" name="password" type="password" placeholder="Введите пароль" required="">
                    <div class="container">
                        <c:if test="${wrongPass == true}">
                            <div class="alert alert-danger alert-sm mt-1">Неверный пароль.</div>
                        </c:if>
                    </div>
                </div>
                <c:if test="${wrongPass != true}">
                    <br>
                </c:if>
                <%--Кнопка входа--%>
                <div class="row">
                    <button id="enterButton" name="enterButton" class="btn btn-success">Вход</button>
                </div>
            </form>
            <%--Кнопка регистрации--%>
            <form action="preregistration" method="get">
                <div class="row">
                    <button id="regButton" name="regButton" class="btn btn-primary">Регистрация</button>
                </div>
            </form>
            <%--Кнопка входа как гость--%>
            <form action="login" method="get">
                <div class="row">
                    <button value="guest" id="guestButton" name="guestButton" class="btn btn-info">Войти как гость</button>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
</html>
