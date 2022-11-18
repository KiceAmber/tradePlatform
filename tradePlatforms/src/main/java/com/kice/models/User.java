package com.kice.models;

import java.util.Date;

public class User {
    private int userID;               // 用户ID
    private String userName;          // 用户名
    private String userPassword;      // 用户密码
    private int userPhone;            // 用户手机号
    private Date useRegistrationTime; // 用户注册时间
    private int userRoleId;           // 用户身份标识码

    public User(int userID, String userName, String userPassword, int userPhone, Date useRegistrationTime, int userRoleId) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.useRegistrationTime = useRegistrationTime;
        this.userRoleId = userRoleId;
    }

    public User() {
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

    public int getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(int userPhone) {
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
                ", userPhone=" + userPhone +
                ", useRegistrationTime=" + useRegistrationTime +
                ", userRoleId=" + userRoleId +
                '}';
    }
}
