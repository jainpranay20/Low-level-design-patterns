package CoreDesignPattern.Factory;

// ── Product interface ──────────────────────────────────────────────────────
public interface Notification {
    void send(String to, String message);
    String getType();
}

