package com.kice.controller.sort;

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

public class QueryAllSort extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SortService sortService = new SortServiceImpl();
        List<Sort> sortList = sortService.queryAllSort();
        req.setAttribute(Constants.SORT_LIST, sortList);
        req.getRequestDispatcher("/template/admin/sortManage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
