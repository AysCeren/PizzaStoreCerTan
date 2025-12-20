package Bridge;

public class SelfServiceDeliveryService implements DeliveryService{
    @Override
    public String getServiceDetail() {
        return "Pickup at CerTan Store counter";
    }
}
