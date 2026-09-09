package CoreDesignPattern.Structural.Decorator.coffee;

// ── MilkDecorator.java ────────────────────────────────────────────────────
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}
