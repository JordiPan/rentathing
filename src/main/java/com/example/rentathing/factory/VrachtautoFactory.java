package com.example.rentathing.factory;

import com.example.rentathing.product.Product;
import com.example.rentathing.product.Vrachtauto;

public class VrachtautoFactory extends FactoryMaker {
    private String naam;
    private double laadVermogen;
    private double motorInhoud;

    public VrachtautoFactory(String naam, double laadVermogen, double motorInhoud) {
        this.naam = naam;
        this.laadVermogen = laadVermogen;
        this.motorInhoud = motorInhoud;
    }

    @Override
    public Product maakProduct() {
        return new Vrachtauto(naam,"vracht",null,motorInhoud,laadVermogen);
    }
}
