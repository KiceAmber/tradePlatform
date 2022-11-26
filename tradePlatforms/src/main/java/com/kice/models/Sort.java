package com.kice.models;

import java.util.List;

public class Sort {
    private int sortID; // 分类ID
    private String sortName; // 分类名称
    private List<Product> productList; // 分类下的商品

    public Sort() {
    }

    public Sort(int sortID) {
        this.sortID = sortID;
    }

    public Sort(int sortID, String sortName, List<Product> productList) {
        this.sortID = sortID;
        this.sortName = sortName;
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getSortID() {
        return sortID;
    }

    public void setSortID(int sortID) {
        this.sortID = sortID;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }


}
