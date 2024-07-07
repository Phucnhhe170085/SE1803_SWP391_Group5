<%@page import="dao.RoomDAO,java.util.List"%>
<%@page import="model.Rooms" %>

<% List<Rooms> listRoom = (List<Rooms>) request.getAttribute("listRoom"); %>
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

        <title>HoLa Motel</title>
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
                        <a href="GuestController?service=GuestHome" class="logo m-0 float-start">Guest</a>

                        <jsp:include page = "navbar.jsp"></jsp:include>

                        <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                            <span></span>
                        </a>

                    </div>
                </div>
            </div>
        </nav>

        <div class="hero">
            <div class="hero-slide">
                <div class="img overlay" style="background-image: url('images/hero_bg_3.jpg')"></div>
                <div class="img overlay" style="background-image: url('images/hero_bg_2.jpg')"></div>
                <div class="img overlay" style="background-image: url('images/hero_bg_1.jpg')"></div>
            </div>
        </div>

        <div class="section">
            <div class="container">
                <div class="row mb-5 align-items-center">
                    <div class="col-lg-12 text-lg-end">
                        <p><a href="GuestController?service=ListRoom&index=1" class="btn btn-primary text-white py-3 px-4">View list rooms</a></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="property-slider-wrap">
                            <div class="property-slider">
                               <% for (int i = 0; i <= 4; i++) { %>
                                <div class="property-item">
                                    <a href="OwnerController?service=roomDetail&roomID=<%= listRoom.get(i).getRoomID()%>" class="img">
                                        <% String base64Image = listRoom.get(i).getRoomImg(); %>
                                        <img src="data:image/jpg;base64,<%= base64Image %>" class="img-fluid" style="height: 350px; width: 100%;">
                                    </a>

                                    <div class="property-content">
                                        <div class="price mb-2"><span><%= listRoom.get(i).getRoomFee().longValue()%>k VND</span></div>
                                        <div>
                                            <span class="d-block mb-2 text-black-50">Thon 3, Tan Xa, Thach That</span>
                                            <span class="city d-block mb-3">Room <%= listRoom.get(i).getRoomNumber()%></span>
                                            <div class="specs d-flex mb-4">
                                                <span class="d-block d-flex align-items-center me-3">
                                                    <span class="icon-bed me-2"></span>
                                                    <span class="caption"><%= listRoom.get(i).getRoomSize()%> beds</span>
                                                </span>
                                                <span class="d-block d-flex align-items-center">
                                                    <span class="icon-bath me-2"></span>
                                                    <span class="caption"><%= listRoom.get(i).getRoomFloor()%> Floor</span>
                                                </span>
                                            </div>

                                            <a style="margin-right: 53px" href="GuestController?service=roomDetail&roomID=<%= listRoom.get(i).getRoomID() %>" class="btn btn-primary py-2 px-3">See details</a>
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

        <div class="site-footer">
            <div class="container">

                <div class="row">
                    <div class="col-lg-4">
                        <div class="widget">
                            <h3>Contact</h3>
                            <address>43 Raymouth Rd. Baltemoer, London 3910</address>
                            <ul class="list-unstyled links">
                                <li><a href="tel://11234567890">+1(123)-456-7890</a></li>
                                <li><a href="tel://11234567890">+1(123)-456-7890</a></li>
                                <li><a href="mailto:info@mydomain.com">info@mydomain.com</a></li>
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
                                <li><a href="#"><span class="icon-facebook"></span></a></li>
                                <li><a href="#"><span class="icon-linkedin"></span></a></li>
                                <li><a href="#"><span class="icon-pinterest"></span></a></li>
                                <li><a href="#"><span class="icon-dribbble"></span></a></li>
                            </ul>
                        </div> <!-- /.widget -->
                    </div> <!-- /.col-lg-4 -->
                </div> <!-- /.row -->

                <div class="row mt-5">
                    <div class="col-12 text-center">
                        <!-- 
**==========
NOTE: 
Please don't remove this copyright link unless you buy the license here https://untree.co/license/  
**==========
                        -->

                        <p>Copyright &copy;<script>document.write(new Date().getFullYear());</script>. All Rights Reserved. &mdash; Designed with love by <a href="https://untree.co">Untree.co</a> <!-- License information: https://untree.co/license/ -->
                        </p>

                    </div>
                </div>
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
