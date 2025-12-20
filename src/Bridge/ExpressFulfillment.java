package Bridge;

public class ExpressFulfillment extends DeliveryFulfillment{
    public ExpressFulfillment(DeliveryService ds) { super(ds); }
    @Override
    public double calculateFulfillmentCost() {
        return 20.0; // Your requirement: +20 TL for Express
    }
    @Override
    public String getFullDescription() {
        return "Express [PRIORITY] - " + deliveryService.getServiceDetail();
    }
}
