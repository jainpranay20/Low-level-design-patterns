package CoreDesignPattern.Adapter;

// The interface CheckoutService works with.
// UPIGateway does NOT implement this — that's the problem Adapter solves.
public interface PaymentProcessor {
    boolean processPayment(PaymentRequest request);
}

