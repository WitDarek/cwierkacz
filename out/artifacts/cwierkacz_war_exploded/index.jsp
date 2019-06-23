<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Daarek
  Date: 2019-06-22
  Time: 09:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Użytkownik:
  <c:if test="${sessionScope.get('user') == null}">
    niezalogowany
  </c:if>
    <c:if test="${sessionScope.get('user') !=null}">
      ${sessionScope.get("user").login}
    </c:if>

  </h2>
  <ul>
    <li><p><a href="messages?action=all"> Wszystkie wiadomości</a></p></li>
    <li><p><a href="add_user.jsp">Dodaj użytkownika</a> </p></li>
    <li><p><a href="login"> Logowanie</a></p></li>
<c:if test="${sessionScope.get('user') !=null}">
    <li><p><a href="logout">Wyloguj</a> </p></li>
</c:if>
      <li><p><a href="messages?action=add">Dodaj wiadomość</a></p></li>
    <li><a href="add_message.jsp">Dodaj wiadomosc bez logowania</a> </li>
    <li>
      <p><a href="api/message/all">API - wszystkie wiadomosci</a></p>
    </li>
    <li>
      <p><a href="api/user/all">API - wszyscy użytkownicy</a></p>
    </li>

  </ul>
  </body>
</html>
