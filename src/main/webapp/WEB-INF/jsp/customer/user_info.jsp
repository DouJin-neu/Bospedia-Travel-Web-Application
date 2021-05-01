<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/3/1
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>My Account</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="css/userCenter.css" />
</head>
<body>
<jsp:include page="../customer/header.jsp"/>

    <div class="user_info_content">

        <ul class="userinfo_left">
            <li class="active" ><a href="http://localhost:8080/FinalProject/infoView.htm">Personal Information</a></li>
            <li><a href="http://localhost:8080/FinalProject/updateView.htm">Update My Info</a></li>
            <li><a href="http://localhost:8080/FinalProject/toOrderHistory.htm">Order History</a></li>
        </ul>


        <div class="subContent">

            <%--personal info--%>
                <div class="user_info_right">
                    <table>
                        <tr>
                            <td>User Name:</td>
                            <td>${sessionScope.currentUser.uname}</td>
                        </tr>
                        <tr>
                            <td>Sex: </td>
                            <td>${sessionScope.currentUser.sex}</td>
                        </tr>
                        <tr>
                            <td>Phone Number: </td>
                            <td>${sessionScope.currentUser.phone}</td>
                        </tr>
                        <tr>
                            <td>Email: </td>
                            <td>${sessionScope.currentUser.email}</td>
                        </tr>
                        <tr>
                            <td>Birthday: </td>
                            <td>${sessionScope.currentUser.birthday}</td>
                        </tr>
                    </table>

                </div>
        </div>

    </div>


<jsp:include page="../customer/footer.jsp"/>

</body>
</html>
