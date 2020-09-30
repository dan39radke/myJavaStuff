package com.ex.db;

import com.ex.Services.DAO;
import com.ex.db.DBConnectionUtil;
import com.ex.db.PGDBConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;


public class JDBCConnect {

    private DAO dao;
    private DBConnectionUtil dbConnector;

    public static DBConnectionUtil connect() {
        JDBCConnect jdbc = new JDBCConnect();
        String url = "jdbc:postgresql://database-1.ckdonqvjc7hf.us-east-2.rds.amazonaws.com:5432/database_revature720";
        String username = "dan39radke";
        String password = "51ldLU3gSw2c";
        jdbc.dbConnector = new PGDBConnectionUtil(url, username, password);
        return jdbc.dbConnector;
    }


    public JDBCConnect() {
    }


    public JDBCConnect(DAO dao) {
        this.dao = dao;
    }


}
