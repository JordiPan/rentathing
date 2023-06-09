package com.example.rentathing.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BeheerController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void voegProductenToe() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}