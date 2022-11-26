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
import java.util.List;

public class deleteSort extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SortService sortService = new SortServiceImpl();
        String sortName = req.getParameter("sortName");
        List<Sort> sortList;
        String path;
        if (sortService.deleteSort(sortName)) {
            sortList = sortService.queryAllSort();
            req.setAttribute(Constants.SORT_LIST, sortList);
        } else {
            req.setAttribute(Constants.MESSAGE, "删除错误");
        }
        path = "/template/admin/sortManage.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
