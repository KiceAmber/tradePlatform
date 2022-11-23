package com.kice.mysql.sort;

import com.kice.common.Constants;
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
}
