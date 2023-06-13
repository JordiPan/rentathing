package com.example.rentathing.factory;

import com.example.rentathing.product.Boormachine;
import com.example.rentathing.product.Product;

public class BoormachineFactory extends FactoryMaker {

    private String naam;
    private String merk;
    private String type;

    public BoormachineFactory(String naam, String merk, String type) {
        this.naam = naam;
        this.merk = merk;
        this.type = type;
    }

    @Override
    public Product maakProduct() {
        return new Boormachine(naam,"boor",null, merk, type);
    }
}
