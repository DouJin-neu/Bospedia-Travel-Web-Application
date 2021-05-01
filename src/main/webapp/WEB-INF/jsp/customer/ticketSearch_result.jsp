<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/4/2021
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tickets</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/resultPage.css" />
</head>
<body>
<jsp:include page="./header.jsp"/>

<div class="result_nav">
    <p id="keyword">Showing search results for "${requestScope.keyword}".</p>
    <p id="resultAmount">${ticketSearch_result.size()+requestScope.restaurantSearch_result.size()} events found</p>
</div>
<div class="main_content">

    <div class="search_bar">
        <form action="filter.htm" method="post" id="filter_form">
            <table id="filter_table">
                <tr>
                    <td>
                        <label for="minPrice">Price </label>
                        <input type="text" name="minPrice" id="minPrice">
                        <label for="maxPrice">&nbsp~ </label>
                        <input type="text" name="maxPrice" id="maxPrice">
                        <input type="hidden" name="category" value="ticket">
                    </td>
                    <td>
                        <input type="submit" name="submit" id="submit" value="Search"/>
                    </td>
                    <td>
                        <label for="sortMethod" style="margin-left: 50px">Sort</label>

                        <select name="sortMethod" id="sortMethod" onchange="javascript:location.href='/FinalProject/sortTickets.htm?sortMethod='+this.value">
                            <option value="1">Newest Events</option>
                            <option value="2">Price(low to high)</option>
                            <option value="3">Price(high to low)</option>
                            <option value="4">Most collected</option>
                        </select>

                    </td>

                </tr>
            </table>
        </form>
    </div>

    <div class="result_content">

        <c:if test="${ticketSearch_result.size() != 0}">

            <table>
                <tr>
                    <c:forEach items="${ticketSearch_result}" var="ticket" varStatus="status">
                        <c:if test="${ticket.tFlag.equals('true')}">
                        <td id="table_div">

                        <div class="result_item">
                            <div class="cover">
                                <h2>${ticket.ticketName}</h2>
                                <p> Price：$${ticket.price}</p>
                                <a href="ticketDetail.htm?ticketID=${ticket.ticketID}">More Info</a>
                            </div>
                            <img src="${ticket.timage}" alt="">
                            <p id="name"> ${ticket.ticketName}</p>
                        </div>
                        </td>
                             <c:if test="${status.count % 3 == 0 && status.count != fn:length(ticketSearch_result)}">
                            </tr>
                            <tr>
                            </c:if>
                        </c:if>
                    </c:forEach>
                       </tr>
            </table>
        </c:if>

        <c:if test="${requestScope.restaurantSearch_result.size() != 0}">
            <table>
                <tr>
                    <c:forEach items="${requestScope.restaurantSearch_result}" var="restaurant" varStatus="status">
                    <td id="table_div">

                        <div class="result_item">
                            <div class="cover">
                                <h2>${restaurant.restaurantName}</h2>
                                <p> Price：$${restaurant.average_price}</p>
                                <a href="restaurantDetail.htm?restaurantID=${restaurant.restaurantID}">More Info</a>
                            </div>
                            <img src="${restaurant.timage}" alt="">
                            <p id="rname"> ${restaurant.restaurantName}</p>
                        </div>
                    </td>
                    <c:if test="${status.count % 3 == 0 && status.count != fn:length(requestScope.restaurantSearch_result)}">
                </tr>
                <tr>
                    </c:if>
                    </c:forEach>
                </tr>
            </table>
        </c:if>

    </div>

</div>


<jsp:include page="./footer.jsp"/>

</body>
</html>