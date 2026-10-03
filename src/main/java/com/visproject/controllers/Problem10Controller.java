package com.visproject.controllers;

import com.visproject.Main;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;

public class Problem10Controller {

    @FXML
    private TextField arrayField;

    @FXML
    private Label resultLabel;

    @FXML
    private ImageView problemImage;

    @FXML
    private ImageView penguinImage;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private TabPane problemTabs;

    @FXML
    private void initialize() {
        backgroundImage.setImage(loadImage("/com/visproject/images/lkkj.png"));
        problemImage.setImage(loadImage(
                "/com/visproject/images/Screenshot 2026-10-03 at 12.06.15.png"
        ));
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
    private void previousProblem(javafx.event.ActionEvent event) throws IOException {
        Main.showProblem(event, "/com/visproject/problem9.fxml");
    }

    @FXML
    private void showProblemTab() {
        problemTabs.getSelectionModel().select(0);
    }

    @FXML
    private void checkArray() {

        String input = arrayField.getText().trim();

        if (input.isEmpty()) {
            resultLabel.setText("Массив оруулна уу.");
            return;
        }

        String[] values = input.split("\\s+");

        try {

            int previous = Integer.parseInt(values[0]);

            for (int i = 1; i < values.length; i++) {

                int current = Integer.parseInt(values[i]);

                if (current < previous) {
                    resultLabel.setText("NO");
                    return;
                }

                previous = current;
            }

            resultLabel.setText("YES");

        } catch (NumberFormatException e) {

            resultLabel.setText(
                    "Зөвхөн бүхэл тоо оруулна уу."
            );
        }
    }
}