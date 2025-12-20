package Builder;

import java.util.List;

public class StuffedCrustPizzaBuilder implements PizzaBuilder {
    @Override
    public void prepareBase() throws InterruptedException{
        System.out.println("Preparing Base...");
        System.out.println("!!!Note for chef: Customer wants Stuffed Crust Pizza.");
        Thread.sleep(1000);
    }

    @Override
    public void addSauce(String sauce) throws InterruptedException{
        System.out.println("Adding sauce: " + sauce);
        Thread.sleep(1000);
    }

    @Override
    public void addCheese(String cheese)throws InterruptedException{
        System.out.println("Adding cheese: " + cheese);
        Thread.sleep(1000);
    }

    @Override
    public void addToppings(List<String> toppings) throws InterruptedException{
        System.out.println("Adding toppings: " + toppings);
        Thread.sleep(1000);
    }
}
