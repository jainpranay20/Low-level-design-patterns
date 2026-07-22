package CoreDesignPattern.Decorator.coffee;

// ── SugarDecorator.java ───────────────────────────────────────────────────
public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.20;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }
}
