package com.example.rentathing.controllers;

import com.example.rentathing.Database;
import com.example.rentathing.factory.BoormachineFactory;
import com.example.rentathing.factory.FactoryMaker;
import com.example.rentathing.product.Boormachine;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MaakBoormachineController {

    @FXML
    private TextField naam;
    @FXML
    private TextField merk;
    @FXML
    private TextField type;
    public void maakBoormachine(){
        FactoryMaker factoryMaker = new BoormachineFactory(naam.getText(), merk.getText(), type.getText());
        Boormachine boormachine = (Boormachine) factoryMaker.maakProduct();
        Database.voegProductToe(boormachine);
    }
}
