package com.kice.controller.user;

import com.kice.common.Constants;
import com.kice.models.Product;
import com.kice.models.Sort;
import com.kice.service.product.ProductService;
import com.kice.service.product.ProductServiceImpl;
import com.kice.service.sort.SortService;
import com.kice.service.sort.SortServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TouristLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        SortService sortService = new SortServiceImpl();

        List<Sort> sortList;
        sortList = sortService.queryAllSort();
        for (Sort sort : sortList) {
            List<Product> productList;
            productList = productService.queryBySort(sort.getSortName());
            sort.setProductList(productList);
        }
        req.getSession().setAttribute(Constants.SORT_LIST, sortList);
        resp.sendRedirect("/template/tourist/HomePage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
