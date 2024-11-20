/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Milena
 */
public class DBBroker {
    private static DBBroker instance;
    private Connection connection;

    private DBBroker() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("config\\dbconfig.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }
}
