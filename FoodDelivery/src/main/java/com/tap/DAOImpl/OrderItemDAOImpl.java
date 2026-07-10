package com.tap.DAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.Utility.DBConnection;

public class OrderItemDAOImpl implements OrderItemDAO {

    private Connection con;

    public OrderItemDAOImpl() {
        con = DBConnection.getConnection();
    }

    @Override
    public void addOrderItem(OrderItem orderItem) {

        String sql =
        "INSERT INTO orderitems(orderId,menuId,quantity,price) VALUES(?,?,?,?)";

        try {

            PreparedStatement pstmt =
            con.prepareStatement(sql);

            pstmt.setInt(1, orderItem.getOrderId());
            pstmt.setInt(2, orderItem.getMenuId());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setDouble(4, orderItem.getPrice());

            pstmt.executeUpdate();

            System.out.println("Order Item Added Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {

        String sql =
        "UPDATE orderitems SET orderId=?,menuId=?,quantity=?,price=? WHERE orderItemId=?";

        try {

            PreparedStatement pstmt =
            con.prepareStatement(sql);

            pstmt.setInt(1, orderItem.getOrderId());
            pstmt.setInt(2, orderItem.getMenuId());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setDouble(4, orderItem.getPrice());
            pstmt.setInt(5, orderItem.getOrderItemId());

            pstmt.executeUpdate();

            System.out.println("Order Item Updated Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItem(int orderItemId) {

        String sql =
        "DELETE FROM orderitems WHERE orderItemId=?";

        try {

            PreparedStatement pstmt =
            con.prepareStatement(sql);

            pstmt.setInt(1, orderItemId);

            pstmt.executeUpdate();

            System.out.println("Order Item Deleted Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderItem getOrderItem(int orderItemId) {

        String sql =
        "SELECT * FROM orderitems WHERE orderItemId=?";

        OrderItem orderItem = null;

        try {

            PreparedStatement pstmt =
            con.prepareStatement(sql);

            pstmt.setInt(1, orderItemId);

            ResultSet rs =
            pstmt.executeQuery();

            if(rs.next()) {

                orderItem = new OrderItem();

                orderItem.setOrderItemId(
                        rs.getInt("orderItemId"));

                orderItem.setOrderId(
                        rs.getInt("orderId"));

                orderItem.setMenuId(
                        rs.getInt("menuId"));

                orderItem.setQuantity(
                        rs.getInt("quantity"));

                orderItem.setPrice(
                        rs.getDouble("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItem;
    }

    @Override
    public List<OrderItem> getAllOrderItems() {

        List<OrderItem> orderItems =
                new ArrayList<>();

        String sql =
        "SELECT * FROM orderitems";

        try {

            Statement stmt =
            con.createStatement();

            ResultSet rs =
            stmt.executeQuery(sql);

            while(rs.next()) {

                OrderItem orderItem =
                        new OrderItem();

                orderItem.setOrderItemId(
                        rs.getInt("orderItemId"));

                orderItem.setOrderId(
                        rs.getInt("orderId"));

                orderItem.setMenuId(
                        rs.getInt("menuId"));

                orderItem.setQuantity(
                        rs.getInt("quantity"));

                orderItem.setPrice(
                        rs.getDouble("price"));

                orderItems.add(orderItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItems;
    }
}
