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
    <title>Регистрация</title>
</head>
<body>
<hr>
<h1>Сдохни или умри!</h1>
<h3>Регистрация</h3>
<hr>
<form action="RegisterServlet" method="post">
    <label for="username">Логин:</label>
    <input type="text" name="username" id="username" required><br><br>

    <label for="nickname">Ник:</label>
    <input type="text" name="nickname" id="nickname" required><br><br>

    <label for="password">Пароль:</label>
    <input type="password" name="password" id="password" required><br><br>

    <input type="submit" value="Зарегистрироваться">
</form>
</body>
</html>

