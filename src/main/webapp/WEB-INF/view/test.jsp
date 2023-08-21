<jsp:useBean id="player" scope="session" type="com.vai.module3project.model.entity.Character"/>
<%--
  Created by IntelliJ IDEA.
  User: antonvesnin
  Date: 19.08.2023
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Player: ${player.name}</h1>
</body>
</html>
