package com.example.rentathing.product;

import com.example.rentathing.Medewerker;
import com.example.rentathing.Observer;

import java.util.ArrayList;

public class PersonenAuto extends Product {
    private String merk;
    private double gewicht;
    private double motorInhoud;

    public PersonenAuto(String naam, boolean verhuurd, double huurprijs, String categorie, ArrayList<Observer> observers, String klantVoornaam, String klantAchternaam, boolean verzekerd, String medewerker, String merk, double gewicht, double motorInhoud) {
        super(naam, verhuurd, huurprijs, categorie, observers, klantVoornaam, klantAchternaam, verzekerd, medewerker);
        this.merk = merk;
        this.gewicht = gewicht;
        this.motorInhoud = motorInhoud;
    }

    public String getMerk() {
        return merk;
    }

    public double getGewicht() {
        return gewicht;
    }

    public double getMotorInhoud() {
        return motorInhoud;
    }

    @Override
    //50 per dag
    public double berekenHuurprijs() {
        return 50;
    }

    @Override
    // 0.01 per cc motorinhoud
    public double berekenVerzekering() {
        return 0.01*motorInhoud;
    }
}
