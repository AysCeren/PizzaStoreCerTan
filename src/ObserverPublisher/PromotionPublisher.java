package ObserverPublisher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Flow;

public class PromotionPublisher implements IPublisher {
    private List<ISubscriber> subscribers = new ArrayList<>();

    public boolean checkSubscriber(int memberID) {
        for (ISubscriber s : subscribers) {
            if (s instanceof CustomerSubscriber && ((CustomerSubscriber) s).getCustomerID() == memberID) {
                return true;
            }
        }
        return false;
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }
    @Override
    public void subscribe(ISubscriber s) { subscribers.add(s); }

    @Override
    public void unsubscribe(ISubscriber s) { subscribers.remove(s); }

    @Override
    public void publish(String message) {
        System.out.println("The message has been sent to the following members: ");
        for (ISubscriber s : subscribers) {
            s.upcomingMessage(message); //
        }
    }
}
