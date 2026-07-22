package CoreDesignPattern.Factory;

// ── Factory ────────────────────────────────────────────────────────────────
public class NotificationFactory {

    public static Notification create(NotificationType type) {
        return switch (type) {
            case EMAIL -> new EmailNotification();
            case SMS -> new SMSNotification();
            case PUSH -> new PushNotification();
        };
    }
}
