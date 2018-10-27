package com.ccsu.servlet;

import com.ccsu.domain.Page;
import com.ccsu.domain.Type;
import com.ccsu.service.GoodsService;
import com.ccsu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodsrecommend_list")
public class GoodsRecommendListServlet extends HttpServlet {
    GoodsService goodsService = new GoodsServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String pageNumber = request.getParameter("pageNumber");
        if(hasLength(type) && hasLength(pageNumber)){
            Page p = goodsService.getGoodsRecommendPage(Integer.valueOf(type), Integer.valueOf(pageNumber), 8);
            request.setAttribute("page", p);
            request.setAttribute("t", type);
        }

        request.getRequestDispatcher("/goodsrecommend_list.jsp").forward(request, response);
    }

    private boolean hasLength(String str) {
        return str!=null && !"".equals(str.trim());
    }
}
