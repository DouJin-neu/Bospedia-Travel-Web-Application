<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/11/2021
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="pl_content">
    <h1>Product NO.${newProduct.ticketID} Added Successfully</h1>
    <table>
        <tr>
            <td>Product ID</td>
            <td>${newProduct.ticketID}</td>
        </tr>
        <tr>
            <td>Product Name</td>
            <td>${newProduct.ticketName}</td>
        </tr>
        <tr>
            <td>Product Price</td>
            <td>${newProduct.price}</td>
        </tr>
        <tr>
            <c:choose>
            <c:when test = "${newProduct.cid == 1}">
                <c:set var="category" value="Activities & Games"/>
            </c:when>

            <c:when test = "${newProduct.cid == 2}">
                <c:set var="category" value="Art & Culture"/>
            </c:when>

            <c:when test = "${newProduct.cid == 3}">
                <c:set var="category" value="At Home"/>
            </c:when>

            <c:otherwise>
                <c:set var="category" value="Trips"/>
            </c:otherwise>
        </c:choose>
            <td>Product Category</td>
            <td>${category}</td>
        </tr>
    </table>

    <a href="productListView.htm">Click here to see all products</a>

</div>


</body>
</html>
