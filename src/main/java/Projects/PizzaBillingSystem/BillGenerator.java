package Projects.PizzaBillingSystem;

// Bill and BillGenerator
public class BillGenerator {
    private static final double TAX_RATE = 0.05;

    public void printBill(Pizza pizza) {
        double subtotal = pizza.getCost();
        double tax = subtotal * TAX_RATE;
        double total = subtotal + tax;

        System.out.println("================================");
        System.out.println("         PIZZA BILL");
        System.out.println("================================");
        System.out.println("Item : " + pizza.getDescription());
        System.out.printf("Subtotal : ₹%.2f%n", subtotal);
        System.out.printf("GST (5%%) : ₹%.2f%n", tax);
        System.out.println("--------------------------------");
        System.out.printf("TOTAL    : ₹%.2f%n", total);
        System.out.println("================================");
    }
}
