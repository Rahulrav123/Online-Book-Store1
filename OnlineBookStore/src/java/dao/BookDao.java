/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author rahul
 */

import Model.Book;
import util.DBConnection;
import java.sql.*;
import java.util.*;

public class BookDao {

    public static List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setPrice(rs.getDouble("price"));
                b.setCategory(rs.getString("category"));
                list.add(b);
            }
            rs.close(); st.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public static boolean addBook(Book b) {
        boolean success = false;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO books(title,author,price,category) VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setDouble(3, b.getPrice());
            ps.setString(4, b.getCategory());
            success = ps.executeUpdate() > 0;
            ps.close(); conn.close();
        } catch (Exception e) { e.printStackTrace(); }
        return success;
    }

    // updateBook(), deleteBook(), getBookById() can be added similarly

    public static Book getBookById(int bookId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

