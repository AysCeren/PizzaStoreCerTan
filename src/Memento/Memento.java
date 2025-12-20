package Memento;

import Builder.CrustType;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    private final CrustType crust;
    private final String sauce;
    private final String cheese;
    private final List<String> toppings;
    private final double price;

    public Memento(CrustType crust, String sauce, String cheese, List<String> toppings, double price) {
        this.crust = crust;
        this.sauce = sauce;
        this.cheese = cheese;
        // Important: Create a NEW list so the snapshot isn't affected by future changes
        this.toppings = new ArrayList<>(toppings);
        this.price = price;
    }

    // Only Getters - No Setters!
    public CrustType getCrust() { return crust; }
    public String getSauce() { return sauce; }
    public String getCheese() { return cheese; }
    public List<String> getToppings() { return toppings; }
    public double getPrice() { return price; }
}
