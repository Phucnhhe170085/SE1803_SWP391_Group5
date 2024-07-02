<%-- 
    Document   : home
    Created on : Jan 12, 2024, 8:23:33 AM
    Author     : yetvv.piacom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Designined by CodingLab - youtube.com/codinglabyt -->
<html lang="en" dir="ltr">

    <head>
        <meta charset="UTF-8">
        <title> Register </title>
        <link rel="icon" href="home-guest/favicon.png">
        <link rel="stylesheet" href="css/register.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
        document.addEventListener("DOMContentLoaded", function () {
            
            var passwordInput = document.querySelector('input[name="password"]');
            var repasswordInput = document.querySelector('input[name="repassword"]');
            var messageElement = document.querySelector('#message');

            
            passwordInput.addEventListener("input", validatePassword);
            repasswordInput.addEventListener("input", validatePassword);

            
            function validatePassword() {
                var password = passwordInput.value;
                var repassword = repasswordInput.value;

                if (password !== repassword) {
                    messageElement.textContent = "Password and Confirm-Password are not match.";
                    messageElement.style.color = "#FF0E0E";
                } else {
                    messageElement.textContent = "";
                }
            }
        });
    </script>
    </head>

    <body>
        <div class="container">
            <div class="title">Register</div>
            <h3 id="message" style="color: #FF0E0E; margin-top: 20px;">${message}</h3>
            <div class="content">
                <form action="register" method="post">
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Username</span>
                            <input type="text" placeholder="Enter your username" name="username" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Email</span>
                            <input type="mail" placeholder="Enter your email" name="usermail" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Phone Number</span>
                            <input type="text" placeholder="Enter your number" name="userphone" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Password</span>
                            <input type="password" placeholder="Enter your password" name="password" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Address</span>
                            <input type="text" placeholder="Confirm your Address" name="address" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Confirm Password</span>
                            <input type="password" placeholder="Confirm your password" name="repassword" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Birth Day</span>
                            <input type="date" name="dob">
                        </div>

                        <div class="input-box">
                            <span class="details">Gender</span>
                            <select id="gender" name="gender"
                                style="width: 300px;height: 40px;border-radius: 5px; padding-left: 15px;font-size: 16px;">
                                <option value="Male" selected="selected">Male</option>
                                <option value="Female">Female</option>
                                <option value="Other">Other</option>
                            </select>
                        </div>
                    </div>




                    <div class="button" ">
                        <input type="submit" value="Register" style="width: 650px;">
                    </div>
                    ${message}
                </form>

                <div class="form1">
                    <div class="button">
                        <a href="login.jsp"><input type="submit" value="Back to Login" style="width: 650px;"></a>
                    </div>
                </div>


            </div>
        </div>

    </body>

</html>
