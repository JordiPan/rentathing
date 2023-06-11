package com.example.rentathing.controllers;

import com.example.rentathing.Main;
import com.example.rentathing.Medewerker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HoofdMenuController {
    public Button uitlog;

    public Medewerker medewerker;
    @FXML
    protected void overzicht() throws IOException {
        Parent root = new FXMLLoader(Main.class.getResource("overzicht-view.fxml")).load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(uitlog.getScene().getWindow());
        stage.setScene(scene);
        stage.setTitle(medewerker.getNaam());
        stage.show();
    }
    @FXML
    protected void beheer() {}
    @FXML
    protected void uitloggen(ActionEvent e) {
        Stage stage = (Stage) uitlog.getScene().getWindow();
        stage.close();
    }
    protected void setMedewerker(Medewerker medewerker) {
        this.medewerker = medewerker;
    }
}