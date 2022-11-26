package com.kice.mysql.sort;

import com.kice.common.Constants;
import com.kice.models.Product;
import com.kice.models.Sort;

import java.sql.Connection;
import java.util.List;

public interface SortDao {

    /**
     * 分类是否存在
     */
    boolean isSortExists(Connection connection, String sortName);

    /**
     * 添加分类
     */
    int addSort(Connection connection, String sortName);

    /**
     * 查询所有分类
     */
    List<Sort> queryAllSort(Connection connection);

    /**
     * 根据名字查询分类
     */
    List<Sort> querySort(Connection connection, String sortName);

    /**
     * 根据名字查询具体分类ID
     */
    int querySpecSort(Connection connection, String sortName);

    /**
     * 删除分类
     */
    int deleteSort(Connection connection, String sortName);

    /**
     * 查询该分类下的商品
     */
    List<Product> queryProductOfSort(Connection connection, String sortName);

}
