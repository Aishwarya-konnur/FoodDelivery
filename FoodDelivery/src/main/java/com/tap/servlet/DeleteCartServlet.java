package com.tap.servlet;

import java.io.IOException;

import com.tap.DAOImpl.CartDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int cartId =
        Integer.parseInt(request.getParameter("cartId"));

        CartDAOImpl dao = new CartDAOImpl();

        dao.deleteCartItem(cartId);

        response.sendRedirect("ViewCartServlet");
    }
}