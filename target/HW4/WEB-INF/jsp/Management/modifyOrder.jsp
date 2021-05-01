<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/12/2021
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Management System:Update</title>
</head>
<body>
<jsp:include page="nav.jsp"/>

<div class="pl_content">

    <form action="modifyOrders.htm" method="post">

        <table >
            <tr>
                <td>Order ID</td>
                <td>${order.orderID}</td>
            </tr>
            <tr>
                <td>Item ID</td>
                <td>${order.itemID}</td>
            </tr>
            <tr>
                <td>User ID</td>
                <td>${order.userID}</td>
            </tr>
            <tr>
                <td>Category</td>
                <td>${order.orderCategory}</td>
            </tr>
            <tr>
                <td>Selected Date</td>
                <td><input type="text" name="selectedDate" value="${order.selectedDate}"></td>
            </tr>
            <tr>
                <td>Selected Time</td>
                <td><input type="text" name="selectedTime" value="${order.selectedTime}"></td>
            </tr>
            <tr>
                <td>Item Amount</td>
                <td><input type="text" name="amount" value="${order.itemAmount}"></td>
            </tr>
            <tr>
                <td>Party</td>
                <td><input type="text" name="party" value="${order.party}"></td>
            </tr>
            <tr>
                <td>Total Price</td>
                <td>${order.totalPrice}</td>
            </tr>
            <tr>
                <td>Contact</td>
                <td><input type="text" name="contact" value="${order.contact}"></td>
            </tr>
            <tr>
                <td>Order Status</td>
                <td>
                    <select name="status" id="status">
                        <option>current: ${order.orderStatus}</option>
                        <option value="pending">Pending</option>
                        <option value="received">Received</option>
                        <option value="completed">Completed</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Order Date</td>
                <td>${order.orderDate}</td>
            </tr>
            <tr>
                <td>Modified Date</td>
                <td>${order.modifyDate}</td>
            </tr>
            <tr>
                <input type="submit" name="submit" value="Update">
                <input type="hidden" name="orderID" value="${order.orderID}">
            </tr>
        </table>
    </form>
</div>

</body>
</html>
