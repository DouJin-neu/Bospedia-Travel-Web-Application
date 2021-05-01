<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/13/2021
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Orders</title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="css/management.css" />
<jsp:include page="nav.jsp"/>
<div class="pl_content">

    <div class="filter">
        <form action="orderIDFilter.htm" method="post">
            <label for="orderID" >Order ID: </label>
            <input type="text" name="orderID" id="orderID"/>
            <input type="submit" name="search" value="Search"/>
        </form>
        <form action="searchByUserID.htm" method="post">

            <label for="userID" > User ID:</label>
            <input type="text" name="userID" id="userID">
            <input type="submit" name="search" value="Search"/>
        </form>

        <div class="selector">
        <label for="category" > Category: </label>
        <select id="category" name="category" onchange="javascript:location.href='/FinalProject/orderCategoryFilter.htm?category='+this.value">
            <option>-Select a category-</option>
            <option value="1" <c:if test="${requestScope.category eq '1'}"> selected="selected" </c:if>>Restaurant Reservation</option>
            <option value="2" <c:if test="${requestScope.category eq '2'}"> selected="selected" </c:if>>Ticket Booking</option>
        </select>

        <label for="orderStatus" > Order Status: </label>
        <select id="orderStatus" name="orderStatus" onchange="javascript:location.href='/FinalProject/orderStatusFilter.htm?orderStatus='+this.value">
            <option>-Select an order status-</option>
            <option value="pending" <c:if test="${requestScope.orderStatus eq 'pending'}"> selected="selected" </c:if>>Pending</option>
            <option value="received" <c:if test="${requestScope.orderStatus eq 'received'}"> selected="selected" </c:if>>Received</option>
            <option value="completed" <c:if test="${requestScope.orderStatus eq 'completed'}"> selected="selected" </c:if>>Completed</option>
        </select>

        <label for="orderStatus" > Sort: </label>
        <select name="sortMethod" id="sortMethod" onchange="javascript:location.href='/FinalProject/sortOrders.htm?sortMethod='+this.value">
            <option value="0">-Default-</option>
            <option value="1" <c:if test="${requestScope.sortMethod eq '1'}"> selected="selected" </c:if>>Latest Order</option>
            <option value="2" <c:if test="${requestScope.sortMethod eq '2'}"> selected="selected" </c:if>>Total Price(low to high)</option>
            <option value="3" <c:if test="${requestScope.sortMethod eq '3'}"> selected="selected" </c:if>>Total Price(high to low)</option>
        </select>
        </div>
    </div>

    <table id="order_table" cellspacing="0">
        <thead>
        <tr>
            <td>Order ID</td>
            <td>Item ID</td>
            <td>User ID</td>
            <td>User Name</td>
            <td>Category</td>
            <td>Selected Date</td>
            <td>Item Amount</td>
            <td>Party</td>
            <td>Total Price</td>
            <td>Contact</td>
            <td>Order Status</td>
            <td>Order Date</td>
            <td>Modified Date</td>
            <td>Operation</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orderList}" var="order" varStatus="status">
            <c:choose>
                <c:when test = "${order.orderCategory == 1}">
                    <c:set var="category" value="Restaurant Reservation"/>
                </c:when>

                <c:when test = "${order.orderCategory == 2}">
                    <c:set var="category" value="Ticket Booking"/>
                </c:when>
            </c:choose>
            <tr>
                <td>${order.orderID}</td>
                <td>${order.itemID}</td>
                <td>${order.user.userID}</td>
                <td>${order.user.uname}</td>
                <td>${category}</td>
                <td>${order.selectedDate} ${order.selectedTime}</td>
                <td>${order.itemAmount}</td>
                <td>${order.party}</td>
                <td>${order.totalPrice}</td>
                <td>${order.contact}</td>
                <td>${order.orderStatus}</td>
                <td>${order.orderDate}</td>
                <td>${order.modifyDate}</td>
                <td>
                    <button name="update" id="update_${status.index+1}" value="${order.orderID}">Update</button>

                    <button name="delete" id="delete_${status.index+1}" value="${order.orderID}">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script>

    var deleteItem_btn = document.getElementsByName("delete");
    var updateItem_btn = document.getElementsByName("update");

    for(var i = 0; i < deleteItem_btn.length;i++){
        deleteItem_btn[i].onclick = function (){
            var flag = confirm('Are you sure to delete this order?');
            if(flag){
                window.location.href = "http://localhost:8080/FinalProject/deleteOrder.htm?orderID="+this.value;
            }else{
                return false;
            }
        }

        updateItem_btn[i].onclick = function(){
            window.location.href = "http://localhost:8080/FinalProject/toModifyOrders.htm?orderID="+this.value;
        }
    }
</script>

</body>
</html>
