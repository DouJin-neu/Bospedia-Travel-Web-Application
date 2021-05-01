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
    <p id="keyword">Showing search results for "Tickets".</p>
    <p id="resultAmount">${allTickets.size()} events found</p>
</div>

<div class="main_content">

    <div class="search_bar">
        <form action="filter.htm" method="post" id="filter_form">
            <table id="filter_table">
                <tr>
                    <td>
                        <label for="minPrice">Price </label>
                        <input type="text" name="minPrice" id="minPrice" value="${requestScope.minPrice}">
                        <label for="maxPrice">&nbsp~ </label>
                        <input type="text" name="maxPrice" id="maxPrice" value="${requestScope.maxPrice}">
                        <input type="hidden" name="category" value="ticket">
                    </td>
                    <td>
                        <input type="submit" name="submit" id="submit" value="Search"/>
                    </td>
                    <td>
                        <label for="sortMethod" style="margin-left: 50px">Sort</label>

                        <select name="sortMethod" id="sortMethod" onchange="javascript:location.href='/FinalProject/sortTickets.htm?sortMethod='+this.value">
                            <option value="0">-Default-</option>
                            <option value="1" <c:if test="${requestScope.sortMethod eq '1'}"> selected="selected" </c:if>>Newest Events</option>
                            <option value="2" <c:if test="${requestScope.sortMethod eq '2'}"> selected="selected" </c:if>>Price(low to high)</option>
                            <option value="3" <c:if test="${requestScope.sortMethod eq '3'}"> selected="selected" </c:if>>Price(high to low)</option>
                            <option value="4" <c:if test="${requestScope.sortMethod eq '4'}"> selected="selected" </c:if>>Most collected</option>
                        </select>

                    </td>

                </tr>
            </table>
        </form>
    </div>

    <div class="result_content">
        <table >
            <tr>
                <c:forEach items="${allTickets}" var="ticket" varStatus="status">

                    <td id="table_div">
                        <div class="result_item">
                            <div class="cover">
                                <h2>${ticket.ticketName}</h2>
                                <p> Price：$${ticket.price}</p>
                                <a href="ticketDetail.htm?ticketID=${ticket.ticketID}">More Info</a>
                            </div>
                            <img src="${ticket.timage}" alt="">
                            <p> ${ticket.ticketName}</p>

                        </div>
                    </td>
                    <c:if test="${status.count % 3 == 0 && status.count != fn:length(allTickets)}">
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
