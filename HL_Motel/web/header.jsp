<%-- 
    Document   : header.jsp
    Created on : Jun 10, 2024, 10:05:17 PM
    Author     : DAT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Untree.co">
        <link rel="shortcut icon" href="favicon.png">

        <meta name="description" content="" />
        <meta name="keywords" content="bootstrap, bootstrap5" />

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">

        <!-- Include jQuery from a CDN -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/2.0.8/css/dataTables.dataTables.css" />

        <script src="https://cdn.datatables.net/2.0.8/js/dataTables.js"></script>

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
                        <a href="index.html" class="logo m-0 float-start">Property</a>

                        <ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu float-end">
                            <li><a href="index.html">Home</a></li>
                            <li class="has-children">
                                <a href="properties.html">Properties</a>
                                <ul class="dropdown">
                                    <li><a href="#">Buy Property</a></li>
                                    <li><a href="#">Sell Property</a></li>
                                    <li class="has-children">
                                        <a href="#">Dropdown</a>
                                        <ul class="dropdown">
                                            <li><a href="#">Sub Menu One</a></li>
                                            <li><a href="#">Sub Menu Two</a></li>
                                            <li><a href="#">Sub Menu Three</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li class="active"><a href="services.html">Services</a></li>
                            <li><a href="about.html">About</a></li>
                            <li><a href="contact.html">Contact Us</a></li>
                        </ul>

                        <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                            <span></span>
                        </a>

                    </div>
                </div>
            </div>
        </nav>
    </body>
</html>
