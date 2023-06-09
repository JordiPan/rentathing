package com.example.rentathing.product;

public class Vrachtauto extends Product {
    private String merk;
    private String type;

    public Vrachtauto(String merk, String type) {
        this.merk = merk;
        this.type = type;
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
