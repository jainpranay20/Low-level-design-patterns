package Projects.PizzaBillingSystem;

// Concrete base pizzas
public class Margherita extends Pizza {
    @Override
    public String getDescription() {
        return "Margherita";
    }

    @Override
    public double getCost() {
        return 200.0;
    }
}
