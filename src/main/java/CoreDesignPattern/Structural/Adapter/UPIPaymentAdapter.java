package CoreDesignPattern.Structural.Adapter;

public class UPIPaymentAdapter implements PaymentProcessor {

    private final UPIGateway upiGateway; // composition — wrap, don't extend

    public UPIPaymentAdapter(UPIGateway upiGateway) {
        this.upiGateway = upiGateway;
    }

    @Override
    public boolean processPayment(PaymentRequest request) {
        // ── TRANSLATION LAYER ──────────────────────────────────────
        String upiId      = request.recipientId() + "@upi";     // build UPI ID
        double amountPaise = request.amount() * 100;             // rupees → paise
        // ──────────────────────────────────────────────────────────

        System.out.printf("[%s] routing payment%n", upiGateway.getGatewayName());
        return upiGateway.makePayment(upiId, amountPaise); // delegate to Adaptee
    }
}