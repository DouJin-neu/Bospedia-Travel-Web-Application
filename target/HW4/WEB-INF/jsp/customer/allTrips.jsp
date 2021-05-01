<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/18/2021
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trips</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/resultPage.css" />
</head>
<body>
<jsp:include page="./header.jsp"/>

<div class="result_nav">
    <p id="keyword">Showing search results for "Trips".</p>
    <p id="resultAmount">${tripList.size()} events found</p>
</div>

<div class="main_content">

    <div class="search_bar">
        <form action="filter.htm" method="post" id="filter_form">
            <table id="filter_table">
                <tr>
                    <td>
                        <label for="sortMethod" style="margin-left: 50px">Sort</label>

                        <select name="sortMethod" id="sortMethod" onchange="javascript:location.href='/FinalProject/sortTickets.htm?sortMethod='+this.value">
                            <option value="0">-Default-</option>
                            <option value="1" <c:if test="${requestScope.sortMethod eq '1'}"> selected="selected" </c:if>>Newest Events</option>
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
                <c:forEach items="${tripList}" var="ticket" varStatus="status">
                    <td id="table_div">
                        <div class="result_item">
                            <div class="cover">
                                <h2>${ticket.ticketName}</h2>
                                <a href="tripDetail.htm?ticketID=${ticket.ticketID}">More Info</a>
                            </div>
                            <img src="${ticket.timage}" alt="">
                            <p> ${ticket.ticketName}</p>

                        </div>
                    </td>
                <c:if test="${status.count % 3 == 0 && status.count != fn:length(tripList)}">
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
