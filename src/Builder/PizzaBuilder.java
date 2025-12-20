package Builder;

import java.util.List;

public interface PizzaBuilder {
    void prepareBase() throws InterruptedException;
    void addSauce(String sauce) throws InterruptedException;
    void addCheese(String cheese) throws InterruptedException;
    void addToppings(List<String> toppings) throws InterruptedException;
}
