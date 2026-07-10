package com.tap.servlet;

import java.io.IOException;

import com.tap.DAOImpl.CartDAOImpl;
import com.tap.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int cartId = Integer.parseInt(request.getParameter("cartId"));
        String action = request.getParameter("action");

        CartDAOImpl dao = new CartDAOImpl();

        Cart cart = dao.getCartItem(cartId);

        if (cart != null) {

            int quantity = cart.getQuantity();

            if (action.equals("increase")) {
                quantity++;
            } else if (action.equals("decrease")) {
                quantity--;
            }

            if (quantity <= 0) {
                dao.deleteCartItem(cartId);
            } else {
                dao.updateQuantity(cartId, quantity);
            }
        }

        response.sendRedirect("ViewCartServlet");
    }
}