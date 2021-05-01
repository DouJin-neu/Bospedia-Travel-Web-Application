<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/3/2021
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success!</title>
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/placeOrder_success.css" />
</head>
<body>
<jsp:include page="../customer/header.jsp"/>
<div class="success_layout">
    <div class="orderInfo">
        <c:if test="${order.orderCategory == 1}">
            <span >Reserved Successfully!<br/> Thank You for Your Ordering!</span>
            <table id="orderTable">
                <tr>
                    <td>
                        Selected Date:
                    </td>
                    <td>
                            ${order.selectedDate}
                    </td>
                </tr>
                <tr>
                    <td>
                        Selected Time:
                    </td>
                    <td>
                            ${order.selectedTime}
                    </td>
                </tr>
                <tr>
                    <td>
                        Party of
                    </td>
                    <td>
                            ${order.party}

                    </td>
                </tr>
                <tr>
                    <td>
                        Contact:
                    </td>
                    <td>
                            ${order.contact}
                    </td>
                </tr>
            </table>

        </c:if>

        <c:if test="${order.orderCategory == 2}">
            <span >Order Placed Successfully!<br/> Thank You for Your Ordering!</span>
            <table id="orderTable">
                <tr>
                    <td>
                        Selected Date:
                    </td>
                    <td>
                            ${order.selectedDate}
                    </td>
                </tr>
                <tr>
                    <td>
                        Selected Time:
                    </td>
                    <td>
                            ${order.selectedTime}
                    </td>
                </tr>
                <tr>
                    <td>
                        Amount:
                    </td>
                    <td>
                            ${order.itemAmount}

                    </td>
                </tr>
                <tr>
                    <td>
                        Total Price:
                    </td>
                    <td>
                            ${order.totalPrice}
                    </td>
                </tr>
            </table>

        </c:if>


        <a href="toHome.htm">Click here to go to Home Page</a>
    </div>
</div>
<!--引入尾部-->
<jsp:include page="../customer/footer.jsp"/>

</body>
</html>
