package com.kice.controller;

import com.kice.models.Product;
import com.kice.models.Sort;
import com.kice.service.product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductServiceImpl productService = new ProductServiceImpl();
        // TODO:添加商品
        Product product = new Product();
        product.setProductName(req.getParameter("productName"));
        product.setProductPrice(Integer.parseInt(req.getParameter("productPrice")));
        product.setProductImage(req.getParameter("productImage"));
        if (productService.addProduct(product)) {

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

