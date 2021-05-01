<%@ page import="com.djin.pojo.Movie" %>
<%@ page import="java.util.List" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 2/27/2021
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Result</title>
    <style type="text/css">
        body{ background-color:#9CC; text-align:center}
        table{ border-collapse:collapse; margin:10px auto;}
        tr th { border: 1px solid #096;}
        td{border: 1px solid #096; height:50px; width: 150px; text-align: center; }
    </style>
</head>
<body>

<p>You searched for ${requestScope.keyword}</p>
<br/>
<h3>Here are the search results</h3>

<table border="1" align="center">
    <tr>
        <th >Movie Title</th>
        <th >Lead Actor</th>
        <th >Lead Actress</th>
        <th >Genre</th>
        <th >Year</th>
    </tr>

<c:forEach items="${results}" var="moive">

    <tr>
        <td><c:out value="${moive.title}"/></td>
        <td><c:out value="${moive.actor}"/></td>
        <td><c:out value="${moive.actress}"/></td>
        <td><c:out value="${moive.genre}"/></td>
        <td><c:out value="${moive.movie_year}"/></td>
    </tr>
</c:forEach>
</table>
<br><br>
<a href="/AS04/index.jsp">Click here to go back to the main page</a>

</body>
</html>
