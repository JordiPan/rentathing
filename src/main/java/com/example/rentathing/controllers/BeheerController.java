package com.example.rentathing.controllers;

import com.example.rentathing.Main;
import com.example.rentathing.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class BeheerController {
    @FXML
    public Text voegToe;

    @FXML
    public void boormachine() throws IOException {
        veranderScene("maak-boormachine-view.fxml");
    }
    public void personenAuto() throws IOException {
        veranderScene("maak-personenauto-view.fxml");
    }
    public void vrachtauto() throws IOException {
        veranderScene("maak-vrachtauto-view.fxml");
    }
    //dit kan ook in andere controllers
    private void veranderScene(String fxml) throws IOException {
        System.out.println("ff");
        Window huidigeScherm = voegToe.getScene().getWindow();
        //ik moet dit doen ipv huidigeScherm.gettitle
        Stage stage = (Stage) voegToe.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxml));
        SceneSwitcher.initModality(huidigeScherm,loader.load(), stage.getTitle()).show();
    }
}
