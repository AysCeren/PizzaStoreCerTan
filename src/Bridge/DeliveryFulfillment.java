package Bridge;

public abstract class DeliveryFulfillment {
    // The "Bridge" link: Abstraction holds the Implementation
    protected DeliveryService deliveryService;

    protected DeliveryFulfillment(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public abstract double calculateFulfillmentCost();
    public abstract String getFullDescription();
}
