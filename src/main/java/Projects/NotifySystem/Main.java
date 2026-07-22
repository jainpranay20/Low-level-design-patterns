import CoreDesignPattern.Observer.User;
import Projects.NotifySystem.NotificationChannel;
import Projects.NotifySystem.NotifierFactory;
import Projects.NotifySystem.NotifyMeService;
import Projects.NotifySystem.Product;

public class Main {
    public static void main(String[] args) {
        NotifyMeService service = new NotifyMeService();
        Product iphone = new Product("P001", "iPhone 15 Pro");

        User alice = new User("U1", "Alice", "alice@email.com", "+91-9999", "token-A");
        User bob   = new User("U2", "Bob",   "bob@email.com",   "+91-8888", "token-B");

        // Alice subscribes via Email + Push
        service.subscribe(iphone.getId(), NotifierFactory.create(NotificationChannel.EMAIL, alice));
        service.subscribe(iphone.getId(), NotifierFactory.create(NotificationChannel.PUSH,  alice));

        // Bob subscribes via SMS
        service.subscribe(iphone.getId(), NotifierFactory.create(NotificationChannel.SMS, bob));

        // Product comes back in stock!
        service.onProductInStock(iphone);

        // Output:
        // [EMAIL] Sending to alice@email.com: iPhone 15 Pro is back in stock!
        // [PUSH]  Sending to device token-A: iPhone 15 Pro is now available!
        // [SMS]   Sending to +91-8888: iPhone 15 Pro is available!
    }
}