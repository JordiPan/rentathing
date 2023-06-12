package com.example.rentathing.controllers;

import com.example.rentathing.Medewerker;
import com.example.rentathing.product.Boormachine;
import com.example.rentathing.product.PersonenAuto;
import com.example.rentathing.product.Product;
import com.example.rentathing.product.Vrachtauto;
import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable {
    private Product product;

    private BorderPane scherm;
    @FXML
    private VBox productInformatie;

    @FXML
    private VBox knoppen;
    @FXML

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
        resetProduct();
    }
    public void verhuren(Stage stage, String klantVoornaam, String klantAchternaam, boolean verzekerd) {
        product.setVerhuurd(true);
        product.setVerzekerd(verzekerd);
        product.setKlantVoornaam(klantVoornaam);
        product.setKlantAchternaam(klantAchternaam);
        product.setMedewerker(stage.getTitle());
        stage.close();
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        printBasisInformatie();

        switch (product.getCategorie()) {
            case "boor" -> printBoor();
            case "persoon" -> printPersonenAuto();
            case "vracht" -> printVrachtauto();
        }

        if (product.isVerhuurd()) {
            try {
                TextField dag = new TextField("hoeveelheid dagen gehuurd. Cijfers aub");
                knoppen.getChildren().add(dag);

                Button retour = new Button("retour");
                retour.setOnMouseClicked((MouseEvent e) -> {
                    retour(Integer.parseInt(dag.getText()));
                });
                knoppen.getChildren().add(retour);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        else {
            CheckBox verzekerd = new CheckBox("verzekeren?");
            Label prijsBerekening = new Label("");
            verzekerd.setOnMouseClicked((MouseEvent e) -> {
                prijsBerekening.setText("Totaal prijs met verzekering per dag: "+ product.prijsBerekening());
            });
            productInformatie.getChildren().add(verzekerd);
            productInformatie.getChildren().add(prijsBerekening);

            TextField klantVoornaam = new TextField("klant voornaam");
            TextField klantAchternaam = new TextField("klant achternaam");

            Button verhuur = new Button("verhuren");
            verhuur.setOnMouseClicked((MouseEvent e) ->{
                Stage stage =  (Stage)((Node) e.getSource()).getScene().getWindow();
                verhuren(stage, klantVoornaam.getText(), klantAchternaam.getText(), verzekerd.isSelected());
            });
            knoppen.getChildren().add(klantVoornaam);
            knoppen.getChildren().add(klantAchternaam);
            knoppen.getChildren().add(verhuur);
        }
    }

    //dit kan type node worden
    public void print(Label label) {
        productInformatie.getChildren().add(label);
    }
    public void printBasisInformatie() {
        print(new Label(product.getNaam()));
        print(new Label("verhuurd: " + product.isVerhuurd()));
        print(new Label("huurprijs (per dag): " + product.getHuurprijs()));
        print(new Label("medewerker: " + product.getMedewerker()));
        print(new Label("klant voornaam: " + product.getKlantVoornaam()));
        print(new Label("klant achternaam: " + product.getKlantAchternaam()));
        print(new Label("verzekerd: " + product.isVerzekerd()));
    }
    public void printBoor(){
        Boormachine boor = (Boormachine) product;
        print(new Label( "merk: " + boor.getMerk()));
        print(new Label( "type: " + boor.getType()));
    }
    public void printPersonenAuto(){
        PersonenAuto personenAuto = (PersonenAuto) product;
        print(new Label("merk " + personenAuto.getMerk()));
        print(new Label("gewicht: " +personenAuto.getGewicht()));
        print(new Label("motorinhoud: " +personenAuto.getMotorInhoud()));
    }
    public void printVrachtauto(){
        Vrachtauto vrachtauto = (Vrachtauto) product;
        print(new Label("laadvermogen: " +vrachtauto.getLaadVermogen()));
        print(new Label("motorinhoud: " +vrachtauto.getMotorInhoud()));
    }
}