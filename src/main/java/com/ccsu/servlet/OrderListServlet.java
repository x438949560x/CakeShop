package com.ccsu.servlet;

import com.ccsu.domain.Order;
import com.ccsu.domain.User;
import com.ccsu.service.OrderService;
import com.ccsu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/order_list")
public class OrderListServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(user==null) {
            response.sendRedirect(request.getContextPath());
            return;
        }
        List<Order> list = orderService.selectAll(user.getId());
        request.setAttribute("orderList", list);
        request.getRequestDispatcher("/myorder.jsp").forward(request, response);
    }
}
