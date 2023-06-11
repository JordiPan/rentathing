package com.example.rentathing;

public class Medewerker implements Observer{
    private String naam;
    private String wachtwoord;

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

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public void melding(){

    }
    public void update(){}
}
