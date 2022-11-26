package com.kice.models;

import java.util.List;

public class Product {

    private int productID; // 商品ID
    private Sort sort; // 商品所属的分类
    private User user; // 发布商品的用户
    private String productName; // 产品名称
    private int productPrice; // 产品价格
    private String productImage; // 产品图片
    private int productCommentCount; // 商品评论数量

    private List<Comment> commentList; // 商品下的评论

    public Product() {
    }

    public Product(int productID, Sort sort, User user, String productName, int productPrice, String productImage, int productCommentCount, List<Comment> commentList) {
        this.productID = productID;
        this.sort = sort;
        this.user = user;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productCommentCount = productCommentCount;

        this.commentList = commentList;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getProductCommentCount() {
        return productCommentCount;
    }

    public void setProductCommentCount(int productCommentCount) {
        this.productCommentCount = productCommentCount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", sort=" + sort +
                ", user=" + user +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productImage='" + productImage + '\'' +
                ", productCommentCount=" + productCommentCount +
                ", commentList=" + commentList +
                '}';
    }
}
