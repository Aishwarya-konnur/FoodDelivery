package com.tap.DAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrderDAO;
import com.tap.model.Order;
import com.tap.Utility.DBConnection;

public class OrderDAOImpl implements OrderDAO {

    private Connection con;

    public OrderDAOImpl() {
        con = DBConnection.getConnection();
    }

    @Override
    public void addOrder(Order order) {

        String sql =
        "INSERT INTO orders(userId,totalAmount,status,orderDate) VALUES(?,?,?,?)";

        try {

            PreparedStatement pstmt =
            con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, order.getUserId());
            pstmt.setDouble(2, order.getTotalAmount());
            pstmt.setString(3, order.getStatus());
            pstmt.setTimestamp(4, order.getOrderDate());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            if(rs.next()) {

                order.setOrderId(rs.getInt(1));

            }

        } catch(Exception e) {

            e.printStackTrace();

        }
    }

    @Override
    public void updateOrder(Order order) {

        String sql =
        "UPDATE orders SET userId=?,totalAmount=?,status=?,orderDate=? WHERE orderId=?";

        try {

            PreparedStatement pstmt =
            con.prepareStatement(sql);

            pstmt.setInt(1, order.getUserId());
            pstmt.setDouble(2, order.getTotalAmount());
            pstmt.setString(3, order.getStatus());
            pstmt.setTimestamp(4, order.getOrderDate());
            pstmt.setInt(5, order.getOrderId());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int id) {

        try {

            PreparedStatement pstmt =
            con.prepareStatement(
            "DELETE FROM orders WHERE orderId=?");

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrder(int id) {

        Order order = null;

        try {

            PreparedStatement pstmt =
            con.prepareStatement(
            "SELECT * FROM orders WHERE orderId=?");

            pstmt.setInt(1, id);

            ResultSet rs =
            pstmt.executeQuery();

            if (rs.next()) {

                order = new Order();

                order.setOrderId(rs.getInt("orderId"));
                order.setUserId(rs.getInt("userId"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                order.setStatus(rs.getString("status"));
                order.setOrderDate(rs.getTimestamp("orderDate"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return order;
    }

    @Override
    public List<Order> getAllOrders() {

        List<Order> list = new ArrayList<>();

        try {

            Statement stmt =
            con.createStatement();

            ResultSet rs =
            stmt.executeQuery("SELECT * FROM orders");

            while (rs.next()) {

                Order order = new Order();

                order.setOrderId(rs.getInt("orderId"));
                order.setUserId(rs.getInt("userId"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                order.setStatus(rs.getString("status"));
                order.setOrderDate(rs.getTimestamp("orderDate"));

                list.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    @Override
    public List<Order> getOrdersByUserId(int userId) {

        List<Order> orderList = new ArrayList<>();

        String sql = "SELECT * FROM orders WHERE userId=? ORDER BY orderDate DESC";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Order order = new Order();

                order.setOrderId(rs.getInt("orderId"));
                order.setUserId(rs.getInt("userId"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                order.setStatus(rs.getString("status"));
                order.setOrderDate(rs.getTimestamp("orderDate"));

                orderList.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderList;
    }
    public void updateOrderStatus(int orderId, String status) {

        String sql = "UPDATE orders SET status=? WHERE orderId=?";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, status);
            pstmt.setInt(2, orderId);

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public double getTotalRevenue() {

        double totalRevenue = 0;

        String sql = "SELECT SUM(totalAmount) AS revenue FROM orders";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                totalRevenue = rs.getDouble("revenue");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalRevenue;
    }
}
