package com.kice.controller.user;

import com.kice.common.Constants;
import com.kice.service.user.UserService;
import com.kice.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserServiceImpl();

        String userName = req.getParameter("userName");
        String password = req.getParameter("userPassword");
        String rePassword = req.getParameter("rePassword");

        // 首先检查用户是否存在
        if (userService.userExists(userName)) {  // 如果存在
            req.setAttribute(Constants.MESSAGE, "用户名已存在");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else {
            if (!password.equals(rePassword)) {
                req.setAttribute(Constants.MESSAGE, "确认密码错误");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            } else {
                if (userService.registerUser(userName, password)) {
                    req.setAttribute(Constants.MESSAGE, "Success");
                    resp.sendRedirect("/login.jsp");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
