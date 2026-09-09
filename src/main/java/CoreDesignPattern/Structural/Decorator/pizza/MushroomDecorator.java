package CoreDesignPattern.Structural.Decorator.pizza;

class MushroomDecorator extends PizzaDecorator {

    MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Mushroom";
    }

    public int cost() {
        return pizza.cost() + 50;
    }
}
