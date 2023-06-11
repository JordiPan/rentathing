package com.example.rentathing.product;

import com.example.rentathing.Medewerker;
import com.example.rentathing.Observer;

import java.util.ArrayList;

public class Boormachine extends Product {
    private String merk;
    private String type;


    public Boormachine(String naam, boolean verhuurd, double huurprijs, ArrayList<Observer> observers, String klantVoornaam, String klantAchternaam, Medewerker medewerker, String merk, String type) {
        super(naam, verhuurd, huurprijs, observers, klantVoornaam, klantAchternaam, medewerker);
        this.merk = merk;
        this.type = type;
    }

    @Override
    public double berekenHuurprijs() {
        return 0;
    }

    @Override
    public double berekenVerzekering() {
        return 0;
    }
}
