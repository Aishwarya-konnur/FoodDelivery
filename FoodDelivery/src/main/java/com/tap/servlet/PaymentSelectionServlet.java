package com.tap.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PaymentSelectionServlet")
public class PaymentSelectionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String payment = request.getParameter("payment");

        if ("Online Payment".equals(payment)) {

            request.getRequestDispatcher("payment.jsp")
                   .forward(request, response);

        } else {

            request.getRequestDispatcher("PlaceOrderServlet")
                   .forward(request, response);

        }
    }
}
