package com.kice.mysql.product;

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

public class ProductDaoImpl implements ProductDao{
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
                    product.setProductID(rs.getInt("product_id"));
                    product.setSort(new Sort(rs.getInt("sort_id")));
                    product.setUser(new User(rs.getInt("user_id")));
                    product.setProductName(rs.getString("product_name"));
                    product.setProductPrice(rs.getInt("product_price"));
                    product.setProductImage(rs.getString("product_image"));
                    product.setProductCommentCount(rs.getInt("product_comment_count"));
                    product.setProductViewCount(rs.getInt("product_view_count"));
                    productList.add(product);
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
    public int addProduct(Connection connection, Product product) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Object[] params = {product.getProductID(), product.getSort().getSortID(), product.getUser().getUserID(),
                            product.getProductName(), product.getProductPrice(), product.getProductImage(),
                              product.getProductCommentCount(), product.getProductViewCount()};
        int row = 0;
        String sql = "insert into tradeplatform.product() values(?, ?, ?, ?, ?, ?, ?, ?)";
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
}
