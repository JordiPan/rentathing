package com.example.rentathing;

import com.example.rentathing.product.Boormachine;
import com.example.rentathing.product.PersonenAuto;
import com.example.rentathing.product.Product;
import com.example.rentathing.product.Vrachtauto;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DetailPrinter {
    Product product;
    public DetailPrinter(Product product) {
        this.product = product;
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


    public void print(VBox locatie, Node node) {
        locatie.getChildren().add(node);
    }
}
