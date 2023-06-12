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
            new PersonenAuto("Volkswagen",false,400,"persoon", observers,
                    null, null, false,null,"Volkers", 1000,144),
            new PersonenAuto("Porsche",false,700,"persoon", observers,
                    null, null, false,null,"GeenIdee", 900,90),
            new PersonenAuto("Ferrari",false,2000,"persoon", observers,
                    null, null, false,null,"Ferr", 1500,150),

            new Vrachtauto("Big vracht", false, 300,"vracht", observers,
                    null, null, false, null, 200,1500),
            new Vrachtauto("Bigger vracht", false, 500,"vracht", observers,
                    null, null, false, null, 300,2100),
            new Vrachtauto("Vrachtauto32", false, 750,"vracht", observers,
                    null, null, false, null, 500,3300),

            new Boormachine("Bosch driller", false,5,"boor", observers,
                    null, null, false,null, "Bosch", "automatisch"),
            new Boormachine("Stigma", false,20,"boor", observers,
                    null, null, false,null, "Ditzo", "handmatig"),
            new Boormachine("Drill", false,30,"boor", observers,
                    null, null, false,null, "Bedrijf", "automatisch")
    ));

    public static void voegProductToe(Product product) {
        producten.add(product);
    }
}
