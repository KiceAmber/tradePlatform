package com.kice.controller.user;

import com.kice.common.Constants;
import com.kice.models.Product;
import com.kice.models.Sort;
import com.kice.models.User;
import com.kice.service.product.ProductService;
import com.kice.service.product.ProductServiceImpl;
import com.kice.service.sort.SortService;
import com.kice.service.sort.SortServiceImpl;
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
        SortService sortService = new SortServiceImpl();
        ProductService productService = new ProductServiceImpl();

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
                req.getSession().setAttribute(Constants.USER_LIST, userList);
            } else {
                // 获取商品信息
                List<Sort> sortList;
                sortList = sortService.queryAllSort();
                for (Sort sort : sortList) {
                    List<Product> productList;
                    productList = productService.queryBySort(sort.getSortName());
                    sort.setProductList(productList);
                    user.setProductList(productList);
                }
                req.getSession().setAttribute(Constants.SORT_LIST, sortList);
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
