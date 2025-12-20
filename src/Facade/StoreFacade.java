package Facade;

import Facade.Subsystem.CleaningSystem;
import Facade.Subsystem.InventorySystem;
import Facade.Subsystem.LightingSystem;
import Facade.Subsystem.PersonnelManagerSystem;

public class StoreFacade {
        private LightingSystem lighting = new LightingSystem();
        private InventorySystem inventory = new InventorySystem();
        private PersonnelManagerSystem personnel = new PersonnelManagerSystem();
        private CleaningSystem cleaning = new CleaningSystem();

        public void openStore() {
            System.out.println("--- Starting Store Opening Sequence ---");
            lighting.turnOn();             // Lights first
            inventory.countSubstances();   // Then inventory count
            personnel.checkStaffPresence();// Followed by personnel check
            System.out.println("Store is now OPEN for business!\n");
        }

        public void closeStore() {
            System.out.println("\n--- Starting Store Closing Sequence ---");
            cleaning.performCleaning();    // Cleaning tasks
            inventory.checkStock();        // Final inventory check
            lighting.turnOff();            // Lights off last
            System.out.println("Store is now CLOSED. See you tomorrow!");
        }
    }
