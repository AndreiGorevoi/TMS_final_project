package com.news.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
    public static final String url="jdbc:mysql://localhost:3306/news?useUnicode=true&serverTimezone=UTC";
    public static final String user="root";
    public static final String password="375256470207";


    public static Connection getConnction(){
        try(Connection connection = DriverManager.getConnection(url,user,password)) {
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
