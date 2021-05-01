<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 3/19/2021
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie Store</title>
</head>
<body>
<form action="movie.htm" method="post">
    <h1>Welcome to our Movie Store</h1>
    <p>Please make your selection below</p>
    <select name="choice" id="choice">
        <option value="browsePage">Browse Movies</option>
        <option value="addPage">Add New Movie Database</option>
    </select>
    <input name="submit" type="submit" value="Send">
</form>

</body>
</html>
