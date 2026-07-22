package Projects.PizzaBillingSystem;

// Abstract decorator — wraps a Pizza
public abstract class ToppingDecorator extends Pizza {
    protected final Pizza pizza;
    public ToppingDecorator(Pizza pizza) { this.pizza = pizza; }
}

