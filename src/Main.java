import Builder.PizzaBuilder;
import Builder.PizzaOrderDirector;
import Builder.StuffedCrustPizzaBuilder;
import Builder.ThinCrustPizzaBuilder;
import Facade.StoreFacade;
import ObserverPublisher.CustomerSubscriber;
import ObserverPublisher.IPublisher;
import ObserverPublisher.ISubscriber;
import ObserverPublisher.PromotionPublisher;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        //Open the store with *Facade Pattern*
        StoreFacade storeFacade = new StoreFacade(); // We instantiate the storeFacade, first.
        storeFacade.openStore(); //storeFacade will handle coupling with other class so main class will have loose coupling with classes (lighting, cleaning etc.)

        //Subscription and User Management with *Publisher Pattern*
        System.out.println(
                "\n==========================================================\n" +
                        "             CER-TAN PIZZA: MEMBERSHIP CHECK              \n" +
                        "==========================================================\n" +
                        "Welcome to the CerTan Pizza Store!\n" +
                        "\n" +
                        "Do you have a CerTan ID Card to access our exclusive\n" +
                        "promotions, discount campaigns, and member-only sales?\n" +
                        "----------------------------------------------------------"
        );
        //Setup the Publisher and the mock data
        PromotionPublisher publisher = new PromotionPublisher();
        ISubscriber ali = new CustomerSubscriber("Ali", 105);
        ISubscriber ayse = new CustomerSubscriber("Ayşe", 202);
        ISubscriber veli = new CustomerSubscriber("Veli", 305);
        publisher.subscribe(ali);
        publisher.subscribe(ayse);
        System.out.println(publisher.getSubscribers());
        System.out.print("Please enter your ID: ");
        int memberID = sc.nextInt();

        if (publisher.checkSubscriber(memberID)) {
            System.out.println("Welcome back, Member! You will receive our new alerts.");
        } else {
            System.out.println("ID not found.");
            System.out.print("Would you like to subscribe? (Y/N): ");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("Y")) {
                System.out.print("Enter your name: ");
                String name = sc.next();
                // Create new Observer and subscribe
                ISubscriber newMember = new CustomerSubscriber(name, memberID);
                publisher.subscribe(newMember);
                System.out.println("Subscription successful! You are now part of CerTan Pizza.");
            }
        }
        publisher.publish("CerTan Pizza: 20% Discount on all thin crust pizzas today!");
        Thread.sleep(1000);
        //Take Order and Build the Pizza
        int pizzaNumber;
        int crustNumber;
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