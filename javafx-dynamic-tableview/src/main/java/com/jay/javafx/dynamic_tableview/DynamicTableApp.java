/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jay.javafx.dynamic_tableview;

import com.jay.javafx.dynamic_tableview.util.ControllerUtil;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DynamicTableApp extends Application {

    private static Scene scene;

    //MAIN EXECUTOR
    public static void main(String[] args) {
        launch(args);
    }

    //CONNECTION DATABASE

    @Override
    public void start(Stage stage) throws Exception {
        //Main Scene
        scene = new Scene(ControllerUtil.loadFXML("dynamic_table"));
        stage.setTitle("Dynamic Table");
        stage.setScene(scene);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        stage.show();
    }
}
