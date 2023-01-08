package com.jay.javafx.dynamic_tableview.config;

import java.io.*;
import java.util.Properties;

public class Value {
    Properties properties = new Properties();

    public Value() {
        File externalAppFile = new File("cfg/application.properties");
        if (externalAppFile.exists()) {
            InputStreamReader in = null;
            try {
                in = new InputStreamReader(new FileInputStream(externalAppFile), "UTF-8");
                properties.load(in);
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            } finally {
                if (null != in) {
                    try {
                        in.close();
                    } catch (IOException ex) {
                    }
                }
            }
        } else {
            try {
                properties.load(Value.class.getClassLoader().getResourceAsStream("application.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getString(String key) {
        return properties.getProperty(key);
    }
}
