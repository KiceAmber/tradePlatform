package com.kice.service.user;

import com.kice.models.User;
import com.kice.mysql.database;
import com.kice.mysql.user.UserDao;
import com.kice.mysql.user.UserDaoImpl;
import org.w3c.dom.CDATASection;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
        return userDao.userLogin(connection, userName);
    }

    @Override
    public boolean userExists(String userName) {
        Connection connection = database.getConn();
        User user = userDao.userLogin(connection, userName);

        if (user != null) {
            return true;
        }
        return false;
    }
}
