package com.kice.mysql.user;

import com.kice.models.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public interface UserDao {

    /**
     * 用户登录
     * @param connection   数据库连接
     * @param userName     用户名
     * @param userPassword 用户密码
     * @return User        用户
     */
    User userLogin(Connection connection, String userName, String userPassword);

    /**
     * 查询用户是否存在
     * @param connection 数据库连接
     * @param userName   用户名
     */
    boolean userExists(Connection connection, String userName);

    /**
     * 查询所有的用户
     * @param connection 数据库连接
     */
    List<User> queryAllUser(Connection connection);

    /**
     * 注册用户
     * @param connection 数据库连接
     */
    int RegisterUser(Connection connection, String username, String password);
}