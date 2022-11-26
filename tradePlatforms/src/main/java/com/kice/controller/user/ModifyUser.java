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

public class ModifyUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();

        String userName = req.getParameter("userName");
        String userPhone = req.getParameter("userPhone");
        String userPassword = req.getParameter("userPassword");
        String rePassword = req.getParameter("rePassword");
        String message;
        User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);

        if (!userPassword.equals(rePassword)) {
            message = "确认密码错误!";
            req.setAttribute(Constants.MESSAGE, message);
            req.getRequestDispatcher("/template/user/changePersonal.jsp").forward(req, resp);
            return;
        } else if (!"".equals(userPhone) && userPhone.length() != 11){
            message = "手机号必须为11位";
            req.setAttribute(Constants.MESSAGE, message);
            req.getRequestDispatcher("/template/user/changePersonal.jsp").forward(req, resp);
            return;
        } else if(user.getUserName().equals(userName)) {
            message = "用户名重复";
            req.setAttribute(Constants.MESSAGE, message);
            req.getRequestDispatcher("/template/user/changePersonal.jsp").forward(req, resp);
            return;
        } else if (userPassword.equals("") || userName.equals("") || rePassword.equals("")) {
            message = "用户名或密码不能为空";
            req.setAttribute(Constants.MESSAGE, message);
            req.getRequestDispatcher("/template/user/changePersonal.jsp").forward(req, resp);
            return;
        }

        // 修改数据库用户数据
        if (userService.modifyUser(user.getUserName(), userName, userPhone, userPassword)) {
            message = "修改信息成功！";
            req.setAttribute(Constants.MESSAGE, message);
            req.getRequestDispatcher("/template/user/changePersonal.jsp").forward(req, resp);
        } else {
            System.out.println("修改用户信息错误");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
