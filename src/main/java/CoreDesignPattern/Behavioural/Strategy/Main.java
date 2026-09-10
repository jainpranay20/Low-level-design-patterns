package CoreDesignPattern.Behavioural.Strategy;

public class Main {
    interface PaymentStrategy {
        boolean pay(double amount);
        String methodName();
    }

    static class CreditCardStrategy implements PaymentStrategy {
        private final String cardNumber;
        private final String cvv;

        CreditCardStrategy(String cardNumber, String cvv) {
            this.cardNumber = cardNumber;
            this.cvv = cvv;
        }

        @Override
        public boolean pay(double amount) {
            System.out.printf("[CreditCard] Charged $%.2f to card ending %s%n",
                    amount, cardNumber.substring(cardNumber.length() - 4));
            return true;
        }

        @Override
        public String methodName() {
            return "Credit Card";
        }
    }

    static class PayPalStrategy implements PaymentStrategy {
        private final String email;

        PayPalStrategy(String email) {
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

    static class CryptoStrategy implements PaymentStrategy {
        private final String walletAddress;

        CryptoStrategy(String walletAddress) {
            this.walletAddress = walletAddress;
        }

        @Override
        public boolean pay(double amount) {
            System.out.printf("[Crypto] Sent $%.2f worth of BTC to %s%n",
                    amount, walletAddress.substring(0, 8) + "...");
            return true;
        }

        @Override
        public String methodName() {
            return "Crypto";
        }
    }

    static class PaymentProcessor {
        private PaymentStrategy strategy;

        PaymentProcessor(PaymentStrategy strategy) {
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

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor(new CreditCardStrategy("4111111111111234", "123"));
        processor.checkout(99.99);

        processor.setStrategy(new PayPalStrategy("user@example.com"));
        processor.checkout(49.50);

        processor.setStrategy(new CryptoStrategy("bc1qar0srrr7xfkvy5l643lydnw9re59gtzzwf5mdq"));
        processor.checkout(200.00);
    }
}
