<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 3/19/2021
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Store</title>
</head>
<body>
<h1><%= "How many books do you want to add?" %>
</h1>
<form action="book.htm" method="post">
    <input type="text" name="amount"/>
    <input type="submit" name="submit" value="Submit"/>
</form>

</body>
</html>
