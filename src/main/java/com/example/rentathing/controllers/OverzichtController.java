package com.example.rentathing.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OverzichtController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void getProducten() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}