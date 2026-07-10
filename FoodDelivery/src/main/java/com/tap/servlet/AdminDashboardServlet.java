package com.tap.servlet;

import java.io.IOException;

import com.tap.DAOImpl.OrderDAOImpl;
import com.tap.DAOImpl.RestaurantDAOImpl;
import com.tap.DAOImpl.UserDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        UserDAOImpl userDAO = new UserDAOImpl();
        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();

        request.setAttribute("totalUsers", userDAO.getAllUser().size());
        request.setAttribute("totalRestaurants", restaurantDAO.getAllRestaurants().size());
        request.setAttribute("totalOrders", orderDAO.getAllOrders().size());
        request.setAttribute("totalRevenue", orderDAO.getTotalRevenue());

        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}