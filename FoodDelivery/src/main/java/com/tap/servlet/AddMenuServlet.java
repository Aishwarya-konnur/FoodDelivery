package com.tap.servlet;

import java.io.IOException;

import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddMenuServlet")
public class AddMenuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Menu menu = new Menu();

        menu.setRestaurantId(
                Integer.parseInt(request.getParameter("restaurantId")));

        menu.setItemName(request.getParameter("itemName"));
        menu.setDescription(request.getParameter("description"));
        menu.setPrice(
                Double.parseDouble(request.getParameter("price")));

        menu.setImage(request.getParameter("image"));

        menu.setAvailable(
                Boolean.parseBoolean(request.getParameter("available")));

        MenuDAOImpl dao = new MenuDAOImpl();

        dao.addMenu(menu);

        response.sendRedirect("ManageMenuServlet");
    }
}
