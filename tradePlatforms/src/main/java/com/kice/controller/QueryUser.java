package com.kice.controller;

import com.kice.service.user.UserService;
import com.kice.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String userName = req.getParameter("userName");
        String userId = req.getParameter("userId");

        if (!(userId.equals("") && userName.equals(""))) {

        } else if (!userName.equals("")){

        } else if (!userId.equals("")){

        } else {
            userService.queryAllUser();
        }
        req.getRequestDispatcher("/template/admin/userManage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
