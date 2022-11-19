package com.kice.mysql.sort;

import com.kice.common.Constants;
import com.kice.models.Sort;

import java.sql.Connection;

public interface SortDao {

    /**
     * 分类是否存在
     */
    boolean isSortExists(Connection connection, String sortName);

    /**
     * 添加分类
     */
    int addSort(Connection connection, String sortName);
}
