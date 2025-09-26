<%-- 
    Document   : logout
    Created on : Sep 26, 2025, 2:18:13 PM
    Author     : rahul
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.invalidate(); // ends the session
    response.sendRedirect("login.jsp"); // redirect to login page
%>

