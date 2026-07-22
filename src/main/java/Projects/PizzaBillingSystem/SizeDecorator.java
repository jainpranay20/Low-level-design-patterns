package Projects.PizzaBillingSystem;

public class SizeDecorator extends Pizza {
    private final Pizza pizza;
    private final Size size;

    public SizeDecorator(Pizza pizza, Size size) {
        this.pizza = pizza;
        this.size = size;
    }

    @Override
    public String getDescription() {
        return size.label + " " + pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost() * size.multiplier;
    }
}
