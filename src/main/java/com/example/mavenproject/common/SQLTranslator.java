package com.example.mavenproject.common;

import java.sql.*;

public class SQLTranslator {

    public static void main(String[] args) {
        try {
            String sql = "select * from message_record";
            executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeQuery(String sql) throws SQLException {
        //数据库连接又叫做数据库会话
        Connection connection = null;
        Statement statement = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            int[][] it = new int[3][4];
            //Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/echat", "root", "");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            System.out.println("user_id, user_name, content, create_time");
            while (resultSet.next()) {
                // 处理查询结果
                System.out.println(resultSet.getString("user_id") + ", " + resultSet.getString("user_name") + ", " + resultSet.getString("content") + ", " + resultSet.getString("create_time"));
            }

        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }
}