<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 2/26/2021
  Time: 9:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie Store</title>
</head>
<body>
<form action="movie.htm" method="post">
    <h1>Searching Movies</h1>
    KeyWord:    <input type="text" name="keyword"/><br/>
    <input type="radio" name="search" value="title"/>Search By Title<br/>
    <input type="radio" name="search" value="actor"/>Search By Actor<br/>
    <input type="radio" name="search" value="actress"/>Search By Actress<br/><br/>

    <button name="search" type="submit" >Search Movies</button>
    <input type="hidden" name="option" value="browse"/>
</form>
</body>
</html>
