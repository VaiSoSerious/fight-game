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
        <div class="col-md-12">
            <br><br>
            <div class="container">
                <h1 align="center" style="color: red">Сдохни или умри!</h1>
            </div>
            <hr>
            <br>
        </div>
    </div>
    <%--Текстовый комментарий--%>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="panel panel-default">
                <div class="panel-body" align="center">Главное меню</div>
            </div>
        </div>
        <div class="col-md-2">
            <div class="panel-body" align="center">Вы вошли как: ${user.name}</div>
        </div>
        <br><br>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <c:if test="${userHaveCharactersCheck != true}">
                    <div class="panel-body" align="center">У вас еще нет созданных персонажей.</div>
                </c:if>
            </div>
        </div>
    </div>


</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
        crossorigin="anonymous"></script>

</body>
</html>
