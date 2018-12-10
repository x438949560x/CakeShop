package com.ccsu.servlet;

import com.ccsu.domain.Page;
import com.ccsu.service.GoodsService;
import com.ccsu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/goods_search")
public class GoodsSearchServlet extends HttpServlet {
    private GoodsService goodsService = new GoodsServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        keyword = new String(keyword.getBytes("iso-8859-1"),"utf-8");
        int pageNo = 1;
        if(request.getParameter("pageNumber") != null ) {
            pageNo = Integer.parseInt(request.getParameter("pageNumber"));
        }
        Page p = goodsService.getSearchGoodsPage(keyword, pageNo);
        request.setAttribute("page", p);
        request.setAttribute("keyword", keyword);
        request.getRequestDispatcher("/search.jsp").forward(request,response);
    }
}
