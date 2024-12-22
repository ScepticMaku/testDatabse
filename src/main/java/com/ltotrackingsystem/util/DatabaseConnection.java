package main.java.com.ltotrackingsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection getConnection() throws SQLException {
        String dbPath = "src/main/resources/license_records.db";
        
        try{
            return DriverManager.getConnection("jdbc:sqlite:"+dbPath);
        } catch(SQLException e) {
            throw new SQLException("Failed to connect to the database: "+e.getMessage());
        }
    }
}
