package com.ccsu.servlet;

import com.ccsu.domain.Goods;
import com.ccsu.domain.Order;
import com.ccsu.service.GoodsService;
import com.ccsu.service.impl.GoodsServiceImpl;
import com.sun.tools.corba.se.idl.constExpr.Or;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@WebServlet("/goods_buy")
public class GoodsBuyServlet extends HttpServlet {
    private GoodsService goodsService = new GoodsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = null;
        // 基于session的购物车
        if(request.getSession().getAttribute("order") != null) {
            order = (Order)request.getSession().getAttribute("order");
        } else {
            order = new Order();
            order.setTotal(new BigDecimal(0));
            request.getSession().setAttribute("order", order);
        }
        int goodid = Integer.parseInt(request.getParameter("goodid"));
        Goods goods = goodsService.getById(goodid);
        if(goods.getStock()>0){
            order.addGoods(goods);
            // 返回信号，ajax接收后弹窗
            response.getWriter().print("ok");
        } else { // 库存不足
            response.getWriter().print("empty");
        }

    }
}
