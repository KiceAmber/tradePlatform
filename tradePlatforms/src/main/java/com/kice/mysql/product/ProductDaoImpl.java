package com.kice.mysql.product;

import com.kice.models.Product;
import com.kice.models.Sort;
import com.kice.models.User;
import com.kice.mysql.database;
import com.kice.mysql.sort.SortDao;
import com.kice.mysql.sort.SortDaoImpl;
import com.kice.mysql.user.UserDao;
import com.kice.mysql.user.UserDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{

    SortDao sortDao = new SortDaoImpl();
    UserDao userDao = new UserDaoImpl();
    @Override
    public List<Product> queryAllProduct(Connection connection) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Object[] params = {};
        List<Product> productList = new ArrayList<>();

        String sql = "select * from tradeplatform.product";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                if(rs.next()){
                    Product product = new Product();
                    User user = new User();
                    Sort sort = new Sort();
                    sort.setSortID(rs.getInt("sort_id"));
                    user.setUserID(rs.getInt("user_id"));
                    product.setProductID(rs.getInt("product_id"));
                    product.setSort(sort);
                    product.setUser(user);
                    product.setProductName(rs.getString("product_name"));
                    product.setProductPrice(rs.getInt("product_price"));
                    product.setProductImage(rs.getString("product_image"));
                    product.setProductCommentCount(rs.getInt("product_comment_count"));
                    productList.add(product);
                    System.out.println(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 释放资源
                database.closeConn(connection, pre, rs);
            }
        }
        return productList;
    }

    @Override
    public int addProduct(Connection connection, String sortName, String userName,String productName, int productPrice, String productImage) {
        // 查询到分类对应的ID
        int sortId = sortDao.querySpecSort(connection, sortName);
        // 查询到用户对应的ID
        int userId = userDao.querySpecUser(connection, userName);
        PreparedStatement pre = null;
        ResultSet rs = null;
        Object[] params = {sortId, userId, productName, productPrice, productImage};
        int row = 0;

        String sql = "insert into tradeplatform.product(sort_id, user_id, product_name, product_price, product_image) values(?, ?, ?, ?, ?)";
        if (connection != null) {
            row = database.update(connection, sql, params, row, pre);
            database.closeConn(connection, pre, rs);
        }
        return row;
    }

    @Override
    public int modifyProduct(Connection connection, Product product) {

        // TODO: 修改商品信息
        return 1;
    }

    @Override
    public int deleteProduct(Connection connection, int productId) {
        // TODO: 下架商品
        return 1;
    }

    @Override
    public List<Product> queryByName(Connection connection, String productName) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<>();
        Object[] params = {"%"+productName+"%"};
        String sql = "select * from tradeplatform.product where product_name like ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                while(rs.next()) {
                    Product product = new Product();
                    product.setProductID(rs.getInt("product_id"));
                    product.setProductName(rs.getString("product_name"));
                    product.setProductPrice(rs.getInt("product_price"));
                    product.setProductImage(rs.getString("product_image"));
                    product.setProductCommentCount(rs.getInt("product_comment_count"));
                    productList.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                database.closeConn(connection, pre, rs);
            }
        }
        return productList;
    }

    @Override
    public List<Product> queryBySort(Connection connection, String sortName) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<>();
        Object[] params = {"%"+sortName+"%"};
        String sql = "select * from tradeplatform.product where product.sort_id = sort.sort_id and product.sort_name like ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                while(rs.next()) {
                    Product product = new Product();
                    product.setProductID(rs.getInt("product_id"));
                    product.setProductName(rs.getString("product_name"));
                    product.setProductPrice(rs.getInt("product_price"));
                    product.setProductImage(rs.getString("product_image"));
                    product.setProductCommentCount(rs.getInt("product_comment_count"));
                    productList.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                database.closeConn(connection, pre, rs);
            }
        }
        return productList;
    }

    @Override
    public List<Product> queryByNameAndSort(Connection connection, String productName, String sortName) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<>();
        Object[] params = {"%"+sortName+"%", "%" + productName + "%"};
        String sql = "select * from tradeplatform.product where product.sort_id = sort.sort_id and product.sort_name like ?" +
                " and product_name like ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                while(rs.next()) {
                    Product product = new Product();
                    product.setProductID(rs.getInt("product_id"));
                    product.setProductName(rs.getString("product_name"));
                    product.setProductPrice(rs.getInt("product_price"));
                    product.setProductImage(rs.getString("product_image"));
                    product.setProductCommentCount(rs.getInt("product_comment_count"));
                    productList.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                database.closeConn(connection, pre, rs);
            }
        }
        return productList;
    }
}
