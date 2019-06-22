<%--
  Created by IntelliJ IDEA.
  User: Daarek
  Date: 2019-06-22
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Dodaj wiadomość</h1>
    <form method="post" action="messages">
        <input type="text" name="title">
        <textarea name="content"></textarea>
        <button type="submit">Dodaj wiadomość</button>
    </form>
</body>
</html>
