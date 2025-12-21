import Bridge.*;
import Builder.*;
import Facade.PizzaStoreFacade;
import Memento.Memento;
import ObserverPublisher.CustomerSubscriber;
import ObserverPublisher.ISubscriber;
import ObserverPublisher.PromotionPublisher;

import java.util.Scanner;

public class PizzaStoreClient {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        // --- 1. FACADE PATTERN ---
        // Handles the complex startup logic (Lighting, Inventory, Personnel) via a simple interface.
        PizzaStoreFacade pizzaStoreFacade = new PizzaStoreFacade();
        pizzaStoreFacade.openStore();

        // --- 2. OBSERVER PATTERN ---
        // Manages customer subscriptions and broadcasts notifications.
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
        
        PromotionPublisher publisher = new PromotionPublisher();
        
        // Add mock subscribers
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
                ISubscriber newMember = new CustomerSubscriber(name, memberID);
                publisher.subscribe(newMember);
                System.out.println("Subscription successful! You are now part of CerTan Pizza.");
            }
        }
        publisher.publish("CerTan Pizza: 20% Discount on all thin crust pizzas today!");
        Thread.sleep(1000);

        // --- 3. BRIDGE PATTERN ---
        // Decouples the 'Delivery Mode' (Implementation) from 'Fulfillment Speed' (Abstraction).
        System.out.println("\n--- 🚚 CER-TAN DELIVERY CONFIGURATION ---");
        
        System.out.println("Step 1: How would you like to receive your pizza?");
        System.out.println(" [1] Self-Service (Pickup)");
        System.out.println(" [2] Courier Delivery");
        System.out.print("Selection: ");
        int serviceChoice = sc.nextInt();
        DeliveryService service = (serviceChoice == 2) ? new CourierDeliveryService() : new SelfServiceDeliveryService();

        Thread.sleep(1000);
        System.out.println("\nStep 2: Choose your fulfillment speed:");
        System.out.println(" [1] Standard (No extra fee)");
        System.out.println(" [2] Express (+20 TL fee - Priority Oven Access!)");
        System.out.print("Selection: ");
        int fulfillmentChoice = sc.nextInt();
        
        DeliveryFulfillment fulfillment;
        if (fulfillmentChoice == 2) {
            fulfillment = new ExpressFulfillment(service);
        } else {
            fulfillment = new StandardFulfillment(service);
        }

        System.out.println("\n-------------------------------------------");
        System.out.println(" FULFILLMENT SECURED ");
        System.out.println("Mode:    " + fulfillment.getFullDescription());
        System.out.println("Surcharge: " + fulfillment.calculateFulfillmentCost() + " TL");
        System.out.println("-------------------------------------------\n");
        Thread.sleep(2000);

        // --- 4. BUILDER PATTERN ---
        // Constructs complex Pizza objects step-by-step using a Director.
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
                        "\t- Price: 250 TL\n\n" +
                        "2. BACON PIZZA\n" +
                        "\t- Sauce:    Ranch Sauce\n" +
                        "\t- Cheese:   Cheddar\n" +
                        "\t- Toppings: Bacon, Tomato, Roquette, Corn, Olive\n\n" +
                        "\t- Price: 350 TL\n\n" +
                        "3. TUNA FISH PIZZA\n" +
                        "\t- Sauce:    Tomato Sauce\n" +
                        "\t- Cheese:   Parmesan\n" +
                        "\t- Toppings: Tuna, Tomato, Roquette, Corn, Mushroom\n\n" +
                        "\t- Price: 325 TL\n\n" +
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
        } else if(crustNumber == 2) {
            pizzaBuilder = new StuffedCrustPizzaBuilder();
        } else {
            System.out.println("Wrong choice. Try again.");
        }

        switch(pizzaNumber) {
            case 1:
                pizzaOrderDirector.makeMargarita(pizzaBuilder);
                break;
            case 2:
                pizzaOrderDirector.makeBaconPizza(pizzaBuilder);
                break;
            case 3:
                pizzaOrderDirector.makeTunaFishPizza(pizzaBuilder);
                break;
        }
        PizzaOrder pizza = pizzaBuilder.getResult();

        System.out.print("Total Cost --> For Pizza " + pizza.getPrice() + " TL Surcharge: "+fulfillment.calculateFulfillmentCost() + " TL = ");
        pizza.setPrice(pizza.getPrice() + fulfillment.calculateFulfillmentCost());
        System.out.println(pizza.getPrice() + " TL");

        // --- 5. MEMENTO PATTERN ---
        // Allows saving and restoring state. 
        // We save the 'Full' state here because the demo below will destructively undo the pizza.
        Thread.sleep(2000);
        System.out.println("Do you wanna know how your pizza got prepared?");
        System.out.print("Before you leave, comment us on Google Maps!");
        System.out.println("We are clean and transparent: press enter and let's start!!!");
        Thread.sleep(1000);
        Memento fullPizzaState = pizza.save();

        // Demonstrates Memento by undoing steps to show history
        pizzaOrderDirector.showTransparencyProcess(pizza);

        // Restore the pizza to its full state so the Manager Report is correct
        pizza.undo(fullPizzaState);
        
        // --- 6. ITERATOR PATTERN ---
        // Allows uniform traversal of different collections (Order List vs Inventory Array).
        pizzaStoreFacade.addPendingOrder(pizza);
        pizzaStoreFacade.printManagerReport();
        
        pizzaStoreFacade.closeStore();
        System.out.println("Thank you! Yine Bekleriz<3");
    }
}