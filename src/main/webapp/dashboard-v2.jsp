<%--
  Created by IntelliJ IDEA.
  User: darrenchance
  Date: 4/29/24
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Dashboard-v2</title>
</head>
<style>
    table, th, td {
        border: 1px solid black;
    }
</style>
<body>
<ul>
    <li><a href="index.jsp">Home</a></li>
    <li><a href="dashboard-servlet">Dashboard</a></li>
    <li><a href="assign-chores-servlet">Assign Chores</a></li>
    <li><a href="login.jsp">Log Out</a></li>
    <li><a href="contact.asp">Contact</a></li>
    <li><a href="about.asp">About</a></li>
</ul>

<h1>Chores</h1>
<c:set value="${rooms}" var="roomList"/>
<!--TABLE HEADERS = Chore | Room | First Name | Username -->
<c:forEach items="${roomList}" var="item">
    <c:forEach items="${roomObjs}" var="room">
        <c:if test="${room.roomId == item}">
            <h2>${room.roomName}</h2>
        </c:if>
    </c:forEach>
<table>
    <th>Chore</th>
    <th>Username</th>
    <c:forEach items="${chores}" var="choreItem">


            <c:if test="${choreItem.roomId == item}">


                <tr>
                    <td>${choreItem.choreTypesByChoreTypeId.choreName}</td>
                    <td>${choreItem.usersByUserId.username}</td>
                </tr>


            </c:if>


    </c:forEach>
</table>

</c:forEach>


</body>
</html>
