<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/23/2021
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="css/userCenter.css" />
    <style>
        .user_info_right div{
            float: left;
            font-size: 16px;
        }
    </style>
</head>
<body>
<jsp:include page="../customer/header.jsp"/>

<div class="user_info_content">
    <!--用户中心左侧菜单-->
    <ul class="userinfo_left">
        <li ><a href="http://localhost:8080/FinalProject/infoView.htm">Personal Information</a></li>
        <li><a href="http://localhost:8080/FinalProject/updateView.htm">Update My Info</a></li>
        <li class="active" ><a href="http://localhost:8080/FinalProject/toOrderHistory.htm">Order History</a></li>
    </ul>
    <div class="subContent">

        <div class="user_info_right">

            <c:if test="${requestScope.order.orderCategory == '1'}">
                <div>
                    <img src="${restaurant.timage}" style="height: 250px">
                </div>
                <div>
                    <ul>
                        <li>
                            Restaurant: ${restaurant.restaurantName}
                        </li>
                        <li>
                            Time: ${requestScope.order.selectedTime},${requestScope.order.selectedDate}
                        </li>
                        <li>${requestScope.order.party} People</li>
                        <li>Restaurant Address: ${restaurant.address}</li>
                        <li>Restaurant Contact: ${restaurant.contact}</li>
                        <li><a href="toOrderHistory.htm">Go back</a></li>
                    </ul>
                </div>
            </c:if>
            <c:if test="${requestScope.order.orderCategory == '2'}">
                <div>
                    <img src="${ticket.timage}" style="height: 250px">
                </div>
                <div>
                    <ul>
                        <li>
                            Event Name: ${ticket.ticketName}
                        </li>
                        <li>
                            Time: ${requestScope.order.selectedTime},${requestScope.order.selectedDate}
                        </li>
                        <li>${requestScope.order.itemAmount} tickets</li>
                        <li>Total Price: ${requestScope.order.totalPrice}</li>
                        <li><a href="toOrderHistory.htm">Go back</a></li>
                    </ul>
                </div>
            </c:if>


        </div>
    </div>
</div>
<jsp:include page="../customer/footer.jsp"/>
</body>
</html>
