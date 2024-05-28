<%-- 
    Document   : navbar
    Created on : 25 thg 5, 2024, 15:32:37
    Author     : quocp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu float-end">
                            <li class="active"><a href="OwnerHome.jsp">Home</a></li>
                            <li class="has-children">
                                <a href="properties.html">View</a>
                                <ul class="dropdown">
                                    <li><a href="#">List of room</a></li>
                                    <li><a href="#">Security</a></li>
                                </ul>
                            </li>                            
                            <li><a href="about.html">Payment</a></li>
                            <li><a href="contact.html">Renter Management</a></li>
                            <li class="has-children">
                                <a href="properties.html">Manage</a>
                                <ul class="dropdown">
                                    <li><a href="#">Rule</a></li>
                                    <li><a href="#">News</a></li>
                                </ul>
                            </li>
                            <li><a href="login.html">Login</a></li>
                        </ul>
        
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/tiny-slider.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/navbar.js"></script>
        <script src="js/counter.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>
