package com.visproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/visproject/problem8.fxml")
        );

        Scene scene = new Scene(loader.load());

        stage.setTitle("VIS Project");
        stage.setScene(scene);
        stage.show();
    }

    public static void showProblem(ActionEvent event, String resourcePath) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(resourcePath));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
    }

    public static void main(String[] args) {
        launch(args);
    }
}