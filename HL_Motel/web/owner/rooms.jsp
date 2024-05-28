<%@page import="dao.RoomDAO,java.util.List,java.util.Vector"%>
<%@page import="model.Rooms" %>

<%
    List<Rooms> listRoom = (List<Rooms>) request.getAttribute("rooms");
%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Untree.co">
        <link rel="shortcut icon" href="favicon.png">

        <meta name="description" content="" />
        <meta name="keywords" content="bootstrap, bootstrap5" />

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">


        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">

        <title>Hola Motel</title>
        <style>
            .container1 {
                width: 500px;
                margin: auto;
                text-align: center;
            }
            .pagination {
                width: 400px;
                margin-left: 50px;
            }
            .pagination a {
                display: block;
                color: black;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
                transition: background-color .3s;
            }

            .pagination a.active {
                background-color: #4CAF50;
                color: white;
            }

            .pagination a:hover:not(.active) {
                background-color: #ddd;
            }
        </style>
    </head>
    <body>

        <div class="site-mobile-menu site-navbar-target">
            <div class="site-mobile-menu-header">
                <div class="site-mobile-menu-close">
                    <span class="icofont-close js-menu-toggle"></span>
                </div>
            </div>
            <div class="site-mobile-menu-body"></div>
        </div>

        <nav class="site-nav">
            <div class="container">
                <div class="menu-bg-wrap">
                    <div class="site-navigation">
                        <a href="OwnerHome.jsp" class="logo m-0 float-start">Room</a>

                        <jsp:include page = "navbar.jsp"></jsp:include>

                            <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                                <span></span>
                            </a>

                        </div>
                    </div>
                </div>
            </nav>

            <div class="hero page-inner overlay" style="background-image: url('images/hero_bg_1.jpg');">

                <div class="container">
                    <div class="row justify-content-center align-items-center">
                        <div class="col-lg-9 text-center mt-5">
                            <h1 class="heading" data-aos="fade-up">Rooms</h1>

                            <nav aria-label="breadcrumb" data-aos="fade-up" data-aos-delay="200">
                                <ol class="breadcrumb text-center justify-content-center">
                                    <li class="breadcrumb-item "><a href="index.html">Home</a></li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>


            <div class="section">
                <div class="container">
                    <div class="row mb-5 align-items-center">
                        <div class="col-lg-6 text-center mx-auto">
                            <h2 class="font-weight-bold text-primary heading">The Rooms</h2>
                        </div>

                    </div>
                    <div class="row">

                        <div class="col-12">


                            <div class="property-slider-wrap">



                                <div class="property-slider">

                                <%
                                    for (int i = 1; i <= 4; i++) {
                                %>

                                <div class="property-item">

                                    <a href="property-single.html" class="img">
                                        <img src="images/room<%= i%>.jpg" alt="Image" class="img-fluid">
                                    </a>

                                    <div class="property-content">
                                        <div class="price mb-2"><span><%= listRoom.get(i).getRoomFee()%> VND</span></div>
                                        <div>
                                            <span class="d-block mb-2 text-black-50">Thon 3, Tan Xa, Thach That</span>
                                            <span class="city d-block mb-3">Room <%= listRoom.get(i).getRoomNumber()%></span>

                                            <div class="specs d-flex mb-4">
                                                <span class="d-block d-flex align-items-center me-3">
                                                    <span class="icon-bed me-2"></span>
                                                    <span class="caption"><%= listRoom.get(i).getRoomSize()%> beds</span>
                                                </span>
                                                <span class="d-block d-flex align-items-center">
                                                    <span class="icon-building me-2"></span>
                                                    <span class="caption"><%= listRoom.get(i).getRoomFloor()%> Floor</span>
                                                </span>
                                            </div>

                                            <a href="property-single.html" class="btn btn-primary py-2 px-3">See details</a>
                                        </div>
                                    </div>
                                </div> <!-- .item -->
                                <%}%>
                            </div>

                            <div id="property-nav" class="controls" tabindex="0" aria-label="Carousel Navigation">
                                <span class="prev" data-controls="prev" aria-controls="property" tabindex="-1">Prev</span>
                                <span class="next" data-controls="next" aria-controls="property" tabindex="-1">Next</span>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </div>


        <div class="section section-properties">
            <div class="container">
                <div class="row">
                    <%
                            for (int i = 0; i <= 19; i++) {
                    %>
                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4">

                        <div class="property-item mb-30">

                            <a href="property-single.html" class="img">
                                <img src="images/room<%= i + 1%>.jpg" alt="Image" class="img-fluid">
                            </a>

                            <div class="property-content">
                                <div class="price mb-2"><span><%= listRoom.get(i).getRoomFee()%> VND</span></div>
                                <div>
                                    <span class="d-block mb-2 text-black-50">Thon 3, Tan Xa, Thach That</span>
                                    <span class="city d-block mb-3">Room <%= listRoom.get(i).getRoomNumber()%></span>

                                    <div class="specs d-flex mb-4">
                                        <span class="d-block d-flex align-items-center me-3">
                                            <span class="icon-bed me-2"></span>
                                            <span class="caption"><%= listRoom.get(i).getRoomSize()%> beds</span>
                                        </span>
                                        <span class="d-block d-flex align-items-center">
                                            <span class="icon-building me-2"></span>
                                            <span class="caption"><%= listRoom.get(i).getRoomFloor()%> Floor</span>
                                        </span>
                                    </div>

                                    <a href="property-single.html" class="btn btn-primary py-2 px-3">See details</a>
                                </div>
                            </div>
                        </div> <!-- .item -->

                    </div>
                    <%}%>                    
                </div>
            </div>
        </div>
    </div>
                 
    <div class="site-footer">
        <div class="container">

            <div class="row">
                <div class="col-lg-4">
                    <div class="widget">
                        <h3>Contact</h3>
                        <address>FPT University, Thach That, Ha Noi</address>
                        <ul class="list-unstyled links">
                            <li><a href="tel://11234567890">+1(123)-456-789</a></li>
                            <li><a href="tel://11234567890">+1(123)-456-789</a></li>
                            <li><a href="mailto:info@mydomain.com">fptuniversity@fpt.edu.vn</a></li>
                        </ul>
                    </div> <!-- /.widget -->
                </div> <!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <div class="widget">
                        <h3>Sources</h3>
                        <ul class="list-unstyled float-start links">
                            <li><a href="#">About us</a></li>
                            <li><a href="#">Services</a></li>
                            <li><a href="#">Vision</a></li>
                            <li><a href="#">Mission</a></li>
                            <li><a href="#">Terms</a></li>
                            <li><a href="#">Privacy</a></li>
                        </ul>
                        <ul class="list-unstyled float-start links">
                            <li><a href="#">Partners</a></li>
                            <li><a href="#">Business</a></li>
                            <li><a href="#">Careers</a></li>
                            <li><a href="#">Blog</a></li>
                            <li><a href="#">FAQ</a></li>
                            <li><a href="#">Creative</a></li>
                        </ul>
                    </div> <!-- /.widget -->
                </div> <!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <div class="widget">
                        <h3>Links</h3>
                        <ul class="list-unstyled links">
                            <li><a href="#">Our Vision</a></li>
                            <li><a href="#">About us</a></li>
                            <li><a href="#">Contact us</a></li>
                        </ul>

                        <ul class="list-unstyled social">
                            <li><a href="#"><span class="icon-instagram"></span></a></li>
                            <li><a href="#"><span class="icon-twitter"></span></a></li>
                            <li><a href="https://www.facebook.com/elfadkeachother"><span class="icon-facebook"></span></a></li>
                            <li><a href="#"><span class="icon-linkedin"></span></a></li>
                            <li><a href="#"><span class="icon-pinterest"></span></a></li>
                            <li><a href="#"><span class="icon-dribbble"></span></a></li>
                        </ul>
                    </div> <!-- /.widget -->
                </div> <!-- /.col-lg-4 -->
            </div> <!-- /.row -->
        </div> <!-- /.container -->
    </div> <!-- /.site-footer -->


    <!-- Preloader -->
    <div id="overlayer"></div>
    <div class="loader">
        <div class="spinner-border" role="status">
            <span class="visually-hidden">Loading...</span>
        </div>
    </div>


    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/tiny-slider.js"></script>
    <script src="js/aos.js"></script>
    <script src="js/navbar.js"></script>
    <script src="js/counter.js"></script>
    <script src="js/custom.js"></script>
</body>
</html>
