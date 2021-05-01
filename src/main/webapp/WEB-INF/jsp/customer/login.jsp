<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 3/31/2021
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bospedia-Sign In</title>

    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/login.css" />
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script>
        var errorMsg = "${requestScope.errorMsg}";
        var flag = ${errorMsg == null};
        if(!flag){
            alert(errorMsg);

        }

        $(document).ready(function(){

            var $email = $("#email");
            var $password = $("#pwd");

            $email.focus(function (){
                $email.css("border","1px solid black")
                $email.next().hide()
            })

            $email.blur(function(){
                fnCheckEmail()
            })
            function fnCheckEmail(){
                var email = $email.val()

                if(email === ''){
                    $email.css("border","1px solid red");
                    $email.next().show().html('this is a required field.')
                    return false;
                }else{
                    $email.css("border","1px solid black");
                    $email.next().hide()
                }
                return true;
            }

            $password.focus(function (){
                $password.css("border","1px solid black")
                $password.next().hide()
            })

            $password.blur(function(){
                fnCheckPwd()
            })
            function fnCheckPwd(){
                var password = $password.val()
                if(password === ''){
                    $password.css("border","1px solid red");
                    $password.next().show().html(' this is a required field.')
                    return false;
                }else{
                    $password.css("border","1px solid black");
                    $password.next().hide()
                }
                return true;

            }


        });

    </script>
    <style>
        .error_tip{
            font-size: 12px;
            color: red;
            position: absolute;
            margin-left: 5px;
        }
        .label {
            height: 25px;
            width: 25px;
            background-image: url(../../../images/close.png);
            position: absolute;
            margin-right: -30px;
            margin-bottom: -10px;
            border-top-left-radius: 4px;
            border-bottom-left-radius: 4px;
        }
        #emailIcon {
            height: 30px;
            width: 30px;
            background-image: url(../../../images/email.jpg);
            position: absolute;
            margin-bottom: -10px;
            display: inline-block;
            margin-top: 5px;
            margin-left: 1px;
        }
    </style>


</head>
<body>
<jsp:include page="/WEB-INF/jsp/customer/header.jsp"/>

<section id="login_wrap">
    <div class="fullscreen-bg" style="background: url(${pageContext.request.contextPath}/images/banner_spring.jpg); height: 532px; width: 1350px;">

    </div>
    <div class="login-box">
        <div class="title">
            <span>Sign in with your email</span>
        </div>
        <div class="login_inner">

            <form id="loginForm" action="customerLogin.htm" method="post" accept-charset="utf-8">
                <table>
                    <tr>
                        <td><label for="email"> Email Address</label>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img src="images/email.jpg" class="label" alt="" id="emailIcon"  />
                            <input name="email" id="email" type="text" placeholder="Please enter your email" autocomplete="off" style="padding-left: 30px;">
                            <span class="error_tip">  </span>
                        </td>

                    </tr>
                    <tr>

                        <td> </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="pwd">Password</label>
                        </td>
                    </tr>
                    <tr>
                        <td >
                            <img src="images/close.png" class="label" alt="" id="eye" style="height: 25px;width: 25px; display: inline-block;margin-top: 5px" />
                            <input type="password" name="password" id="pwd" placeholder="Please enter your password " autocomplete="off" style="border: 1px solid lightgray; width: 246px;padding-left: 30px">
                            <span class="error_tip" >  </span>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="hidden" name="action" value="login"/>
                            <div class="submit_btn">
                                <input type="submit"  id="btn_sub" value="Sign In"/>
                            </div>

                        </td>
                    </tr>
                </table>





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



            </form>
            <!--Login error message-->
            <span>${errorMsg}</span>
            <div class="reg">Don't have an account? <a href="toSignup.htm">Sign Up</a></div>

        </div>
    </div>
</section>
<!--footer-->
<jsp:include page="/WEB-INF/jsp/customer/footer.jsp"/>

</body>
</html>
