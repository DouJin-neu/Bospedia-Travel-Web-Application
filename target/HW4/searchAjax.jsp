<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/29/2021
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script>
        function changeBackColor_over(div){
            $(div).css("background-color","#CCCCCC");
        }
        //鼠标离开内容
        function changeBackColor_out(div){
            $(div).css("background-color","");
        }
        //将点击的内容放到搜索框
        function setSearch_onclick(div){
            $("#search_input").val(div.innerText);
            $("#context1").css("display","none");
        }
        $(function (){

            $("#search_input").keyup(function (){
                var content = $(this).val();
                if(content === ""){
                    $("#context1").css("display","none");
                    return;
                }

                var time = new Date().getTime();
                $.ajax({
                    type:"get",
                    url:"http://localhost:8080/FinalProject/findEventsAjax.htm",
                    data:{keyword:content, time:time},
                    success:function (data){
                        var res = data.split(",");
                        var html = "";
                        for(var i = 0; i < res.length;i++){
                            html+="<div onclick='setSearch_onclick(this)' onmouseout='changeBackColor_out(this)' onmouseover='changeBackColor_over(this)'>"+res[i]+"</div>";

                        }
                        $("#context1").html(html);
                        $("#context1").css("display","block");
                    }
                });
            });
        });
    </script>
    <style>
        #context1{
            background-color:white;
            border: 1px solid black;
            width:160px;
            height: 200px;
            position: absolute;
            /*display: none;*/

        }
    </style>

</head>
<body>

<div class="search">
    <form action="keywordSearch.htm" method="post">
        <input name="keyword_search" id="search_input" type="text" placeholder="Things to do in Boston" class="search_input" autocomplete="off">
        <input type="submit" class="search-button" name="search_btn" value="Search">
    </form>
</div>

<div id="context1"></div>

</body>
</html>
