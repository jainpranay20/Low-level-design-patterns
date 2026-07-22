package Projects.NotifySystem;

// Subject interface
public interface Subject {
    void subscribe(String productId, Observer observer);

    void unsubscribe(String productId, Observer observer);

    void notifyObservers(String productId,  Product product);
}
