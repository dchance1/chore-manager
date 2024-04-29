<%--
  Created by IntelliJ IDEA.
  User: darrenchance
  Date: 4/29/24
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
</head>
<body>
<ul>
    <li><a href="index.jsp">Home</a></li>
    <li><a href="login.jsp">Dashboard</a></li>
    <li><a href="assign-chores-servlet">Assign Chores</a></li>
    <li><a href="login.jsp">Log Out</a></li>
    <li><a href="contact.asp">Contact</a></li>
    <li><a href="about.asp">About</a></li>
</ul>
<p>
    <%=request.getAttribute("successMessage")%>
</p>
<a href="assign-chores-servlet">Add More Chores</a>


</body>
</html>
