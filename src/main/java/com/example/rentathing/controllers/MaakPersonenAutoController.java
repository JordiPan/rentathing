package com.example.rentathing.controllers;

import com.example.rentathing.Database;
import com.example.rentathing.factory.AutoFactory;
import com.example.rentathing.factory.FactoryMaker;
import com.example.rentathing.product.PersonenAuto;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MaakPersonenAutoController {
    @FXML
    private TextField naam;
    @FXML
    private TextField merk;
    @FXML
    private TextField gewicht;
    @FXML
    private TextField motorInhoud;
    public void maakPersonenAuto(){
        FactoryMaker factoryMaker = new AutoFactory(naam.getText(), merk.getText(), Double.parseDouble(gewicht.getText()), Double.parseDouble(motorInhoud.getText()));
        PersonenAuto personenAuto = (PersonenAuto) factoryMaker.maakProduct();
        Database.voegProductToe(personenAuto);
    }
}
