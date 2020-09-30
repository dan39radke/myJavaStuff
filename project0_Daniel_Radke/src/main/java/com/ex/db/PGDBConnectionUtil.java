package com.ex.db;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PGDBConnectionUtil implements DBConnectionUtil{

    private String url;
    private String username;
    private String password;

    // preload driver class to manager
    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public PGDBConnectionUtil(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
