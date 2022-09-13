package com.devcolibri.database;

import java.io.FileNotFoundException;
import java.sql.*;


public class Main2 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    static Connection conn;
    static Statement stat;
    static ResultSet rs;

    public static void main(String[] args) {
        String query = "select * from clients";

        try {
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            stat = conn.createStatement();
            stat.execute("INSERT INTO clients (name, salary) VALUES ('Tim', 1500);");
            stat.execute("INSERT INTO clients (name) VALUES ('Marat');");

            rs = stat.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                System.out.println("id = " + id + ", name = " + name + ", salary = " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
