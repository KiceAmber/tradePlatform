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
     *
     */
    int RegisterUser(Connection connection, String username, String password);


    /**
     * 根据用户名查询用户
     * @param connection 数据库连接
     * @param userName 用户名
     */
    List<User> queryUserByName(Connection connection, String userName);

    /**
     * 根据用户ID查询用户
     * @param connection 数据库连接
     * @paran userId 用户ID
     */
    List<User> queryUserById(Connection connection, String userId);

    /**
     * 根据用户ID和用户名查询用户
     */
    List<User> queryUserByNameAndId(Connection connection, String userName, String userId);

    /**
     * 根据用户名查询具体ID
     */
    int querySpecUser(Connection connection, String userName);
}
