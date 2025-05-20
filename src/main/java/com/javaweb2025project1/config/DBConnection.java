package com.javaweb2025project1.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
//    private static String dbConfig;
//
//    public static void setDbConfig(String config) {
//        dbConfig = config;
//    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
//            InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("config.properties");
//            Properties properties = new Properties();
//            properties.load(inputStream);
//            String url = properties.getProperty("jdbc.url");
//            String user = properties.getProperty("db.user");
//            String password = properties.getProperty("db.password");

//            // In thông tin URL để kiểm tra
//            System.out.println("Database URL: " + url);
//
//            // Đảm bảo driver đã được tải
//            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/manage_student?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "123456";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
