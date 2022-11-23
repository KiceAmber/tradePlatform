package com.kice.service.product;

import com.kice.models.Product;
import com.kice.models.User;
import com.kice.mysql.database;
import com.kice.mysql.product.ProductDao;
import com.kice.mysql.product.ProductDaoImpl;
import com.kice.mysql.user.UserDao;
import com.kice.mysql.user.UserDaoImpl;

import java.sql.Connection;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    ProductDao productDao = new ProductDaoImpl();

    // 查询所有商品
    @Override
    public List<Product> queryAllProduct() {
        Connection connection = database.getConn();
        return productDao.queryAllProduct(connection);
    }

    // 添加商品
    @Override
    public boolean addProduct(Product product) {
        boolean flag = false;
        Connection connection = database.getConn();
        if (productDao.addProduct(connection, product) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Product> queryByName(String productName) {
        Connection connection = database.getConn();
        return productDao.queryByName(connection, productName);
    }

    @Override
    public List<Product> queryBySort(String sortName) {
        Connection connection = database.getConn();
        return productDao.queryBySort(connection, sortName);
    }

    @Override
    public List<Product> queryByNameAndSort(String username, String userId) {
        Connection connection = database.getConn();
        return productDao.queryByNameAndSort(connection, username, userId);
    }
}
