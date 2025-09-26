<%-- 
    Document   : register
    Created on : Sep 26, 2025, 2:16:58 PM
    Author     : rahul
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Register</h2>
<form action="RegisterServlet" method="post">
    <label>Name:</label>
    <input type="text" name="name" required><br><br>
    
    <label>Email:</label>
    <input type="email" name="email" required><br><br>
    
    <label>Password:</label>
    <input type="password" name="password" required><br><br>
    
    <button type="submit">Register</button>
</form>
<p>Already have an account? <a href="login.jsp">Login here</a></p>
</body>
</html>

