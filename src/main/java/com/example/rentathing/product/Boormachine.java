package com.example.rentathing.product;

import com.example.rentathing.Medewerker;
import com.example.rentathing.Observer;

import java.util.ArrayList;

public class Boormachine extends Product {
    private String merk;
    private String type;

    public Boormachine(String naam, boolean verhuurd, double huurprijs, String categorie, ArrayList<Observer> observers, String klantVoornaam, String klantAchternaam, boolean verzekerd, String medewerker, String merk, String type) {
        super(naam, verhuurd, huurprijs, categorie, observers, klantVoornaam, klantAchternaam, verzekerd, medewerker);
        this.merk = merk;
        this.type = type;
    }

    public String getMerk() {
        return merk;
    }

    public String getType() {
        return type;
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
