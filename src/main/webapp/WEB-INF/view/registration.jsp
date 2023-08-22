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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<hr>
<b>
    <h1>Сдохни или умри!</h1>
</b>
<hr>
<form class="form-horizontal" action="RegisterServlet" method="post">
    <h5>Регистрация</h5>
    <hr>
    <!-- Text input-->
    <div class="col-md-2">
        <input name="username" type="text" placeholder="логин" class="form-control input-md"
               required="">
    </div>
    <div class="col-md-2">
        <input name="nickname" type="text" placeholder="никнейм" class="form-control input-md"
               required="">
    </div>
    <!-- Password input-->
    <div class="col-md-2">
        <input name="password" type="password" placeholder="пароль"
               class="form-control input-md" required="">
    </div>

    <!-- Button -->
    <button name="singlebutton" class="btn btn-success">Зарегистрироваться</button>

</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
<%--<hr>--%>
<%--<h1>Сдохни или умри!</h1>--%>
<%--<h3>Регистрация</h3>--%>
<%--<hr>--%>
<%--<form action="RegisterServlet" method="post">--%>
<%--    <label for="username">Логин:</label>--%>
<%--    <input type="text" name="username" id="username" required><br><br>--%>

<%--    <label for="nickname">Ник:</label>--%>
<%--    <input type="text" name="nickname" id="nickname" required><br><br>--%>

<%--    <label for="password">Пароль:</label>--%>
<%--    <input type="password" name="password" id="password" required><br><br>--%>

<%--    <input type="submit" value="Зарегистрироваться">--%>
<%--</form>--%>
</body>
</html>

