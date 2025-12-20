import Builder.PizzaBuilder;
import Builder.PizzaOrderDirector;
import Builder.StuffedCrustPizzaBuilder;
import Builder.ThinCrustPizzaBuilder;
import Facade.StoreFacade;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Open the store with *Facade Pattern*
        StoreFacade storeFacade = new StoreFacade(); // We instantiate the storeFacade, first.
        storeFacade.openStore(); //storeFacade will handle coupling with other class so main class will have loose coupling with classes (lighting, cleaning etc.)
        //Subscription and User Management with *Publisher Pattern*
        //Take Order and Build the Pizza
        int pizzaNumber;
        int crustNumber;
        Scanner sc = new Scanner(System.in);
        PizzaOrderDirector pizzaOrderDirector = new PizzaOrderDirector();
        PizzaBuilder pizzaBuilder = null;
        System.out.print(
                "\n============================================\n" +
                        "        WELCOME TO CERTAN PIZZA             \n" +
                        "  [KNOW WHAT YOU EAT: TRANSPARENT PIZZA]    \n" +
                        "============================================\n" +
                        "Please choose your Pizza:\n\n" +
                        "1. MARGARITA\n" +
                        "\t- Sauce:    Tomato Sauce\n" +
                        "\t- Cheese:   Mozzarella\n" +
                        "\t- Toppings: Tomato, Basil\n\n" +
                        "2. BACON PIZZA\n" +
                        "\t- Sauce:    Ranch Sauce\n" +
                        "\t- Cheese:   Cheddar\n" +
                        "\t- Toppings: Bacon, Tomato, Roquette, Corn, Olive\n\n" +
                        "3. TUNA FISH PIZZA\n" +
                        "\t- Sauce:    Tomato Sauce\n" +
                        "\t- Cheese:   Parmesan\n" +
                        "\t- Toppings: Tuna, Tomato, Roquette, Corn, Mushroom\n\n" +
                        "--------------------------------------------\n" +
                        "Enter choice (1-3): "
        );
        pizzaNumber = sc.nextInt();
        System.out.print(
                "\nPlease choose your Crust Type:\n" +
                        "1. Thin Crust\n" +
                        "2. Stuffed Crust\n\n" +
                        "Enter choice (1-2) : "
        );
        crustNumber = sc.nextInt();
        if(crustNumber == 1) {
            pizzaBuilder = new ThinCrustPizzaBuilder();
        }else if(crustNumber == 2) {
            pizzaBuilder = new StuffedCrustPizzaBuilder();
        }else{
            System.out.println("Wrong choice. Try again.");
        }
        switch(crustNumber) {
            case 1:
                pizzaOrderDirector.makeMargarita(pizzaBuilder);
                break;
            case 2:
                pizzaOrderDirector.makeTunaFishPizza(pizzaBuilder);
                break;
            case 3:
                pizzaOrderDirector.makeBaconPizza(pizzaBuilder);
                break;
        }
    }
}