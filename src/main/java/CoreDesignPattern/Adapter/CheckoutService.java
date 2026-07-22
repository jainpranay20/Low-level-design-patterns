package CoreDesignPattern.Adapter;

public class CheckoutService {
    private final PaymentProcessor processor; // Target interface only

    public CheckoutService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void checkout(String userId, double totalRupees) {
        PaymentRequest req = new PaymentRequest(userId, totalRupees, "INR");
        boolean ok = processor.processPayment(req);
        System.out.println(ok ? " Payment succeeded" : " Payment failed");
    }
}

    // ── Wire it together (main / DI config) ─────────────────────────────
//    CheckoutService checkout = new CheckoutService(
//            new UPIPaymentAdapter(new UPIGateway())   // swap any PaymentProcessor here
//    );
//checkout.checkout("manideep", 499.0);
// Output: [UPI-v2] routing payment
//         UPI: ₹499.00 → manideep@upi
//          Payment succeeded