package com.example.rentathing.product;

import com.example.rentathing.Medewerker;
import com.example.rentathing.Observer;

import java.util.ArrayList;

public class Vrachtauto extends Product {
    private double motorInhoud;
    private double laadVermogen;

    public Vrachtauto(String naam, boolean verhuurd, double huurprijs, ArrayList<Observer> observers, String klantVoornaam, String klantAchternaam, Medewerker medewerker, double motorInhoud, double laadVermogen) {
        super(naam, verhuurd, huurprijs, observers, klantVoornaam, klantAchternaam, medewerker);
        this.motorInhoud = motorInhoud;
        this.laadVermogen = laadVermogen;
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
