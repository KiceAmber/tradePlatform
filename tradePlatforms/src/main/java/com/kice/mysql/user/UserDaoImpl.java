package com.kice.mysql.user;

import com.kice.models.User;
import com.kice.mysql.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{

    @Override
    public User userLogin(Connection connection, String userName) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        User user = null;
        Object[] params = {userName};

        String sql = "select * from tradeplatform.user where user_name = ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                if(rs.next()){
                    user = new User();
                    user.setUserID(rs.getInt("user_id"));
                    user.setUserName(rs.getString("user_name"));
                    user.setUserPassword(rs.getString("user_password"));
                    user.setUserRole(rs.getInt("user_role"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 释放资源
                database.closeConn(connection, pre, rs);
            }
        }
        return user;
    }
}
