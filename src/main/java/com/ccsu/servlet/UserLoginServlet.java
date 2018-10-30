package com.ccsu.servlet;

import com.ccsu.domain.User;
import com.ccsu.service.UserService;
import com.ccsu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user_login")
public class UserLoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ue = request.getParameter("ue");
        String password = request.getParameter("password");
        User user = userService.login(ue, password);
        if(user==null) {
            request.setAttribute("failMsg", "用户名/邮箱或密码错误,请重新登录!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            // 跳转到个人中心
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/mycenter.jsp").forward(request, response);
        }
    }
}
