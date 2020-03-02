<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 02/03/2020
  Time: 22.11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign-up</title>
</head>
<body>
<h1>Opret ny bruger:</h1>


<form action="OpretServlet" method="post">
    <label for="fname">Name:</label><br>
    <input type="text" id="fname" name="navn"><br>
    <label for="pass">Password:</label><br>
    <input type="password" id="pass" name="password" >
    <p style="color: red">${requestScope.besked}</p>

    <input type="submit" value="Opret">
</form>

</body>
</html>
