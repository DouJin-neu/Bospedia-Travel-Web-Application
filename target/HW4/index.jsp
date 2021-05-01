<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bospedia- Enjoy your times in Boston </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet"  href="css/bootstrap.min.css"/>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<link href="css/bootstrap.min.css" rel="stylesheet">
<jsp:include page="WEB-INF/jsp/customer/header.jsp"/>
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<!--banner start-->
<section id="banner">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="2000">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            <li data-target="#carousel-example-generic" data-slide-to="3"></li>
        </ol>
        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="images/banner_spring1.jpg" alt="">
            </div>
            <div class="item">
                <img src="images/banner_winter.jpg" alt="">
            </div>
            <div class="item">
                <img src="images/banner_fall.jpg" alt="">
            </div>
            <div class="item">
                <img src="images/banner_winter1.jpg" alt="">
            </div>
        </div>
        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</section>
<!-- banner end-->
<!-- Recommendation-->
<div class="subtitle">
    <p>Ideas for you to explore Boston</p>
</div>
<section id="content">
    <!-- recommend start-->
    <section class="recommend">
        <div class="tab_list">
            <div class="recommend_tit">
                <img src="images/icon_5.jpg" alt="">
            </div>
            <div class="recommend_tabs">
                <ul>
                    <li class="current" index="0">Top Sellers</li>
                    <li index="1">Local Restaurants</li>
                    <li index="2">Activities & Games</li>
                    <li index="3">Culture & Arts</li>
                </ul>
            </div>
        </div>
        <!--tab content-->
        <div class="tab_con">
            <!--Top Sellers start-->
            <div class="category" style="display: block;">
                <div role="tabpanel" class="tab-pane active" id="top_sellers">
                    <div class="row">
                        <div class="col-md-3">
                            <a href="ticketDetail.htm?ticketID=1">
                                <img src="images/candlelight.jpg" alt="">
                                <div class="has_border">
                                    <h3>Candlelight: Chopin's Best Works</h3>
                                    <div class="price">From <em>$</em><strong>20.00</strong></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="ticketDetail.htm?ticketID=2">
                                <img src="images/vanG.jpg" alt="">
                                <div class="has_border">
                                    <h3>Van Gogh:The Immersive Experience</h3>
                                    <div class="price">From <em>$</em><strong>16.00</strong></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="ticketDetail.htm?ticketID=3">
                                <img src="images/dating.jpg" alt="">
                                <div class="has_border">
                                    <h3>Dining in The Dark in Boston</h3><br/>
                                    <div class="price"><em> $</em><strong>90.00</strong></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="ticketDetail.htm?ticketID=4">
                                <img src="images/Nailed.jpg" alt="">
                                <div class="has_border">
                                    <h3>Nailed it! At Home Experience - Double</h3>
                                    <div class="price">From <em>$</em><strong>54.00</strong></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <!--Top Sellers end-->
            <!--Restaurants start-->
            <div class="category">
                <div role="tabpanel" class="tab-pane active" id="restaurant">
                    <div class="row">
                        <div class="col-md-3">
                            <a href="restaurantDetail.htm?restaurantID=1">
                                <img src="images/voile.jpg" alt="" height="210" width="210">
                                <div class="has_border">
                                    <h3>LA VOILE</h3><br/>
                                    <div class="price">Average <strong>&nbsp;$$$</strong></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="restaurantDetail.htm?restaurantID=2">
                                <img src="images/fogo1.jpeg" alt="" height="210" width="210">
                                <div class="has_border">
                                    <h3>FOGO DE CHAO Brazilian Steakhouse</h3>
                                    <div class="price">Average <strong>&nbsp;$$</strong></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="restaurantDetail.htm?restaurantID=3">
                                <img src="images/bacco.jpg" alt="">
                                <div class="has_border">
                                    <h3>BACCO</h3><br/>
                                    <div class="price">Average <strong>&nbsp;$$$</strong></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="restaurantDetail.htm?restaurantID=4">
                                <img src="images/bambara.png" alt="">
                                <div class="has_border">
                                    <h3>BAMBARA RESTAURANT - HOTEL MARLOWE</h3>
                                    <div class="price">Average <strong>&nbsp;$$</strong></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <!--Restaurant end-->
            <!--Activities start-->
            <div class="category">
                <div role="tabpanel" class="tab-pane active" id="activity">
                    <div class="row">
                        <div class="col-md-3">
                            <a href="ticketDetail.htm?ticketID=5">
                                <img src="images/clue.jpg" alt="" width="210" height="210">
                                <div class="has_border">
                                    <h3>Downloadable Clue Game</h3><br/>
                                    <div class="price"><strong>$30.00</strong></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="ticketDetail.htm?ticketID=6">
                                <img src="images/crown.jpg" alt="" width="210" height="210">
                                <div class="has_border">
                                    <h3>Crown & Prophet: Virtual Epic Fantasy Tour</h3>
                                    <div class="price"><strong>$15.00</strong></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="ticketDetail.htm?ticketID=7">
                                <img src="images/bingo.jpg" alt="" width="210" height="210">
                                <div class="has_border">
                                    <h3>Adult Bingo! Streaming Party & Complimentary</h3>
                                    <div class="price">Average <strong>$6.00</strong></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="ticketDetail.htm?ticketID=8">
                                <img src="images/wonder.jpg" alt="" width="210" height="210">
                                <div class="has_border">
                                    <h3>The Wonder Cave: A Virtual Escape Room</h3>
                                    <div class="price"><strong>$7.50</strong></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <!--activities end-->
            <!--culture start-->
            <div class="category">
                <div role="tabpanel" class="tab-pane active" id="culture">
                    <div class="row">
                        <div class="col-md-3">
                            <a href="ticketDetail.htm?ticketID=2">
                                <img src="images/vanG.jpg" alt="">
                                <div class="has_border">
                                    <h3>Van Gogh: The Immersive Experience</h3>
                                    <div class="price">From <strong>$16.20</strong></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="ticketDetail.htm?ticketID=9">
                                <img src="images/pride.jpg" alt="" width="210" height="210">
                                <div class="has_border">
                                    <h3>Pride and Prejudice: A New Jane Austen</h3>
                                    <div class="price">From <strong>$4.99</strong></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="ticketDetail.htm?ticketID=10">
                                <img src="images/isabella.jpg" alt="" width="210" height="210">
                                <div class="has_border">
                                    <h3>Isabella Stewart Gardner Museum</h3>
                                    <div class="price">From <strong>$15.00</strong></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="ticketDetail.htm?ticketID=11">
                                <img src="images/mfa.jpg" alt="" width="210" height="210">
                                <div class="has_border">
                                    <h3>Museum of Fine Art</h3><br/>
                                    <div class="price">From <strong>$30</strong></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <!--culture end-->
        </div>
        </div>

        <script>
            var tab_list = document.querySelector('.tab_list');
            var lis = tab_list.querySelectorAll('li');
            var items = document.querySelectorAll('.category');
            for(var i = 0; i < lis.length; i++){

                lis[i].setAttribute('index',i);
                lis[i].onclick = function (){

                    for(var i = 0;i < lis.length;i++){
                        lis[i].className = '';
                    }

                    this.className = 'current';
                    var index = this.getAttribute('index');

                    for(var i = 0; i < items.length;i++){
                        items[i].style.display = 'none';
                    }

                    items[index].style.display = 'block';
                }
            }
        </script>

    </section>


    <!-- Hang out start-->
    <div class="subtitle">Hang out</div>
    <section class="hangout">
        <div class="hangout_pic">
            <img src="images/isabella.jpg" alt="">
            <div class="hangout_detail">
                <h2>Isabella Gardener Museum </h2>
                <p>Spring MUST GO!</p>
                <a href="ticketDetail.htm?ticketID=10">More Info</a>
            </div>

        </div>
        <div class="tours">
            <ul>
                <li>
                    <div class="detail">
                        <h2>Boston Common</h2>
                        <p>Good place to go</p>
                        <a href="tripDetail.htm?ticketID=15">More Info</a>
                    </div>
                    <img src="images/bosCommon.png" width="240" height="200" alt=""/>
                </li>
                <li>
                    <div class="detail">
                        <h2>New England Aquarium</h2>
                        <p>Best place for Kids</p>
                        <a href="tripDetail.htm?ticketID=14">More Info</a>
                    </div>
                    <img src="images/aquarium.jpg" width="240" height="200" alt=""/>
                </li>
                <li>
                    <div class="detail">
                        <h2>Chinatown</h2>
                        <p>Get into different culture </p>
                        <a href="tripDetail.htm?ticketID=16">More Info</a>
                    </div>
                    <img src="images/chinatown.jpg" width="240" height="200" alt=""/>
                </li>
                <li>
                    <div class="detail">
                        <h2>The White Mountains</h2>
                        <p>It's FALL!!</p>
                        <a href="tripDetail.htm?ticketID=17">More Info</a>
                    </div>
                    <img src="images/whiteMountain.jpeg" width="240" height="200" alt=""/>
                </li>
                <li>
                    <div class="detail">
                        <h2>Harvard University</h2>
                        <p>Enjoy the knowledge</p>
                        <a href="tripDetail.htm?ticketID=18">More Info</a>
                    </div>
                    <img src="images/Harvard.jpg" width="240" height="200" alt=""/>
                </li>
                <li>
                    <div class="detail">
                        <h2>Tatte</h2>
                        <p>Enjoy your brunch!</p>
                        <a href="#">More Info</a>
                    </div>
                    <img src="images/tatte.jpg" width="240" height="200" alt=""/>
                </li>
            </ul>
        </div>
    </section>
    <!-- hang out end-->

</section>
<!-- tours end-->
<!--footer-->
<jsp:include page="WEB-INF/jsp/customer/footer.jsp"/>
</body>
</html>
