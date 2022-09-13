package com.devcolibri.database;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static void main(String[] args) throws SQLException {
        String query = "select id, name from users";

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("Connection is successful");

            statement = connection.createStatement();
            System.out.println("Statement done!");

            statement.execute("INSERT INTO users (name, age, mail) VALUES ('Bob',81,'bobby@gmail.coccom');");
            statement.executeUpdate("UPDATE users SET name='new name' where id = 15");

            resultSet = statement.executeQuery(query);
            System.out.println("ResultSet is ready!");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("id = " + id + ",name = " + name);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка во время подключения");
        } finally {
            try { connection.close(); } catch(SQLException se) { /*can't do anything */ }
            try { statement.close(); } catch(SQLException se) { /*can't do anything */ }
            try { resultSet.close(); } catch(SQLException se) { /*can't do anything */ }
        }

//        try (Connection connection = DriverManager.getConnection(URL,LOGIN, PASSWORD);
//                Statement statement = connection.createStatement()) {
//            statement.execute("INSERT INTO users (name, age, mail) VALUES ('Bob', 81, 'bob@mail.ru');");
//
//        }


    }
}
