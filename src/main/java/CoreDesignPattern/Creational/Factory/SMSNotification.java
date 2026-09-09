package CoreDesignPattern.Creational.Factory;

public class SMSNotification implements Notification {
    @Override
    public void send(String to, String message) {
        System.out.println("[SMS] To: " + to + " | " + message);
    }

    @Override
    public String getType() {
        return "SMS";
    }
}
