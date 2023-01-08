package com.jay.javafx.dynamic_tableview.jdbc;

import com.jay.javafx.dynamic_tableview.config.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;

public class JDBCUtil {
    private static Logger logger = LoggerFactory.getLogger(JDBCUtil.class);
    private String queryRetrieveCustomers;

    public JDBCUtil() {
        Value value = new Value();
        queryRetrieveCustomers = value.getString("data.sql.search.customers");
    }

    public ResultSet getCustomers() {
        ResultSet resultSet = null;
        try {
            Connection connection = DBConnect.getInstance().getConnection();
            resultSet = connection.createStatement().executeQuery(queryRetrieveCustomers);
        } catch (Exception exception) {
            logger.error("Error to Retrieve.", exception);
        }
        return resultSet;
    }
}