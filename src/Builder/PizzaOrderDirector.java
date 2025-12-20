package Builder;

import Memento.PizzaCaretaker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaOrderDirector {
    private PizzaCaretaker pizzaCaretaker = new  PizzaCaretaker();
    List<String> toppings = new ArrayList<>();
    public void makeMargarita(PizzaBuilder builder) throws InterruptedException {
        System.out.println("The order has been taken. Chef prepares Margarita Pizza...");
        Thread.sleep(1000);
        toppings= Arrays.asList("Tomato", "Basil");
        builder.setPrice(250);
        builder.prepareBase();       // Builder sets the crust
        pizzaCaretaker.saveState(builder.getResult());
        builder.addSauce("Tomato");  // Builder adds sauce
        pizzaCaretaker.saveState(builder.getResult());
        builder.addCheese("Mozzarella"); // Builder adds cheese
        pizzaCaretaker.saveState(builder.getResult());
        builder.addToppings(toppings); // Builder adds toppings
        pizzaCaretaker.saveState(builder.getResult());
        builder.putToOven();
    }
    public void makeBaconPizza(PizzaBuilder builder) throws InterruptedException {
        System.out.println("The order has been taken. Chef prepares Bacon Pizza...");
        Thread.sleep(1000);
        toppings= Arrays.asList( "Bacon", "Tomato", "Roquette", "Corn", "Olive");
        builder.setPrice(350);
        builder.prepareBase();       // Builder sets the crust
        builder.addSauce("Ranch");  // Builder adds sauce
        builder.addCheese("Cheddar"); // Builder adds cheese
        builder.addToppings(toppings); // Builder adds toppings
        builder.putToOven();
    }
    public void makeTunaFishPizza(PizzaBuilder builder) throws InterruptedException {
        System.out.println("The order has been taken. Chef prepares Tuna Fish Pizza...");
        Thread.sleep(1000);
        toppings= Arrays.asList( "Tuna", "Tomato", "Roquette", "Corn", "Mushroom");
        builder.setPrice(300);
        builder.prepareBase();       // Builder sets the crust
        builder.addSauce("Tomato");  // Builder adds sauce
        builder.addCheese("Parmesan"); // Builder adds cheese
        builder.addToppings(toppings); // Builder adds toppings
        builder.putToOven();
    }
    // Inside PizzaOrderDirector.java
    public void showTransparencyProcess(PizzaOrder pizza) throws InterruptedException {
        System.out.println("\n [CER-TAN PIZZA REPLAY: THE TRANSPARENT JOURNEY]");
        System.out.println("Wait while we deconstruct your order to verify quality...");
        Thread.sleep(1500);

        // Use the Caretaker to step backward through time
        // We can show the "Reverse Construction" to prove every ingredient was placed correctly
        while (true) {
            System.out.println(pizza.toString());
            System.out.println(" Step Verified! Checking previous layer...");
            Thread.sleep(1000);

            // If caretaker is empty, we reached the start
            if (pizzaCaretaker.isHistoryEmpty()) break;
            pizzaCaretaker.undo(pizza);
        }

        System.out.println("\n [VERIFICATION COMPLETE]: All layers meet CerTan Quality Standards!");
    }
}
