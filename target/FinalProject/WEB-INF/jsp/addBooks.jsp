<%@ page import="com.djin.pojo.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 2/27/2021
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Books Here</title>
    <style type="text/css">
        body{ background-color:#9CC; text-align:center}
        table{ border-collapse:collapse; margin:10px auto;}
        tr th { border: 1px solid #096;}
        td{border: 1px solid #096; height:50px; width: 150px; text-align: center; }
        input{ box-shadow: 0px 0px 10px #9CC inset; border: none; height: 20px; width: 130px; }
        #submit{border:1px solid}
    </style>
</head>
<body>

<form action="book.htm" method="post">
<table border="1" align="center">
    <tr>
        <th >ISBN</th>
        <th >Book Title</th>
        <th >Authors</th>
        <th >Price</th>
    </tr>


    <h1><c:out value="Please Enter Books Information Here"/></h1>
    <c:set var="bookList" scope="session" value="${newBookList}"/>

   <c:forEach items="${newBookList}" var="book" varStatus="status">

        <tr>
            <td><input type="text" name="isbn_${status.index}"/></td>
            <td><input type="text" name="title_${status.index}"/> </td>
            <td><input type="text" name="authors_${status.index}"/> </td>
            <td><input type="text" name="price_${status.index}"/> </td>
        </tr>
    </c:forEach>


    <tr><td colspan="4"> <input id="submit" type="submit" name="addBooks" value="Add Books"/>
    </td></tr>




</table>


</form>
</body>
</html>
