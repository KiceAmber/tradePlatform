package com.kice.controller;

import com.kice.common.Constants;
import com.kice.service.sort.SortService;
import com.kice.service.sort.SortServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddSort extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SortService sortService = new SortServiceImpl();

        String sortName = req.getParameter("sortName");
        if (sortService.addSort(sortName)) {
            req.setAttribute(Constants.MESSAGE, sortName + " 分类添加成功");
            req.getRequestDispatcher("").forward(req, resp);
        } else {
            req.setAttribute(Constants.MESSAGE, "分类添加失败，可能已存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
