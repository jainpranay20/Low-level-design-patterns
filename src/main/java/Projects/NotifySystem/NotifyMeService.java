package Projects.NotifySystem;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

// NotifyMeService — Subject implementation (thread-safe)
public class NotifyMeService implements Subject {

    // CopyOnWriteArrayList — safe concurrent reads; writes are infrequent
    private final Map<String, CopyOnWriteArrayList<Observer>> productObservers
        = new ConcurrentHashMap<>();

    @Override
    public void subscribe(String productId, Observer observer) {
        productObservers
            .computeIfAbsent(productId, k -> new CopyOnWriteArrayList<>())
            .addIfAbsent(observer);   // idempotent — no duplicates
    }

    @Override
    public void unsubscribe(String productId, Observer observer) {
        List<Observer> observers = productObservers.get(productId);
        if (observers != null) observers.remove(observer);
    }



    // Called when inventory service marks product in-stock
    public void onProductInStock(Product product) {
        product.setInStock(true);
        notifyObservers(product.getId(), product);
    }

    public void notifyObservers(String productId, Product product) {
        List<Observer> observers = productObservers.getOrDefault(
            productId, new CopyOnWriteArrayList<>());
        for (Observer o : observers) {
            try { o.update(product); }
            catch (Exception e) { System.err.println("Error: " + e.getMessage()); }
        }
        // Auto-clear after notification (optional — based on requirement)
        productObservers.remove(productId);
    }
}