<%-- Document : SeNews Created on : Jan 18, 2024, 2:59:38 PM Author : ASUS --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap"
              rel="stylesheet">


        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
        <link rel="stylesheet" href="./vcss/tiny-slider.css">
        <link rel="stylesheet" href="./vcss/aos.css">
        <link rel="stylesheet" href="./vcss/style.css">

        <title>Property &mdash; Free Bootstrap 5 Website Template by Untree.co</title>
        <link rel="icon" href="home-guest/favicon.png">
        <style>
            /*table*/
            .tabular--wrapper {
                background: #fff;
                margin-top: 1rem;
                border-radius: 10px;
                padding: 2rem;
            }
            /* WebKit Scrollbar */
            /* Track */
            ::-webkit-scrollbar-track {
                background: #f1f1f1; /* Change background color */
                border-radius: 10px; /* Set border radius */
            }

            /* Handle */
            ::-webkit-scrollbar-thumb {
                background: #888; /* Change handle color */
                border-radius: 10px; /* Set border radius */
            }

            /* Firefox Scrollbar */
            /* Track */
            .scrollbar-track {
                background: #f1f1f1; /* Change background color */
                border-radius: 10px; /* Set border radius */
            }

            /* Handle */
            .scrollbar-thumb {
                background: #888; /* Change handle color */
                border-radius: 10px; /* Set border radius */
            }

            /* Set scrollbar width for Firefox */
            .scrollbar {
                scrollbar-width: thin;
            }

            /* Set scrollbar width for WebKit */
            ::-webkit-scrollbar {
                width: 10px; /* Set scrollbar width */
            }

            /* Optional: Set scrollbar color */
            .scrollbar::-webkit-scrollbar {
                width: 10px; /* Set scrollbar width */
            }

            /* Optional: Set scrollbar color for thumb */
            .scrollbar::-webkit-scrollbar-thumb {
                background: #888; /* Change thumb color */
                border-radius: 10px; /* Set border radius */
            }

            .table-container {
                width: 100%;
            }

            table {
                width: 100%;
                border-collapse: collapse;
            }

            /*Chinh mau chu o hang dau*/
            thead {
                background: rgb(138, 110, 60, 000);
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
                background: rgba(113, 99, 186, 255);
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
            .user-info {
                display: flex;
                flex-direction: column;
                align-items: center;
                /* Center items horizontally */
                text-align: center;
                /* Center text within the container */
                background-color: #f9f9f9;
                /* Background color */
                border-radius: 10px;
                /* Optional: Add rounded corners */
                box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
                /* Optional: Add box shadow */
                padding: 20px;
                /* Optional: Add padding */
                max-width: 600px;
                /* Optional: Set max-width */
                margin: 20px auto;
                /* Center the container */
            }

            .user-info p {
                font-size: 20px;
                /* Increase paragraph font size */
                color: green;
                /* Change color to green */
                margin-bottom: 12px;
            }
            .guidelines,
            .rules {
                background-color: #f9f9f9;
                /* or any shade of gray you prefer */
                padding: 20px;
                padding-top: 0px;
                /* Add padding for better readability */
                margin-bottom: 20px;
                /* Add margin to separate sections */
                font-size: 20px;
                flex: 1px;
                border-radius: 8px;
                width: 400px;
                /* Fixed width */
                height: 300px;
                /* Fixed height */
                padding-right: 100px;
                overflow-y: auto;
                /* Add scrollbar if content exceeds dimensions */
                margin: 10px;
            }
            .rule-container {
                display: flex;
                flex-direction: column;
            }
            .container {
                display: flex;
                justify-content: space-between;
                padding-right: 20px;
            }
            .rule-group .rule-list {
                display: flex;
                gap: 30px;
                /* Display Rule 1 and Rule 2 in a row */
            }
            .rule-group li {
                margin-right: 10px;
                /* Adjust spacing between rules */
            }
            .guidelines ul li {
                margin-bottom: 20px;
                /* Adjust as needed */
            }
            .guidelines h2,
            .rules h2 {
                position: sticky;
                margin-top: 0;
                top: 0;
                background-color: #f9f9f9;
                border-radius: 8px;
                padding: 10px 20px;
                margin-bottom: 10px;
            }
            @media (max-width: 768px) {
                .renter-info {
                    max-width: 100%;
                }
                #searchInput {
                    width: 100%;
                    max-width: 300px;
                    padding: 10px;
                    border: 1px solid #ccc;
                    border-radius: 5px;
                    box-sizing: border-box; /* Ensures padding and border are included in the width */
                    margin: 0 auto; /* Center horizontally */
                    display: block;
                    font-size: 16px;
                    transition: border-color 0.3s ease;
                }

                /* Style for the placeholder text */
                #searchInput::placeholder {
                    color: #999;
                }

                /* Style for the search input on focus */
                #searchInput:focus {
                    outline: none; /* Remove default focus outline */
                    border-color: #007bff; /* Change border color on focus */
                }
                .show-picture {
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    height: 300px; /* Adjust height as needed */
                    margin-top: 20px; /* Add margin for spacing */
                }

                .show-picture img {
                    max-width: 100%;
                    max-height: 100%;
                }
                .pictureContainer{
                    margin-left: 150px;
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
                            <a href="rentercontroller?service=renterhome" class="logo m-0 float-start">Renter</a>

                            <jsp:include page = "navbar.jsp"></jsp:include>

                            <a href="#"
                               class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none"
                               data-toggle="collapse" data-target="#main-navbar">
                                <span></span>
                            </a>

                        </div>
                    </div>
                </div>
            </nav>


            <div class="PaddingMenu" style="background-image: url('');
                height: 100px;
                padding: 40px;">
                <!-- Content of PaddingMenu -->
            </div>
            <!-- Content section -->
            <h3 style="text-align: center;
            font-size: 38px; margin-top: 30px">Guideline And Rule</h3>
            <input type="text" id="searchInput" placeholder="Search Guide and Rule" style="display: block;
            margin: 0 auto;
            font-size: 18px; ">

            <div class="container">
                <div class="guidelines">
                    <h2>Community Guidelines</h2>
                    <ul>
                        <c:forEach items="${ListG}" var="guide">
                            <li>
                                <a href="#" onclick="showPicture('${guide.img}')">${guide.guideName}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div> 
                <div class="rules">
                    <h2>Rules and Regulations</h2>
                    <div class="rule-container">
                        <div class="rule-group">
                            <ul class="rule-list">
                                <c:forEach items="${ListR}" var="rule" varStatus="loop">
                                    <c:if test="${loop.index % 2 == 0}">
                                        <li><a href="#" onclick="showPicture('${rule.img}')">${rule.ruleName}</a></li>
                                            </c:if>
                                        </c:forEach>
                            </ul>
                        </div>
                        <div class="rule-group">
                            <ul class="rule-list">
                                <c:forEach items="${ListR}" var="rule" varStatus="loop">
                                    <c:if test="${loop.index % 2 != 0}">
                                       <li><a href="#" onclick="showPicture('${rule.img}')">${rule.ruleName}</a></li>
                                            </c:if>
                                        </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>


            </div>
            






    <!-- Preloader -->
    <div id="overlayer"></div>
    <div class="loader">
        <div class="spinner-border" role="status">
            <span class="visually-hidden">Loading...</span>
        </div>
    </div>

    <script>
        function showPicture(pictureUrl) {
            // Clear the existing picture container
            var pictureContainer = document.querySelector('.show-picture');
            pictureContainer.innerHTML = ''; // Clear the contents of the container

            // Create a new div element
            var newDiv = document.createElement('div');
            newDiv.classList.add('pictureContainer'); // Add a CSS class to style the new div if needed

            // Create a new image element
            var newImg = document.createElement('img');
            newImg.src = pictureUrl;
            newImg.alt = 'Guide Picture';
            newImg.style.maxWidth = '100%'; // Set maximum width to 100% of the container
            newImg.style.maxHeight = '100%'; // Set maximum height to 100% of the container
           

            // Append the image element to the new div
            newDiv.appendChild(newImg);

            // Append the new div to the picture container
            pictureContainer.appendChild(newDiv);
        }
    </script>

    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/tiny-slider.js"></script>
    <script src="js/aos.js"></script>
    <script src="js/navbar.js"></script>
    <script src="js/counter.js"></script>
    <script src="js/custom.js"></script>
</body>

</html>