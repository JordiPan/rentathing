package com.example.rentathing;

import com.example.rentathing.controllers.DetailController;
import com.example.rentathing.product.Boormachine;
import com.example.rentathing.product.PersonenAuto;
import com.example.rentathing.product.Product;
import com.example.rentathing.product.Vrachtauto;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DetailPrinter {
    DetailController detailController;
    Product product;
    public DetailPrinter(Product product, DetailController detailController) {
        this.product = product;
        this.detailController = detailController;
    }
    public void printBasisInformatie(VBox locatie) {
        print(locatie, new Label(product.getNaam()));
        print(locatie, new Label("verhuurd: " + product.isVerhuurt()));
        print(locatie, new Label("huurprijs (per dag): " + product.berekenHuurprijs()));
        print(locatie, new Label("medewerker: " + product.getMedewerker()));
        print(locatie, new Label("klant voornaam: " + product.getKlantVoornaam()));
        print(locatie, new Label("klant achternaam: " + product.getKlantAchternaam()));
        print(locatie, new Label("verzekerd: " + product.isVerzekerd()));
    }
    public void printBoor(VBox locatie){
        Boormachine boor = (Boormachine) product;
        print(locatie, new Label( "merk: " + boor.getMerk()));
        print(locatie, new Label( "type: " + boor.getType()));
    }
    public void printPersonenAuto(VBox locatie){
        PersonenAuto personenAuto = (PersonenAuto) product;
        print(locatie, new Label("merk " + personenAuto.getMerk()));
        print(locatie, new Label("gewicht: " +personenAuto.getGewicht()));
        print(locatie, new Label("motorinhoud: " +personenAuto.getMotorInhoud()));
    }
    public void printVrachtauto(VBox locatie){
        Vrachtauto vrachtauto = (Vrachtauto) product;
        print(locatie, new Label("laadvermogen: " +vrachtauto.getLaadVermogen()));
        print(locatie, new Label("motorinhoud: " +vrachtauto.getMotorInhoud()));
    }

    public void printInfoRetour(VBox knoppen) {
        TextField dag = new TextField("hoeveelheid dagen gehuurd. Cijfers aub");
        Button retour = new Button("retour");

        //kan dit niet in detailprinter zetten omdat ik retour methode van detailcontroller nodig heb
        retour.setOnMouseClicked((MouseEvent e) -> {
            detailController.retour(Integer.parseInt(dag.getText()));
        });

        print(knoppen, dag);
        print(knoppen, retour);
    }

    public void printInfoVerhuren(VBox knoppen, VBox productInformatie) {
        TextField klantVoornaam = new TextField("klant voornaam");
        TextField klantAchternaam = new TextField("klant achternaam");
        Button verhuur = new Button("verhuren");
        CheckBox verzekerd = new CheckBox("verzekeren?");
        Label prijsBerekening = new Label("");

        verzekerd.setOnMouseClicked((MouseEvent e) -> {
            prijsBerekening.setText("Totaal prijs met verzekering per dag: "+ product.prijsBerekening());
        });

        verhuur.setOnMouseClicked((MouseEvent e) ->{
            Stage stage =  (Stage)((Node) e.getSource()).getScene().getWindow();
            detailController.verhuren(stage, klantVoornaam.getText(), klantAchternaam.getText(), verzekerd.isSelected());
        });

        print(productInformatie, verzekerd);
        print(productInformatie, prijsBerekening);
        print(knoppen, klantVoornaam);
        print(knoppen, klantAchternaam);
        print(knoppen, verhuur);
    }

    public void print(VBox locatie, Node node) {
        locatie.getChildren().add(node);
    }
}
