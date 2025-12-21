package Builder;

import Memento.Memento;
import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {
    // Originator for Memento Pattern
    private CrustType crustType;
    private String sauce;
    private String cheese;
    private List<String> toppings = new ArrayList<>();
    private double price;

    // --- Getters ---
    public CrustType getCrustType() { return crustType; }
    public String getSauce() { return sauce; }
    public String getCheese() { return cheese; }
    public List<String> getToppings() { return toppings; }
    public double getPrice() { return price; }

    // --- Setters ---
    public void setPrice(double price) { this.price = price; }
    
    // REVERTED: Renamed back to 'setCrust' to match your Builder files
    public void setCrust(CrustType crustType) { this.crustType = crustType; }
    
    public void setSauce(String sauce) { this.sauce = sauce; }
    public void setCheese(String cheese) { this.cheese = cheese; }
    
    public void addToppings(List<String> toppings) { 
        this.toppings.addAll(toppings); 
    }

    // --- Memento Methods ---
    public Memento save() {
        System.out.println("[Originator] Saving a snapshot of the pizza...");
        return new Memento(crustType, sauce, cheese, toppings, price);
    }

    public void undo(Memento memento) {
        // Uses getCrust() to match your existing Memento.java
        this.crustType = memento.getCrust(); 
        this.sauce = memento.getSauce();
        this.cheese = memento.getCheese();
        this.toppings = new ArrayList<>(memento.getToppings());
        this.price = memento.getPrice();
        System.out.println("[Originator] Restored to previous state: " + this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Current Build Phase ---\n");
        if (crustType != null) sb.append(" > Dough:   ").append(crustType).append("\n");
        if (sauce != null)     sb.append(" > Sauce:   ").append(sauce).append("\n");
        if (cheese != null)    sb.append(" > Cheese:  ").append(cheese).append("\n");
        if (!toppings.isEmpty()) sb.append(" > Extras:  ").append(String.join(", ", toppings)).append("\n");
        return sb.toString();
    }
}