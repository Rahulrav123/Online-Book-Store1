<%-- 
    Document   : cart
    Created on : Sep 26, 2025, 2:08:51?PM
    Author     : rahul
--%>


<%@ page import="java.util.*,Model.CartItem" %>
<%
    List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
    double total = 0;
%>

<h2>Your Cart</h2>
<% if (cart == null || cart.isEmpty()) { %>
    <p>Your cart is empty.</p>
<% } else { %>
<table border="1" cellpadding="5">
<tr><th>Title</th><th>Price</th><th>Qty</th><th>Subtotal</th></tr>
<% for (CartItem item : cart) {
    double subtotal = item.getSubtotal();
    total += subtotal;
%>
<tr>
    <td><%= item.getTitle() %></td>
    <td><%= item.getPrice() %></td>
    <td><%= item.getQuantity() %></td>
    <td><%= subtotal %></td>
</tr>
<% } %>
<tr><td colspan="3" align="right"><b>Total:</b></td><td><b><%= total %></b></td></tr>
</table>

<form action="PlaceOrderServlet" method="post">
    <button type="submit">Place Order</button>
</form>
<% } %>
<c:if test="${not empty sessionScope.user}">
    <p>Welcome, ${sessionScope.user.name}! 
       <a href="logout.jsp">Logout</a>
    </p>
</c:if>
