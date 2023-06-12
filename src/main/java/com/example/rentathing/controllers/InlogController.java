package com.example.rentathing.controllers;

import com.example.rentathing.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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

                SceneSwitcher.sceneWisselen(root, medewerker.getNaam()).show();
            }
        }
//        Parent root = new FXMLLoader(getClass().getResource("/com/example/rentathing/hoofdmenu-view.fxml")).load();
    }
}