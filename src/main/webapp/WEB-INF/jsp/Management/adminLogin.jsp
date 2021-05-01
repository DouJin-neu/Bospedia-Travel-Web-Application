<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/10/2021
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login</title>
    <style>
        .errorMessage{
            color: red;
            font-size: 14px;
        }
    </style>
</head>
<body>
<h1 align="center">${message}</h1>
<div class="content" style="alignment: center">
    <form action="adminLogin.htm" method="post">
        <table align="center">
            <tr>
                <td>
                    Email
                </td>
                <td>
                    <input type="text" name="admin_email" style="border: 1px solid black;">
                </td>
            </tr>
            <tr>
                <td>
                    Password
                </td>
                <td>
                    <input type="password" name="admin_pwd" style="border: 1px solid black;">
                </td>
            </tr>
            <tr>
                <td>

                </td>
                <td>
                    <input type="submit" name="submit" value="Login">
                </td>
            </tr>
            <tr>
                <td>
                    <div class="errorMessage">
                        ${requestScope.errorMsg}
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <a href="toHome.htm" style="alignment: center">Click here to go to home page</a>
                </td>
            </tr>

        </table>
    </form>


</div>




</body>
</html>
