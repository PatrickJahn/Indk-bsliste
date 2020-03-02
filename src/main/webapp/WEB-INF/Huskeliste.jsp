<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 02/03/2020
  Time: 21.47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Webshop</title>
</head>
<body>
<h1>Velkommen til ${sessionScope.brugerNavn}</h1>

<form action="ItemsServlet" method="post">
    <label for="fvare">Vælg vare:</label><br>
    <input type="text" id="fvare" name="vareNavn"><br>

    <input type="submit" value="Tilføj">
</form>
<p style="color: green">${requestScope.besked}</p>


<h3>Dine vare: </h3>
<c:forEach var="element" items="${sessionScope.basket}">
    ${element}
    <br>
</c:forEach>


<form action="LogoutServlet" method="post">
    <input type="submit" value="Log ud">
</form>

</body>
</html>
