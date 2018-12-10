package com.ccsu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order_submit")
public class OrderSubmitServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user")!=null){ // 判断是否已经登陆
            request.getRequestDispatcher("/pay.jsp").forward(request, response);
        }else{
            request.setAttribute("failMsg", "请登陆后再提交订单!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
