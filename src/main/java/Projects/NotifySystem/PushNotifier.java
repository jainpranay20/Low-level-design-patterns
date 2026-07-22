package Projects.NotifySystem;

public class PushNotifier implements Observer {
    private final String deviceToken;

    public PushNotifier(String token) {
        this.deviceToken = token;
    }

    @Override
    public void update(Product product) {
        System.out.println("[PUSH] Sending to device " + deviceToken +
                ": " + product.getName() + " is now available!");
    }
}
