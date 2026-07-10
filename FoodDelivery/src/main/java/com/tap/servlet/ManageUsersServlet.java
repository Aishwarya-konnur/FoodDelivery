package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ManageUsersServlet")
public class ManageUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        UserDAOImpl dao = new UserDAOImpl();

        List<User> userList = dao.getAllUser();

        request.setAttribute("userList", userList);

        request.getRequestDispatcher("manageusers.jsp")
               .forward(request, response);
    }
}
