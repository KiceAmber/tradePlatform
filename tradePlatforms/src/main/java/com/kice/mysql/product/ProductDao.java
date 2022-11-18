package com.kice.mysql.product;

import com.kice.models.Product;

import java.sql.Connection;
import java.util.List;

public interface ProductDao {
    /**
     * 查询所有商品
     * @param connection 数据库连接
     */
    List<Product> queryAllProduct(Connection connection);

    /**
     * 添加商品
     *
     */
    int addProduct(Connection connection, Product product);
}
