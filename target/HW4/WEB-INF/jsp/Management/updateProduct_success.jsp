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
    <h1>Product NO.${updatedProduct.ticketID} Updated Successfully</h1>
    <table>
        <tr>
            <td>Product ID</td>
            <td>${updatedProduct.ticketID}</td>
        </tr>
        <tr>
            <td>Product Name</td>
            <td>${updatedProduct.ticketName}</td>
        </tr>
        <tr>
            <td>Product Price</td>
            <td>${updatedProduct.price}</td>
        </tr>
        <tr>
            <td>Product Availability</td>
            <td>${updatedProduct.tFlag}</td>
        </tr>
        <tr>
            <td>Product Introduce</td>
            <td>${updatedProduct.tIntroduce}</td>
        </tr>
    </table>

    <a href="productListView.htm">Click here to see all products</a>

</div>


</body>
</html>
