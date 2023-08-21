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
</head>
<body>
<hr>
<h1>Сдохни или умри!</h1>
<hr>
<h3>Предлагаю тебе испытать свои силы в увлекательнейшей игре тысячилетия: "Сдохни или умри!"</h3>
<h3>Для продолжения тебе нужно войти в аккаунт или зарегистрироваться.</h3>
<form action="LoginServlet" method="get">
    <label for="username">Логин:</label>
    <input type="text" name="username" id="username" required><br><br>

    <label for="password">Пароль:</label>
    <input type="password" name="password" id="password" required><br><br>

    <input type="submit" value="Войти">
</form>
<form action="registration" method="get">
    <input type="submit" value="Регистрация">
</form>
<%--<button onclick="window.location.href='PreRegistrationServlet'">Регистрация</button>--%>
<%--<h3>Поздно вечером, возвращаясь домой к тебе пристал местный забулдыга. Сперва он что-то неразборчиво пробормотал,</h3>--%>
<%--<h3>а потом спросил как тебя зовут?</h3>--%>

</body>
</html>
