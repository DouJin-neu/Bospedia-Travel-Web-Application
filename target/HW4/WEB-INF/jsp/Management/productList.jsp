<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/11/2021
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" type="text/css" href="css/management.css" />
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="pl_content">

    <div class="filter">
        <form action="idFilter.htm" method="post" id="idFilter">
            <label for="productID" >ProductID: </label>
            <input type="text" name="productID" id="productID"/>
            <input type="submit" name="search" value="Search"/>
        </form>
        <form action="priceNameFilter.htm" method="post" id="priceNameFilter">

            <label for="productName" > Product Name:</label>
            <input type="text" name="productName" id="productName">

            <label for="minPrice" >Price </label>
            <input type="text" name="minPrice" id="minPrice">
            <label for="maxPrice" >&nbsp~ </label>
            <input type="text" name="maxPrice" id="maxPrice">
            <input type="submit" name="search" value="Search"/>
        </form>

        <label for="category" id="categoryLabel"> Category: </label>
        <select id="category" name="category" onchange="javascript:location.href='/FinalProject/categoryFilter.htm?categoryFilter='+this.value">
            <option value="0">-Select a category-</option>
            <option value="1" <c:if test="${requestScope.categoryFilter eq '1'}"> selected="selected" </c:if>>Activities & Games</option>
            <option value="2" <c:if test="${requestScope.categoryFilter eq '2'}"> selected="selected" </c:if>>Art & Culture</option>
            <option value="3" <c:if test="${requestScope.categoryFilter eq '3'}"> selected="selected" </c:if>>At Home</option>
            <option value="4" <c:if test="${requestScope.categoryFilter eq '4'}"> selected="selected" </c:if>>Trips</option>
        </select>

        <label for="sortMethod" id="sortLabel" style="margin-left: 50px">Sort</label>

        <select name="sortMethod" id="sortMethod" onchange="javascript:location.href='/FinalProject/sortProducts.htm?sortMethod='+this.value">
            <option value="0">-Default-</option>
            <option value="1" <c:if test="${requestScope.sortMethod eq '1'}"> selected="selected" </c:if>>Newest Events</option>
            <option value="2" <c:if test="${requestScope.sortMethod eq '2'}"> selected="selected" </c:if>>Price(low to high)</option>
            <option value="3" <c:if test="${requestScope.sortMethod eq '3'}"> selected="selected" </c:if>>Price(high to low)</option>
            <option value="4" <c:if test="${requestScope.sortMethod eq '4'}"> selected="selected" </c:if>>Most collected</option>
        </select>
    </div>

    <div class="operation" >
        <button name="create" id="create">Create</button>
        <button name="deleteSelected" id="deleteSelected">Delete Selected Items</button>
    </div>


    <table id="product_table" cellspacing="0">
        <thead>
            <tr>
                <td>Product ID</td>
                <td>Product Name</td>
                <td>Price</td>
                <td>Category</td>
                <td>Availability</td>
                <td>Selling Date</td>
                <td>Collection Times</td>
                <td>Operation</td>
            </tr>
        </thead>
        <tbody>
             <c:forEach items="${productList}" var="product" varStatus="status">
                 <c:choose>
                     <c:when test = "${product.cid == 1}">
                         <c:set var="category" value="Activities & Games"/>
                     </c:when>

                     <c:when test = "${product.cid == 2}">
                         <c:set var="category" value="Art & Culture"/>
                     </c:when>

                     <c:when test = "${product.cid == 3}">
                         <c:set var="category" value="At Home"/>
                     </c:when>

                     <c:otherwise>
                         <c:set var="category" value="Trips"/>
                     </c:otherwise>
                 </c:choose>
                 <tr>
                     <td>${product.ticketID}</td>
                     <td>${product.ticketName}</td>
                     <td>${product.price}</td>
                     <td>${category}</td>
                     <td>${product.tFlag}</td>
                     <td>${product.tDate}</td>
                     <td>${product.collect}</td>
                     <td>
                         <button name="update" id="update_${status.index+1}" value="${product.ticketID}">Update</button>

                         <c:if test="${product.tFlag.equals('true')}">
                             <button name="status" id="status_${status.index+1}" value="${product.ticketID}">Sold out</button>
                         </c:if>
                        <c:if test="${product.tFlag.equals('false')}">
                            <button class="status" name="status" id="status_${status.index+1}" value="${product.ticketID}">Replenish</button>
                        </c:if>
                         <button name="delete" id="delete_${status.index+1}" value="${product.ticketID}">Delete</button>
                     </td>
                 </tr>
             </c:forEach>
        </tbody>
    </table>
</div>

<script>

    var create_btn = document.getElementById("create");

    create_btn.onclick = function (){
        window.location.href = "http://localhost:8080/FinalProject/toAddProduct.htm";

    }

    var deleteItem_btn = document.getElementsByName("delete");
    var updateItem_btn = document.getElementsByName("update");
    var status_btn = document.getElementsByName("status");

    for(var i = 0; i < deleteItem_btn.length;i++){
        deleteItem_btn[i].onclick = function (){
            var flag = confirm('Are you sure to delete this product?');
            if(flag){
                window.location.href = "http://localhost:8080/FinalProject/deleteProduct.htm?productID="+this.value;
            }else{
                return false;
            }

        }
        updateItem_btn[i].onclick = function(){
            window.location.href = "http://localhost:8080/FinalProject/toUpdateProduct.htm?productID="+this.value;
        }
        status_btn[i].onclick = function(){
            window.location.href = "http://localhost:8080/FinalProject/changeAvailability.htm?productID="+this.value;
        }
    }
</script>

</body>
</html>
