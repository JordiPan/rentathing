package com.example.rentathing.controllers;

import com.example.rentathing.Database;
import com.example.rentathing.Main;
import com.example.rentathing.Medewerker;
import com.example.rentathing.Observer;
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
    private Label welcomeText;

    //hardgecodeerde accounts misschien??

    public TextField gebruikersnaam;
    public TextField wachtwoord;
    @FXML
    protected void inloggen(ActionEvent e) throws IOException {
        for ( Medewerker medewerker : Database.medewerkers) {

            if(medewerker.getNaam().equals(gebruikersnaam.getText()) && medewerker.getWachtwoord().equals(wachtwoord.getText())) {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("hoofdmenu-view.fxml"));
                Parent root = (Parent) loader.load();
                Scene scene = new Scene(root);
                HoofdMenuController hoofdMenuController = loader.getController();
                hoofdMenuController.setMedewerker(medewerker);

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle(medewerker.getNaam());
                stage.show();
            }
        }
//        Parent root = new FXMLLoader(getClass().getResource("/com/example/rentathing/hoofdmenu-view.fxml")).load();
    }
}