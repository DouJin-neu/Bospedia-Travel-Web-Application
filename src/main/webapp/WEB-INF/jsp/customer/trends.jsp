<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/5/2021
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trends</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/resultPage.css" />
</head>
<body>
<jsp:include page="./header.jsp"/>

<div class="result_nav">
    <p id="keyword">Showing search results for "Trends".</p>
    <c:set var="result" value="${trends.topRestaurants.size()+trends.topSellers.size()}"/>
    <p id="resultAmount">${result} results found</p>
</div>

<div class="main_content">

    <div class="result_content">

        <div class="top_title">
            <p >Top Sellers</p>
        </div>

        <table >
            <tr>
                <c:forEach items="${trends.topSellers}" var="ticket" varStatus="status">
                <td id="table_div">
                    <div class="result_item">
                        <div class="cover">
                            <h2>${ticket.ticketName}</h2>
                            <p> Price：${ticket.price}</p>
                            <a href="ticketDetail.htm?ticketID=${ticket.ticketID}">More Info</a>
                        </div>
                        <img src="${ticket.timage}" alt="">
                        <p> ${ticket.ticketName}</p>

                    </div>
                </td>
                <c:if test="${status.count % 3 == 0 && status.count != fn:length(topSellers)}">
            </tr>
            <tr>
                </c:if>
                </c:forEach>
            </tr>

        </table>

        <div class="top_title">
            <p >Top Restaurant</p>
        </div>
        <table >
            <tr>
                <c:forEach items="${trends.topRestaurants}" var="restaurant" varStatus="status">
                <td id="table_div">
                    <div class="result_item">
                        <div class="cover">
                            <h2>${restaurant.restaurantName}</h2>
                            <p> Price：${restaurant.average_price}</p>
                            <c:set var="rCategory" value="${restaurant.rCategory}"/>
                            <c:choose>
                                <c:when test="${rCategory == 1}">
                                    <p>Asian Foods</p>
                                </c:when>
                                <c:when test="${rCategory == 2}">
                                    <p>American Foods</p>
                                </c:when>
                                <c:when test="${rCategory == 3}">
                                    <p>Italian Foods</p>
                                </c:when>
                                <c:when test="${rCategory == 4}">
                                    <p>Brazilian Foods</p>
                                </c:when>
                                <c:when test="${rCategory == 5}">
                                    <p>French Foods</p>
                                </c:when>
                                <c:otherwise>
                                    <p>Null</p>
                                </c:otherwise>
                            </c:choose>


                            <a href="restaurantDetail.htm?restaurantID=${restaurant.restaurantID}">More Info</a>
                        </div>
                        <img src="${restaurant.timage}" alt="">
                        <p> ${restaurant.restaurantName}</p>

                    </div>
                </td>
                <c:if test="${status.count % 3 == 0 && status.count != fn:length(topRestaurants)}">
            </tr>
            <tr>
                </c:if>
                </c:forEach>
            </tr>

        </table>


    </div>

</div>


<jsp:include page="./footer.jsp"/>
</body>
</html>
