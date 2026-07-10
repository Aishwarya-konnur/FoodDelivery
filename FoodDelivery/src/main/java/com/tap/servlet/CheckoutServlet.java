package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.CartDAOImpl;
import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.model.Cart;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        CartDAOImpl cartDAO = new CartDAOImpl();
        MenuDAOImpl menuDAO = new MenuDAOImpl();

        List<Cart> cartList = cartDAO.getAllCartItems();

        double grandTotal = 0;

        for (Cart cart : cartList) {

            Menu menu = menuDAO.getMenuById(cart.getMenuId());

            if (menu != null) {
                grandTotal += menu.getPrice() * cart.getQuantity();
            }
        }

        request.setAttribute("cartList", cartList);
        request.setAttribute("grandTotal", grandTotal);

        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }
}