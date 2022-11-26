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

public class QueryProductByNameOrSort extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        String productName = req.getParameter("productName");
        String productSort = req.getParameter("productSort");
        List<Product> product_list;
        String path ="/template/admin/productManage.jsp";
        if (!"".equals(productName) && "".equals(productSort)) {
            product_list = productService.queryByName(productName);
        } else if ("".equals(productName) && !"".equals(productSort)) {
            product_list = productService.queryBySort(productSort);
        } else if ("".equals(productName) && "".equals(productSort)) {
            product_list = productService.queryAllProduct();
        } else {
            product_list = productService.queryByNameAndSort(productName, productSort);
        }
        req.setAttribute(Constants.PRODUCT_LIST, product_list);
        req.getRequestDispatcher(path).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
