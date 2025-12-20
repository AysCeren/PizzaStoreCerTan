package Facade.Subsystem;

public class InventorySystem {
    public void countSubstances() throws InterruptedException {
        System.out.println("[Inventory] Counting flour and cheese...");
        Thread.sleep(1000);
    }
    public void checkStock() throws InterruptedException {
        System.out.println("[Inventory] Stock levels verified.");
        Thread.sleep(1000);
    }
    public void checkOvenTemperature() throws InterruptedException {
        System.out.println("[Inventory] Oven pre-heated to 450°F.");
        Thread.sleep(1000);
    }
    public void orderSupplies() throws InterruptedException {
        System.out.println("[Inventory] Weekly supply order placed.");
        Thread.sleep(1000);
    }
}
