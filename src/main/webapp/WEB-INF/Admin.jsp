<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 02/03/2020
  Time: 22.54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1> Admin Page</h1>

<c:forEach var="bruger" items="${applicationScope.brugerMap}">

    ${bruger}
    <br>

</c:forEach>
</body>
</html>
