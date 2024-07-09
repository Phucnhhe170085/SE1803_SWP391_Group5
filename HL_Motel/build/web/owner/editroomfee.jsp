<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Edit Room Fee</title>
</head>
<body>
    <h1>Edit Room Fee</h1>
    
    <form action="${pageContext.request.contextPath}/editroomfee" method="POST">
        <table>
            <tr>
                <td>Bill ID:</td>
                <input type="hidden"  id="billID" name="billID" value="<%= request.getParameter("id") %>">
                <td><input type="text" name="billID" value="${billDetail.billID}" readonly /></td>
            </tr>
            <tr>
                <td>Room ID:</td>
                <td><input type="text" name="roomId" value="${room.roomID}" readonly /></td>
            </tr>
            <tr>
                <td>Room Fee:</td>
                <td><input type="text" name="roomFee" value="${room.roomFee}" readonly /></td>
            </tr>
            <tr>
                <td>Electricity Price:</td>
                <td><input type="text" name="eprice" value="${eprice}" readonly /></td>
            </tr>
            <tr>
                <td>Water Price:</td>
                <td><input type="text" name="wprice" value="${wprice}" readonly /></td>
            </tr>
            <tr>
                <td>Electricity Used:</td>
                <td><input type="text" name="electric" value="${billDetail.electric}" /></td>
            </tr>
            <tr>
                <td>Water Used:</td>
                <td><input type="text" name="water" value="${billDetail.water}" /></td>
            </tr>
            <tr>
                <td>Service Fee:</td>
                <td><input type="text" name="service" value="${billDetail.serviceFee}" /></td>
            </tr>
            <tr>
                <td>Other Charges:</td>
                <td><input type="text" name="other" value="${billDetail.otherCharges}" /></td>
            </tr>
            <tr>
                <td>Penalty Fee:</td>
                <td><input type="text" name="penMoney" value="${billDetail.penaltyFee}" /></td>
            </tr>
            <tr>
                <td>Deadline:</td>
                <td><input type="text" name="deadline" value="${billDetail.deadline}" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Update Fee" /></td>
            </tr>
        </table>
    </form>

    <c:if test="${not empty updateMessage}">
        <p>${updateMessage}</p>
    </c:if>
</body>
</html>
