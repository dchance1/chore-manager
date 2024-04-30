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
    <title>Dashboard</title>
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
<!--TABLE HEADERS = Chore | User | Room | -->
<table>
    <tr>
        <th>Chore</th>
        <th>Room</th>
        <th>Assigned To</th>
    </tr>
    <!-- Gettign attribute names 'chores' which is a list containining Java Object[] whith Object in the
    following indexes. For example, index 0 = Chore.java, 1 = ChoreType.java, 2 = User.java, 3 = Room.java -->
    <c:forEach items="${chores}" var="element">
        <tr>
            <td>
                <c:set value="${element[1]}" var="choreType"/>
                <c:out value="${choreType.choreName}"/>
            </td>
            <td>
                <c:set value="${element[3]}" var="room"/>
                <c:out value="${room.roomName}"/>
            </td>
            <td>
                <c:set value="${element[2]}" var="user"/>
                <c:out value="${user.username}"/>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
