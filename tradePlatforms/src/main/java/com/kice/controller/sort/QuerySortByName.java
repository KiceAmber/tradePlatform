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

public class QuerySortByName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO:名字查询分类
        SortService sortService = new SortServiceImpl();
        String sortName = req.getParameter("sortName");
        List<Sort> sortList = sortService.querySort(sortName);
        req.setAttribute(Constants.SORT_LIST, sortList);
        req.getRequestDispatcher("/template/admin/sortManage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
