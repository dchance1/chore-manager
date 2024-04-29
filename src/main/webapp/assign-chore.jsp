<%--
  Created by IntelliJ IDEA.
  User: darrenchance
  Date: 4/27/24
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Assign Chore</title>
</head>
<body>
<h1>
    You can use this page to assign a chore to a member of the household.
</h1>
<div>
    <table>
        <thead>
        <h3>Assign a Chore</h3>
        </thead>
        <form action="create-chore-servlet">
            <tr>
                <td>
                    <label>Chore: </label>
                </td>
                <td>
                    <select name="chore-type">
                        <c:forEach items="${choreList}" var="listItem" varStatus="count">
                            <option value="${listItem.choreTypeId}">${listItem.choreName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Where: </label>
                </td>
                <td>
                    <select name="room">
                        <c:forEach items="${roomList}" var="listItem" varStatus="count">
                            <option value="${listItem.roomId}">${listItem.roomName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Assigned to: </label>
                </td>
                <td>
                    <select name="username">
                        <c:forEach items="${userList}" var="listItem" varStatus="count">
                            <option value="${listItem.id}">${listItem.username}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Create Chore">
                </td>
            </tr>
        </form>
    </table>
</div>



</body>
</html>
