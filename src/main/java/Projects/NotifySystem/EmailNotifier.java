package Projects.NotifySystem;

import CoreDesignPattern.Observer.User;

// Concrete observers
public class EmailNotifier implements Observer {
    private final String email;
    public EmailNotifier(String email) { this.email = email; }

    @Override
    public void update(Product product) {
        System.out.println("[EMAIL] Sending to " + email +
            ": " + product.getName() + " is back in stock!");
        // emailService.send(email, subject, body);
    }
}

// Factory — creates notifier by channel type
public class NotifierFactory {
    public static Observer create(NotificationChannel channel, User user) {
        return switch (channel) {
            case EMAIL -> new EmailNotifier(user.getEmail());
            case SMS   -> new SMSNotifier(user.getPhone());
            case PUSH  -> new PushNotifier(user.getDeviceToken());
        };
    }
}