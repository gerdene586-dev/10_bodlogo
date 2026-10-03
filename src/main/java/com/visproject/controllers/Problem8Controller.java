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

public class Problem8Controller {

    @FXML
    private TextField numberField;

    @FXML
    private Label resultLabel;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private void initialize() {
        URL imageUrl = getClass().getResource("/com/visproject/images/зураг.png");
        if (imageUrl == null) {
            throw new IllegalStateException("First problem background image was not found.");
        }
        backgroundImage.setImage(new Image(imageUrl.toExternalForm()));
    }

    @FXML
    private void nextProblem(ActionEvent event) throws IOException {
        Main.showProblem(event, "/com/visproject/problem9.fxml");
    }

    @FXML
    private void checkPalindrome() {

        String number = numberField.getText().trim();

        if (number.isEmpty()) {
            resultLabel.setText("Тоогоо оруулна уу.");
            return;
        }

        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                resultLabel.setText("Зөвхөн цифр оруулна уу.");
                return;
            }
        }

        int[] count = new int[10];

        for (char c : number.toCharArray()) {
            count[c - '0']++;
        }

        for (int c : count) {
            if (c % 2 != 0) {
                resultLabel.setText(
                        "Палиндром үүсгэх боломжгүй."
                );
                return;
            }
        }

        StringBuilder half = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < count[i] / 2; j++) {
                half.append(i);
            }
        }

        String left = half.toString();
        String right = half.reverse().toString();

        String palindrome = left + right;

        resultLabel.setText(
                "Үүсэх палиндромын тоо: 1\n" +
                "Хамгийн их палиндром: " + palindrome
        );
    }
}