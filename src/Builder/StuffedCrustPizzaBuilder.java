package Builder;

import java.util.List;

public class StuffedCrustPizzaBuilder implements PizzaBuilder {
    @Override
    public void prepareBase() {
        System.out.println("Preparing Base...");
        System.out.println("Note for chef: Customer wants Stuffed Crust Pizza.");
    }

    @Override
    public void addSauce(String sauce) {
        System.out.println("Adding sauce: " + sauce);
    }

    @Override
    public void addCheese(String cheese){
        System.out.println("Adding cheese: " + cheese);
    }

    @Override
    public void addToppings(List<String> toppings) {
        System.out.println("Adding toppings: " + toppings);
    }
}
