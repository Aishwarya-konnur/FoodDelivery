package com.tap.DAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.Utility.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO {

    private Connection con;

    public RestaurantDAOImpl() {
        con = DBConnection.getConnection();
    }

    @Override
    public void addRestaurant(Restaurant r) {

        String sql = "INSERT INTO restaurant(restaurantName,cuisineType,address,rating,deliveryTime) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, r.getRestaurantName());
            pstmt.setString(2, r.getCuisineType());
            pstmt.setString(3, r.getAddress());
            pstmt.setFloat(4, r.getRating());
            pstmt.setInt(5, r.getDeliveryTime());

            pstmt.executeUpdate();

            System.out.println("Restaurant Added Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRestaurant(Restaurant r) {

        String sql = "UPDATE restaurant SET restaurantName=?, cuisineType=?, address=?, rating=?, deliveryTime=? WHERE restaurantId=?";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, r.getRestaurantName());
            pstmt.setString(2, r.getCuisineType());
            pstmt.setString(3, r.getAddress());
            pstmt.setFloat(4, r.getRating());
            pstmt.setInt(5, r.getDeliveryTime());
            pstmt.setInt(6, r.getRestaurantId());

            pstmt.executeUpdate();

            System.out.println("Restaurant Updated Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRestaurant(int id) {

        String sql = "DELETE FROM restaurant WHERE restaurantId=?";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            System.out.println("Restaurant Deleted Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restaurant getRestaurant(int id) {

        String sql = "SELECT * FROM restaurant WHERE restaurantId=?";

        Restaurant restaurant = null;

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                restaurant = new Restaurant();

                restaurant.setRestaurantId(rs.getInt("restaurantId"));
                restaurant.setRestaurantName(rs.getString("restaurantName"));
                restaurant.setCuisineType(rs.getString("cuisineType"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setRating(rs.getFloat("rating"));
                restaurant.setDeliveryTime(rs.getInt("deliveryTime"));
                restaurant.setImage(rs.getString("image"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurant;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {

        List<Restaurant> restaurants = new ArrayList<>();

        String sql = "SELECT * FROM restaurant";

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Restaurant restaurant = new Restaurant();

                restaurant.setRestaurantId(rs.getInt("restaurantId"));
                restaurant.setRestaurantName(rs.getString("restaurantName"));
                restaurant.setCuisineType(rs.getString("cuisineType"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setRating(rs.getFloat("rating"));
                restaurant.setDeliveryTime(rs.getInt("deliveryTime"));

                // ADD THIS LINE
                restaurant.setImage(rs.getString("image"));

                restaurants.add(restaurant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurants;
    }
}