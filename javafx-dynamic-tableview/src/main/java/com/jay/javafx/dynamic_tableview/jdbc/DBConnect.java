/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jay.javafx.dynamic_tableview.jdbc;

import com.jay.javafx.dynamic_tableview.config.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    private static DBConnect dbConnect = null;
    private static Connection conn = null;
    private String url;
    private String userName;
    private String password;
    private String driver;

    private DBConnect() {
        Value value = new Value();
        url = value.getString("datasource.jdbc.registration.url");
        userName = value.getString("datasource.jdbc.registration.username");
        password = value.getString("datasource.jdbc.registration.password");
        driver = value.getString("datasource.jdbc.registration.driver");
    }

    private Connection connect() throws SQLException {
        try {
            Class.forName(driver).newInstance();
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Error: " + cnfe.getMessage());
        } catch (InstantiationException ie) {
            System.err.println("Error: " + ie.getMessage());
        } catch (IllegalAccessException iae) {
            System.err.println("Error: " + iae.getMessage());
        }
        conn = DriverManager.getConnection(url, userName, password);
        return conn;
    }

    public static DBConnect getInstance() {
        if (null == dbConnect) {
            dbConnect = new DBConnect();
        }
        return dbConnect;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conn != null && !conn.isClosed()) {
            return conn;
        }
        connect();
        return conn;
    }
}