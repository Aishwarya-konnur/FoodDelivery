package com.tap.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import com.tap.model.User;
import jakarta.servlet.http.HttpSession;

import com.tap.DAOImpl.CartDAOImpl;
import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.DAOImpl.OrderDAOImpl;
import com.tap.DAOImpl.OrderItemDAOImpl;
import com.tap.model.Cart;
import com.tap.model.Menu;
import com.tap.model.Order;
import com.tap.model.OrderItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

    	HttpSession session = request.getSession(false);

    	User user = (User) session.getAttribute("loggedUser");

    	if (user == null) {
    	    response.sendRedirect("login.jsp");
    	    return;
    	}

    	int userId = user.getUserId();

        String address = request.getParameter("address");
        String payment = request.getParameter("payment");

        CartDAOImpl cartDAO = new CartDAOImpl();
        MenuDAOImpl menuDAO = new MenuDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();

        List<Cart> cartList = cartDAO.getAllCartItems();

        double grandTotal = 0;

        for (Cart cart : cartList) {

            Menu menu = menuDAO.getMenuById(cart.getMenuId());

            if (menu != null) {
                grandTotal += menu.getPrice() * cart.getQuantity();
            }
        }

        // Create Order
        Order order = new Order();

        order.setUserId(userId);
        order.setTotalAmount(grandTotal);
        order.setStatus("PLACED");
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));

        orderDAO.addOrder(order);

        // Get Generated Order ID
        int orderId = order.getOrderId();

        // Save Order Items
        for (Cart cart : cartList) {

            Menu menu = menuDAO.getMenuById(cart.getMenuId());

            if (menu != null) {

                OrderItem item = new OrderItem();

                item.setOrderId(orderId);
                item.setMenuId(cart.getMenuId());
                item.setQuantity(cart.getQuantity());
                item.setPrice(menu.getPrice());

                orderItemDAO.addOrderItem(item);

                // Remove item from cart
                cartDAO.deleteCartItem(cart.getCartId());
            }
        }

        request.setAttribute("address", address);
        request.setAttribute("payment", payment);
        request.setAttribute("amount", grandTotal);

        request.getRequestDispatcher("orderSuccess.jsp")
               .forward(request, response);
    }
}