package com.tap.DAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.MenuDAO;
import com.tap.model.Menu;
import com.tap.Utility.DBConnection;

public class MenuDAOImpl implements MenuDAO {

    private Connection con;

    public MenuDAOImpl() {
        con = DBConnection.getConnection();
    }

    @Override
    public void addMenu(Menu menu) {

        String sql = "INSERT INTO menu(restaurantId,itemName,description,price,available) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, menu.getRestaurantId());
            pstmt.setString(2, menu.getItemName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setBoolean(5, menu.isAvailable());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMenu(Menu menu) {

        String sql = "UPDATE menu SET restaurantId=?,itemName=?,description=?,price=?,available=? WHERE menuId=?";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, menu.getRestaurantId());
            pstmt.setString(2, menu.getItemName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setBoolean(5, menu.isAvailable());
            pstmt.setInt(6, menu.getMenuId());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu(int id) {

        try {

            PreparedStatement pstmt = con.prepareStatement("DELETE FROM menu WHERE menuId=?");

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Menu getMenu(int id) {

        Menu menu = null;

        try {

            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM menu WHERE menuId=?");

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                menu = new Menu();

                menu.setMenuId(rs.getInt("menuId"));
                menu.setRestaurantId(rs.getInt("restaurantId"));
                menu.setItemName(rs.getString("itemName"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setAvailable(rs.getBoolean("available"));
                menu.setImage(rs.getString("image"));
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menu;
    }

    @Override
    public List<Menu> getAllMenus() {

        List<Menu> list = new ArrayList<>();

        try {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM menu");

            while (rs.next()) {

                Menu menu = new Menu();

                menu.setMenuId(rs.getInt("menuId"));
                menu.setRestaurantId(rs.getInt("restaurantId"));
                menu.setItemName(rs.getString("itemName"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setAvailable(rs.getBoolean("available"));
                menu.setImage(rs.getString("image"));
                

                list.add(menu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Menu> getMenuByRestaurantId(int restaurantId) {

        List<Menu> menuList = new ArrayList<>();

        String sql = "SELECT * FROM menu WHERE restaurantId=?";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, restaurantId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Menu menu = new Menu();

                menu.setMenuId(rs.getInt("menuId"));
                menu.setRestaurantId(rs.getInt("restaurantId"));
                menu.setItemName(rs.getString("itemName"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setAvailable(rs.getBoolean("available"));
                menu.setImage(rs.getString("image"));
               

                menuList.add(menu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuList;
    }

    @Override
    public Menu getMenuById(int menuId) {

        Menu menu = null;

        String sql = "SELECT * FROM menu WHERE menuId=?";

        try {

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, menuId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                menu = new Menu();

                menu.setMenuId(rs.getInt("menuId"));
                menu.setRestaurantId(rs.getInt("restaurantId"));
                menu.setItemName(rs.getString("itemName"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setAvailable(rs.getBoolean("available"));
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menu;
    }
}