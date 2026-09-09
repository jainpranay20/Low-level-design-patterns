package CoreDesignPattern.Behavioural.Strategy;

// Crypto
public class CryptoStrategy implements PaymentStrategy {
    private final String walletAddress;

    public CryptoStrategy(String walletAddress) {
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
