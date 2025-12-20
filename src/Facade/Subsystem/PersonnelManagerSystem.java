package Facade.Subsystem;

public class PersonnelManagerSystem {
    public void checkStaffPresence() throws InterruptedException {
        System.out.println("[Personnel] Staff clocked in.");
        Thread.sleep(1000);
    }
    public void assignStations() throws InterruptedException {
        System.out.println("[Personnel] Chef assigned to Pizza Station.");
        Thread.sleep(1000);
    }
    public void processPayroll() throws InterruptedException {
        System.out.println("[Personnel] Daily hours logged for payroll.");
        Thread.sleep(1000);
    }
}
