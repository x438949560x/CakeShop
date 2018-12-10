package com.ccsu.servlet;

import com.ccsu.domain.Order;
import com.ccsu.domain.User;
import com.ccsu.service.OrderService;
import com.ccsu.service.impl.OrderServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/order_confirm")
public class OrderConfirmServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = (Order)request.getSession().getAttribute("order");
        try{
            BeanUtils.copyProperties(order, request.getParameterMap());
        } catch (Exception e){
            e.printStackTrace();
        }
        order.setDatetime(new Date());
        order.setStatus(2);  // 已付款状态,后续接入支付接口后改为1
        order.setUser((User) request.getSession().getAttribute("user"));
        orderService.addOrder(order);
        request.getSession().removeAttribute("order");

        request.setAttribute("msg", "订单支付成功!");
        request.getRequestDispatcher("/paysuccess.jsp").forward(request, response);
    }
}
