package com.example.rentathing.product;

import com.example.rentathing.Medewerker;
import com.example.rentathing.Observer;

import java.util.ArrayList;

public class PersonenAuto extends Product {
    private String merk;
    private double gewicht;
    private double motorInhoud;

    public PersonenAuto(String naam, boolean verhuurd, double huurprijs, ArrayList<Observer> observers, String klantVoornaam, String klantAchternaam, Medewerker medewerker, String merk, double gewicht, double motorInhoud) {
        super(naam, verhuurd, huurprijs, observers, klantVoornaam, klantAchternaam, medewerker);
        this.merk = merk;
        this.gewicht = gewicht;
        this.motorInhoud = motorInhoud;
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
