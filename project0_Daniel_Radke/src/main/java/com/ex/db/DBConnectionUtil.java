package com.ex.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnectionUtil {
    Connection getConnection() throws SQLException;
}
