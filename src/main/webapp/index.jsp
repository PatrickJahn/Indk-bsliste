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
    <title>Title</title>
</head>
<body>
<h1>Velkommen til indkøbslisten</h1>


<form action="LoginServlet" method="post">
    <label for="fname">First name:</label><br>
    <input type="text" id="fname" name="navn"><br>
    <label for="pass">Password:</label><br>
    <input type="password" id="pass" name="password" ><br><br>
    <input type="submit" value="Login">
</form>

</body>
</html>
