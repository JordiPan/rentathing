package com.example.rentathing;

import java.util.ArrayList;

public class Medewerker implements Observer{
    private String naam;
    private String wachtwoord;
    private ArrayList<String> meldingen = new ArrayList<>();

    public Medewerker(String naam, String wachtwoord) {
        this.naam = naam;
        this.wachtwoord = wachtwoord;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public ArrayList<String> getMeldingen() {
        return meldingen;
    }

    public void update(String melding){
        meldingen.add(melding);
    }
}
