package com.epam.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class ConnectionManager {
    private static final Logger logger = LogManager.getLogger(ConnectionManager.class);
    private static Connection connection = null;

    private ConnectionManager() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().
                        getResource("")).getPath() + "db_connection.properties"));
                connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
                        properties.getProperty("password"));
            } catch (SQLException | FileNotFoundException e) {
                logger.error("SQLException: " + e.getMessage());
            } catch (IOException e) {
                logger.error(e.getStackTrace());
            }
        }
        return connection;
    }


}
