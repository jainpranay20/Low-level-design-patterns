package Projects.PizzaBillingSystem;

public class VeggieSupreme extends Pizza {
    @Override
    public String getDescription() {
        return "Veggie Supreme";
    }

    @Override
    public double getCost() {
        return 300.0;
    }
}
