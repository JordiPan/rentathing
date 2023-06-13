package com.example.rentathing.controllers;

import com.example.rentathing.Database;
import com.example.rentathing.Main;
import com.example.rentathing.Medewerker;
import com.example.rentathing.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HoofdMenuController {
    @FXML
    private AnchorPane hoofdScherm;
    @FXML
    private Button uitlog;
    private Medewerker medewerker;

    @FXML
    private void overzicht() throws IOException {
        Parent root = new FXMLLoader(Main.class.getResource("overzicht-view.fxml")).load();
        SceneSwitcher.maakStageMetModality(uitlog.getScene().getWindow(), root, medewerker.getNaam()).show();
    }
    @FXML
    private void beheer() throws IOException {
        Parent root = new FXMLLoader(Main.class.getResource("beheer-view.fxml")).load();
        SceneSwitcher.maakStageMetModality(uitlog.getScene().getWindow(), root, medewerker.getNaam()).show();
    }
    @FXML
    private void uitloggen(ActionEvent e) {
        Stage stage = (Stage) uitlog.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void notificaties(ActionEvent e) {
        if (!medewerker.getMeldingen().isEmpty()) {
            for (String melding : medewerker.getMeldingen()) {
                hoofdScherm.getChildren().add(new Label(melding));
            }
        }
        else {
            hoofdScherm.getChildren().add(new Label("Geen notificaties"));
        }
    }
    public void setMedewerker(Medewerker medewerker) {
        this.medewerker = medewerker;
    }
}