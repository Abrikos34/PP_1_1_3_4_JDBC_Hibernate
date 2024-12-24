package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/user_database";
    private static final String USER = "root";
    private static final String PASSWORD = "bibuzi34";

    private static SessionFactory sessionFactory;
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (Util.class) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                        System.out.println("JDBC Connection established!");
                    } catch (SQLException e) {
                        System.out.println("Failed to establish JDBC Connection...");
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (Util.class) {
                if (sessionFactory == null) {
                    try {
                        sessionFactory = new Configuration()
                                .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                                .setProperty("hibernate.connection.url", DB_URL)
                                .setProperty("hibernate.connection.username", USER)
                                .setProperty("hibernate.connection.password", PASSWORD)
                                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                                .setProperty("hibernate.show_sql", "true")
                                .setProperty("hibernate.hbm2ddl.auto", "update")
                                .addAnnotatedClass(User.class)
                                .buildSessionFactory();
                        System.out.println("Hibernate SessionFactory initialized!");
                    } catch (Throwable ex) {
                        System.err.println("Failed to initialize Hibernate SessionFactory: " + ex);
                        throw new ExceptionInInitializerError(ex);
                    }
                }
            }
        }
        return sessionFactory;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("JDBC Connection closed!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
            sessionFactory = null;
            System.out.println("Hibernate SessionFactory closed!");
        }
    }
}



