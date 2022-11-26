package com.kice.models;

import java.util.Date;
import java.util.List;

public class User {
    private int userID;               // 用户ID
    private String userName;          // 用户名
    private String userPassword;      // 用户密码
    private String userPhone;         // 用户手机号
    private Date useRegistrationTime; // 用户注册时间
    private int userRoleId;           // 用户身份标识码
    private List<Product> productList; // 用户下的商品列表
    private List<Comment> commentList; // 用户下的评论

    public User(int userID, String userName, String userPassword, String userPhone, Date useRegistrationTime, int userRoleId, List<Product> productList, List<Comment> commentList) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.useRegistrationTime = useRegistrationTime;
        this.userRoleId = userRoleId;
        this.productList = productList;
        this.commentList = commentList;
    }

    public User() {
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public User(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getUseRegistrationTime() {
        return useRegistrationTime;
    }

    public void setUseRegistrationTime(Date useRegistrationTime) {
        this.useRegistrationTime = useRegistrationTime;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", useRegistrationTime=" + useRegistrationTime +
                ", userRoleId=" + userRoleId +
                ", productList=" + productList +
                ", commentList=" + commentList +
                '}';
    }
}
