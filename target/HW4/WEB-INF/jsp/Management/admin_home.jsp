<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/10/2021
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Management System: Home</title>
    <link rel="stylesheet" type="text/css" href="css/management.css" />
    <script>
        var errorMsg = "${errorMsg}";
        var flag = ${errorMsg == null};
        if(!flag){
            alert(errorMsg);

        }
    </script>
</head>
<body>
<jsp:include page="nav.jsp"/>

<section class="rt_wrap">
    <div class="rt_content">
        <img src="images/adminHomeBG.jpg" >

    </div>
</section>


</body>
</html>
