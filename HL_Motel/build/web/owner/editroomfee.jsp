<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Room Fee</title>
</head>
<body>
    <h1>Edit Room Fee</h1>

    <c:if test="${not empty updateMessage}">
        <p>${updateMessage}</p>
    </c:if>

    <form action="editroomfee" method="post">
        <table>
            <tr>
                <td>Service:</td>
                <td><input type="text" name="service" value="${billDetail.service}"></td>
            </tr>
            <tr>
                <td>Electric:</td>
                <td><input type="text" name="electric" value="${billDetail.electric}"></td>
            </tr>
            <tr>
                <td>Water:</td>
                <td><input type="text" name="water" value="${billDetail.water}"></td>
            </tr>
            <tr>
                <td>Room Fee:</td>
                <td><input type="text" name="roomFee" value="${billDetail.roomFee}"></td>
            </tr>
            <tr>
                <td>Other:</td>
                <td><input type="text" name="other" value="${billDetail.other}"></td>
            </tr>
            <tr>
                <td>Penalty Money:</td>
                <td><input type="text" name="penMoney" value="${billDetail.penMoney}"></td>
            </tr>
            <tr>
                <td>Deadline:</td>
                <td><input type="text" name="deadline" value="${billDetail.deadline}"></td>
            </tr>
            <tr>
                <td>Pay At:</td>
                <td><input type="text" name="payAt" value="${billDetail.payAt}"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Update"></td>
            </tr>
        </table>
    </form>
</body>
</html>
