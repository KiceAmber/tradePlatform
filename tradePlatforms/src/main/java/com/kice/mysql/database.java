package com.kice.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class database {
        private static String driver;
        private static String url;
        private static String user;
        private static String password;

        // 静态加载数据库配置文件 database.properties
        static{
            Properties properties = new Properties();

            ClassLoader classLoader = database.class.getClassLoader();

            InputStream resourceAsStream = classLoader.getResourceAsStream("database.properties");

            try {
                properties.load(resourceAsStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        }

        public static Connection getConn(){
            Connection connection = null;
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

        // 数据库查找操作
        public static ResultSet execute(Connection conn, String sql, Object[] params, ResultSet resultSet, PreparedStatement preparedStatement){
            try {
                preparedStatement = conn.prepareStatement(sql);

                for (int i = 0; i < params.length; i++) {

                    preparedStatement.setObject(i+1, params[i]);
                }
                resultSet = preparedStatement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;
        }

        // 数据库的增删改查
        public static int update(Connection conn, String sql, Object[] params, int result, PreparedStatement preparedStatement){
            try {
                preparedStatement = conn.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i+1, params[i]);
                }
                result = preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }

        // 关闭数据库连接
        public static boolean closeConn(Connection conn, PreparedStatement prep, ResultSet resu){
            boolean flag = true;
            try {
                if(conn != null){
                    conn.close();
                    conn = null;
                }
                if(prep != null){
                    prep.close();
                    prep = null;
                }
                if(resu != null){
                    resu.close();
                    resu = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
            return flag;
        }
    }
