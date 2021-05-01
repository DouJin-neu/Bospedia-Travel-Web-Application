<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/11/2021
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Management System:Add Product</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

    <script>

        $(function() {

            $('#productName').blur(function () {
                checkProductName();
            });

            $('#price').blur(checkPrice);
            $('#sellingDate').blur(checkDate);
            $('#introduce').blur(checkIntroduce);


            $('#productName').focus(function () {
                $(this).css("border", "1px solid black")
                $(this).next().hide()
            })
            $('#price').focus(function () {
                $(this).css("border", "1px solid black")
                $(this).next().hide()
            })
            $('#sellingDate').focus(function () {
                $(this).css("border", "1px solid black")
                $(this).next().hide()
            })
            $('#introduce').focus(function () {
                $(this).css("border", "1px solid black")
                $(this).next().hide()
            })

            function checkProductName() {

                var productName = $('#productName').val();

                var reg_productName = /^([a-zA-Z]+\s)*[a-zA-Z]+$/;

                if(productName === ''){
                    $("#productName").css("border", "1px solid red");
                    $("#productName").next().show().html('this is a required field.');
                    $("#submit").attr("disabled","disabled");
                    return false;
                }else{

                    var flag = reg_productName.test(productName);
                    if (flag) {

                        $("#productName").css("border","1px solid green");
                        $("#submit").removeAttr("disabled");
                    } else {

                        $("#productName").css("border", "1px solid red");
                        $("#productName").next().show().html('Product name should not contains special characters.');
                        $("#submit").attr("disabled","disabled");
                    }
                }


                return flag;
            }


            function checkPrice() {

                var price = $("#price").val();

                var reg_price = /^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$/;

                if(price === ''){
                    $("#price").css("border", "1px solid red");
                    $("#price").next().show().html('this is a required field.');
                    $("#submit").attr("disabled","disabled");
                    return false;
                }else{


                    var flag = reg_price.test(price);
                    if (flag) {

                        $("#price").css("border","1px solid green");
                        $("#submit").removeAttr("disabled");
                    } else {

                        $("#price").css("border", "1px solid red");
                        $("#price").next().show().html('Price only contains digits');
                        $("#submit").attr("disabled","disabled");
                    }
                }
                return flag;
            }


            function checkDate() {

                var selectedDate = new Date($("#sellingDate").val());
                var currentDate = new Date();

                if(selectedDate < currentDate){
                    $("#sellingDate").css("border", "1px solid red");
                    $("#sellingDate").next().show().html('Date cannot before today, you need to select date again!');
                    $("#submit").attr("disabled","disabled");
                    return false;
                }

                return true;
            }


            function checkIntroduce(){
                var introduce = $("#introduce").val();
                if(introduce === ""){
                    $("#introduce").css("border", "1px solid red");
                    $("#introduce").next().show().html('Introduction cannot be null');
                    $("#submit").attr("disabled","disabled");
                    return false;
                }
                return true;
            }

            if(checkProductName() && checkDate() && checkIntroduce() && checkPrice()){
                $("#submit").removeAttr("disabled");

            }


        })
    </script>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="pl_content">
    <form action="addProduct.htm" method="post">

        <table >
            <tr>
                <td>Product Name:</td>
                <td> <input type="text" name="productName" id="productName">
                    <span class="error_tip" style="color:red;"> </span></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" id="price">
                    <span class="error_tip" style="color:red;"> </span></td>

            </tr>
            <tr>
                <td>Availability:</td>
                <td> <select id="availability" name="availability">
                         <option value="true">True</option>
                         <option value="false">False</option>
                     </select>
                    <span class="error_tip" style="color:red;"> </span>
                </td>

            </tr>
            <tr>
                <td>Selling Date:</td>
                <td> <input type="date" name="sellingDate" id="sellingDate">
                    <span class="error_tip" style="color:red; "> </span></td>

            </tr>
            <tr>
                <td>Collected Times:</td>
                <td><input type="text" name="collect" id="collect" value="0" disabled="disabled">
                </td>

            </tr>
            <tr>
                <td>Category:</td>
                <td>
                    <select id="category" name="category">
                        <option value="1">Activities & Games</option>
                        <option value="2">Art & Culture</option>
                        <option value="3">At Home</option>
                        <option value="4">Trips</option>
                    </select>
                    <span class="error_tip" style="color:red;"> </span>
                </td>

            </tr>
            <tr>
                <td>Image:</td>
                <td> <input type="file" name="image" id="image">
                    <span class="error_tip" style="color:red; "> </span>
                </td>
            </tr>
            <tr>
                <td>Introduce: </td>
                <td> <textarea name="introduce" id="introduce"></textarea>
                    <span class="error_tip" style="color:red;"> </span>
                </td>

            </tr>
            <tr>
                <input type="submit" name="add" value="Add" id="submit">
            </tr>
        </table>

    </form>
</div>
</body>
</html>
