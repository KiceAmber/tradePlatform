package com.kice.mysql.sort;

import com.kice.models.Product;
import com.kice.models.Sort;
import com.kice.models.User;
import com.kice.mysql.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SortDaoImpl implements SortDao{

    @Override
    public boolean isSortExists(Connection connection, String sortName) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Object[] params = {sortName};
        boolean flag = false;
        String sql = "select sort_name from tradeplatform.sort where sort_name = ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                if (rs.next()) {
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 释放资源
                database.closeConn(connection, pre, rs);
            }
        }
        return flag;
    }

    @Override
    public int addSort(Connection connection, String sortName) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Object[] params = {sortName};
        int row = 0;
        String sql = "insert into tradeplatform.sort values(?)";
        if (connection != null) {
            row = database.update(connection, sql, params, row, pre);
            database.closeConn(connection, pre, rs);
        }
        return row;
    }

    @Override
    public List<Sort> queryAllSort(Connection connection) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Object[] params = {};
        List<Sort> sortList = new ArrayList<>();
        String sql = "select * from sort";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                while(rs.next()) {
                    Sort sort = new Sort();
                    sort.setSortID(rs.getInt("sort_id"));
                    sort.setSortName(rs.getString("sort_name"));
                    sortList.add(sort);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                database.closeConn(connection, pre, rs);
            }

        }
        return sortList;
    }
}
