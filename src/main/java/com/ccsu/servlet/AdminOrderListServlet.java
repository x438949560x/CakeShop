package com.ccsu.servlet;

import com.ccsu.domain.Page;
import com.ccsu.service.GoodsService;
import com.ccsu.service.OrderService;
import com.ccsu.service.impl.GoodsServiceImpl;
import com.ccsu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/order_list")
public class AdminOrderListServlet extends HttpServlet {
    private OrderService goodsService = new OrderServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int status = 0;
        if(request.getParameter("status") != null) {
            status = Integer.parseInt(request.getParameter("status"));
        }
        request.setAttribute("status", status);
        int pageNumber = 1;
        if(request.getParameter("pageNumber") != null) {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        }
        Page p = goodsService.getOrderPage(status, pageNumber);
        request.setAttribute("page", p);
        request.getRequestDispatcher("/admin/order_list.jsp").forward(request, response);
    }
}
