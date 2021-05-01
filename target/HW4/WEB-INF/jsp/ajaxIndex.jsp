<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/15/2021
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script>
        var $uname = $('#txtName');
        $uname.blur(function () {
            a1()
        })

        function a1(){
            $.post({
                url:"http://localhost:8080/FinalProject/a1.htm",
                data:{'name':$uname.val()},
                success:function(data,status){
                    alert(data);
                    alert(status);
                }
            });
        }

        var $btn = $('#btn');
        $btn.click(function (){
            changeCSS()
        })

        function changeCSS(){
            $btn.style.backgroundColor = 'blue';
            $btn.innerHTML = 'Saved';
            alert('clicked')
        }
    </script>
    <style>
        .btn_pink {
            background-color: pink;
        }
        .btn_blue {
            background-color: cornflowerblue;
        }
    </style>
</head>
<body>

User Name:<input type="text" id="txtName" onblur="a1()"/>
<button onclick="changeCSS()" id="btn" >Click here</button>
</body>
</html>
