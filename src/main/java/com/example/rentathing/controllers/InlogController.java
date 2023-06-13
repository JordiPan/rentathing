package com.example.rentathing.controllers;

import com.example.rentathing.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class InlogController {
    @FXML
    public TextField gebruikersnaam;
    public TextField wachtwoord;
    @FXML
    protected void inloggen(ActionEvent e) throws IOException {
        for ( Medewerker medewerker : Database.medewerkers) {

            if(medewerker.getNaam().equals(gebruikersnaam.getText()) && medewerker.getWachtwoord().equals(wachtwoord.getText())) {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("hoofdmenu-view.fxml"));
                Parent root = (Parent) loader.load();

                HoofdMenuController hoofdMenuController = loader.getController();
                hoofdMenuController.setMedewerker(medewerker);

                SceneSwitcher.veranderStage(root, medewerker.getNaam()).show();
            }
        }
//        Parent root = new FXMLLoader(getClass().getResource("/com/example/rentathing/hoofdmenu-view.fxml")).load();
    }
}