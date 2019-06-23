<%--
  Created by IntelliJ IDEA.
  User: Daarek
  Date: 2019-06-23
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodanie użytkownia</title>
</head>
<body>
<h1>Dodaj wiadomość</h1>
<form method="post" action="api/user/add/form">
    <input type="text" name="login">
    <input type="password" name="password">
    <input type="text" name="email">
    <button type="submit">Dodaj użytkownika</button>
</form>
</body>
</html>
