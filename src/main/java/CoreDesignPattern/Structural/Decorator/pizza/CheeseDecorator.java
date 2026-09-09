package CoreDesignPattern.Structural.Decorator.pizza;

class CheeseDecorator extends PizzaDecorator {

    CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    public int cost() {
        return pizza.cost() + 40;
    }
}
