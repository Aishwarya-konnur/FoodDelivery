package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.OrderDAOImpl;
import com.tap.model.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AllOrdersServlet")
public class AllOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        OrderDAOImpl dao = new OrderDAOImpl();

        List<Order> orderList = dao.getAllOrders();

        request.setAttribute("orderList", orderList);

        request.getRequestDispatcher("allorders.jsp")
               .forward(request, response);
    }
}
