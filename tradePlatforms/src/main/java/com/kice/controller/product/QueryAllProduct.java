package com.kice.controller.product;

import com.kice.common.Constants;
import com.kice.models.Product;
import com.kice.service.product.ProductService;
import com.kice.service.product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QueryAllProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        String path = "/template/admin/productManage.jsp";
        List<Product> productList;
        productList = productService.queryAllProduct();
        req.setAttribute(Constants.PRODUCT_LIST, productList);
        req.getRequestDispatcher(path).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
