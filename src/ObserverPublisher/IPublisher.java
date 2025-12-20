package ObserverPublisher;

public interface IPublisher {
    void subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber);
    void publish(String message);
}
