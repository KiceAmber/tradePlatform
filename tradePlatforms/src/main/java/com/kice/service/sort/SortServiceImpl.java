package com.kice.service.sort;

import com.kice.mysql.database;
import com.kice.mysql.sort.SortDao;
import com.kice.mysql.sort.SortDaoImpl;

import java.sql.Connection;

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
}
