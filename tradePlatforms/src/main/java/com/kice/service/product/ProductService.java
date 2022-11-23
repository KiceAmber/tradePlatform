package com.kice.service.product;

import com.kice.models.Product;
import com.kice.models.User;

import java.util.List;

public interface ProductService {
    // 显示所有商品
    List<Product> queryAllProduct();

    // 添加商品
    boolean addProduct(Product product);

    // 根据商品名查询商品
    List<Product> queryByName(String productName);

    // 根据分类查询商品
    List<Product> queryBySort(String sortName);


    // 根据ID和商品名查询商品
    List<Product> queryByNameAndSort(String productName, String sortName);
}
