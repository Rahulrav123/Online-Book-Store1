<%-- 
    Document   : books
    Created on : Sep 26, 2025, 2:08:27?PM
    Author     : rahul
--%>

<%@ page import="java.util.*,Model.Book" %>
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>
<h2>Available Books</h2>
<table border="1" cellpadding="5">
<tr><th>Title</th><th>Author</th><th>Price</th><th>Category</th><th>Action</th></tr>
<% for (Book b : books) { %>
<tr>
    <td><%= b.getTitle() %></td>
    <td><%= b.getAuthor() %></td>
    <td><%= b.getPrice() %></td>
    <td><%= b.getCategory() %></td>
    <td><a href="AddToCartServlet?id=<%= b.getId() %>">Add to Cart</a></td>
</tr>
<% } %>
</table>
<a href="cart.jsp">View Cart</a>
<c:if test="${not empty sessionScope.user}">
    <p>Welcome, ${sessionScope.user.name}! 
       <a href="logout.jsp">Logout</a>
    </p>
</c:if>


