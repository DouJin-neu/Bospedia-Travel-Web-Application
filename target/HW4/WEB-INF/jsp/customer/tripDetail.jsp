<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jindou
  Date: 4/18/2021
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${ticket.ticketName}</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/ticketView.css" />
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script>
        var $favorite_btn = $('#favorite');
        var $remove_btn = $('#remove');

        $favorite_btn.click(function() {
            addToFavorite()
        });

        function addToFavorite(){

                $.post({
                    url:"http://localhost:8080/FinalProject/addToFavorite.htm",
                    data:{'category':'ticket',
                        'ticketID':'${ticket.ticketID}',
                        'userID':'${sessionScope.currentUser.userID}'
                    },
                    success:function (status){

                        $('#remove').show();
                        $('#favorite').hide();
                        $('#isFavorite').show();
                        alert(status);
                    },
                    error: function () {
                        alert('Please sign in to add favorite event!')
                        window.location.href = "http://localhost:8080/FinalProject/toLogin.htm"
                    }
                });
        }

        $remove_btn.click(function(){
            removeFavorite()
        });
        function removeFavorite(){
            $.post({
                url:"http://localhost:8080/FinalProject/cancelFavorite.htm",
                data:{'userID':'${sessionScope.currentUser.userID}',
                    'ticketID':'${ticket.ticketID}'
                },
                success:function (data, status){

                    $('#remove').hide();
                    $('#favorite').show();
                    $('#isFavorite').hide();
                    alert(status);
                    alert(data);
                }
            });
        }
    </script>
</head>
<body>
<jsp:include page="../customer/header.jsp"/>

<div class="ticket_content">
    <div class="ticket_introduce">
        <div class="ticket_introduce_img">
            <img src= ${ticket.timage}>
        </div>

        <div class="ticket_introduce_text">

            <div id="ticket_introduce_title">
                <p>${ticket.ticketName}</p>
            </div>

            <div id="ticket_introduce_brief">
                <p>${ticket.tIntroduce}</p>
            </div>

            <c:set var="isFavorite" value="false"/>
            <c:forEach items="${sessionScope.favoriteList}" var="favorite">
                <c:if test="${ticket.ticketID == favorite.ticketID}">
                    <c:set var="isFavorite" value="true"/>
                    <div id="isFavorite">
                        <span>Saved</span>
                    </div>
                    <script>
                        var favorite = document.getElementById("favorite");
                        favorite.style.display = 'none';
                    </script>
                </c:if>
            </c:forEach>
            <div class="addFavorite">
                 <c:if test="${isFavorite eq 'false'}">
                    <input type="button" name="favorite" id="favorite" value="Add to Favorite" onclick="addToFavorite()" />

                    <input type="button" name="remove" id="remove" value="Remove Favorite" onclick="removeFavorite()" style="display: none" />

                </c:if>
                <c:if test="${isFavorite eq 'true'}">
                    <input type="button" name="remove" id="remove" value="Remove Favorite" onclick="removeFavorite()" />
                    <input type="button" name="favorite" id="favorite" value="Add to Favorite" onclick="addToFavorite()" style="display: none" />
                </c:if>

            </div>
        </div>
    </div>

    <div class="ticket_detail">
        <div class="detail_tab">
            <div class="detail_tab_list">
                <ul>
                    <li class="current" index="0">Tickets</li>
                    <li index="1">What You Will Enjoy</li>
                    <li index="2">General Info</li>
                    <li index="3">Description</li>
                    <li index="4">User Reviews</li>
                </ul>
            </div>
            <div class="detail_tab_con">
                <div class="ticket_info" style="display: block">
                    <ul>
                        <li>🎫 Zone A seating (premium visibility)</li>
                        <li>🎫 Zone B seating (great visibility)</li>
                        <li>🎫 Zone C seating (good visibility)</li>
                    </ul>
                    <br/>
                    <span style="font-style: italic">Seating is assigned on a first come first served basis within each zone</span>
                </div>
                <div class="ticket_info">
                    <ul>
                        <li>⭐ An intimate ambience in a beautiful venue bathed in candlelight</li>
                        <li>⭐ A talented string quartet performing classical pieces by Beethoven</li>
                        <li>⭐ The stunning architecture of an iconic secret location in Boston</li>
                        <li>⭐ A safe, comfortable and socially-distanced event</li>
                    </ul>
                </div>
                <div class="ticket_info">
                    <ul>
                        <li>* Venue: an emblematic building in Boston (to be announced soon)</li>
                        <li>* Date and time: various dates at 7:00 PM and 9:15 PM (select during purchase)</li>
                        <li>* Duration: 65 minutes (doors open 30 mins prior to the start time and late entry is not permitted)</li>
                        <li>* Age requirement: 10 years old or older. Anyone under the age of 16 must be accompanied by an adult</li>
                        <li>* View the FAQs for this event</li>
                        <li>* Your safety is Fever's priority. You can read the safety measures for this event</li>
                    </ul>
                </div>
                <div class="ticket_info">
                    <p>Whether you’re looking for a beautifully unique classical music performance or a romantic candlelit experience, this performance is for you.
                        You don’t need to know all things Beethoven to enjoy the evening, simply sit back and savor the stunning atmosphere and pieces you’ll hear.
                        Walk into one of Boston's emblematic buildings where the walls will be flickering by candlelight to create a magical atmosphere.
                        Prepare to be taken into the clouds with Beethoven's most treasured masterpieces!</p>
                </div>
                <div class="ticket_info">
                    <ul>
                        <li>Beatriz H. ⭐⭐⭐⭐⭐: "Was an amazing night full of good things. What a magical experience!"</li>
                        <li>Gloria V. ⭐⭐⭐⭐⭐: "So beautiful, professional, elegant, romantic and organized"</li>
                        <li>Iris G. ⭐⭐⭐⭐⭐: "Beautiful evening and the ambiance was perfect!"</li>
                    </ul>
                </div>

            </div>

        </div>
        <script>
            var tab_list = document.querySelector('.detail_tab_list');
            var lis = tab_list.querySelectorAll('li');
            var items = document.querySelectorAll('.ticket_info');
            for(var i = 0; i <lis.length;i++){
                lis[i].setAttribute('index',i);
                lis[i].onclick = function(){
                    for(var i = 0; i <lis.length;i++){
                        lis[i].className = '';
                    }
                    this.className = 'current';
                    var index = this.getAttribute('index');
                    for(var i = 0; i < items.length;i++){
                        items[i].style.display = 'none';
                    }
                    items[index].style.display='block';
                }
            }

        </script>
    </div>
</div>
<jsp:include page="../customer/footer.jsp"/>
</body>
</html>
