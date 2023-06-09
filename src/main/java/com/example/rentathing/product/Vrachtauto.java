package com.example.rentathing.product;

import com.example.rentathing.Medewerker;
import com.example.rentathing.Observer;

import java.util.ArrayList;

public class Vrachtauto extends Product {
    private double motorInhoud;
    private double laadVermogen;

    public Vrachtauto(String naam, String categorie, ArrayList<Observer> observers, double motorInhoud, double laadVermogen) {
        super(naam, categorie, observers);
        this.motorInhoud = motorInhoud;
        this.laadVermogen = laadVermogen;
    }

    public double getMotorInhoud() {
        return motorInhoud;
    }

    public double getLaadVermogen() {
        return laadVermogen;
    }

    @Override
    //0.10 cent per kg laadvermogen
    public double berekenHuurprijs() {
        return 0.10*laadVermogen;
    }

    @Override
    //0.01 cent per cc motorinhoud
    public double berekenVerzekering() {
        return 0.01*motorInhoud;
    }
}
