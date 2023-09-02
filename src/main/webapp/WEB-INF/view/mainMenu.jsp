<jsp:useBean id="user" scope="session" type="com.vai.module3project.model.entity.User"/>

<%--
  Created by IntelliJ IDEA.
  User: antonvesnin
  Date: 23.08.2023
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Главное меню</title>
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
                <div class="panel-body" align="center">Главное меню</div>
            </div>
        </div>
        <div class="col-md-2">
        </div>
        <br><br>
    </div>
    <%--Блок отображения персонажей--%>
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <c:if test="${user.characters.size() == 0}">
                    <div class="panel-body" align="center">У вас еще нет созданных персонажей.</div>
                </c:if>
                <c:if test="${user.characters.size() > 0}">
                    <div class="panel-body" align="center">Ваши персонажи:</div>
                    <table class="table table-hover">
                        <thead>
                        <tr class="ui-state-active">
                            <th>Имя</th>
                            <th>Уровень</th>
                            <th>%</th>
                            <th>Сила</th>
                            <th>Жизни</th>
                            <th>Класс</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="character" items="${user.characters}">
                            <tr>
                                <td>${character.name}</td>
                                <td>${character.level}</td>
                                <td>${character.percents}</td>
                                <td>${character.characterClass.power}</td>
                                <td>${character.health}</td>
                                <td>${character.characterClass.tittle}</td>
                                <td align="center">
                                    <form action="battle" method="get">
                                        <button value="${character.name}" id="fightButton" name="fightButton" class="btn btn-success">В бой!
                                        </button>
                                    </form>
                                </td>
                                <td align="center">
                                    <form action="mainmenu" method="post">
                                        <button value="${character.name}" id="delButton" name="delButton"
                                                class="btn btn-danger">Удалить
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>
    </div>
    <%--Блок создания персонажа--%>
    <div class="row">
        <c:if test="${user.characters.size() < 5}">
            <div class="col-md-12" align="center">
                <form action="newcharacter" method="get">
                    <button id="creatCharacterButton" name="creatCharacterButton" class="btn btn-info">Создать</button>
                </form>
            </div>
        </c:if>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
        crossorigin="anonymous"></script>
</body>
</html>
