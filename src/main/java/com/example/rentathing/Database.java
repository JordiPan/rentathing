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
            new PersonenAuto("Volkswagen",false,400,"persoon", observers,null, null, false,null,"Volkers", 1000,144),
            new Vrachtauto("Big", false, 700,"vracht", observers, null, null, false, null, 300,1500),
            new Boormachine("Bosch driller", false,13,"boor", observers, null, null, false,null, "Bosch", "automatisch")
    ));


}
