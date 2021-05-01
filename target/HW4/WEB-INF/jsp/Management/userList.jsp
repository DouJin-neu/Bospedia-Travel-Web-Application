<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/12/2021
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Management System:UserList</title>
    <link rel="stylesheet" type="text/css" href="css/management.css" />

</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="pl_content">

    <div class="filter">
        <form action="userIDFilter.htm" method="post">
            <label for="userID" >User ID: </label>
            <input type="text" name="userID" id="userID"/>
            <input type="submit" name="search" value="Search"/>
        </form>
        <form action="userNameFilter.htm" method="post">

            <label for="userName" > User Name:</label>
            <input type="text" name="userName" id="userName">
            <input type="submit" name="search" value="Search"/>
        </form>

        <label for="userRole" > User Role: </label>
        <select id="userRole" name="userRole" onchange="javascript:location.href='/FinalProject/userRoleFilter.htm?userRole='+this.value">
            <option>-Select a Role-</option>
            <option value="0" <c:if test="${requestScope.userRole eq '0'}"> selected="selected" </c:if>>Customer</option>
            <option value="1" <c:if test="${requestScope.userRole eq '1'}"> selected="selected" </c:if>>Administrator</option>
            <option value="2" <c:if test="${requestScope.userRole eq '2'}"> selected="selected" </c:if>>Employee</option>
        </select>
    </div>

    <div class="operation" style="height: 25px; width: 400px">
        <button name="create" id="create">Create</button>
        <button name="deleteSelected" id="deleteSelected">Delete Selected Users</button>
    </div>

    <table id="user_table" cellspacing="0">
        <thead>
        <tr>
            <td>User ID</td>
            <td>User Name</td>
            <td>Password</td>
            <td>Email</td>
            <td>Phone Number</td>
            <td>Birthday</td>
            <td>Sex</td>
            <td>Role</td>
            <td>Account Create Time</td>
            <td>Account Modify Time</td>
            <td>Operation</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user" varStatus="status">
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
            <tr>
                <td>${user.userID}</td>
                <td>${user.uname}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.birthday}</td>
                <td>${user.sex}</td>
                <td>${userRole}</td>
                <td>${user.createTime}</td>
                <td>${user.updateTime}</td>
                <td>
                    <button name="update" id="update_${status.index+1}" value="${user.userID}">Update</button>

                    <button name="delete" id="delete_${status.index+1}" value="${user.userID}">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    var create_btn = document.getElementById("create");

    create_btn.onclick = function (){
        window.location.href = "http://localhost:8080/FinalProject/toAddUser.htm";

    }

    var deleteItem_btn = document.getElementsByName("delete");
    var updateItem_btn = document.getElementsByName("update");

    for(var i = 0; i < deleteItem_btn.length;i++) {
        deleteItem_btn[i].onclick = function () {
            var flag = confirm('Are you sure to delete this user?');
            if (flag) {
                window.location.href = "http://localhost:8080/FinalProject/deleteUser.htm?userID=" + this.value;
            } else {
                return false;
            }
        }
        updateItem_btn[i].onclick = function () {
            window.location.href = "http://localhost:8080/FinalProject/toUpdateUser.htm?userID=" + this.value;
        }
    }
</script>

</body>
</html>
