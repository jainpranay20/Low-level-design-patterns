package CoreDesignPattern.Creational.Factory;

// ── Usage ──────────────────────────────────────────────────────────────────
public class Main {
    public static void main(String[] args) {
        Notification n1 = NotificationFactory.create(NotificationType.EMAIL);
        n1.send("user@example.com", "Your order shipped!");

        Notification n2 = NotificationFactory.create(NotificationType.SMS);
        n2.send("+1-555-0100", "OTP: 482910");

        Notification n3 = NotificationFactory.create(NotificationType.PUSH);
        n3.send("device-token-xyz", "New message from Alice");
    }
}

// Notification n1 = new EmailNotification();