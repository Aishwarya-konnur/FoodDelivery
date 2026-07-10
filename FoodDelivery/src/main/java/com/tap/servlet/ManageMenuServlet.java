package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ManageMenuServlet")
public class ManageMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        MenuDAOImpl dao = new MenuDAOImpl();

        List<Menu> menuList = dao.getAllMenus();

        request.setAttribute("menuList", menuList);

        request.getRequestDispatcher("managemenu.jsp")
               .forward(request, response);
    }
}