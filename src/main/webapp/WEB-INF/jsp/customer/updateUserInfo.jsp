<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/1/2021
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>My Account</title>
    <meta charset="UTF-8">
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>

        $(document).ready(function(){

            var $userName = $("#user_name");
            var $password = $("#pwd");
            var $confirm_pwd = $("#confirm_pwd");
            var $phone = $("#phone");


            $password.focus(function () {
                $password.css("border", "1px solid black")
                $password.next().hide()
            })
            $confirm_pwd.focus(function () {
                $confirm_pwd.css("border", "1px solid black")
                $confirm_pwd.next().hide()
            })
            $userName.focus(function () {
                $userName.css("border", "1px solid black")
                $userName.next().hide()
            })
            $phone.focus(function () {
                $phone.css("border", "1px solid black")
                $phone.next().hide()
            })

            $userName.blur(function () {
                fnCheckUser();
            });

            $password.blur(function (){
                fnCheckPwd();
            });
            $confirm_pwd.blur(function (){
                fnCheckCpwd();
            });

            $phone.blur(function (){
                fnCheckPhone()
            });

            function fnCheckUser() {
                var username = $userName.val()

                var re = /^\w{6,20}$/;

                if (username === '') {
                    $userName.css("border", "1px solid red");
                    $userName.next().show().html('this is a required filed.')
                    return false;
                } else {
                    var flag = re.test(username);
                    if (flag) {
                        $userName.next().hide()

                    } else {
                        $userName.css("border", "1px solid red")
                        $userName.next().show().html('User name should contains 6-12 digits, characters.')

                    }

                }
                return flag;
            }


            function fnCheckPwd() {

                var pwd = $password.val()

                var rePass = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;

                if (pwd === '') {
                    $password.css("border", "1px solid red");
                    $password.next().show().html('this is a required field')
                    return false;
                } else {

                    var flag = rePass.test(pwd)
                    if (flag) {

                        $password.next().hide()
                    } else {

                        $password.css("border", "1px solid red")
                        $password.next().show().html('Password should contains 6-12 digits and characters')
                    }

                }
                return flag;
            }

            function fnCheckCpwd() {

                var confirm_pwd = $confirm_pwd.val()
                var pwd = $password.val()

                if (confirm_pwd === '') {
                    $confirm_pwd.css("border", "1px solid red");
                    $confirm_pwd.next().show().html('this.is a required filed')
                } else {
                    if (confirm_pwd === pwd) {
                        $confirm_pwd.next().hide();
                        return true;
                    } else {
                        $confirm_pwd.css("border", "1px solid red");
                        $confirm_pwd.next().show().html('Password not match, please try again')
                    }

                }
                return false;
            }


            function fnCheckPhone() {

                var phone = $phone.val()

                var rePhone = /^\d{10}$/;

                if (phone === '') {
                    $phone.css("border", "1px solid red");
                    $phone.next().show().html('this is a required filed')
                    return false;
                } else {
                    var flag = rePhone.test(phone);
                    if (flag) {

                        $phone.css("border", "");
                    } else {

                        $phone.css("border", "1px solid red");
                        $phone.next().show().html('Wrong format, your phone number should be 10 digits')
                    }

                }
                return flag;
            }

            var $sub_btn = $("#submit");

            $sub_btn.click(function () {
                updateUserInfo()
            });

            function updateUserInfo() {
                var result = false;
                if (fnCheckUser() && fnCheckPwd() && fnCheckCpwd() && fnCheckPhone()) {
                    $.ajax({
                        type: 'post',
                        url: 'http://localhost:8080/FinalProject/updateUserInfo.htm',
                        data: $("#updateUserInfoForm").serialize(),
                        async: false,
                        success: function (status) {
                            alert(status);
                            result = true;
                            alert('update success!')
                            window.location.href = "http://localhost:8080/FinalProject/toLogout.htm";
                        },
                        error: function (request) {
                            $("#errorMsg").show().html('Update failed');
                            $("#errorMsg").css("color", "red");
                            result = false;
                        }

                    })
                    return result;
                }
            }

        })
    </script>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="css/userCenter.css" />
</head>
<body>
<jsp:include page="../customer/header.jsp"/>


<div class="user_info_content">

    <ul class="userinfo_left">
        <li ><a href="http://localhost:8080/FinalProject/infoView.htm">Personal Information</a></li>
        <li class="active"><a href="http://localhost:8080/FinalProject/updateView.htm">Update My Info</a></li>
        <li><a href="http://localhost:8080/FinalProject/toOrderHistory.htm">Order History</a></li>
    </ul>


    <div class="subContent">
        <div id="errorMsg">

        </div>
    <form id="updateUserInfoForm" onsubmit="return false" action="#" method="post" class="user_information">
        <table id="userInfo_table">
            <input type="hidden" name="id" value="${sessionScope.currentUser.userID}" />
            <tr>
                <td><label  class="label_txt">Username：</label></td>
                <td> <input type="text" name="username" id="user_name" value="${sessionScope.currentUser.uname}" class="user_inputxt" />
                    <span class="errorTips" style="color: red;font-size: 14px;"> </span></td>
            </tr>
            <tr>
                <td>
                    <label class="label_txt">New Password：</label>
                </td>
                <td>
                    <img src="images/close.png" alt="" id="eye" style="float:right;">
                    <input type="password" name="password" id="pwd">
                    <span class="errorTips" style="color: red;font-size: 14px;"></span>
                </td>

            </tr>
            <tr>
                <td>
                    <label class="label_txt">Confirm Password：</label>
                </td>
                <td>
                    <input type="text" name="confirm_password" id="confirm_pwd">
                    <span class="errorTips" style="color: red;font-size: 14px;"></span>
                </td>
            </tr>
            <tr>
                <td> <label  class="label_txt">Phone：</label></td>
                <td> <input type="text" name="phone" id="phone" value="${sessionScope.currentUser.phone}" class="user_inputxt" />
                    <span class="errorTips" style="color: red;font-size: 14px;"> </span></td>

            </tr>
            <tr>
                <td> <label  class="label_txt">Email：</label></td>
                <td> <input type="email" name="email" id="email" value="${sessionScope.currentUser.email}" class="user_inputxt" disabled="disabled" /></td>
            </tr>
           <tr>
               <td> </td>
               <td><input type="button" value="Save" class="submit_btn" id="submit" ></td>
           </tr>

        </table>
    </form>
    </div>
    <script>

        var eye = document.getElementById('eye');
        var pwd = document.getElementById('pwd');

        var flag = 0;

        eye.onclick = function(){
            if(flag == 0){
                pwd.type='text';
                eye.src = 'images/open.png';
                flag = 1;
            }else{
                pwd.type='password';
                eye.src = 'images/close.png';
                flag = 0;
            }
        }

    </script>
</div>
<jsp:include page="../customer/footer.jsp"/>
</body>
</html>
