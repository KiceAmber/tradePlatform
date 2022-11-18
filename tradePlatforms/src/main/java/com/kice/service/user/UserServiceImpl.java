package com.kice.service.user;

import com.kice.models.User;
import com.kice.mysql.database;
import com.kice.mysql.user.UserDao;
import com.kice.mysql.user.UserDaoImpl;
import org.w3c.dom.CDATASection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public User userLogin(String userName, String userPassword) {
        Connection connection = null;
        User user = null;

        connection = database.getConn();
        return userDao.userLogin(connection, userName, userPassword);
    }

    @Override
    public boolean userExists(String userName) {
        Connection connection = database.getConn();
        return userDao.userExists(connection, userName);
    }

    @Override
    public List<User> queryAllUser() {
        Connection connection = database.getConn();
        return userDao.queryAllUser(connection);
    }

    @Override
    public boolean registerUser(String userName, String userPassword) {
        boolean flag = false;
        Connection connection = database.getConn();
        if (userDao.RegisterUser(connection, userName, userPassword) > 0) {
            flag = true;
        }
        return flag;
    }
}
