package com.kice.controller;

import com.kice.common.Constants;
import com.kice.models.Sort;
import com.kice.service.sort.SortService;
import com.kice.service.sort.SortServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddSort extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        SortService sortService = new SortServiceImpl();
        List<Sort> sortList;
        String sortName = req.getParameter("sortName");
        System.out.println(sortName);
        if (sortService.addSort(sortName)) {
            sortList = sortService.queryAllSort();
            req.setAttribute(Constants.SORT_LIST, sortList);
            req.getRequestDispatcher("/template/admin/sortManage.jsp").forward(req, resp);
        } else {
            req.setAttribute(Constants.MESSAGE, "分类添加失败，可能已存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
