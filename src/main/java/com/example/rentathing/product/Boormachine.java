package com.example.rentathing.product;

import com.example.rentathing.Medewerker;
import com.example.rentathing.Observer;

import java.util.ArrayList;

public class Boormachine extends Product {
    private String merk;
    private String type;

    public Boormachine(String naam, String categorie, ArrayList<Observer> observers, String merk, String type) {
        super(naam, categorie, observers);
        this.merk = merk;
        this.type = type;
    }
    public String getMerk() {
        return merk;
    }

    public String getType() {
        return type;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    //5 euro per dag
    public double berekenHuurprijs() {
        return 5;
    }

    @Override
    //1 euro per dag
    public double berekenVerzekering() {
        return 1;
    }
}
