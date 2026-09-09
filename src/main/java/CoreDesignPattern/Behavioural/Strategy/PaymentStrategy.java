package CoreDesignPattern.Behavioural.Strategy;

public interface PaymentStrategy {
    boolean pay(double amount);
    String methodName();
}

