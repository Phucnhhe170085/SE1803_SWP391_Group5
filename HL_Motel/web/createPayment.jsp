<%-- 
    Document   : list
    Created on : Jun 10, 2024, 9:56:50 PM
    Author     : DAT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.GuideLine" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Payments</title>
    </head>
    <body>
        <jsp:include page="header.jsp" flush="true"></jsp:include>
            <div class="hero page-inner overlay" style="background-image: url('images/hero_bg_1.jpg');">

                <div class="container">
                    <div class="row justify-content-center align-items-center">
                        <div class="col-lg-9 text-center mt-5">
                            <h1 class="heading" data-aos="fade-up">Create Payment</h1>
                        </div>
                    </div>
                </div>
            </div>

            <div class="main">
                <div class="container" style="margin-top: 2em">
                    <form action="createPayment" method="post">
                        <div class="mb-3 mt-3">
                            <label for="guide-name" class="form-label">Input money you want to deposit to system: </label>
                            <input type="number" class="form-control" id="money" placeholder="Enter money" name="money" required>
                        </div>
                        <button class="btn btn-sucess">Create Payment</button>
                    </form>
                </div>
            </div>
        <jsp:include page="footer.jsp" flush="true"></jsp:include>
    </body>
    <script>

    </script>
</html>
