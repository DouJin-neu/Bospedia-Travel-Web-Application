<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 3/31/2021
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Successfully Signed Up</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/register.css" />
</head>
<body>
<jsp:include page="../customer/header.jsp"/>
<div class="rg_layout">
    <div style="alignment: center">
        <span style="font-weight: bold; font-size: x-large">Welcome to Bospedia!</span>
        <a href="toLogin.htm">Click here to login</a>
    </div>
</div>

<jsp:include page="../customer/footer.jsp"/>

</body>
</html>
