package com.example.rentathing.controllers;

import com.example.rentathing.Database;
import com.example.rentathing.Main;
import com.example.rentathing.SceneSwitcher;
import com.example.rentathing.product.Product;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OverzichtController implements Initializable {
    @FXML
    private VBox producten;
    @FXML
    protected void refresh() {
        producten.getChildren().clear();
        printProducten();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        printProducten();
    }
    public void printProducten() {
        for (Product product : Database.producten) {
            Label label = new Label(product.getNaam()+" - verhuurd: "+ product.isVerhuurt() + " categorie: " + product.getCategorie());
            label.setStyle("-fx-border-color: black; -fx-padding: 10;");

            //maak detailvenster wanneer erop geklikt wordt
            label.setOnMouseClicked((MouseEvent e) ->{
                Stage kindStage = klikOpProductActie(product);
                kindStage.show();
                kindStage.setOnHidden(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent windowEvent) {
                        refresh();
                    }
                });
            });
            producten.getChildren().add(label);
        }
    }

    private Stage klikOpProductActie(Product product) {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("detail-view.fxml"));

        DetailController detailController = new DetailController();
        detailController.setProduct(product);

        loader.setController(detailController);
        Parent root = null;

        try {
            root = (Parent) loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        Stage huidigeStage = (Stage) producten.getScene().getWindow();
        return SceneSwitcher.maakStageMetModality(huidigeStage, root, huidigeStage.getTitle());
    }
}