<%--
  Created by IntelliJ IDEA.
  User: antonvesnin
  Date: 19.08.2023
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Регистрация</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

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
                <div class="panel-body" align="center">Регистрация</div>
            </div>
        </div>
        <div class="col-md-1"></div>
        <br><br>
    </div>

    <%--Блок с вводом информации и кнопками--%>
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form action="registration" method="post">
                <%--Поле ввода логина--%>
                <div class="row">
                    <input id="loginInput" name="username" type="text" placeholder="Введите логин" required="">
                    <div class="container">
                        <c:if test="${alreadyExist == true}">
                            <div class="alert alert-danger alert-sm mt-1">Этот логин уже занят.</div>
                        </c:if>
                        <c:if test="${badLogin == true}">
                            <div class="alert alert-danger alert-sm mt-1">Логин может содержать только английские буквы
                                и цифры.
                            </div>
                        </c:if>
                    </div>
                </div>
                <c:if test="${alreadyExist != true || badLogin != true}">
                    <br>
                </c:if>
                <div class="row">
                    <input id="nameInput" name="name" type="text" placeholder="Введите имя" required="">
                    <div class="container">
                    </div>
                </div>
                <br>
                <%--Поле ввода email--%>
                <div class="row">
                    <input id="emailInput" name="email" type="email" placeholder="Введите почту" required="">
                    <c:if test="${emailIsBusy == true}">
                        <div class="alert alert-danger alert-sm mt-1">Эта почта уже занята.</div>
                    </c:if>
                </div>
                <c:if test="${emailIsBusy != true}">
                    <br>
                </c:if>
                <%--Поле ввода пароля--%>
                <div class="row">
                    <input id="passwordInput" name="password" type="password" placeholder="Введите пароль" required="">
                </div>
                <br>
                <div class="row">
                    <input id="passwordRepeatInput" name="passwordRepeat" type="password"
                           placeholder="Введите пароль повторно" required="">
                    <div class="container">
                        <c:if test="${differentPass == true}">
                            <div class="alert alert-danger alert-sm mt-1">Введены разные пароли.</div>
                        </c:if>
                        <c:if test="${badPassword == true}">
                            <div class="alert alert-danger alert-sm mt-1">Пароль может содержать только английские буквы
                                и цифры.
                            </div>
                        </c:if>
                    </div>
                </div>
                <c:if test="${differentPass != true || badPassword != true}">
                    <br>
                </c:if>
                <%--Кнопка входа--%>
                <div class="row">
                    <button id="regButton" name="regButton" class="btn btn-success">Зарегистрироваться</button>
                </div>
            </form>
            <form action="hello" method="get">
                <div class="row">
                    <button id="backButton" name="backButton" class="btn btn-danger">Назад</button>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>

