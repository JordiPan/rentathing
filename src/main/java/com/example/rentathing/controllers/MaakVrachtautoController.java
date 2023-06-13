package com.example.rentathing.controllers;

import com.example.rentathing.Database;
import com.example.rentathing.factory.AutoFactory;
import com.example.rentathing.factory.FactoryMaker;
import com.example.rentathing.factory.VrachtautoFactory;
import com.example.rentathing.product.PersonenAuto;
import com.example.rentathing.product.Vrachtauto;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MaakVrachtautoController {
    @FXML
    private TextField naam;
    @FXML
    private TextField laadVermogen;
    @FXML
    private TextField motorInhoud;
    public void maakVrachtauto(){
        FactoryMaker factoryMaker = new VrachtautoFactory(naam.getText(), Double.parseDouble(laadVermogen.getText()), Double.parseDouble(motorInhoud.getText()));
        Vrachtauto vrachtauto = (Vrachtauto) factoryMaker.maakProduct();
        Database.voegProductToe(vrachtauto);
    }
}
