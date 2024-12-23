package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/user_database";
    private static final String USER = "root";
    private static final String PASSWORD = "bibuzi34";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                System.out.println("JDBC Connection established!");
            } catch (SQLException e) {
                System.out.println("JDBC Connection failed...");
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("JDBC Connection is closed!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



