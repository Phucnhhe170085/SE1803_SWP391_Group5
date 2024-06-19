<%-- 
    Document   : login
    Created on : Jan 9, 2024, 10:22:56 AM
    Author     : yetvv.piacom
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <title>Login</title>

        <link rel="icon" href="home-guest/favicon.png">
        <link rel="stylesheet" href="css/login.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            /*
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/CascadeStyleSheet.css to edit this template
            */
            /* 
                Created on : Jan 21, 2024, 7:26:14 PM
                Author     : yetvv.piacom
            */

            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;
            }

            body {
                height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 10px;
                background: linear-gradient(135deg, #30BD36, #5A84E6);
            }

            .container {
                max-width: 700px;
                width: 100%;
                background-color: #fff;
                padding: 25px 30px;
                border-radius: 5px;
                box-shadow: 0 5px 10px rgba(0, 0, 0, 0.15);
            }

            .container1 {
                max-width: 700px;

                background-color: #fff;
                padding: 25px 30px;
                border-radius: 5px;
                box-shadow: 0 5px 10px rgba(0, 0, 0, 0.15);
            }

            .container1 .title {
                font-size: 25px;
                font-weight: 500;
                position: relative;
            }

            .container1 .title::before {
                content: "";
                position: absolute;
                left: 0;
                bottom: 0;
                height: 3px;
                width: 30px;
                border-radius: 5px;
                background: linear-gradient(135deg, #30BD36, #5A84E6);
            }


            .container .title {
                font-size: 25px;
                font-weight: 500;
                position: relative;
            }

            .container .title::before {
                content: "";
                position: absolute;
                left: 0;
                bottom: 0;
                height: 3px;
                width: 30px;
                border-radius: 5px;
                background: linear-gradient(135deg, #30BD36, #5A84E6);
            }

            .content form .user-details {
                display: flex;
                flex-wrap: wrap;
                justify-content: space-between;
                margin: 20px 0 12px 0;
            }

            .content form .user-details {
                display: flex;
                flex-wrap: wrap;
                justify-content: space-between;
                margin: 20px 0 12px 0;
            }

            form .user-details .input-box {
                margin-bottom: 15px;
                width: calc(100% / 2 - 20px);
            }

            form .input-box span.details {
                display: flex;
                font-weight: 500;
                margin-bottom: 5px;
            }

            .user-details .input-box input {
                height: 45px;
                width: 100%;
                outline: none;
                font-size: 16px;
                border-radius: 5px;
                padding-left: 15px;
                border: 1px solid #ccc;
                border-bottom-width: 2px;
                transition: all 0.3s ease;
            }

            .user-details .input-box input:focus,
            .user-details .input-box input:valid {
                border-color: #5A84E6;
            }


            .content form .user-details1 {
                display: block;
                flex-wrap: wrap;
                justify-content: space-between;
                margin: 20px 0 12px 0;
            }

            form .user-details1 .input-box {
                margin-bottom: 15px;
                width: calc(100% / 2 - 20px);
            }

            form .input-box span.details {
                display: flex;
                font-weight: 500;
                margin-bottom: 5px;
            }

            .user-details1 .input-box input {
                height: 45px;
                width: 400px;
                outline: none;
                font-size: 16px;
                border-radius: 5px;
                padding-left: 15px;
                border: 1px solid #ccc;
                border-bottom-width: 2px;
                transition: all 0.3s ease;
            }

            .user-details1 .input-box input:focus,
            .user-details1 .input-box input:valid {
                border-color: #5A84E6;
            }




            form .gender-details .gender-title {
                font-size: 20px;
                font-weight: 500;
            }

            form .category {
                display: flex;
                width: 80%;
                margin: 14px 0;
                justify-content: space-between;
            }

            form .category label {
                display: flex;
                align-items: center;
                cursor: pointer;
            }

            form .category label .dot {
                height: 18px;
                width: 18px;
                border-radius: 50%;
                margin-right: 10px;
                background: #d9d9d9;
                border: 5px solid transparent;
                transition: all 0.3s ease;
            }

            #dot-1:checked~.category label .one,
            #dot-2:checked~.category label .two,
            #dot-3:checked~.category label .three {
                background: #9b59b6;
                border-color: #d9d9d9;
            }

            form input[type="radio"] {
                display: none;
            }

            form .button {
                height: 45px;
                border: none;
            }

            form .button input {
                height: 45px;
                width: 400px;
                border-radius: 5px;
                border: none;
                color: #fff;
                font-size: 18px;
                font-weight: 500;
                letter-spacing: 1px;
                cursor: pointer;
                transition: all 0.3s ease;
                background: linear-gradient(135deg, #30BD36, #5A84E6);
            }

            form .button input:hover {
                /* transform: scale(0.99); */
                background: linear-gradient(-135deg, #30BD36, #5A84E6);
            }

            form .button1 {
                height: 45px;
                margin: 35px 0
            }

            form .button1 input {
                height: 100%;
                width: 400px;
                border-radius: 5px;
                border: none;
                color: #fff;
                font-size: 18px;
                font-weight: 500;
                letter-spacing: 1px;
                cursor: pointer;
                transition: all 0.3s ease;
                background: linear-gradient(135deg, #30BD36, #5A84E6);
            }

            form .button input:hover {
                /* transform: scale(0.99); */
                background: linear-gradient(-135deg, #30BD36, #5A84E6);
            }

            .form1 .button {
                height: 45px;
                margin: 35px 0
            }

            .form1 .button input {
                height: 100%;
                width: 400px;
                border-radius: 5px;
                border: none;
                color: #fff;
                font-size: 18px;
                font-weight: 500;
                letter-spacing: 1px;
                cursor: pointer;
                transition: all 0.3s ease;
                background: linear-gradient(135deg, #30BD36, #5A84E6);
            }

            .form1 .button input:hover {
                /* transform: scale(0.99); */
                background: linear-gradient(-135deg, #30BD36, #5A84E6);
            }





            @media(max-width: 584px) {
                .container {
                    max-width: 100%;
                }

                form .user-details .input-box {
                    margin-bottom: 15px;
                    width: 100%;
                }

                form .category {
                    width: 100%;
                }

                .content form .user-details {
                    max-height: 300px;
                    overflow-y: scroll;
                }

                .user-details::-webkit-scrollbar {
                    width: 5px;
                }
            }

            @media(max-width: 459px) {
                .container .content .category {
                    flex-direction: column;
                }
            }
        </style>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    </head>
    <body>
        <div class="container1">
            <div class="title">Login</div>
            <h3 style="color: #FF0E0E; margin-top: 20px;">${message}</h3>
            <div class="content">
                <form id="loginForm" action="login" method="post" onsubmit="return validateRecaptcha();">
                    <div class="user-details1">
                        <div class="input-box">
                            <span class="details">Email</span>
                            <input type="email" name="email" placeholder="Enter your Email" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Password</span>
                            <input type="password" name="password" placeholder="Enter your Password" required>
                        </div>
                        <div class="g-recaptcha" data-sitekey="6Ld9Ou0pAAAAAF7_lKuiJ9rv_FmYvEfjzGhp7f0k"></div>
                        <br/>
                        <span class="details">
                            Don't have an account?
                            <a href="register.jsp" style="text-decoration: none; font-weight: 600;">Register now</a>
                        </span>
                    </div>
                    <div class="button">
                        <input type="submit" value="Login" style="width: 400px; height: 45px">
                    </div>
                </form>

                <div class="form1">
                    <div class="button">
                        <a href="forgotPassword.jsp"><input type="button" value="Forgot password"></a>
                    </div>
                </div>
            </div>
        </div>

        <script>
            function validateRecaptcha() {
                var response = grecaptcha.getResponse();
                if (response.length == 0) {
                    alert("Please complete the reCAPTCHA");
                    return false;
                }
                return true;
            }
        </script>
    </body>
</html>