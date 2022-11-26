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
import java.util.ArrayList;
import java.util.List;

public class QueryUserByNameOrId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String username = req.getParameter("userName");
        String userId = req.getParameter("userId");
        List<User> user_list;
        String path ="/template/admin/userManage.jsp";
        if (!"".equals(username) && "".equals(userId)) {
            user_list = userService.queryByName(username);
        } else if ("".equals(username) && !"".equals(userId)) {
            user_list = userService.queryById(userId);
        } else if ("".equals(username) && "".equals(userId)) {
            user_list = userService.queryAllUser();
        } else {
            user_list = userService.queryByNameAndId(username, userId);
        }
        req.setAttribute(Constants.USER_LIST, user_list);
        req.getRequestDispatcher(path).forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
