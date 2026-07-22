package Projects.PizzaBillingSystem;

public class Jalapeno extends ToppingDecorator {
    public Jalapeno(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Jalapeno";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 30.0;
    }
}
