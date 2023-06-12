package com.example.rentathing.controllers;

import com.example.rentathing.factory.BoormachineFactory;
import com.example.rentathing.factory.FactoryMaker;
import com.example.rentathing.product.Boormachine;

public class MaakBoormachineController {
    FactoryMaker factoryMaker;

    public void voegProductToe(){
        factoryMaker = new BoormachineFactory();
        Boormachine boormachine = (Boormachine) factoryMaker.maakProduct();
        boormachine.setNaam();
    }
}
