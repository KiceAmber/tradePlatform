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
        String sql = "insert into tradeplatform.sort(sort_name) values(?)";
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
        System.out.println(sortList.toString());
        return sortList;
    }

    @Override
    public List<Sort> querySort(Connection connection, String sortName) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Object[] params = {sortName};
        List<Sort> sortList = new ArrayList<>();
        String sql = "select * from sort where sort_name like ?";
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

    @Override
    public int querySpecSort(Connection connection, String sortName) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Sort sort = new Sort();
        Object[] params = {sortName};
        String sql = "select * from sort where sort_name = ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                if (rs.next()) {
                    sort.setSortID(rs.getInt("sort_id"));
                    sort.setSortName(rs.getString("sort_name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                database.closeConn(connection, pre, rs);
            }
        }
        return sort.getSortID();
    }

    @Override
    public int deleteSort(Connection connection, String sortName) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        int row = 0;
        Object[] params = {sortName};
        String sql = "delete from sort where sort_name = ?";
        if (connection != null) {
            row = database.update(connection, sql, params, row, pre);
            database.closeConn(connection, pre, rs);
        }
        return row;
    }

    @Override
    public List<Product> queryProductOfSort(Connection connection, String sortName) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Object[] params = {sortName};
        List<Product> productList = new ArrayList<>();
        String sql = "select productName, productPrice, productImage from sort, product " +
                "where sort.sort_id = product.sort_id and sort.sort_name = ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                while (rs.next()) {
                    Product product = new Product();
                    product.setProductName(rs.getString("product_name"));
                    product.setProductPrice(rs.getInt("product_price"));
                    product.setProductImage(rs.getString("product_image"));
                    productList.add(product);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            database.closeConn(connection, pre, rs);
        }
        return productList;
    }
}
