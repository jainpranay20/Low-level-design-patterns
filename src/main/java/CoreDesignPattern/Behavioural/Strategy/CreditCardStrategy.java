package CoreDesignPattern.Behavioural.Strategy;

// Credit Card
public class CreditCardStrategy implements PaymentStrategy {
    private final String cardNumber;
    private final String cvv;

    public CreditCardStrategy(String cardNumber, String cvv) {
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
