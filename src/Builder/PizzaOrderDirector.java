package Builder;

import java.util.Arrays;
import java.util.List;

public class PizzaOrderDirector {
    private PizzaBuilder pizzaBuilder;
    List<String> toppings;
    public void makeMargarita(PizzaBuilder builder) throws InterruptedException {
        System.out.println("The order has been taken. Chef prepares Margarita Pizza...");
        Thread.sleep(1000);
        toppings= Arrays.asList("Tomato", "Basil");
        builder.prepareBase();       // Builder sets the crust
        builder.addSauce("Tomato");  // Builder adds sauce
        builder.addCheese("Mozzarella"); // Builder adds cheese
        builder.addToppings(toppings); // Builder adds toppings
    }
    public void makeBaconPizza(PizzaBuilder builder) throws InterruptedException {
        System.out.println("The order has been taken. Chef prepares Bacon Pizza...");
        Thread.sleep(1000);
        toppings= Arrays.asList( "Bacon", "Tomato", "Roquette", "Corn", "Olive");
        builder.prepareBase();       // Builder sets the crust
        builder.addSauce("Ranch");  // Builder adds sauce
        builder.addCheese("Cheddar"); // Builder adds cheese
        builder.addToppings(toppings); // Builder adds toppings
    }
    public void makeTunaFishPizza(PizzaBuilder builder) throws InterruptedException {
        System.out.println("The order has been taken. Chef prepares Tuna Fish Pizza...");
        Thread.sleep(1000);
        toppings= Arrays.asList( "Tuna", "Tomato", "Roquette", "Corn", "Mushroom");
        builder.prepareBase();       // Builder sets the crust
        builder.addSauce("Tomato");  // Builder adds sauce
        builder.addCheese("Parmesan"); // Builder adds cheese
        builder.addToppings(toppings); // Builder adds toppings
    }
}
