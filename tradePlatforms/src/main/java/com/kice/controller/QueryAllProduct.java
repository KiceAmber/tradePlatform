package com.kice.controller;

import com.kice.models.Product;
import com.kice.models.User;
import com.kice.service.product.ProductServiceImpl;
import com.kice.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QueryAllProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductServiceImpl productService = new ProductServiceImpl();
        List<Product> productList = new ArrayList<>();
        productList = productService.queryAllProduct();
        req.setAttribute("userList", productService);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
