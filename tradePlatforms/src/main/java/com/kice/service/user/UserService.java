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

    // 根据ID查询用户
    List<User> queryById(String userId);

    // 根据用户名查询用户
    List<User> queryByName(String username);

    // 根据ID和用户名查询用户
    List<User> queryByNameAndId(String username, String userId);

    // 修改用户信息
    boolean modifyUser(String oldName, String newName, String userPhone, String password);

}
