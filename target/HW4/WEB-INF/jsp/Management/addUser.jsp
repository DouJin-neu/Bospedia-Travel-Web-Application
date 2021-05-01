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

            $(document).ready(function(){

                var $userName = $("#userName");
                var $password = $("#password");
                var $email = $("#email");
                var $phone = $("#phone");
                var $birthday = $("#birthday");


                $password.focus(function () {
                    $password.css("border", "1px solid black")
                    $password.next().hide()
                })
                $userName.focus(function () {
                    $userName.css("border", "1px solid black")
                    $userName.next().hide()
                })
                $email.focus(function () {
                    $email.css("border", "1px solid black")
                    $email.next().hide()
                })
                $phone.focus(function () {
                    $phone.css("border", "1px solid black")
                    $phone.next().hide()
                })
                $birthday.focus(function (){
                    $(this).css("border", "1px solid black")
                    $(this).next().hide()
                })

                $userName.blur(function () {
                    fnCheckUser();
                });

                $password.blur(function (){
                    fnCheckPwd();
                });

                $email.blur(function (){
                    fnCheckEmail();
                });
                $phone.blur(function (){
                    fnCheckPhone()
                });
                $birthday.blur(function (){
                    fnCheckBirthday()
                });

                function fnCheckUser() {
                    var username = $userName.val()

                    var re = /^([a-zA-Z]+\s)*[a-zA-Z]+$/;

                    if (username === '') {
                        $userName.css("border", "1px solid red");
                        $userName.next().show().html('this is a required filed.')
                       /* $("#submit").attr("disabled","disabled");*/
                        return false;
                    } else {
                        var flag = re.test(username);
                        if (flag) {
                            $userName.next().hide()

                        } else {
                            $userName.css("border", "1px solid red")
                            $userName.next().show().html('User name should only contains characters and space.')
                            //$("#submit").attr("disabled","disabled");

                        }

                    }
                    console.log(flag);
                    return flag;
                }


                function fnCheckPwd() {

                    var pwd = $password.val()

                    var rePass = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;

                    if (pwd === '') {
                        $password.css("border", "1px solid red");
                        $password.next().show().html('this is a required field')
                       // $("#submit").attr("disabled","disabled");
                        return false;
                    } else {

                        var flag = rePass.test(pwd)
                        if (flag) {

                            $password.next().hide()
                        } else {

                            $password.css("border", "1px solid red")
                            $password.next().show().html('Password should contains 6-12 digits and characters')
                           // $("#submit").attr("disabled","disabled");
                        }

                    }
                    console.log(flag);
                    return flag;
                }


                function fnCheckEmail() {

                    var email = $email.val()

                    var reMail = /^[a-z0-9][\w\.\-]*@[a-z0-9\-]+(\.[a-z]{2,5}){1,2}$/i

                    if (email === '') {
                        $email.css("border", "1px solid red");
                        $email.next().show().html('this is a required filed')
                        //$("#submit").attr("disabled","disabled");
                        return false;
                    } else {
                        var flag = reMail.test(email);
                        if (flag) {

                            $email.css("border", "");
                        } else {

                            $email.css("border", "1px solid red");
                            $email.next().show().html('Wrong format, your email should be xxx@xxx.xxx')
                           // $("#submit").attr("disabled","disabled");
                        }

                    }
                    console.log(flag);
                    return flag;
                }

                function fnCheckPhone() {

                    var phone = $phone.val()

                    var rePhone = /^\d{10}$/;

                    if (phone === '') {
                        $phone.css("border", "1px solid red");
                        $phone.next().show().html('this is a required filed')
                        //$("#submit").attr("disabled","disabled");
                        return false;
                    } else {
                        var flag = rePhone.test(phone);
                        if (flag) {

                            $phone.css("border", "");
                        } else {

                            $phone.css("border", "1px solid red");
                            $phone.next().show().html('Wrong format, your phone number should be 10 digits')
                           // $("#submit").attr("disabled","disabled");
                        }

                    }
                    console.log(flag);
                    return flag;
                }

                function fnCheckBirthday() {

                    var birthday = new Date($birthday.val());
                    var currentDate = new Date();

                    if(18 > currentDate.getFullYear() - birthday.getFullYear()){
                        $birthday.css("border", "1px solid red");
                        $birthday.next().show().html('Employee should older than 18!');
                        return false;
                    }

                    return true;
                }

               /* if(fnCheckPhone() && fnCheckEmail() && fnCheckPwd() && fnCheckUser()){
                    $("#submit").removeAttr("disabled");
                }*/
        })
    </script>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="pl_content">
    <form action="addUser.htm" method="post">

        <table>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="userName" id="userName">
                    <span class="error_tip" style="color:red;"> </span></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password" id="password">
                    <span class="error_tip" style="color:red;"> </span></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" id="email">
                    <span class="error_tip" style="color:red;"> </span></td>
            </tr>
            <tr>
                <td>Phone Number</td>
                <td><input type="text" name="phone" id="phone">
                    <span class="error_tip" style="color:red;"> </span></td>
            </tr>
            <tr>
                <td>Birthday</td>
                <td><input type="text" name="birthday" placeholder="yyyy-mm-dd" id="birthday">
                    <span class="error_tip" style="color:red;"> </span></td>
            </tr>
            <tr>
                <td>Sex</td>
                <td><input type="radio" name="sex" value="Female">Female
                    <input type="radio" name="sex" value="Male">Male
                </td>
            </tr>
            <tr>
                <td>Role</td>
                <td>
                    <select name="role" >
                        <option value="0">0 -customer</option>
                        <option value="1">1 -administrator</option>
                        <option value="2">2 -employee</option>
                    </select>
                </td>
            </tr>
            <tr>
                <input type="submit" name="add" value="Create Account" id="submit">
            </tr>
        </table>

    </form>
</div>
</body>
</html>
