<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Management System</title>
    <meta name="author" content="DeathGhost" />
    <link rel="stylesheet" href="css/management.css">

    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script>

        (function($){
            $(window).load(function(){

                $("a[rel='load-content']").click(function(e){
                    e.preventDefault();
                    var url=$(this).attr("href");
                    $.get(url,function(data){
                        $(".content .mCSB_container").append(data); //load new content inside .mCSB_container
                        //scroll-to appended content
                        $(".content").mCustomScrollbar("scrollTo","h2:last");
                    });
                });

                $(".content").delegate("a[href='top']","click",function(e){
                    e.preventDefault();
                    $(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
                });

            });
        })(jQuery);
    </script>
</head>
<body>
<header>
    <img src="images/logo.png"/>
    <span id="welcome">Welcome to Bospedia's Management System </span>
    <c:choose>
        <c:when test="${sessionScope.currentUser.role == 1}">
            <c:set var="role" value="admin"/>
        </c:when>
        <c:when test="${sessionScope.currentUser.role == 2}">
            <c:set var="role" value="employee"/>
        </c:when>
    </c:choose>
    <span id="welcomeUser">Welcome ${sessionScope.currentUser.uname}_${role}!</span>
    <ul class="rt_nav">
        <li><a href="toAdminHome.htm">Home Page</a></li>

        <li><a href="toLogout.htm">Logout</a></li>
    </ul>
</header>

<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
    <h2><a href="toAdminHome.htm">Home Page</a></h2>
    <ul>
        <li>
            <dl>
                <dt>All Products</dt>

                <dd><a href="productListView.htm" <c:if test="${requestScope.currentView == 0}"> class="active"</c:if>>Products List</a></dd>
                <dd><a href="toAddProduct.htm">Add Product</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>All Users</dt>
                <dd><a href="toUserListView.htm" <c:if test="${requestScope.currentView == 1}"> class="active"</c:if>>Users List</a></dd>
                <dd><a href="toAddUser.htm">Add Employee</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>All Orders</dt>
                <dd><a href="toOrderListView.htm" <c:if test="${requestScope.currentView == 2}"> class="active"</c:if> >Order List</a></dd>
            </dl>
        </li>



    </ul>
</aside>

</body>
</html>


