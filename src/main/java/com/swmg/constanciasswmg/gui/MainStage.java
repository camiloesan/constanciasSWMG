package com.swmg.constanciasswmg.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainStage extends Application {
    private static Scene scene;

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainStage.class.getResource(fxml));
        return fxmlLoader.load();
    }

    public static void changeView(String url, int width, int height) {
        Stage currentStage = (Stage) scene.getWindow();
        configureStage(currentStage, width, height, null);
        try {
            MainStage.setRoot(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeView(String url, int width, int height, Object obj) {
        Stage currentStage = (Stage) scene.getWindow();
        configureStage(currentStage, width, height, obj);
        try {
            MainStage.setRoot(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getUserData() {
        Stage currentStage = (Stage) scene.getWindow();
        return currentStage.getUserData();
    }

    private static void configureStage(Stage stage, int width, int height, Object obj) {
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setUserData(obj);
        stage.centerOnScreen();
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("src/main/resources/com/swmg/constanciasswmg/views/login-view.fxml"), 600, 400);
        stage.setTitle("Sistema de generación de constancias");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}