package com.galaxy.studentmanagement.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://11.11.7.142:1433;databaseName=student-management-tri;user=tm_app;password=Sql#1234");
            System.out.println("connect sucessfully");
        } catch (SQLException e) {
            System.out.println("Kết nối đến cơ sở dữ liệu thất bại: " + e.getMessage());
        }
    }
}
