package CoreDesignPattern.Structural.Adapter;

public record PaymentRequest(String recipientId, double amount, String currency) {

    // record means it has all the methods
    // getter
    // setter
    // equals
    // hashcode
}