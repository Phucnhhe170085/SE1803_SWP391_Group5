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

        <title>Property &mdash; Free Bootstrap 5 Website Template by Untree.co</title>
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
                max-width: 400px;
            }

            .info-container h3 {
                color: #555;
            }

            /* Responsive adjustments for smaller screens */
            @media (max-width: 768px) {
                .info-container {
                    flex-direction: column;
                }

                .user-info,
                .renter-info {
                    width: 100%;
                    text-align: center;
                    margin: 10px 0;
                }

                .personal-info h2 {
                    margin: 10px 0;
                    color: #006eff;
                }
            }

            /* Additional styles for the update profile section */
            .update-profile {
                margin-top: 50px;
                padding: 20px;
                background-color: #f9f9f9;
                border-radius: 8px;
                box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
                max-width: 600px;
                margin: 0 auto;
            }

            .profile-title h3 {
                color: #555;
                margin-bottom: 34px;
                text-align: center;
            }
            .profile-title a {
                font-size: 20px;
            }

            .update-profile form {
                display: grid;
                grid-gap: 10px;
            }

            .update-profile input[type="text"] {
                width: 100%;
                padding: 10px;
                border: 2px solid #ccc;
                border-radius: 15px; /* Updated border radius */
                box-sizing: border-box;
                margin-bottom: 15px; /* Add 15px margin bottom */
            }

            .update-profile button {
                width: 100%;
                padding: 12px;
                border: none;
                border-radius: 5px;
                background-color: #007bff;
                color: #fff;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            .update-profile button:hover {
                background-color: #0056b3;
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
            /* Added CSS for gender radio buttons */
            .gender-radio {
                display: flex;
                align-items: center;
            }

            .gender-radio input[type="radio"] {
                margin-right: 10px;
            }

            /* Same CSS styling for all input fields */
            .update-profile input[type="text"],
            .update-profile input[type="number"],
            .update-profile input[type="radio"] {
                width: 100%;
                padding: 10px;
                border: 2px solid #ccc;
                border-radius: 15px;
                box-sizing: border-box;
                margin-bottom: 15px;
            }

            .update-profile button {
                width: 100%;
                padding: 12px;
                border: none;
                border-radius: 5px;
                background-color: #007bff;
                color: #fff;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            .update-profile button:hover {
                background-color: #0056b3;
            }

        </style>
    </head>

    <body>
        <div class="container">
            <div class="main-body">
                <div>
                    <nav class="site-nav" style="width: 85%">
                        <div class="container" >
                            <div class="menu-bg-wrap">
                                <div class="site-navigation">
                                    <a href="renterprofile" class="logo m-0 float-start" style="text-decoration: none;">Profile</a>

                                    <jsp:include page="navbar.jsp"></jsp:include>

                                        <a href="" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                                            <span></span>
                                        </a>

                                    </div>
                                </div>
                            </div>
                        </nav>
                    </div>


                    <div class="PaddingMenu" style="background-image: url(''); height: 120px; padding: 40px;">
                        <!-- Content of PaddingMenu -->
                    </div>
                    <!--INSERT PERSONAL INFO-->


                    <div class="Avatar">
                        <h3>Update Profile</h3>         
                        <center><a href="renterprofile">Back To Profile</a></center>         
                    </div>
                    <div class="update-profile">
                        <form action="renterupdate" method="post">
                        <c:set var="user" value="${requestScope.user}" />

                        <input type="hidden" name="userID" value="${param.userID}" readonly/><br/>

                        Enter Name: <input type="text" name="userName" value="${user.userName}"/><br/>

                        Enter Gender: 
                        <div class="gender-radio">
                            Male: <input type="radio" id="male" name="userGender" value="Male" <c:if test="${user.userGender == 'Male'}">checked</c:if>>
                            Female: <input type="radio" id="female" name="userGender" value="Female" <c:if test="${user.userGender == 'Female'}">checked</c:if>>
                            </div>

                            Enter Birth: <input type="text" name="userBirth" value="${user.userBirth}"/><br/>
                        Enter Address: <input type="text" name="userAddress" value="${user.userAddress}"/><br/>

                        Enter Phone: <input type="text" name="userPhone" value="${user.userPhone}"/><br/>

                        <input type="submit" value="Update"/>
                    </form>
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