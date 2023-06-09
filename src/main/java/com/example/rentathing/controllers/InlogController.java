package com.example.rentathing.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InlogController {
    @FXML
    private Label welcomeText;

    //hardgecodeerde accounts misschien??
    @FXML
    protected void inloggen() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}