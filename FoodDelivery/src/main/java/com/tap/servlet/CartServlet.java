package com.tap.servlet;

import java.io.IOException;

import com.tap.DAOImpl.CartDAOImpl;
import com.tap.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int userId = 1;   // your old logic

        int menuId = Integer.parseInt(request.getParameter("menuId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Cart cart = new Cart();

        cart.setUserId(userId);
        cart.setMenuId(menuId);
        cart.setQuantity(quantity);

        CartDAOImpl dao = new CartDAOImpl();
        dao.addCartItem(cart);

        response.sendRedirect("ViewCartServlet");
    }
}