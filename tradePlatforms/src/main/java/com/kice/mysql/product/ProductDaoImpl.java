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

        if (sortId == 0 || userId == 0) {
            return 0;
        }
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
        String sql = "select * from product, sort where product.sort_id = sort.sort_id and sort.sort_name like ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                while(rs.next()) {
                    Product product = new Product();
                    Sort sort = new Sort();
                    sort.setSortName(rs.getString("sort_name"));
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

    @Override
    public List<Product> queryByUserName(Connection connection, String userName) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<>();
        Object[] params = {userName};
        String sql = "select * from user, product,sort where user.user_id = product.user_id and product.sort_id = sort.sort_id and  user_name = ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                while(rs.next()) {
                    Sort sort = new Sort();
                    sort.setSortID(rs.getInt("sort_id"));
                    sort.setSortName(rs.getString("sort_name"));
                    Product product = new Product();
                    product.setProductID(rs.getInt("product_id"));
                    product.setProductName(rs.getString("product_name"));
                    product.setSort(sort);
                    product.setProductPrice(rs.getInt("product_price"));
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
    public int modifyProduct(Connection connection, String oldName, String newName, String newSort, String newPrice) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        int row = 0;
        // 先通过分类名找到分类id
        int sortId = sortDao.querySpecSort(connection, newSort);
        System.out.println(sortId);
        Object[] params = {newName, sortId, newPrice, oldName};
        System.out.println(oldName);
        String sql = "update product set product_name = ?, sort_id = ?, product_price = ? where product_name = ?";
        if (connection != null) {
            row = database.update(connection, sql, params, row, pre);
            database.closeConn(connection, pre, rs);
        }
        return row;
    }
}
