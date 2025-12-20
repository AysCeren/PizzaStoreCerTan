package Facade.Subsystem;

public class LightingSystem {
    public void turnOn() { System.out.println("[Lighting] Main lights are ON."); }
    public void turnOff() { System.out.println("[Lighting] All lights are OFF."); }
    public void dimLights() { System.out.println("[Lighting] Lights dimmed for closing."); }
    public void checkEmergencyLights() { System.out.println("[Lighting] Emergency exit lights: OK."); }
}
