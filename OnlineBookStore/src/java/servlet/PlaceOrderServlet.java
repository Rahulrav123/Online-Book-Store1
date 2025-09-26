/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

/**
 *
 * @author rahul
 */


import dao.OrderDao;
import Model.CartItem;
import Model.Order;
import Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        if (cart == null || cart.isEmpty()) {
            response.getWriter().println("❌ Your cart is empty.");
            return;
        }

        double total = 0;
        for (CartItem item : cart) {
            total += item.getSubtotal();
        }

        Order order = new Order();
        order.setUserId(user.getId());
        order.setItems(cart);
        order.setTotal(total);
        order.setOrderDate(new Date());

        if (OrderDao.placeOrder(order)) {
            session.removeAttribute("cart");
            response.sendRedirect("order-success.jsp");
        } else {
            response.getWriter().println("❌ Failed to place order.");
        }
    }
}

