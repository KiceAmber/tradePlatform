package com.kice.service.user;

import com.kice.models.User;

public interface UserService{

    // 用户登录
    User userLogin(String userName, String userPassword);

    // 检测用户是否存在
    boolean userExists(String userName);
}
