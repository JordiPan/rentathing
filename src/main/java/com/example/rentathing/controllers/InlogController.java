package com.example.rentathing.controllers;

import com.example.rentathing.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class InlogController {
    @FXML
    private Label welcomeText;

    //hardgecodeerde accounts misschien??
    @FXML
    protected void inloggen(ActionEvent e) throws IOException {
//        Parent root = new FXMLLoader(getClass().getResource("/com/example/rentathing/hoofdmenu-view.fxml")).load();
        Parent root = new FXMLLoader(Main.class.getResource("hoofdmenu-view.fxml")).load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}