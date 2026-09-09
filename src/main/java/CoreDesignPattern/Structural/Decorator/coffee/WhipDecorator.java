package CoreDesignPattern.Structural.Decorator.coffee;

// ── WhipDecorator.java ────────────────────────────────────────────────────
public class WhipDecorator extends CoffeeDecorator {
    public WhipDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.70;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whip";
    }
}
