package ObserverPublisher;

public class CustomerSubscriber implements ISubscriber {
    String userName;
    int CustomerID;
    public CustomerSubscriber(){};
    public CustomerSubscriber(String userName, int CustomerID) {
        this.userName = userName;
        this.CustomerID = CustomerID;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    @Override
    public void upcomingMessage(String message) {
        System.out.println(message);
    }
}
