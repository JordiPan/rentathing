package com.example.rentathing;

import com.example.rentathing.product.Boormachine;
import com.example.rentathing.product.PersonenAuto;
import com.example.rentathing.product.Product;
import com.example.rentathing.product.Vrachtauto;

import java.util.ArrayList;
import java.util.Arrays;

public class Database {

    public static ArrayList<Medewerker> medewerkers = new ArrayList<>(Arrays.asList(
            new Medewerker("medewerker1","pass"),
            new Medewerker("w","w"),
            new Medewerker("medewerker2","pass"),
            new Medewerker("medewerker3", "pass")));


    public static ArrayList<Product> producten = new ArrayList<>(Arrays.asList(
            new PersonenAuto("Volkswagen","persoon", new ArrayList<>(),"Volkers", 1000,144),
            new PersonenAuto("Porsche","persoon", new ArrayList<>(), "GeenIdee", 900,90),
            new PersonenAuto("Ferrari","persoon", new ArrayList<>(), "Ferr", 1500,150),

            new Vrachtauto("Big vracht","vracht", new ArrayList<>(), 200,1500),
            new Vrachtauto("Bigger vracht","vracht", new ArrayList<>(), 300,2100),
            new Vrachtauto("Vrachtauto32","vracht", new ArrayList<>(), 500,3300),

            new Boormachine("Bosch driller","boor", new ArrayList<>(), "Bosch", "automatisch"),
            new Boormachine("Stigma","boor", new ArrayList<>(), "Ditzo", "handmatig"),
            new Boormachine("Drill","boor", new ArrayList<>(), "Bedrijf", "automatisch")
    ));

    public static void voegProductToe(Product product) {
        producten.add(product);
    }

    public static void voegObserversToe() {
        for (Product product : producten) {
            for (Medewerker medewerker : medewerkers) {
                product.voegObserverToe(medewerker);
            }
        }
    }
}
