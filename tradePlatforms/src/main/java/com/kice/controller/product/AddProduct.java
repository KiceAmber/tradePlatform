package com.kice.controller.product;

import com.kice.common.Constants;
import com.kice.models.Product;
import com.kice.models.Sort;
import com.kice.models.User;
import com.kice.service.product.ProductService;
import com.kice.service.product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();

        Product product = new Product();
        Sort sort = new Sort();
        User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);
        sort.setSortName(req.getParameter("sortName"));
        product.setUser(user);
        product.setSort(sort);
        product.setProductName(req.getParameter("productName"));
        product.setProductPrice(Integer.parseInt(req.getParameter("productPrice")));
        product.setProductImage(req.getParameter("productImage"));
        //TODO:上传图片
        if (productService.addProduct(product)) {
            req.setAttribute(Constants.MESSAGE, "商品添加成功");
            req.getRequestDispatcher("user/info").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

