<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 3/31/2021
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script>
    function changeBackColor_over(div){
        $(div).css("background-color","#CCCCCC");
    }

    function changeBackColor_out(div){
        $(div).css("background-color","");
    }

    function setSearch_onclick(div){
        $("#search_input").val(div.innerText);
        $("#autoComplete").css("display","none");
    }
    $(function (){

       /* $("#search_input").blur(function (){
            $("#autoComplete").css("display","none");
        })*/

        $("#search_input").keyup(function (){
            var content = $(this).val();
            if(content === ""){
                $("#autoComplete").css("display","none");
                return;
            }

            var time = new Date().getTime();
            $.ajax({
                type:"get",
                url:"http://localhost:8080/FinalProject/findEventsAjax.htm",
                data:{keyword:content, time:time},
                success:function (data){
                    var res = data.split(",");
                    var html = "";
                    for(var i = 0; i < res.length;i++){
                        html+="<div onclick='setSearch_onclick(this)' onmouseout='changeBackColor_out(this)' onmouseover='changeBackColor_over(this)'>"+res[i]+"</div>";

                    }
                    $("#autoComplete").html(html);
                    $("#autoComplete").css("display","block");
                }
            });
        });
    });
</script>
<style>
    #autoComplete{
        background-color:white;
        border: 1px solid #ffc900;
        width:500px;
        height: 300px;
        position: absolute;
        display: none;
        margin-top: 50px;
        font-size: 16px;
        padding-top: 10px;
        padding-left: 10px;
        z-index: 10;
        overflow: hidden;

    }
</style>

<link rel="stylesheet" type="text/css" href="css/common.css" />
<header id="header">

    <div class="shortcut">
        <!-- Logout  -->
     <c:if test="${ sessionScope.currentUser==null }">
        <div class="login_out">
            <a href="toAdminLogin.htm">I'm Staff</a>
            <a href="toLogin.htm">Sign in</a>
            <a href="toSignup.htm">Sign up</a>
        </div>
     </c:if>
        <!-- Login  -->
     <c:if test="${ sessionScope.currentUser!=null }">
        <div class="login">
            <span id="span_username">Welcome ${sessionScope.currentUser.uname}</span>
            <a href="toMyFavorite.htm?userID=${sessionScope.currentUser.userID}" class="collection">My Favorites</a>
            <a href="toLogout.htm">Logout</a>
            <a href="toCenter.htm" class="account">My Account</a>
           <%-- <a href="toCart.htm" class="cart">My Cart</a>--%>
        </div>
     </c:if>
    </div>
    <div class="header_wrap">
        <div class="top_bar">
            <div class="logo">
                <a href="toHome.htm"><img src="images/logo.png" alt=""></a>
            </div>
            <div class="search">
                <form action="keywordSearch.htm" method="post">
                    <input name="keyword_search" id="search_input"  type="text" placeholder="Things to do in Boston" class="search_input" autocomplete="off">
                    <input type="submit" class="search-button" name="search_btn" value="Search">
                </form>
                <div id="autoComplete"></div>
            </div>

            <div class="hot_tel">
                <p class="hot_time">Customer Service(9:00 A.M.-6:00 P.M.)</p>
                <p class="hot_num">617-258-8080</p>
            </div>
        </div>
    </div>
</header>
<!-- 头部 end -->
<!-- 首页导航 -->
<div class="navitem">
    <ul id="category" class="nav">
        <li <c:if test="${requestScope.currentPage eq 'home'}"> class="nav-active" </c:if> ><a href="toHome.htm">Home</a></li>
        <li <c:if test="${requestScope.currentPage eq 'tickets'}"> class="nav-active" </c:if> ><a href="toTickets.htm">Tickets</a></li>
        <li <c:if test="${requestScope.currentPage eq 'restaurants'}"> class="nav-active" </c:if>><a href="toRestaurants.htm">Restaurants</a></li>
        <li <c:if test="${requestScope.currentPage eq 'trips'}"> class="nav-active" </c:if>><a href="toTrips.htm">Trips</a></li>
        <li <c:if test="${requestScope.currentPage eq 'trends'}"> class="nav-active" </c:if>><a href="toTrends.htm">Trends near you</a></li>
    </ul>
</div>
