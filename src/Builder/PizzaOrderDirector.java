package Builder;

import Memento.PizzaCaretaker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaOrderDirector {
    private PizzaCaretaker pizzaCaretaker = new PizzaCaretaker();
    List<String> toppings = new ArrayList<>();

    public void makeMargarita(PizzaBuilder builder) throws InterruptedException {
        System.out.println("The order has been taken. Chef prepares Margarita Pizza...");
        Thread.sleep(1000);
        toppings = Arrays.asList("Tomato", "Basil");
        builder.setPrice(250);
        
        builder.prepareBase();       
        pizzaCaretaker.saveState(builder.getResult()); // KAYIT 1
        
        builder.addSauce("Tomato");  
        pizzaCaretaker.saveState(builder.getResult()); // KAYIT 2
        
        builder.addCheese("Mozzarella"); 
        pizzaCaretaker.saveState(builder.getResult()); // KAYIT 3
        
        builder.addToppings(toppings); 
        pizzaCaretaker.saveState(builder.getResult()); // KAYIT 4
        
        builder.putToOven();
    }

    public void makeBaconPizza(PizzaBuilder builder) throws InterruptedException {
        System.out.println("The order has been taken. Chef prepares Bacon Pizza...");
        Thread.sleep(1000);
        toppings = Arrays.asList("Bacon", "Tomato", "Roquette", "Corn", "Olive");
        builder.setPrice(350);
        
        builder.prepareBase();       
        pizzaCaretaker.saveState(builder.getResult()); // [DÜZELTME] Eklendi
        
        builder.addSauce("Ranch");  
        pizzaCaretaker.saveState(builder.getResult()); // [DÜZELTME] Eklendi
        
        builder.addCheese("Cheddar"); 
        pizzaCaretaker.saveState(builder.getResult()); // [DÜZELTME] Eklendi
        
        builder.addToppings(toppings); 
        pizzaCaretaker.saveState(builder.getResult()); // [DÜZELTME] Eklendi
        
        builder.putToOven();
    }

    public void makeTunaFishPizza(PizzaBuilder builder) throws InterruptedException {
        System.out.println("The order has been taken. Chef prepares Tuna Fish Pizza...");
        Thread.sleep(1000);
        toppings = Arrays.asList("Tuna", "Tomato", "Roquette", "Corn", "Mushroom");
        builder.setPrice(300);
        
        builder.prepareBase();       
        pizzaCaretaker.saveState(builder.getResult()); // [DÜZELTME] Eklendi
        
        builder.addSauce("Tomato");  
        pizzaCaretaker.saveState(builder.getResult()); // [DÜZELTME] Eklendi
        
        builder.addCheese("Parmesan"); 
        pizzaCaretaker.saveState(builder.getResult()); // [DÜZELTME] Eklendi
        
        builder.addToppings(toppings); 
        pizzaCaretaker.saveState(builder.getResult()); // [DÜZELTME] Eklendi
        
        builder.putToOven();
    }

    // Inside PizzaOrderDirector.java
    public void showTransparencyProcess(PizzaOrder pizza) throws InterruptedException {
        System.out.println("\n [CER-TAN PIZZA REPLAY: THE TRANSPARENT JOURNEY]");
        System.out.println("Wait while we deconstruct your order to verify quality...");
        Thread.sleep(1500);

        // Use the Caretaker to step backward through time
        while (true) {
            System.out.println(pizza.toString());
            
            if (pizzaCaretaker.isHistoryEmpty()) {
                break;
            }
            
            System.out.println(" Step Verified! Checking previous layer...");
            Thread.sleep(1000);
            
            // Undo işleminden sonra döngü başa döner ve önceki hali yazdırır
            pizzaCaretaker.undo(pizza);
        }

        System.out.println("\n [VERIFICATION COMPLETE]: All layers meet CerTan Quality Standards!");
    }
}