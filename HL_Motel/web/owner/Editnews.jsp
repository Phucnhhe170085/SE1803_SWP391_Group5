<%-- 
    Document   : Editnews
    Created on : Jul 4, 2024, 3:09:03 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    </head>
    <body>
        <div class="container">
        <h2>Edit News</h2>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">${errorMessage}</div>
        </c:if>
        <form action="editNews" method="post">
            <input type="hidden" name="id" value="${news.newId}" />
            <div class="form-group mb-3">
                <label for="title">Title</label>
                <input type="text" class="form-control" id="title" name="title" value="${news.newTitle}" required>
            </div>
            <div class="form-group mb-3">
                <label for="description">Description</label>
                <textarea class="form-control" id="description" name="description" required>${news.description}</textarea>
            </div>
            <div class="form-group mb-3">
                <label for="img">Image URL</label>
                <input type="text" class="form-control" id="img" name="img" value="${news.img}" required>
            </div>
            <div class="form-group mb-3">
                <label for="createAt">Create At</label>
                <input type="text" class="form-control" id="createAt" name="createAt" value="${news.createAt}" required>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </div>
    </body>
</html>
