package com.ccsu.servlet;

import com.ccsu.domain.Goods;
import com.ccsu.domain.Page;
import com.ccsu.domain.Type;
import com.ccsu.service.GoodsService;
import com.ccsu.service.TypeService;
import com.ccsu.service.impl.GoodsServiceImpl;
import com.ccsu.service.impl.TypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/goods_list")
public class GoodsListServlet extends HttpServlet {
    private GoodsService goodsService = new GoodsServiceImpl();
    private TypeService typeService = new TypeServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String pageNumber = request.getParameter("pageNumber");
        Type t = null;
        if(hasLength(id) && hasLength(pageNumber)){
            Page p = goodsService.getGoodsPage(Integer.valueOf(id), Integer.valueOf(pageNumber), 8);
            request.setAttribute("page", p);
            request.setAttribute("id", id);
            if(Integer.valueOf(id)!=0){
                t = typeService.select(Integer.valueOf(id));
            }
            request.setAttribute("t",t);
        }

        request.getRequestDispatcher("/goodslist.jsp").forward(request, response);
    }

    private boolean hasLength(String str) {
        return str!=null && !"".equals(str.trim());
    }
}
