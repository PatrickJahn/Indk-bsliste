<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 02/03/2020
  Time: 21.09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Indkøbslisten</title>
</head>
<body>
<h1>Velkommen til webshoppen ${sessionScope.brugerNavn}</h1>


<form action="LoginServlet" method="post">
    <label for="fname">First name:</label><br>
    <input type="text" id="fname" name="navn"><br>
    <label for="pass">Password:</label><br>
    <input type="password" id="pass" name="password" >
    <p style="color: red">${requestScope.besked}</p>

    <input type="submit" value="Login">
</form>

<a href="http://localhost:8080/Indkøbsliste_war/OpretBruger.jsp"> Opret bruger</a>
</body>
</html>
