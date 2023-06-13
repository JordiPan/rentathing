package com.example.rentathing.factory;

import com.example.rentathing.product.PersonenAuto;
import com.example.rentathing.product.Product;

public class AutoFactory extends FactoryMaker {

    private String naam;
    private String merk;
    private double gewicht;
    private double motorInhoud;

    public AutoFactory(String naam, String merk, double gewicht, double motorInhoud) {
        this.naam = naam;
        this.merk = merk;
        this.gewicht = gewicht;
        this.motorInhoud = motorInhoud;
    }

    @Override
    public Product maakProduct() {
        return new PersonenAuto(naam, "persoon",null, merk, gewicht,motorInhoud);
    }
}
