<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/4/2021
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/resultPage.css" />
</head>
<body>
<jsp:include page="./header.jsp"/>

<div class="result_nav">
    <p id="keyword">Showing search results for "Restaurants".</p>
    <p id="resultAmount">${allRestaurants.size()} restaurants found</p>
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
                        <input type="hidden" name="category" value="restaurant">
                    </td>
                    <td>
                        <input type="submit" name="submit" id="submit" value="Search"/>
                    </td>
                    <td>
                        <label for="sortMethod" style="margin-left: 50px">Sort</label>

                        <select name="sortMethod" id="sortMethod" onchange="javascript:location.href='/FinalProject/sortRestaurants.htm?sortMethod='+this.value">
                            <option value="0">-Default-</option>
                            <option value="1" <c:if test="${requestScope.sortMethod eq '1'}"> selected="selected" </c:if>>Display All</option>
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
        <table id="result_table" >
            <tr>
                <c:forEach items="${allRestaurants}" var="restaurant" varStatus="status">
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
                        <p>${restaurant.restaurantName}</p>
                    </div>
                </td>
                <c:if test="${status.count % 3 == 0 && status.count != fn:length(allRestaurants)}">
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
