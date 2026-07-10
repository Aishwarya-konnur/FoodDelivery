package com.tap.DAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.CartDAO;
import com.tap.model.Cart;
import com.tap.Utility.DBConnection;

public class CartDAOImpl implements CartDAO {

    private Connection con;

    public CartDAOImpl() {
        con = DBConnection.getConnection();
    }

    @Override
    public void addCartItem(Cart cart) {

        String sql =
        "INSERT INTO cart(userId,menuId,quantity) VALUES(?,?,?)";

        try {

            PreparedStatement pstmt =
            con.prepareStatement(sql);

            pstmt.setInt(1, cart.getUserId());
            pstmt.setInt(2, cart.getMenuId());
            pstmt.setInt(3, cart.getQuantity());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCartItem(Cart cart) {

        String sql =
        "UPDATE cart SET userId=?,menuId=?,quantity=? WHERE cartId=?";

        try {

            PreparedStatement pstmt =
            con.prepareStatement(sql);

            pstmt.setInt(1, cart.getUserId());
            pstmt.setInt(2, cart.getMenuId());
            pstmt.setInt(3, cart.getQuantity());
            pstmt.setInt(4, cart.getCartId());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCartItem(int cartId) {

        try {

            PreparedStatement pstmt =
            con.prepareStatement(
            "DELETE FROM cart WHERE cartId=?");

            pstmt.setInt(1, cartId);

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cart getCartItem(int cartId) {

        Cart cart = null;

        try {

            PreparedStatement pstmt =
            con.prepareStatement(
            "SELECT * FROM cart WHERE cartId=?");

            pstmt.setInt(1, cartId);

            ResultSet rs =
            pstmt.executeQuery();

            if (rs.next()) {

                cart = new Cart();

                cart.setCartId(rs.getInt("cartId"));
                cart.setUserId(rs.getInt("userId"));
                cart.setMenuId(rs.getInt("menuId"));
                cart.setQuantity(rs.getInt("quantity"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cart;
    }

    @Override
    public List<Cart> getAllCartItems() {

        List<Cart> list = new ArrayList<>();

        try {

            Statement stmt =
            con.createStatement();

            ResultSet rs =
            stmt.executeQuery("SELECT * FROM cart");

            while (rs.next()) {

                Cart cart = new Cart();

                cart.setCartId(rs.getInt("cartId"));
                cart.setUserId(rs.getInt("userId"));
                cart.setMenuId(rs.getInt("menuId"));
                cart.setQuantity(rs.getInt("quantity"));

                list.add(cart);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    @Override
    public void updateQuantity(int cartId, int quantity) {

        String sql = "UPDATE cart SET quantity=? WHERE cartId=?";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, quantity);
            pstmt.setInt(2, cartId);

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

