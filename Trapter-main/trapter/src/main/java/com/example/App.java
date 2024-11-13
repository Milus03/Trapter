/*
* File: App.java
* Author: Reiter Milán
* Copyright: 2024, Reiter Milán
* Group: Szoft II/I/N
* Date: 2024-11-13
* Github: https://github.com/Milus03/
* Licenc: GNU GPL
*/
package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * Simple JavaFX Application
 */
public class MyApplication extends Application {

    private static Scene mainScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        mainScene = new Scene(loadFXMLFile("ElsoScene"), 640, 480);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    static void changeRoot(String fxmlFile) throws IOException {
        mainScene.setRoot(loadFXMLFile(fxmlFile));
    }

    private static Parent loadFXMLFile(String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(MyApplication.class.getResource(fxmlFile + ".fxml"));
        return loader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}

