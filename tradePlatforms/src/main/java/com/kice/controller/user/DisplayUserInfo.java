package com.kice.controller.user;

import com.kice.common.Constants;
import com.kice.models.Product;
import com.kice.models.User;
import com.kice.service.product.ProductService;
import com.kice.service.product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DisplayUserInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        User user = (User)req.getSession().getAttribute("user_session");
        List<Product> productList = productService.queryByUserName(user.getUserName());
        req.setAttribute(Constants.PRODUCT_LIST, productList);
        req.getRequestDispatcher("/template/user/userInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
