/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jay.javafx.dynamic_tableview.util;

import com.jay.javafx.dynamic_tableview.DynamicTableApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

/**
 * @author PGPS
 */
public class ControllerUtil {
    private static Logger logger = LoggerFactory.getLogger(ControllerUtil.class);

    private ControllerUtil() {
        //Private constructor to hide the implicit public
    }

    public static Parent loadFXML(String fxml) throws IOException {
        URL fxmlLocation = DynamicTableApp.class.getResource(fxml + ".fxml");
        logger.info("fxmlLocation: {}", fxmlLocation);
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        return fxmlLoader.load();
    }
}