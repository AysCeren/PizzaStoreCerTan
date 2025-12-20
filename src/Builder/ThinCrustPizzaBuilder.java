package Builder;

import java.util.List;

public class ThinCrustPizzaBuilder implements PizzaBuilder {
    private PizzaOrder pizza = new PizzaOrder();

    @Override
    public void setPrice(double price) {
        pizza.setPrice(price);
    }

    @Override
    public void prepareBase()throws InterruptedException{
        pizza.setCrust(CrustType.ThinCrust); // Updating State
        System.out.println("Preparing Base...");
        System.out.println("!!!Note for chef: Customer wants Thin Crust Pizza.");
        Thread.sleep(1000);
    }

    @Override
    public void addSauce(String sauce) throws InterruptedException{
        pizza.setSauce(sauce); // Updating State
        System.out.println("Adding sauce: " + sauce);
        Thread.sleep(1000);
    }

    @Override
    public void addCheese(String cheese) throws InterruptedException{
        pizza.setCheese(cheese); // Updating State
        System.out.println("Adding cheese: " + cheese);
        Thread.sleep(1000);
    }

    @Override
    public void addToppings(List<String> toppings) throws InterruptedException{
        pizza.addToppings(toppings); // Updating State
        System.out.println("Adding toppings: " + toppings);
        Thread.sleep(1000);
    }

    @Override
    public void putToOven() throws InterruptedException {
        System.out.println("The pizza is in the oven.");
        Thread.sleep(1000);
    }
    @Override
    public PizzaOrder getResult() {
        return this.pizza;
    }
}
