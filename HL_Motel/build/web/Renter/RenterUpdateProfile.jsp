<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Update Profile</h1>
        <form action="renterupdate" method="post">
            <div class="form-group">
                <label for="userName">Full Name</label>
                <input type="text" name="userName" class="form-control" value="${user.userName}" />
            </div>
            <div class="form-group">
                <label for="userGender">Gender</label>
                <select name="userGender" class="form-control">
                    <option value="Female" ${user.userGender eq 'Female' ? 'selected' : ''}>Female</option>
                    <option value="Male" ${user.userGender eq 'Male' ? 'selected' : ''}>Male</option>
                    <option value="Other" ${user.userGender eq 'Other' ? 'selected' : ''}>Other</option>
                </select>
            </div>
            <div class="form-group">
                <label for="userBirth">Birth Date</label>
                <input type="date" name="userBirth" class="form-control" value="${user.userBirth}" />
            </div>
            <div class="form-group">
                <label for="userAddress">Address</label>
                <input type="text" name="userAddress" class="form-control" value="${user.userAddress}" />
            </div>
            <div class="form-group">
                <label for="userPhone">Phone</label>
                <input type="text" name="userPhone" class="form-control" value="${user.userPhone}" />
            </div>
            <input type="hidden" name="userID" value="${user.userID}" />
            <button type="submit" class="btn btn-primary">Save Changes</button>
        </form>
    </div>
    <script src='https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js'></script>
</body>
</html>
