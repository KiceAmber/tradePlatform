package com.kice.controller.user;

import com.kice.common.Constants;
import com.kice.models.User;
import com.kice.service.user.UserService;
import com.kice.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();

        // 获取用户名和密码
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        User user = userService.userLogin(userName, userPassword);
        if (user != null) {
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            // 重定向跳转到主页面
            resp.sendRedirect("template/HomePage.jsp");
        } else {
            req.setAttribute(Constants.MESSAGE, "用户名或密码错误");
            req.getRequestDispatcher( "login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
