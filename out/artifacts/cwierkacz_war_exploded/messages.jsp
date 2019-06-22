<%--
  Created by IntelliJ IDEA.
  User: Daarek
  Date: 2019-06-22
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%--
   BABA -> 0*2 + 1*1 + 2*2 + 3*2 = 008
    CD -> 2*4 = 008
--%>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${requestScope.lista}" var="message">
    <p> Tytuł: ${message.title}, zawartość: ${message.content},
        data publikacji: ${message.published},
    autor: ${message.author.login}</p>

</c:forEach>
</body>
</html>
