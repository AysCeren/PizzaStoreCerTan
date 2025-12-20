package Bridge;

public class CourierDeliveryService implements DeliveryService{
    @Override
    public String getServiceDetail() {
        return "Home delivery via CerTan Moto-Courier";
    }
}
