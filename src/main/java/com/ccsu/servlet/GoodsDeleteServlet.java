package com.ccsu.servlet;

import com.ccsu.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goods_delete")
public class GoodsDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = (Order)request.getSession().getAttribute("order");
        int goodid = Integer.parseInt(request.getParameter("goodid"));
        order.delete(goodid);
        response.getWriter().print("ok");
    }
}
