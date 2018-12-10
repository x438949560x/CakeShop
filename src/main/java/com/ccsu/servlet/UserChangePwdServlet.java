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

@WebServlet("/user_changepwd")
public class UserChangePwdServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String password = request.getParameter("password");
            String newPwd = request.getParameter("newPassword");

            User u = (User)request.getSession().getAttribute("user");
            if(password.equals(u.getPassword())) {
                u.setPassword(newPwd);
                userService.updatePwd(u);
                request.setAttribute("msg", "修改成功");
                request.getRequestDispatcher("/mycenter.jsp").forward(request, response);
            } else {
                request.setAttribute("failMsg", "修改失败,原密码不正确");
                request.getRequestDispatcher("/mycenter.jsp").forward(request, response);
            }
    }
}
