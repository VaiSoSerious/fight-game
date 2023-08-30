<%--
  Created by IntelliJ IDEA.
  User: antonvesnin
  Date: 25.08.2023
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Создание персонажа</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<div class="container-fluid">
    <%--Название игры--%>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <br><br>
            <div class="container">
                <h1 align="center" style="color: red">Сдохни или умри!</h1>
            </div>
            <br>
        </div>
        <div class="col-md-2">
            <br><br>
            <div class="panel-body" align="center">Вы вошли как: ${user.name}
                <form action="hello" method="get">
                    <button id="backButton" name="backButton" class="btn btn-danger">Выйти</button>
                </form>
            </div>
        </div>
    </div>
    <hr>
    <%--Текстовый комментарий--%>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="panel panel-default">
                <div class="panel-body" align="center">Выбор профессии</div>
            </div>
        </div>
        <div class="col-md-2">
        </div>
        <br><br>
    </div>
    <%--Выбранный класс--%>
    <div class="row">
        <div class="col-md-12" align="center">
            Ты выбрал класс: ${characterClass}. Интересное решение... ну да ладно, о вкусах не спорят. Осталось
            придумать имя для твоего персонажа и можно отправляться в бой!
        </div>
    </div>
    <br>
    <%--Поля ввода данных--%>
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form action="mainmenu" method="post">
                <%--Поле ввода логина--%>
                <div class="row">
                    <input class="text" id="characterName" name="characterName" type="text"
                           placeholder="Введите имя персонажа" required="">
                    <div class="container">
                        <c:if test="${badName == true}">
                            <div class="alert alert-danger alert-sm mt-1">Имя может содержать только английские буквы
                                и цифры.
                            </div>
                        </c:if>
                    </div>
                </div>
                    <c:if test="${badName != true}">
                        <br>
                    </c:if>
                <%--Кнопка создания--%>
                <div class="row">
                    <button value="${characterClass}" id="creatButton" name="creatButton" class="btn btn-success">
                        Создать
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>

</body>
</html>
