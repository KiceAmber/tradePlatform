package com.kice.service.user;

import com.kice.models.User;

import java.util.List;

public interface UserService{

    // 用户登录
    User userLogin(String userName, String userPassword);

    // 查询用户是否存在
    boolean userExists(String userName);

    // 查询所有用户
    List<User> queryAllUser();

    // 注册用户
    boolean registerUser(String userName, String userPassword);
}
