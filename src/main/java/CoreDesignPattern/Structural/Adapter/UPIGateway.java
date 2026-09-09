package CoreDesignPattern.Structural.Adapter;

/**
 * Third-party UPI SDK we cannot modify.
 * Incompatible with PaymentProcessor — different method name + parameters.
 */
public class UPIGateway {
    public boolean makePayment(String upiId, double amountInPaise) {
        System.out.printf("UPI: ₹%.2f → %s%n", amountInPaise / 100.0, upiId);
        return true;
    }
    public String getGatewayName() {
        return "UPI-v2";
    }
}