package CoreDesignPattern.Decorator.coffee;

public abstract class CoffeeDecorator implements Coffee {

    protected final Coffee coffee;   // the wrapped component

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    // Default: pure delegation — subclasses override to add behavior
    @Override
    public double getCost() { return coffee.getCost(); }

    @Override
    public String getDescription() { return coffee.getDescription(); }
}

