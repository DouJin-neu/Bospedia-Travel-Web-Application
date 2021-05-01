<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/11/2021
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="pl_content">
    <h1>User ID:${newUser.userID} Account Created Successfully</h1>
    <c:choose>
        <c:when test = "${newUser.role == 0}">
            <c:set var="userRole" value="Customer"/>
        </c:when>

        <c:when test = "${newUser.role == 1}">
            <c:set var="userRole" value="Administrator"/>
        </c:when>

        <c:when test = "${newUser.role == 2}">
            <c:set var="userRole" value="Employee"/>
        </c:when>
    </c:choose>

    <table>
        <tr>
            <td>User ID</td>
            <td>${newUser.userID}</td>
        </tr>
        <tr>
            <td>User Name</td>
            <td>${newUser.uname}</td>
        </tr>
        <tr>
            <td>Password</td>
            <td>${newUser.password}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${newUser.email}</td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td>${newUser.phone}</td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td>${newUser.birthday}</td>
        </tr>
        <tr>
            <td>Sex</td>
            <td>${newUser.sex}</td>
        </tr>
        <tr>
            <td>Role</td>
            <td>${userRole}</td>
        </tr>
        <tr>
            <td>Account Create Time</td>
            <td>${newUser.createTime}</td>
        </tr>
        <tr>
            <td>Account Modify Time</td>
            <td>${newUser.updateTime}</td>
        </tr>
    </table>

    <a href="toUserListView.htm">Click here to see all users</a>

</div>


</body>
</html>
