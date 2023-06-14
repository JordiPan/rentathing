package com.example.rentathing.controllers;

import com.example.rentathing.DetailPrinter;
import com.example.rentathing.product.Boormachine;
import com.example.rentathing.product.PersonenAuto;
import com.example.rentathing.product.Product;
import com.example.rentathing.product.Vrachtauto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable {
    private Product product;

    public BorderPane scherm;
    @FXML
    public VBox productInformatie;

    @FXML
    public VBox knoppen;

    private DetailPrinter detailPrinter;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        detailPrinter = new DetailPrinter(product,this);
        detailPrinter.printBasisInformatie(productInformatie);

        switch (product.getCategorie()) {
            case "boor" -> detailPrinter.printBoor(productInformatie);
            case "persoon" -> detailPrinter.printPersonenAuto(productInformatie);
            case "vracht" -> detailPrinter.printVrachtauto(productInformatie);
        }

        if (product.isVerhuurt()) {
            detailPrinter.printInfoRetour(knoppen);
        }
        else {

            detailPrinter.printInfoVerhuren(knoppen, productInformatie);
        }
    }

    public void resetProduct() {
        product.setMedewerker(null);
        product.setVerhuurd(false);
        product.setKlantVoornaam(null);
        product.setKlantAchternaam(null);
    }
    public void retour(int dag) {
        double totaal = product.prijsBerekening()*dag;
        knoppen.getChildren().clear();
        knoppen.getChildren().add(new Label("kosten: "+ totaal));

        product.meldingGeven("Medewerker: " + product.getMedewerker() + " heeft " + product.getNaam() + " geretourneert.");
        resetProduct();
    }
    public void verhuren(Stage stage, String klantVoornaam, String klantAchternaam, boolean verzekerd) {
        product.setVerhuurd(true);
        product.setVerzekerd(verzekerd);
        product.setKlantVoornaam(klantVoornaam);
        product.setKlantAchternaam(klantAchternaam);
        product.setMedewerker(stage.getTitle());

        product.meldingGeven("Medewerker: " + product.getMedewerker() + " heeft " + product.getNaam() + " verhuurt.");
        stage.close();
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}