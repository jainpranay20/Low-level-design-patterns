package CoreDesignPattern.Adapter;

public class Main {

    public static void main(String[] args) {


        UPIGateway gateway = new UPIGateway();
        PaymentProcessor processor = new UPIPaymentAdapter(gateway);
        CheckoutService checkout = new CheckoutService(processor);
        checkout.checkout("pranay", 499);
    }
}