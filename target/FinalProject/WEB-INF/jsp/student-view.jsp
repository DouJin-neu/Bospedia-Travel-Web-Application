<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 3/17/2021
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student View</title>
</head>
<body>
First Name: ${requestScope.student.fname}
<br/>
Last Name: ${student.lname}
<br/>
NUID: ${student.id}
<br/>
Message: ${requestScope.msg}

</body>
</html>
