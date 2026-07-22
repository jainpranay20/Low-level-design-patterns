package Projects.PizzaBillingSystem;

// Main demo
public class Main {
    public static void main(String[] args) {
        // Customer orders: Medium Margherita + ExtraCheese + Mushroom + Jalapeno
        Pizza pizza = new Margherita();
        pizza = new ExtraCheese(pizza);    // +50
        pizza = new Mushroom(pizza);       // +40
        pizza = new Jalapeno(pizza);       // +30
        pizza = new SizeDecorator(pizza, Size.MEDIUM); // ×1.5

        // Cost: (200+50+40+30) × 1.5 = 480
        new BillGenerator().printBill(pizza);

        // Output:
        // Item : Medium Margherita + Extra Cheese + Mushroom + Jalapeno
        // Subtotal : ₹480.00
        // GST (5%) : ₹24.00
        // TOTAL    : ₹504.00

        /***
         *
         * Pizza pizza =
         *     new SizeDecorator(
         *         new Jalapeno(
         *             new Mushroom(
         *                 new ExtraCheese(
         *                     new Margherita()
         *                 )
         *             )
         *         ),
         *         Size.MEDIUM
         *     );
         *
         * new BillGenerator().printBill(pizza);
         */
    }
}
