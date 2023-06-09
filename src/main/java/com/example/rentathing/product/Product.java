package com.example.rentathing.product;

import com.example.rentathing.Medewerker;
import com.example.rentathing.Observer;

import java.util.ArrayList;

public abstract class Product {
    private String naam;
    private boolean verhuurd;
    private double huurprijs;
    private ArrayList<Observer> observers;
    private String klantVoornaam;
    private String klantAchternaam;
    //door welke medewerker is het verhuurd?
    private Medewerker medewerker;

    public double prijsBerekening() {
        double huur = berekenHuurprijs();
        double verzekering = berekenVerzekering();
        return huur + verzekering;
    }
    public abstract double berekenHuurprijs();
    public abstract double berekenVerzekering();

    public void meldingGeven() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public void voegObserverToe(Medewerker medewerker) {
        observers.add(medewerker);
    }

}
