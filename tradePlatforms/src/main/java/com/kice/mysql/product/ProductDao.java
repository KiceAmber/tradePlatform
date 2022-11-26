package com.kice.mysql.product;

import com.kice.models.Product;
import com.kice.models.Sort;

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
     * @param connection 数据库连接
     *
     */
    int addProduct(Connection connection, String sortName, String userName,String productName, int productPrice, String productImage);

    /**
     * 下架商品
     * @param connection 数据库连接
     * @param productId 商品ID
     */
    int deleteProduct(Connection connection, int productId);

    /**
     * 通过名称查询商品
     * @
     */
    List<Product> queryByName(Connection connection, String productName);

    /**
     * 通过分类查询商品
     */
    List<Product> queryBySort(Connection connection, String sortName);

    /**
     * 通过名称和分类查询商品
     */
    List<Product> queryByNameAndSort(Connection connection, String productName, String sortName);

    /**
     * 查询用户售卖的商品
     */
    List<Product> queryByUserName(Connection connection, String userName);

    /**
     * 修改商品信息
     */
    int modifyProduct(Connection connection, String oldName, String newName, String newSort, String newPrice);
}
