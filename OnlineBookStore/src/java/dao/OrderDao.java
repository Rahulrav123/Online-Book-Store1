/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import Model.CartItem;
import Model.Order;
import util.DBConnection;

import java.sql.*;
import java.util.List;

public class OrderDao {

    public static boolean placeOrder(Order order) {
        String orderSql = "INSERT INTO orders(user_id, total, order_date) VALUES(?,?,?)";
        String itemSql = "INSERT INTO order_items(order_id, book_id, quantity, price) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false); // Start transaction

            // Insert order
            PreparedStatement psOrder = conn.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
            psOrder.setInt(1, order.getUserId());
            psOrder.setDouble(2, order.getTotal());
            psOrder.setTimestamp(3, new Timestamp(order.getOrderDate().getTime()));
            psOrder.executeUpdate();

            ResultSet rs = psOrder.getGeneratedKeys();
            int orderId = 0;
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            // Insert order items
            PreparedStatement psItem = conn.prepareStatement(itemSql);
            for (CartItem item : order.getItems()) {
                psItem.setInt(1, orderId);
                psItem.setInt(2, item.getBookId());
                psItem.setInt(3, item.getQuantity());
                psItem.setDouble(4, item.getPrice());
                psItem.addBatch();
            }
            psItem.executeBatch();

            conn.commit(); // Commit transaction
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

