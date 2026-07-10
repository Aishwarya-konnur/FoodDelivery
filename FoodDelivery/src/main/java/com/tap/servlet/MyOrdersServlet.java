package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.OrderDAOImpl;
import com.tap.model.Order;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MyOrdersServlet")
public class MyOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        System.out.println("Session: " + session);

        if(session != null){
            System.out.println("Logged User: " + session.getAttribute("loggedUser"));
        }

        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        OrderDAOImpl dao = new OrderDAOImpl();

        List<Order> orderList = dao.getOrdersByUserId(user.getUserId());

        request.setAttribute("orderList", orderList);

        request.getRequestDispatcher("myorders.jsp")
               .forward(request, response);
    }
}