<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 3/31/2021
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <!--导入jquery-->
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>

    <script>

        $(function() {

            $('#username').blur(function () {
                checkUsername();
            });

            $('#password').blur(checkPassword);
            $('#email').blur(checkEmail);
            $('#password').focus(function () {
                $('#password').css("border", "1px solid black")
                $('#password').next().hide()
            })
            $('#username').focus(function () {
                $('#username').css("border", "1px solid black")
                $('#username').next().hide()
            })
            $('#email').focus(function () {
                $('#email').css("border", "1px solid black")
                $('#email').next().hide()
            })
            $('#phone').focus(function () {
                $('#phone').css("border", "1px solid black")
                $('#phone').next().hide()
            })

            //校验用户名
            //单词字符，长度8到20位
            function checkUsername() {
                //1.获取用户名值
                var username = $('#username').val();
                //2.定义正则
                var reg_username = /^\w{6,20}$/;

                if(username === ''){
                    $("#username").css("border", "1px solid red");
                    $("#username").next().show().html('this is a required field.');
                    $("#submit").attr("disabled","disabled");
                    return false;
                }else{
                    //3.判断，给出提示信息
                    var flag = reg_username.test(username);
                    if (flag) {
                        //用户名合法
                        $("#username").css("border","1px solid green");
                        $("#submit").removeAttr("disabled");
                    } else {
                        //用户名非法,加一个红色边框
                        $("#username").css("border", "1px solid red");
                        $("#username").next().show().html('User name should has 8 - 20 letters.');
                        $("#submit").attr("disabled","disabled");
                    }
                }


                return flag;
            }

            //校验密码
            function checkPassword() {
                //1.获取密码值
                var password = $("#password").val();
                //2.定义正则
                var reg_password = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;

                if(password == ''){
                    $("#password").css("border", "1px solid red");
                    $("#password").next().show().html('this is a required field.');
                    $("#submit").attr("disabled","disabled");
                   return false;
                }else{

                //3.判断，给出提示信息
                var flag = reg_password.test(password);
                if (flag) {
                    //密码合法
                    $("#password").css("border","1px solid green");
                    $("#submit").removeAttr("disabled");
                } else {
                    //密码非法,加一个红色边框
                    $("#password").css("border", "1px solid red");
                    $("#password").next().show().html('Use between 6 and 20 characters and digits');
                    $("#submit").attr("disabled","disabled");
                }
            }
                return flag;
            }

            //校验邮箱
            function checkEmail() {
                //1.获取邮箱
                var email = $("#email").val();
                //2.定义正则		itcast@163.com
                var reg_email = /^\w+@\w+\.\w+$/;

                if(email == ''){
                    $("#email").css("border", "1px solid red");
                    $("#email").next().show().html('this is a required field.');
                    return false;
                } else{
                    var flag = reg_email.test(email);
                    if (flag) {
                       $.ajax({
                           type: "GET",
                           url: "http://localhost:8080/FinalProject/userExist.htm",
                           data:{
                               "email":email
                           },
                           success:function (data){

                               if(data === "1"){
                                   $("#email").next().show().html('User already existed.');
                                   $("#submit").attr("disabled","disabled");
                               }else{
                                   $("#email").css("border","1px solid green");
                                   $("#submit").removeAttr("disabled");
                               }
                           }
                       })
                    } else {
                        $("#email").css("border", "1px solid red");
                        $("#email").next().show().html('Wrong email format');
                        $("#email").next().css("display","inline");
                    }
                }
                //3.判断
                console.log(flag);
                return flag;
            }

            $('#submit').click(function(){
                submit()
            });

            function submit() {
                var result = false;
                if(checkUsername() && checkPassword() && checkEmail()) {
                    $.ajax({
                        type: 'post',
                        url: 'http://localhost:8080/FinalProject/registration.htm',
                        data: $('#registerForm').serialize(),
                        async: false,
                        success: function (status) {
                            alert(status);
                            result = true;
                            alert('Registration success!')
                            window.location.href="http://localhost:8080/FinalProject/toHome.htm";
                        },
                        error: function (request) {
                            $("#errorMsg").show().html('Registration failed');
                            result = false;
                        }

                    })
                    return result;
                }
            }

        })
    </script>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/register.css" />
    <style>
        .error_tip{
            color: red;
            font-size: 12px;
            margin-left: 50px;
        }
        #eye{
            width: 25px;
            height: 25px;
            display: inline;
            float: right;
            margin-top: 5px;
        }
    </style>
</head>

<body>
<!--include header.jsp -->
<jsp:include page="../customer/header.jsp"/>

<div class="rg_layout">
    <div class="rg_form clearfix">
        <div class="rg_form_left">
            <p>USER REGISTER</p>
        </div>
        <div class="rg_form_center">
            <form id="registerForm" onsubmit="return false" action="#" method="post">

                <input type="hidden" name="action" value="Sign-up">
                <table style="margin-top: 25px;">
                    <tr>
                        <td class="td_left">
                            <label for="username">User Name</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="username" name="username" placeholder="Please enter username">
                            <span class="error_tip" style="color:red; display: none"> </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="password">Password</label>
                        </td>
                        <td class="td_right">
                            <img src="images/close.png" alt="" id="eye">
                            <input type="password" id="password" name="password" placeholder="Please enter password">
                            <span class="error_tip" style="color:red; display: none"> </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="email">Email</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="email" name="email" placeholder="Please enter your Email">
                            <span class="error_tip" style="color:red; display: none"> </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="name">Name</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="name" name="name" placeholder="Please enter your Full Name">
                            <span class="error_tip" style="color:red; display: none"> </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="telephone">Phone Number</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="telephone" name="telephone" placeholder="Please enter your phone number">
                            <span class="error_tip" style="color:red; display: none"> </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="sex">Sex</label>
                        </td>
                        <td class="td_right gender">
                            <input type="radio" id="sex" name="sex" value="Male" checked> Male
                            <input type="radio" name="sex" value="Female"> Female
                            <span class="error_tip" style="color:red; display: none"> </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="birthday">Date of Birth</label>
                        </td>
                        <td class="td_right">
                            <input type="date" id="birthday" name="birthday" placeholder="dd/MM/yy">
                            <span class="error_tip" style="color:red; display: none"> </span>
                        </td>
                    </tr>
                   <tr>
                        <td class="td_left">
                        </td>
                        <td class="td_right check">
                            <input type="button" class="submit" id="submit" value="Create Free Account" onclick="submit()"/>
                            <span id="errorMsg" style="color: red;"></span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="rg_form_right">
            <p>
                Already have an account?
                <a href="toLogin.htm">Login</a>
            </p>
        </div>
    </div>
    <script>

        var eye = document.getElementById('eye');
        var password = document.getElementById('password');

        var flag = 0;

        eye.onclick = function(){
            if(flag == 0){
                password.type='text';
                eye.src = 'images/open.png';
                flag = 1;
            }else{
                password.type='password';
                eye.src = 'images/close.png';
                flag = 0;
            }
        }

    </script>
</div>
<!--include -->
<jsp:include page="../customer/footer.jsp"/>
</body>
</html>
