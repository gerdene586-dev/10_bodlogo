package com.visproject.controllers;

import com.visproject.Main;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;

public class Problem9Controller {

    @FXML
    private TextField nField;

    @FXML
    private TextField mField;

    @FXML
    private Label resultLabel;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private ImageView penguinImage;

    @FXML
    private void initialize() {
        backgroundImage.setImage(loadImage("/com/visproject/images/зураг.png"));
        penguinImage.setImage(loadImage(
                "/com/visproject/images/Screenshot 2026-10-03 at 11.09.16.png"
        ));
    }

    private Image loadImage(String resourcePath) {
        URL imageUrl = getClass().getResource(resourcePath);
        if (imageUrl == null) {
            throw new IllegalStateException("Image resource was not found: " + resourcePath);
        }
        return new Image(imageUrl.toExternalForm());
    }

    @FXML
    private void previousProblem(ActionEvent event) throws IOException {
        Main.showProblem(event, "/com/visproject/problem8.fxml");
    }

    @FXML
    private void nextProblem(ActionEvent event) throws IOException {
        Main.showProblem(event, "/com/visproject/problem10.fxml");
    }

    @FXML
    private void doubleNumber() {
        resultLabel.setText("Улаан товчлуур: ×2");
    }

    @FXML
    private void decreaseNumber() {
        resultLabel.setText("Цэнхэр товчлуур: -1");
    }
}