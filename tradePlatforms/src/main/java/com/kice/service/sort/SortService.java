package com.kice.service.sort;

import com.kice.models.Sort;

import java.util.List;

public interface SortService {
    // 增加分类
    boolean addSort(String sortName);

    // 查询所有分类
    List<Sort> queryAllSort();

    // 根据名称查询分类
    List<Sort> querySort(String sortName);

    // 删除分类
    boolean deleteSort(String sortName);


}
