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
        <title>Payments</title>
    </head>
    <body>
        <jsp:include page="header.jsp" flush="true"></jsp:include>
            <div class="hero page-inner overlay" style="background-image: url('images/hero_bg_1.jpg');">

                <div class="container">
                    <div class="row justify-content-center align-items-center">
                        <div class="col-lg-9 text-center mt-5">
                            <h1 class="heading" data-aos="fade-up">Payments</h1>
                        </div>
                    </div>
                </div>
            </div>

            <div class="main">
                <div class="container" style="margin-top: 2em">
                    <div class="col-3"><a href="createPayment"><button type="button" class="btn btn-primary">Create Payment</button></div></a>
                    <table id="guildLineTable" class="display">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th><p class="text-center">Money</p></th>
                                <th><p class="text-center">Status</p></th>
                                <th>Created At</th>
                                <th>Updated At</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        <jsp:include page="footer.jsp" flush="true"></jsp:include>
        </body>
        <script>
            $(document).ready(function () {
                var dataList = ${dataList};
                //var realData = JSON.parse(dataList);
                $('#guildLineTable').DataTable({
                    data: dataList,
                    columns: [
                        {title: "ID", data: "id"},
                        {title: "Money", data: "money"},
                        {
                            title: "Status",
                            data: "status",
                            render: function (data, type, row) {
                                if (data === 0) {
                                    return '<button type="button" class="btn btn-info">Pending</span>';
                                } else if (data === 1) {
                                    return '<button type="button" class="btn btn-success">Paid</span>';
                                } else if (data === 2) {
                                    return '<button type="button" class="btn btn-danger">Not Paid</span>';
                                }
                            }
                        },
                        {
                            title: "Created At",
                            data: "createdAt",
                            render: function (data, type, row) {
                                return '<p class="text-left">' + data + '</p>';
                            }
                        },
                        {
                            title: "Updated At",
                            data: "updatedAt",
                            render: function (data, type, row) {
                                return '<p class="text-left">' + data + '</p>';
                            }
                        },
                        {
                            title: "Action",
                            data: "guideID",
                            render: function (data, type, row) {

                                return '\
            <a href="payRequest?id=' + data + '"><button type="button" class="btn btn-success">Pay</button></a>';
                            },
                            orderable: false
                        }
                    ]
                });

            });
    </script>
</html>
