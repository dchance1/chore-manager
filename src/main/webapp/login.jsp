<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Log into Chore Manager</title>
</head>
<body>
<h1>Chore Manager 123
</h1>
<div class="login_form_container">
<p>Log on to manage your chores
</p>
</div>

<form id="login_form" method="post" action="index.jsp">
    <div class="email_container">
        <input type="text" placeholder="Email or phone number"/>
    </div>
    <br>
    <div>
        <input type="password" placeholder="Password">
    </div>
    <br>
    <div>
        <button type="submit">
            Log In
        </button>
    </div>


</form>
<br/>
</body>
</html>