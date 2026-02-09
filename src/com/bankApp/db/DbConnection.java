package com.bankApp.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static final String url = "jdbc:mysql://localhost:3306/bank_db";
    private static final String user = "root";
    private static final String password = "pass@123";

    public static Connection getConnection()throws Exception{
        return DriverManager.getConnection(url,user,password);
    }
}
