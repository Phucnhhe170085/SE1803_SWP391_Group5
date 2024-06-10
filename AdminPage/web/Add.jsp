<%-- 
    Document   : Add
    Created on : Jun 5, 2024, 10:55:38 AM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;

            }
            .body{
                height: 100vh;
                background: #dadada;
                
                
                
                background-image: linear-gradient(45deg,rgb(0, 204, 255)10%,rgb(255, 102, 255)30%,rgb(255, 214, 153)90%);
                
            }
            .container{
                width: 500px;
                height: 600px;
                background: white;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0,0,0,0.2);
                margin: 50px auto;
                text-align: center;
                padding: 10px 20px;

            }

            .form-label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
            }

            .form-input {
                width: 200px;
                padding: 5px;
                margin-bottom: 10px;
            }
            .label{
                display: flex;
                align-items: center;
                margin-bottom: 10px;

            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Add account</h1>
            <form action="add" method="post" onsubmit="return validate();">
                <div class="label" >
                    <label for="email" class="form-label">Email:</label>
                    <input type="text" name="email" id="email" class="form-input" required/><br><!-- comment -->
                </div>
                <div class="label" >
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" name="password" id="password" class="form-input" required/><br><!-- comment -->
                </div>
                <div class="label" >
                    <label for="role" class="form-label">Role:</label>
                    <input type="number" name="role" id="role" class="form-input" required/><br><!-- comment -->
                </div>
                <input type="submit" value="ADD" name="add" />

            </form>
        </div>
    </body>
    <script>
        function validate() {
            var email = document.getElementById("email").value;
            var password = document.getElementById("password").value;

            if (email.length === 0) {
                alert("Please enter an email.");
                return false;
            }

            if (password.length === 0) {
                alert("Please enter a password.");
                return false;
            }

            return true;
        }
    </script>
</html>
