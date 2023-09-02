<jsp:useBean id="selectedEnemy" scope="session" type="com.vai.module3project.model.entity.Character"/>
<jsp:useBean id="selectedCharacter" scope="session" type="com.vai.module3project.model.entity.Character"/>
<%--
  Created by IntelliJ IDEA.
  User: antonvesnin
  Date: 19.08.2023
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Бой</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<div class="container">
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
                <div class="panel-body" align="center">Бой начинается!
                    <br>
            </div>
        </div>
        <div class="col-md-2">
        </div>
        <br><br>
    </div>
    <br>
    <%--Отображение персонажей--%>
    <div class="row">
        <div class="col-md-4" align="center">
            <div><span style="color: darkcyan">${selectedCharacter.name}</span></div>
            <div>Класс: ${selectedCharacter.characterClass.tittle}</div>
            <div>Жизней: ${selectedCharacter.health}</div>
            <div>Сила: ${selectedCharacter.characterClass.power}</div>
            <div>
                <form method="post" action="battle">
                    <c:if test="${enemyLost != true}">
                        <button value="hit" id="hitButton" name="hitButton" class="btn btn-success">
                            Атака
                        </button>
                    </c:if>
                </form>
            </div>
        </div>
        <div class="col-md-4" align="center">
            <c:if test="${playerHitText != null}">
                Бой: <br>
                <span style="color: darkcyan">${selectedCharacter.name}:</span>
                ${playerHitText}
                <br>
                <span style="color: red">${selectedEnemy.name}:</span>
                ${enemyHitText}
                <br>
            </c:if>
            <c:if test="${enemyLost == true}">
                <span style="color: darkcyan">${selectedCharacter.name}</span> выиграл!
                <form method="get" action="mainmenu">
                    <button value="win" id="victoryMainMenuButton" name="mainMenuButton" class="btn btn-success">
                        В главное меню
                    </button>
                </form>
            </c:if>
            <c:if test="${playerLost == true}">
                <span style="color: red">${selectedEnemy.name}</span> выиграл!
                <form method="get" action="mainmenu">
                    <button value="lost" id="lostMainMenuButton" name="mainMenuButton" class="btn btn-danger">
                        В главное меню
                    </button>
                </form>
            </c:if>
        </div>
        <div class="col-md-4" align="center">
            <div><span style="color: red">${selectedEnemy.name}</span></div>
            <div>Класс: ${selectedEnemy.characterClass.tittle}</div>
            <div>Жизней: ${selectedEnemy.health}</div>
            <div>Сила: ${selectedEnemy.characterClass.power}</div>
        </div>
    </div>
</div>
<%--<c:set var="selectedCharacter" value="${selectedChAaracter}" scope="request"/>--%>
<%--<c:set var="selectedEnemy" value="${selectedEnemy}" scope="request"/>--%>
</body>
</html>
