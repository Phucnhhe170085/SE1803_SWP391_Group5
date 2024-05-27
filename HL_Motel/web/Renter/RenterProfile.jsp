<%-- 
    Document   : SeNews
    Created on : Jan 18, 2024, 2:59:38 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- /*
* Template Name: Property
* Template Author: Untree.co
* Template URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
<!-- /*
* Template Name: Property
* Template Author: Untree.co
* Template URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
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
        <link rel="stylesheet" href="./vcss/tiny-slider.css">
        <link rel="stylesheet" href="./vcss/aos.css">
        <link rel="stylesheet" href="./vcss/style.css">

        <title>Hoa Lac Motel</title>
        <link rel="icon" href="home-guest/favicon.png">
        <style>
            /* Existing styles */
            .tabular--wrapper {
                background: #fff;
                margin-top: 1rem;
                border-radius: 10px;
                padding: 2rem;
            }

            .table-container {
                width: 100%;
            }

            table {
                width: 100%;
                border-collapse: collapse;
            }

            thead {
                background: rgba(138, 110, 60, 0.5);
                color: black;
            }

            th {
                padding: 15px;
                text-align: left;
            }

            tbody {
                background: #f2f2f2;
            }

            td {
                padding: 15px;
                font-size: 14px;
                color: #333;
            }

            tr:nth-child(even) {
                background: white;
            }

            tfoot {
                background: rgba(113, 99, 186, 0.5);
                font-weight: bold;
                color: rgb(255, 255, 255);
            }

            tfoot td {
                padding: 15px;
            }

            .table-container button {
                color: green;
                background: none;
                cursor: pointer;
            }

            th {
                padding: 15px;
                background: none;
                cursor: pointer;
            }

            /* Combined styles for info-container, user-info, and renter-info */
            .info-container {
                display: flex;
                justify-content: center;
                align-items: center;
                flex-wrap: wrap;
            }

            .user-info,
            .renter-info {
                width: 50%;
                box-sizing: border-box;
                padding: 15px;
                background-color: #f9f9f9;
                border-radius: 8px;
                box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
                margin: 8px;
                text-align: left;
                max-width: 800px;
                max-height: 500px;
            }

            .info-container  {
                color: #555;
            }

            /* Responsive adjustments for smaller screens */
            @media (max-width: 768px) {
                .info-container {
                    flex-direction: column;
                    margin-bottom: 30px;
                }

                .user-info,
                .renter-info {
                    width: 400px; /* Set the desired width */
                    height: auto; /* Set height to auto to accommodate content */
                    font-size: 16px; /* Adjust the font size as needed */
                    padding: 20px; /* Add padding for better spacing */
                    box-sizing: border-box; /* Include padding in the total width */
                }

                .personal-info h2 {
                    margin: 10px 0;
                    color: #006eff;
                }
                .personal-info h3 {
                    font-size: 30px;
                }
            }


            .update-profile h3 {
                color: #555;
                margin-bottom: 20px;
                text-align: center;
            }

            .user-info p,
            .renter-info p {
                font-size: 16px; /* Adjust the size as needed */
            }
            .Avatar {
                text-align: center;
                margin-bottom: 30px;

            }

            .Avatar h3 {
                font-size: 34px;
            }

            .Avatar a {
                font-size: 20px;
            }
            .Avatar img {
                border-radius: 25%;
                width: 200px;
                height: 200px;
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
                        <a href="Homepage.html" class="logo m-0 float-start">Hoa Lac Motel</a>

                        <ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu float-end">
                            <li class="active"><a href="renterhome">Home</a></li>
                            <li class="active"><a href="RoomList.html">Room</a></li>
                            <li><a href="Payment.html">Payment</a></li>
                            <li><a href="renterprofile">Renter</a></li>
                            <li><a href="Guide.html">Guide</a></li>
                            <li><a href="News.html">News</a></li>
                        </ul>

                        <a href="#"
                           class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none"
                           data-toggle="collapse" data-target="#main-navbar">
                            <span></span>
                        </a>

                    </div>
                </div>
            </div>
        </nav>

        <div class="PaddingMenu" style="background-image: url(''); height: 120px; padding: 40px;">
            <!-- Content of PaddingMenu -->
        </div>
        <!--INSERT PERSONAL INFO-->
        <c:forEach items="${ListRP}" var="user">
            <c:set var="uid" value="${user.userID}" />
            <div class="Avatar">
                <h3>Personal Information</h3>         
                <center><a href="renterupdate?userID=${uid}">Edit Information</a></center>
                <center><a href="changepass?userMail=${user.account.userMail}">Change Password</a></center>
            </div>


            <div class="personal-info">                

                <div class="info-container " style="margin-bottom: 30px">
                    <div class="user-info">
                        <h3>Basic Information</h3>   
                        <p>Name: ${user.userName}</p>
                        <p>Email: ${user.account.userMail}</p>
                        <p>Gender: ${user.userGender}</p>
                         <p>Birth: ${user.userBirth}</p>
                        <p>Address: ${user.userAddress}</p>
                        <p>Phone: ${user.userPhone}</p>

                    </div>
                    <div class="renter-info">
                        <h3>Renter Information</h3>
                        <p>Room Number: ${user.room.roomNumber}</p>
                        <p>Room Floor: ${user.room.roomFloor}</p>
                        <p>CGR Score: ${user.renter.CGRScore}</p>
                        <p>Balance: ${user.renter.balance}</p>
                        <!-- Add other renter-related properties as needed -->
                    </div>
                </div>
            </c:forEach>
        </div>

        <!-- Text boxes for user to input updated information -->

        <script src="js/tiny-slider.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/navbar.js"></script>
        <script src="js/counter.js"></script>
        <script src="js/custom.js"></script>
    </body>

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
                    </div>
                    <!-- /.widget -->
                </div>
                <!-- /.col-lg-4 -->
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
                    </div>
                    <!-- /.widget -->
                </div>
                <!-- /.col-lg-4 -->
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
                    </div>
                    <!-- /.widget -->
                </div>
                <!-- /.col-lg-4 -->
            </div>
            <!-- /.row -->


        </div>
        <!-- /.container -->
    </div>
    <!-- /.site-footer -->


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