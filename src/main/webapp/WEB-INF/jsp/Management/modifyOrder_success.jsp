<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/13/2021
  Time: 11:52 AM
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
    <h1>Order NO.${modifiedOrder.orderID} Updated Successfully</h1>
    <table>
            <tr>
                <td>Order ID</td>
                <td>${modifiedOrder.orderID}</td>
            </tr>
            <tr>
                <td>Item ID</td>
                <td>${modifiedOrder.itemID}</td>
            </tr>
            <tr>
                <td>User ID</td>
                <td>${modifiedOrder.userID}</td>
            </tr>
            <tr>
                <td>Category</td>
                <td>${modifiedOrder.orderCategory}</td>
            </tr>
            <tr>
                <td>Selected Date</td>
                <td>${modifiedOrder.selectedDate}</td>
            </tr>
            <tr>
                <td>Selected Time</td>
                <td>${modifiedOrder.selectedTime}</td>
            </tr>
            <tr>
                <td>Item Amount</td>
                <td>${modifiedOrder.itemAmount}</td>
            </tr>
            <tr>
                <td>Party</td>
                <td>${modifiedOrder.party}</td>
            </tr>
            <tr>
                <td>Total Price</td>
                <td>${modifiedOrder.totalPrice}</td>
            </tr>
            <tr>
                <td>Contact</td>
                <td>${modifiedOrder.contact}</td>
            </tr>
            <tr>
                <td>Order Status</td>
                <td>${modifiedOrder.orderStatus}</td>
            </tr>
            <tr>
                <td>Order Date</td>
                <td>${modifiedOrder.orderDate}</td>
            </tr>
            <tr>
                <td>Modified Date</td>
                <td>${modifiedOrder.modifyDate}</td>
            </tr>
    </table>

    <a href="toOrderListView.htm">Click here to see all orders</a>

</div>
</body>
</html>
