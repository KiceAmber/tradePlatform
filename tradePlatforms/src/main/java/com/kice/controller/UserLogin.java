package com.kice.controller;

import com.kice.common.Constants;
import com.kice.models.User;
import com.kice.service.user.UserService;
import com.kice.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();

        // 获取用户名和密码
        String path;
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        User user = userService.userLogin(userName, userPassword);
        if (user != null) {
            // 如果是管理员
            if (user.getUserName().equals("admin") && user.getUserPassword().equals("admin") && user.getUserRoleId() == 0) {
                path = "/template/admin/userManage.jsp";
                List<User> userList;
                userList = userService.queryAllUser();
                for (User u : userList) {
                    System.out.println(u);
                }
                req.getSession().setAttribute(Constants.USER_LIST, userList);
            } else {
                path = "/template/user/HomePage.jsp";
            }
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            // 重定向跳转到主页面
            resp.sendRedirect(path);
        } else {
            path = "/login.jsp";
            req.setAttribute(Constants.MESSAGE, "用户名或密码错误");
            req.getRequestDispatcher(path).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
