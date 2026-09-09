package CoreDesignPattern.Creational.Factory;

public class PushNotification implements Notification {
    @Override
    public void send(String to, String message) {
        System.out.println("[PUSH] Device: " + to + " | " + message);
    }

    @Override
    public String getType() {
        return "PUSH";
    }
}
