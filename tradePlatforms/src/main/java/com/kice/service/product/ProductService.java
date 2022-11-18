package com.kice.service.product;

import com.kice.models.Product;

import java.util.List;

public interface ProductService {
    // 显示所有商品
    List<Product> queryAllProduct();

    // 添加商品
    boolean addProduct(Product product);
}
