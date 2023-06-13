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

    private static ArrayList<Observer> observers = new ArrayList<>(medewerkers);

    public static ArrayList<Product> producten = new ArrayList<>(Arrays.asList(
            new PersonenAuto("Volkswagen","persoon", observers,"Volkers", 1000,144),
            new PersonenAuto("Porsche","persoon", observers, "GeenIdee", 900,90),
            new PersonenAuto("Ferrari","persoon", observers, "Ferr", 1500,150),

            new Vrachtauto("Big vracht","vracht", observers, 200,1500),
            new Vrachtauto("Bigger vracht","vracht", observers, 300,2100),
            new Vrachtauto("Vrachtauto32","vracht", observers, 500,3300),

            new Boormachine("Bosch driller","boor", observers, "Bosch", "automatisch"),
            new Boormachine("Stigma","boor", observers, "Ditzo", "handmatig"),
            new Boormachine("Drill","boor", observers, "Bedrijf", "automatisch")
    ));

    public static void voegProductToe(Product product) {
        producten.add(product);
    }
}
