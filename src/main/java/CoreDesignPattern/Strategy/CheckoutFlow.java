package CoreDesignPattern.Strategy;

// Client
public class CheckoutFlow {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor(new CreditCardStrategy("4111111111111234", "123"));
        processor.checkout(99.99);

        // User switches payment method at checkout
        processor.setStrategy(new PayPalStrategy("user@example.com"));
        processor.checkout(49.50);

        processor.setStrategy(new CryptoStrategy("bc1qar0srrr7xfkvy5l643lydnw9re59gtzzwf5mdq"));
        processor.checkout(200.00);
    }
}
