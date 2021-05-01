<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/6/2021
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Favorite</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/favorite.css" />
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>


        $(document).ready(function (){

            var deleteItem_btn = document.getElementsByName("remove");

            for(var i = 0; i < deleteItem_btn.length;i++){

                deleteItem_btn[i].onclick = function (){
                    var flag = confirm('Are you sure to remove this from favorite?');

                    if(flag){
                        submit();

                    }else{
                        return false;
                    }
                }
            }

            function submit() {
                var result = false;

                $.ajax({
                    type: 'post',
                    url: 'http://localhost:8080/FinalProject/cancelFavorite.htm',
                    data: $('#removeForm').serialize(),
                    async: false,
                    success: function (status) {
                        alert(status);
                        result = true;
                        alert('Remove success!')
                        window.location.href="http://localhost:8080/FinalProject/toMyFavorite.htm";
                    },
                    error: function (request) {
                        $("#errorMsg").show().html('Remove failed');
                        result = false;
                    }

                })
                return result;

            }
        });

    </script>

</head>
<body>
<jsp:include page="../customer/header.jsp"/>
<div class="favorite_title">
    <p>My next experience</p>
</div>
<div class="search_bar">
        <table id="filter_table">
            <tr>
                <form action="filterFavorite.htm" method="post" id="filter_form">

                    <label for="favorite_search_keyword" > Keywords:</label>
                    <input type="text" name="favorite_search_keyword" id="favorite_search_keyword">

                    <label for="minPrice" >Price </label>
                    <input type="text" name="minPrice" id="minPrice">
                    <label for="maxPrice" >&nbsp~ </label>
                    <input type="text" name="maxPrice" id="maxPrice">
                    <input type="submit" name="search" value="Search" id="submit"/>
                    <input type="hidden" name="userID", value="${sessionScope.currentUser.userID}">
                </form>


                <label for="sortMethod" style="margin-left: 50px">Sort</label>

                <select name="sortMethod" id="sortMethod" onchange="javascript:location.href='/FinalProject/sortFavorite.htm?userID=${sessionScope.currentUser.userID}&sortMethod='+this.value">
                    <option value="0">-Default-</option>
                    <option value="1" <c:if test="${requestScope.sortMethod eq '1'}"> selected="selected" </c:if>>Collected Date(latest)</option>
                    <option value="2" <c:if test="${requestScope.sortMethod eq '2'}"> selected="selected" </c:if>>Price(low to high)</option>
                    <option value="3" <c:if test="${requestScope.sortMethod eq '3'}"> selected="selected" </c:if>>Price(high to low)</option>
                    <option value="4" <c:if test="${requestScope.sortMethod eq '4'}"> selected="selected" </c:if>>Most collected</option>
                </select>

            </tr>
        </table>
</div>

<div class="result_content">
    <c:if test="${favoriteList.size() == 0}">
        <div style="height: 250px;width: 300px; margin-left: 400px; color: white">
            <span style="font-size: 24px; font-weight: bold;">You don't collect any event</span><br/>
            <a href="toHome.htm" style="font-size: 14px;color: wheat">click here to explore more in Boston</a>
        </div>

    </c:if>
    <table id="favorite_table" >
        <tr>
            <c:forEach items="${favoriteList}" var="favorite" varStatus="status">
            <c:if test="${favorite.restaurantID == 0}">
                <td id="table_div">
                    <div class="result_item">
                        <img src="${favorite.ticket.timage}" alt="">
                        <span id="ticketName">${favorite.ticket.ticketName}</span>
                        <c:if test="${favorite.ticket.cid == 4}">
                            <a href="tripDetail.htm?ticketID=${favorite.ticketID}">View Details</a>
                        </c:if>
                        <c:if test="${favorite.ticket.cid != 4}">
                            <span id="ticketPrice"> Price：$${favorite.ticket.price}</span>
                            <a href="ticketDetail.htm?ticketID=${favorite.ticketID}">View Details</a>
                        </c:if>
                        <%--<a href="cancelFavorite.htm?ticketID=${favorite.ticketID}&userID=${favorite.userID}">Remove</a>--%>
                        <form id="removeForm" method="post" action="#" onsubmit="return false">
                            <input type="hidden" name="userID" value="${favorite.userID}"/>
                            <input type="hidden" name="ticketID" value="${favorite.ticketID}"/>
                            <input type="button" class="remove_btn" name="remove" value="Remove Favorite"/>
                        </form>

                    </div>
                </td>
            </c:if>
            <c:if test="${favorite.ticketID == 0}">
                <td id="table_div">
                    <div class="result_item">

                        <img src="${favorite.restaurant.timage}" alt="">
                        <h2>${favorite.restaurant.restaurantName}</h2>
                        <span> Price：$${favorite.restaurant.average_price}</span>
                        <c:set var="rCategory" value="${favorite.restaurant.rCategory}"/>
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
                        <a href="restaurantDetail.htm?restaurantID=${favorite.restaurant.restaurantID}">View Details</a>
                        <form id="removeForm" method="post" action="#" onsubmit="return false">
                            <input type="hidden" name="userID" value="${favorite.userID}"/>
                            <input type="hidden" name="restaurantID" value="${favorite.restaurantID}"/>
                            <input type="button" name="remove" value="Remove Favorite" />
                        </form>

                       <%-- <a href="cancelFavorite.htm?restaurantID=${favorite.restaurantID}&userID=${favorite.userID}">Cancel Favorite</a>--%>
                    </div>
                </td>
            </c:if>
            <c:if test="${status.count % 3 == 0 && status.count != fn:length(favoriteList)}">
        </tr>
        <tr>
            </c:if>
            </c:forEach>
        </tr>
    </table>
</div>


<jsp:include page="../customer/footer.jsp"/>
</body>
</html>
