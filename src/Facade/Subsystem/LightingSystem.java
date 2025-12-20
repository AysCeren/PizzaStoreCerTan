package Facade.Subsystem;

public class LightingSystem {
    public void turnOn() throws InterruptedException {
        System.out.println("[Lighting] Main lights are ON.");
        Thread.sleep(1000);
    }
    public void turnOff() throws InterruptedException {
        System.out.println("[Lighting] All lights are OFF.");
        Thread.sleep(1000);
    }
    public void dimLights() throws InterruptedException {
        System.out.println("[Lighting] Lights dimmed for closing.");
        Thread.sleep(1000);
    }
    public void checkEmergencyLights() throws InterruptedException {
        System.out.println("[Lighting] Emergency exit lights: OK.");
        Thread.sleep(1000);
    }
}
