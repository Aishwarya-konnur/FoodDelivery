package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.CartDAOImpl;
import com.tap.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        CartDAOImpl dao = new CartDAOImpl();

        List<Cart> cartList = dao.getAllCartItems();

        request.setAttribute("cartList", cartList);

        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
}
