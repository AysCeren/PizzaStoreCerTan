package Bridge;

public class StandardFulfillment extends DeliveryFulfillment{

    public StandardFulfillment(DeliveryService ds) { super(ds); }

    @Override
    public double calculateFulfillmentCost() {
        return 0.0; // Standard is base price
    }
    @Override
    public String getFullDescription() {
        return "Standard - " + deliveryService.getServiceDetail();
    }
}
