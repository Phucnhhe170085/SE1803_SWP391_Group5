<%-- 
    Document   : testImage
    Created on : Jun 21, 2024, 11:15:43 PM
    Author     : DAT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="uploadFile" enctype="multipart/form-data">
            <input type="file" name="file" required>
            <button>Submit</button>
        </form>
    </body>
</html>
