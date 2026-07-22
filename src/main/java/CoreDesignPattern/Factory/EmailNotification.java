package CoreDesignPattern.Factory;

// ── Concrete Products ──────────────────────────────────────────────────────
public class EmailNotification implements Notification {
    @Override
    public void send(String to, String message) {
        System.out.println("[EMAIL] To: " + to + " | " + message);
    }

    @Override
    public String getType() {
        return "EMAIL";
    }
}
