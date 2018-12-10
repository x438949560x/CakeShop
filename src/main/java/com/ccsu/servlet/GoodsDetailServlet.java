package com.ccsu.servlet;

import com.ccsu.domain.Goods;
import com.ccsu.service.GoodsService;
import com.ccsu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goods_detail")
public class GoodsDetailServlet extends HttpServlet {
    private GoodsService goodsService = new GoodsServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数
        int id = Integer.parseInt(request.getParameter("id"));
        // 2.做处理
        Goods g = goodsService.getById(id);
        request.setAttribute("g", g);
        // 3.返回响应
        request.getRequestDispatcher("/goods_detail.jsp").forward(request, response);
    }
}
