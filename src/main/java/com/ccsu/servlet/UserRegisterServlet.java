package com.ccsu.servlet;

import com.ccsu.domain.User;
import com.ccsu.service.UserService;
import com.ccsu.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user_register")
public class UserRegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
            BeanUtils.copyProperties(user, request.getParameterMap());
        } catch (Exception e){
            e.printStackTrace();
        }
        if(userService.register(user)) {
            request.setAttribute("msg", "注册成功,请登录!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else {
            request.setAttribute("msg", "注册失败,用户名或邮箱已经被注册!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }


    }
}
