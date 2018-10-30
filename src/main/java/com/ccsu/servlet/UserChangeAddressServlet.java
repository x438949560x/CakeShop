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

@WebServlet("/user_changeaddress")
public class UserChangeAddressServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User loginUser = (User)request.getSession().getAttribute("user");
        try{
            BeanUtils.copyProperties(loginUser, request.getParameterMap());
            userService.updateUserAddress(loginUser);
            request.setAttribute("msg", "收件信息更新成功");
            request.getRequestDispatcher("/mycenter.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
