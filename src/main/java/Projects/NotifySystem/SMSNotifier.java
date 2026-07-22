package Projects.NotifySystem;

public class SMSNotifier implements Observer {
    private final String phone;

    public SMSNotifier(String phone) {
        this.phone = phone;
    }

    @Override
    public void update(Product product) {
        System.out.println("[SMS] Sending to " + phone +
                ": " + product.getName() + " is available!");
    }
}
