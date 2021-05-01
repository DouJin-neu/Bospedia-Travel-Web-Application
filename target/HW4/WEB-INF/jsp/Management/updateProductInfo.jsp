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
    <script>
        var errorMsg = "${requestScope.errorMsg}";
        var flag = ${requestScope.errorMsg == null};
        if(!flag){
            alert(errorMsg);

        }
    </script>
</head>
<body>
<jsp:include page="nav.jsp"/>

<div class="pl_content">

    <form action="updateProduct.htm" method="post">

        <table >
            <tr>
                <td>Product Name:</td>
                <td>${ticket.ticketName}</td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" id="price" value="${ticket.price}"></td>
            </tr>
            <tr>
                <td>Availability:</td>
                <td>
                <select id="availability" name="availability" >
                    <option selected="selected">current: ${ticket.tFlag}</option>
                    <option value="true">True</option>
                    <option value="false">False</option>
                </select>
                </td>
            </tr>
            <tr>
                <td>Selling Date:</td>
                <td> ${ticket.tDate}</td>
            </tr>
            <tr>
                <td>Collected Times:</td>
                <td>${ticket.collect}</td>
            </tr>
           <tr>
                <td>Category:</td>
                <td>
                    ${ticket.cid}
                </td>
            </tr>
            <tr>
                <td>Introduce: </td>
                <td> <textarea name="introduce" id="introduce">${ticket.tIntroduce}</textarea></td>
            </tr>
            <tr>
                <input type="submit" name="update" value="Update">
                <input type="hidden" name="productID" value="${ticket.ticketID}">
            </tr>
        </table>

    </form>
</div>

</body>
</html>
