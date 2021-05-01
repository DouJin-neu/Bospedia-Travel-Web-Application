<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/12/2021
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Management System:Update</title>
</head>
<body>
<jsp:include page="nav.jsp"/>

<div class="pl_content">

    <form action="updateUser.htm" method="post">
        <c:choose>
            <c:when test = "${user.role == 0}">
                <c:set var="userRole" value="Customer"/>
            </c:when>

            <c:when test = "${user.role == 1}">
                <c:set var="userRole" value="Administrator"/>
            </c:when>

            <c:when test = "${user.role == 2}">
                <c:set var="userRole" value="Employee"/>
            </c:when>
        </c:choose>
        <table >
            <tr>
                <td>User ID:</td>
                <td>${user.userID}</td>
            </tr>
            <tr>
                <td>User Name:</td>
                <td>${user.uname}</td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" id="password" value="${user.password}"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>
                    <input type="text" name="email" id="email" value="${user.email}">
                </td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td> <input type="text" name="phone" id="phone" value="${user.phone}"></td>
            </tr>
            <tr>
                <td>Birthday</td>
                <td>${user.birthday}</td>
            </tr>
           <tr>
                <td>Sex:</td>
                <td>
                    ${user.sex}
                </td>
            </tr>
            <tr>
                <td>User Role: </td>
                <td>
                    <select name="role" id="role" >
                        <option>${userRole}</option>
                        <option value="0">0 -customer</option>
                        <option value="1">1 -administrator</option>
                        <option value="2">2 -employee</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Account Create Time</td>
                <td>${user.createTime}</td>
            </tr>
            <tr>
                <td>Account Modify Time</td>
                <td>${user.updateTime}</td>
            </tr>
            <tr>
                <input type="submit" name="update" value="Update">
                <input type="hidden" name="userID" value="${user.userID}">
            </tr>

        </table>

    </form>
</div>

</body>
</html>
