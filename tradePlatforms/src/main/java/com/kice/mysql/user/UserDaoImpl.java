package com.kice.mysql.user;

import com.kice.models.User;
import com.kice.mysql.database;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public User userLogin(Connection connection, String userName, String userPassword) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        User user = null;
        Object[] params = {userName, userPassword};

        String sql = "select * from tradeplatform.user where user_name = ? and user_password = ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                if(rs.next()){
                    user = new User();
                    user.setUserID(rs.getInt("user_id"));
                    user.setUserName(rs.getString("user_name"));
                    user.setUserPassword(rs.getString("user_password"));
                    user.setUserPhone(rs.getString("user_phone"));
                    user.setUseRegistrationTime(rs.getDate("user_registration_time"));
                    user.setUserRoleId(rs.getInt("user_role_id"));
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

    @Override
    public boolean userExists(Connection connection, String userName) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Object[] params = {userName};
        boolean flag = false;

        String sql = "select * from tradeplatform.user where user_name = ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                if(rs.next()){
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 释放资源
                database.closeConn(connection, pre, rs);
            }
        }
        return flag;
    }

    @Override
    public List<User> queryAllUser(Connection connection) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Object[] params = {};
        List<User> userList = new ArrayList<>();

        String sql = "select * from tradeplatform.user";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                while (rs.next()) {
                    User user = new User();
                    user.setUserID(rs.getInt("user_id"));
                    user.setUserName(rs.getString("user_name"));
                    user.setUserPassword(rs.getString("user_password"));
                    user.setUserPhone(rs.getString("user_phone"));
                    user.setUseRegistrationTime(rs.getDate("user_registration_time"));
                    user.setUserRoleId(rs.getInt("user_role_id"));
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 释放资源
                database.closeConn(connection, pre, rs);
            }
        }
        return userList;
    }

    @Override
    public int RegisterUser(Connection connection, String username, String password) {
        PreparedStatement pre = null;
        ResultSet rs = null;

        Date date = new Date();
        Timestamp currTime = new Timestamp(date.getTime());
        int row = 0;
        Object[] params = {username, password, currTime};

        String sql = "insert into tradeplatform.user(user_name, user_password, user_registration_time) values(?, ?, ?)";
        if (connection != null) {
            row = database.update(connection, sql, params, row, pre);
            database.closeConn(connection, pre, rs);
        }
        return row;
    }

    @Override
    public List<User> queryUserByName(Connection connection, String userName) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        Object[] params = {"%"+userName+"%"};
        String sql = "select * from tradeplatform.user where user_name like ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                while(rs.next()) {
                    User user = new User();
                    user.setUserID(rs.getInt("user_id"));
                    user.setUserName(rs.getString("user_name"));
                    user.setUserPassword(rs.getString("user_password"));
                    user.setUserPhone(rs.getString("user_phone"));
                    user.setUseRegistrationTime(rs.getDate("user_registration_time"));
                    user.setUserRoleId(rs.getInt("user_role_id"));
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                database.closeConn(connection, pre, rs);
            }
        }
        return userList;
    }

    @Override
    public List<User> queryUserById(Connection connection, String userId) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        Object[] params = {"%" + userId + "%"};
        String sql = "select * from tradeplatform.user where user_id like ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                while(rs.next()) {
                    User user = new User();
                    user = new User();
                    user.setUserID(rs.getInt("user_id"));
                    user.setUserName(rs.getString("user_name"));
                    user.setUserPassword(rs.getString("user_password"));
                    user.setUserPhone(rs.getString("user_phone"));
                    user.setUseRegistrationTime(rs.getDate("user_registration_time"));
                    user.setUserRoleId(rs.getInt("user_role_id"));
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                database.closeConn(connection, pre, rs);
            }

        }
        return userList;
    }

    @Override
    public List<User> queryUserByNameAndId(Connection connection, String userName, String userId) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        Object[] params = {"%" + userName + "%", "%" + userId + "%"};
        String sql = "select * from tradeplatform.user where user_name like ? and user_id like ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                while(rs.next()) {
                    User user = new User();
                    user = new User();
                    user.setUserID(rs.getInt("user_id"));
                    user.setUserName(rs.getString("user_name"));
                    user.setUserPassword(rs.getString("user_password"));
                    user.setUserPhone(rs.getString("user_phone"));
                    user.setUseRegistrationTime(rs.getDate("user_registration_time"));
                    user.setUserRoleId(rs.getInt("user_role_id"));
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                database.closeConn(connection, pre, rs);
            }
        }
        return userList;
    }

    @Override
    public int querySpecUser(Connection connection, String userName) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        User user = new User();
        Object[] params = {userName};
        String sql = "select * from tradeplatform.user where user_name = ?";
        if (connection != null) {
            rs = database.execute(connection, sql, params, rs, pre);
            try {
                while(rs.next()) {
                    user.setUserID(rs.getInt("user_id"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user.getUserID();
    }

    @Override
    public int modifyUser(Connection connection,String oldName, String newName, String userPhone, String userPassword) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        int row = 0;
        User user = new User();
        Object[] params;
        String sql;
        if (userPhone.equals("")) {
            sql = "update user set user_name = ?, user_password = ? where user_name = ?";
            params = new Object[]{newName, userPassword, oldName};
        } else {
            sql = "update user set user_name = ?, user_phone = ?, user_password = ? where user_name = ?";
            params = new Object[]{newName, userPhone, userPassword, oldName};
        }

        if (connection != null) {
            row = database.update(connection, sql, params, row, pre);
            database.closeConn(connection, pre, rs);
        }
        return row;
    }
}
