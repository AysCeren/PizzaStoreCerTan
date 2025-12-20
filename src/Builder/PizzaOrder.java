package Builder;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {
    private CrustType crustType;
    private String sauce;
    private String cheese;
    private List<String> toppings = new ArrayList<>();
    private double price;
    String currentStepName;

    public CrustType getCrustType() {
        return crustType;
    }

    public String getSauce() {
        return sauce;
    }

    public String getCheese() {
        return cheese;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {this.price = price;}
    public void setCrust(CrustType crust) { this.crustType = crust; }
    public void setSauce(String sauce) { this.sauce = sauce; }
    public void setCheese(String cheese) { this.cheese = cheese; }
    public void addToppings(List<String> toppings) { this.toppings.addAll(toppings); }
    public String toString() {
        return "Pizza [" + crustType + " crust, " + sauce + " sauce, " + cheese + " cheese, Toppings: " + toppings + "]";
    }
}