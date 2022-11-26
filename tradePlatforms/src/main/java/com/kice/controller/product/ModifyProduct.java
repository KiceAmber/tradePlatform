package com.kice.controller.product;

import com.kice.common.Constants;
import com.kice.service.product.ProductService;
import com.kice.service.product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        String oldName = req.getParameter("productOldName");
        String newName = req.getParameter("productNewName");
        String newSort = req.getParameter("productNewSort");
        String newPrice = req.getParameter("productNewPrice");
        if (productService.modifyProduct(oldName, newName, newSort, newPrice)) {
            req.setAttribute(Constants.MESSAGE, "修改商品信息成功！");
        } else {
            req.setAttribute(Constants.MESSAGE, "修改商品信息失败！");
        }
        req.getRequestDispatcher("/template/user/changeProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
