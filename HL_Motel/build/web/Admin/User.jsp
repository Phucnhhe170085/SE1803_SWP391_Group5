<%-- 
    Document   : User
    Created on : May 29, 2024, 9:06:48 PM
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
       <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
              img {
            height: 200px;
            width: 200px;
        }
    </style>
    <body>
        <table border="1">

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Birth</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Avatar</th>
            </tr>



            <c:forEach var="user" items="${user}">
                <tr>
                    <td>${user.userID}</td>
                    <td>${user.userName}</td>
                    <td>${user.userGender}</td>
                    <td>${user.userBirth}</td>
                    <td>${user.userAddress}</td>
                    <td>${user.userPhone}</td>
                    <td><img src="${user.userAvatar}" alt="User" ></td>
                </tr>
            </c:forEach>



        </table>



    </body>
</html>
