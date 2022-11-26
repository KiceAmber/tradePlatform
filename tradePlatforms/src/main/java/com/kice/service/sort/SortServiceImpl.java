package com.kice.service.sort;

import com.kice.models.Sort;
import com.kice.mysql.database;
import com.kice.mysql.sort.SortDao;
import com.kice.mysql.sort.SortDaoImpl;

import java.sql.Connection;
import java.util.List;

public class SortServiceImpl implements SortService{

    SortDao sortDao = new SortDaoImpl();

    @Override
    public boolean addSort(String sortName) {
        boolean flag = false;
        Connection connection = database.getConn();
        // 先判断是否存在
        if (!sortDao.isSortExists(connection, sortName)) {
            if (sortDao.addSort(connection, sortName) > 0) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public List<Sort> queryAllSort() {
        Connection connection = database.getConn();
        return sortDao.queryAllSort(connection);
    }

    @Override
    public List<Sort> querySort(String sortName) {
        Connection connection = database.getConn();
        return sortDao.querySort(connection, sortName);
    }

    @Override
    public boolean deleteSort(String sortName) {
        boolean flag = false;
        Connection connection = database.getConn();
        if (sortDao.deleteSort(connection, sortName) > 0) {
            flag = true;
        }
        return flag;
    }
}
