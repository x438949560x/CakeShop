package com.ccsu.servlet;

import com.ccsu.service.GoodsService;
import com.ccsu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private GoodsService goodsService = new GoodsServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 取的条幅商品
        Map<String, Object> banner = goodsService.getScrollGoods();
        request.setAttribute("banner",banner);
        // 取的热销商品
        List<Map<String, Object>> list_hot = goodsService.getGoodsList(2);
        request.setAttribute("hotList",list_hot);
        // 取的新品商品
        List<Map<String, Object>> list_new = goodsService.getGoodsList(3);
        request.setAttribute("newList",list_new);
        // 跳转到index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
