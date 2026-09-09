package CoreDesignPattern.Behavioural.Strategy;

// PayPal
public class PayPalStrategy implements PaymentStrategy {
    private final String email;

    public PayPalStrategy(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(double amount) {
        System.out.printf("[PayPal] Debited $%.2f from %s%n", amount, email);
        return true;
    }

    @Override
    public String methodName() {
        return "PayPal";
    }
}
