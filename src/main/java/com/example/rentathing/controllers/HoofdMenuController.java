package com.example.rentathing.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HoofdMenuController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void uitloggen() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}