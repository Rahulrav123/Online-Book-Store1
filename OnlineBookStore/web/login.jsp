<%-- 
    Document   : login
    Created on : Sep 26, 2025, 2:17:37 PM
    Author     : rahul
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="LoginServlet" method="post">
    <label>Email:</label>
    <input type="email" name="email" required><br><br>
    
    <label>Password:</label>
    <input type="password" name="password" required><br><br>
    
    <button type="submit">Login</button>
</form>
<p>Don't have an account? <a href="register.jsp">Register here</a></p>
</body>
</html>

