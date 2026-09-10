package CoreDesignPattern.Structural.Adapter;

public class Main {
    interface PaymentProcessor {
        boolean processPayment(PaymentRequest request);
    }

    record PaymentRequest(String recipientId, double amount, String currency) {
    }

    static class CheckoutService {
        private final PaymentProcessor processor;

        CheckoutService(PaymentProcessor processor) {
            this.processor = processor;
        }

        public void checkout(String userId, double totalRupees) {
            PaymentRequest req = new PaymentRequest(userId, totalRupees, "INR");
            boolean ok = processor.processPayment(req);
            System.out.println(ok ? " Payment succeeded" : " Payment failed");
        }
    }

    static class UPIGateway {
        public boolean makePayment(String upiId, double amountInPaise) {
            System.out.printf("UPI: ₹%.2f → %s%n", amountInPaise / 100.0, upiId);
            return true;
        }

        public String getGatewayName() {
            return "UPI-v2";
        }
    }

    static class UPIPaymentAdapter implements PaymentProcessor {
        private final UPIGateway upiGateway;

        UPIPaymentAdapter(UPIGateway upiGateway) {
            this.upiGateway = upiGateway;
        }

        @Override
        public boolean processPayment(PaymentRequest request) {
            String upiId = request.recipientId() + "@upi";
            double amountPaise = request.amount() * 100;

            System.out.printf("[%s] routing payment%n", upiGateway.getGatewayName());
            return upiGateway.makePayment(upiId, amountPaise);
        }
    }

    public static void main(String[] args) {
        UPIGateway gateway = new UPIGateway();
        PaymentProcessor processor = new UPIPaymentAdapter(gateway);
        CheckoutService checkout = new CheckoutService(processor);
        checkout.checkout("pranay", 499);
    }
}
