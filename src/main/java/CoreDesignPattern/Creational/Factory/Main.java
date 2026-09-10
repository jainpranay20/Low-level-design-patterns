package CoreDesignPattern.Creational.Factory;

public class Main {
    interface Notification {
        void send(String to, String message);
        String getType();
    }

    enum NotificationType {
        EMAIL,
        SMS,
        PUSH
    }

    static class EmailNotification implements Notification {
        @Override
        public void send(String to, String message) {
            System.out.println("[EMAIL] To: " + to + " | " + message);
        }

        @Override
        public String getType() {
            return "EMAIL";
        }
    }

    static class SMSNotification implements Notification {
        @Override
        public void send(String to, String message) {
            System.out.println("[SMS] To: " + to + " | " + message);
        }

        @Override
        public String getType() {
            return "SMS";
        }
    }

    static class PushNotification implements Notification {
        @Override
        public void send(String to, String message) {
            System.out.println("[PUSH] To: " + to + " | " + message);
        }

        @Override
        public String getType() {
            return "PUSH";
        }
    }

    static class NotificationFactory {
        public static Notification create(NotificationType type) {
            return switch (type) {
                case EMAIL -> new EmailNotification();
                case SMS -> new SMSNotification();
                case PUSH -> new PushNotification();
            };
        }
    }

    public static void main(String[] args) {
        Notification n1 = NotificationFactory.create(NotificationType.EMAIL);
        n1.send("user@example.com", "Your order shipped!");

        Notification n2 = NotificationFactory.create(NotificationType.SMS);
        n2.send("+1-555-0100", "OTP: 482910");

        Notification n3 = NotificationFactory.create(NotificationType.PUSH);
        n3.send("device-token-xyz", "New message from Alice");
    }
}
