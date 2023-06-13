package com.example.rentathing.product;

import com.example.rentathing.Medewerker;
import com.example.rentathing.Observer;

import java.util.ArrayList;

public abstract class Product {
    private String naam;
    private boolean verhuurd;
//    private double huurprijs;
    private String categorie;
    private ArrayList<Observer> observers;
    private String klantVoornaam;
    private String klantAchternaam;
    private boolean verzekerd;
    //door welke medewerker is het verhuurd?
    private String medewerker;

    public Product(String naam, String categorie, ArrayList<Observer> observers) {
        this.naam = naam;
        this.verhuurd = false;
        this.categorie = categorie;
        this.observers = observers;
        this.klantVoornaam = null;
        this.klantAchternaam = null;
        this.verzekerd = false;
        this.medewerker = null;
    }

//    public double getHuurprijs() {
//        return huurprijs;
//    }

    public String getCategorie() {
        return categorie;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public String getKlantVoornaam() {
        return klantVoornaam;
    }

    public String getKlantAchternaam() {
        return klantAchternaam;
    }

    public void setKlantVoornaam(String klantVoornaam) {
        this.klantVoornaam = klantVoornaam;
    }

    public void setKlantAchternaam(String klantAchternaam) {
        this.klantAchternaam = klantAchternaam;
    }

    public void setVerzekerd(boolean verzekerd) {
        this.verzekerd = verzekerd;
    }

    public void setMedewerker(String medewerker) {
        this.medewerker = medewerker;
    }

    public boolean isVerzekerd() {
        return verzekerd;
    }

    public String getMedewerker() {
        return medewerker;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean isVerhuurt() {
        return verhuurd;
    }

    public void setVerhuurd(boolean verhuurd) {
        this.verhuurd = verhuurd;
    }

    //berekent per dag kosten
    public double prijsBerekening() {
        double huur = berekenHuurprijs();
        double verzekering = berekenVerzekering();
        return huur + verzekering;
    }
    public abstract double berekenHuurprijs();
    public abstract double berekenVerzekering();

    public void meldingGeven(String melding) {
        for (Observer o : observers) {
            o.update(melding);
        }
    }

    public void voegObserverToe(Medewerker medewerker) {
        observers.add(medewerker);
    }

}
