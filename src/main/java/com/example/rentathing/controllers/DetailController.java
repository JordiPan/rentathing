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

    private BorderPane scherm;
    @FXML
    private VBox productInformatie;

    @FXML
    private VBox knoppen;

    private DetailPrinter detailPrinter;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        detailPrinter = new DetailPrinter(product);
        detailPrinter.printBasisInformatie(productInformatie);

        switch (product.getCategorie()) {
            case "boor" -> detailPrinter.printBoor(productInformatie);
            case "persoon" -> detailPrinter.printPersonenAuto(productInformatie);
            case "vracht" -> detailPrinter.printVrachtauto(productInformatie);
        }

        if (product.isVerhuurt()) {
            productIsVerhuurt();
        }
        else {
            productInVoorraad();
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
        System.out.println(product.getObservers().get(0));
        product.meldingGeven("Medewerker: " + product.getMedewerker() + " heeft " + product.getNaam() + " verhuurt.");
        stage.close();
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void productIsVerhuurt() {
        TextField dag = new TextField("hoeveelheid dagen gehuurd. Cijfers aub");
        Button retour = new Button("retour");

        //kan dit niet in detailprinter zetten omdat ik retour methode van detailcontroller nodig heb
        retour.setOnMouseClicked((MouseEvent e) -> {
            retour(Integer.parseInt(dag.getText()));
        });

        detailPrinter.print(knoppen, dag);
        detailPrinter.print(knoppen, retour);
    }

    public void productInVoorraad() {
        CheckBox verzekerd = new CheckBox("verzekeren?");
        Label prijsBerekening = new Label("");
        TextField klantVoornaam = new TextField("klant voornaam");
        TextField klantAchternaam = new TextField("klant achternaam");
        Button verhuur = new Button("verhuren");

        verzekerd.setOnMouseClicked((MouseEvent e) -> {
            prijsBerekening.setText("Totaal prijs met verzekering per dag: "+ product.prijsBerekening());
        });

        verhuur.setOnMouseClicked((MouseEvent e) ->{
            Stage stage =  (Stage)((Node) e.getSource()).getScene().getWindow();
            verhuren(stage, klantVoornaam.getText(), klantAchternaam.getText(), verzekerd.isSelected());
        });

        detailPrinter.print(productInformatie, verzekerd);
        detailPrinter.print(productInformatie, prijsBerekening);
        detailPrinter.print(knoppen, klantVoornaam);
        detailPrinter.print(knoppen, klantAchternaam);
        detailPrinter.print(knoppen, verhuur);
    }
}