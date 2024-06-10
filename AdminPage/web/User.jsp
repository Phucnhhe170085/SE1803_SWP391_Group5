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
              <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
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
        td a{
            font-size: 25px;
        }
       
    </style>
    <body class="sb-nav-fixed">

        <div id="layoutSidenav_content">
            <main>
                <div id="layoutSidenav">

                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manage User</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="Tables.jsp">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Tables</li>
                                </ol>
                                <div class="card mb-4">
                                    <div class="card-body">
                                         This is the tenant information sheet. You can refer to the information below.
                                        
                                        .
                                    </div>
                                </div>
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-table me-1"></i>
                                        Manage User
                                    </div>
                                    <div class="card-body">
                                        <table id="datatablesSimple" border="1">
                                            <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Gender</th>
                                                <th>Birth</th>
                                                <th>Address</th>
                                                <th>Phone</th>
                                                <th>Avatar</th>
                                                <th>Active</th>
                                            </tr>
                                            </thead>


                                            <c:forEach var="user" items="${user}">
                                                <tr>
                                                    <td>${user.userID}</td>
                                                    <td>${user.userName}</td>
                                                    <td>${user.userGender}</td>
                                                    <td>${user.userBirth}</td>
                                                    <td>${user.userAddress}</td>
                                                    <td>${user.userPhone}</td>
                                                    <td><img src="${user.userAvatar}" alt="User" ></td>
                                                    <td><a href="edit?userMail=${acc.userMail}" class="edit-link">
                                                            <i class="fa-regular fa-pen-to-square"></i>
                                                        </a></td>
                                                    
                                                </tr>
                                            </c:forEach>

                                        </table>
                                    </div>
                                </div>
                            </div>
                            <c:if test="${checkedit == 1}">
                                <form action="edit" method="post">
                                    ${chagneUsermail}<br>
                                    New pass:<input type="text" name="npass"><br>
                                    New role:<input type="text" name="nrole"><br>
                                    <input type="submit" value="Submit">
                                </form>
                            </c:if>
                        </main>
                        <footer class="py-4 bg-light mt-auto">
                            <div class="container-fluid px-4">
                                <div class="d-flex align-items-center justify-content-between small">
                                    <div class="text-muted">HL Motel &copy;  Website 2023</div>

                                </div>
                            </div>
                        </footer>
                    </div>
                </div>
            </main>
            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid px-4">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">Copyright &copy; Your Website 2023</div>
                        <div>
                            <a href="#">Privacy Policy</a>
                            &middot;
                            <a href="#">Terms &amp; Conditions</a>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
    <script src="js/datatables-simple-demo.js"></script>
</body>
</html>
