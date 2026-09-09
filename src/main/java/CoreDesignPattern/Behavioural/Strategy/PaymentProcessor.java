package CoreDesignPattern.Behavioural.Strategy;

// Context
public class PaymentProcessor {
    private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(double amount) {
        System.out.println("Processing via: " + strategy.methodName());
        boolean ok = strategy.pay(amount);
        System.out.println(ok ? "Payment successful." : "Payment failed.");
    }
}
