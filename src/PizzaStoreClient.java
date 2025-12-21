import Bridge.*;
import Builder.*;
import Facade.PizzaStoreFacade;
import ObserverPublisher.CustomerSubscriber;
import ObserverPublisher.ISubscriber;
import ObserverPublisher.PromotionPublisher;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PizzaStoreClient {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        //Open the store with *Facade Pattern*
        PizzaStoreFacade pizzaStoreFacade = new PizzaStoreFacade(); // We instantiate the storeFacade, first.
        pizzaStoreFacade.openStore(); //storeFacade will handle coupling with other class so main class will have loose coupling with classes (lighting, cleaning etc.)

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
        //We have done this to show who is taking the message who is not.
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
        //Check the deliveryService and deliveryFulfillment
        System.out.println("\n--- 🚚 CER-TAN DELIVERY CONFIGURATION ---");
        // 1. Choose Delivery Method (The Implementation)
        System.out.println("Step 1: How would you like to receive your pizza?");
        System.out.println(" [1] Self-Service (Pickup)");
        System.out.println(" [2] Courier Delivery");
        System.out.print("Selection: ");
        int serviceChoice = sc.nextInt();
        DeliveryService service = (serviceChoice == 2) ? new CourierDeliveryService() : new SelfServiceDeliveryService();
        // 2. Choose Fulfillment Type (The Abstraction)
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
        // 3. Fancy Confirmation Output
        System.out.println("\n-------------------------------------------");
        System.out.println(" FULFILLMENT SECURED ");
        System.out.println("Mode:    " + fulfillment.getFullDescription());
        System.out.println("Surcharge: " + fulfillment.calculateFulfillmentCost() + " TL");
        System.out.println("-------------------------------------------\n");
        Thread.sleep(2000);
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
        }else if(crustNumber == 2) {
            pizzaBuilder = new StuffedCrustPizzaBuilder();
        }else{
            System.out.println("Wrong choice. Try again.");
        }
        switch(pizzaNumber) {
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
        PizzaOrder pizza = pizzaBuilder.getResult(); //no new keywords

        System.out.print("Total Cost --> For Pizza " + pizza.getPrice() + " TL Surcharge: "+fulfillment.calculateFulfillmentCost() + " TL = ");
        pizza.setPrice(pizza.getPrice() + fulfillment.calculateFulfillmentCost());
        System.out.println(pizza.getPrice() + " TL");
        System.out.println("Do you wanna know how your pizza got prepared?");
        System.out.println("We are clean and transparent: press enter and let's start!!!");
        // This uses the Mementos stored during the build to show the "Story"
        pizzaOrderDirector.showTransparencyProcess(pizza);
        System.out.println("Thank you! Yine Bekleriz<3");
        pizzaStoreFacade.closeStore();
    }
}