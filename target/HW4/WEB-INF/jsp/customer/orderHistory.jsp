<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/9/2021
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Account</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="css/userCenter.css" />
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

</head>

<style>
    th{
        background-color: lightgray;
    }

    td{
        height: 50px;
        width: 100px;
    }
</style>
<body>
<jsp:include page="../customer/header.jsp"/>

<div class="user_info_content">
    <!--用户中心左侧菜单-->
    <ul class="userinfo_left">
        <li  ><a href="http://localhost:8080/FinalProject/infoView.htm">Personal Information</a></li>
        <li><a href="http://localhost:8080/FinalProject/updateView.htm">Update My Info</a></li>
        <li class="active"><a href="http://localhost:8080/FinalProject/toOrderHistory.htm">Order History</a></li>
    </ul>
    <!--用户中心左侧菜单 end-->

    <div class="subContent">

        <%--order history--%>
        <div class="user_info_right">

            <table border="1" align="center">
                <tr>
                    <th >Order ID</th>
                    <th >Total Price</th>
                    <th >Order Date</th>
                    <th >Order Status</th>
                    <th>Operation</th>

                </tr>
            <c:forEach items="${orderHistory}" var="order">

                <c:if test="${order.orderCategory == 2}">
                <tr>
                    <td><c:out value="${order.orderID}"/></td>
                    <td><c:out value="${order.totalPrice}"/></td>
                    <td><c:out value="${order.orderDate}"/></td>
                    <td><c:out value="${order.orderStatus}"/></td>
                    <td>
                        <a href="getOrderDetail.htm?itemID=${order.itemID}&orderID=${order.orderID}&category=${order.orderCategory}">View Detail</a>
                        <c:if test="${order.orderStatus == 'completed'}">
                        <a href="report.htm?itemID=${order.itemID}&orderID=${order.orderID}">Print Ticket</a>
                        </c:if>
                    </td>
                </tr>
                </c:if>

                <c:if test="${order.orderCategory == 1}">
                        <tr>
                            <td><c:out value="${order.orderID}"/></td>
                            <td><c:out value="-"/></td>
                            <td><c:out value="${order.orderDate}"/></td>
                            <td><c:out value="${order.orderStatus}"/></td>
                            <td><a href="getOrderDetail.htm?itemID=${order.itemID}&orderID=${order.orderID}&category=${order.orderCategory}">View Detail</a> </td>
                        </tr>
                </c:if>

            </c:forEach>
            </table>

        </div>
    </div>
</div>


<jsp:include page="../customer/footer.jsp"/>

</body>
</html>