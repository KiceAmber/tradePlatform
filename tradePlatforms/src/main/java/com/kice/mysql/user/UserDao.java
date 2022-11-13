package com.kice.mysql.user;

import com.kice.models.User;

import java.sql.Connection;

public interface UserDao {

    /**
     * 用户登录
     * @param connection 数据库连接
     * @param userName   用户名
     * @return User      用户
     */
    User userLogin(Connection connection, String userName);

}
