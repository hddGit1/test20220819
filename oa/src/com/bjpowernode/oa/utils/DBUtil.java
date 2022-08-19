package com.bjpowernode.oa.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {

    //静态变量，在类加载时执行。
    //属性资源文件绑定
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources.jdbc");

    //根据属性资源文件的key获取value
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");


    static {
        //注册驱动（注册驱动只需要注册一次，放在静态代码块中，类加载的时候执行）
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
