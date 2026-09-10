package CoreDesignPattern.Structural.Decorator.pizza;

public class Main {
    interface Pizza {
        String getDescription();
        int cost();
    }

    abstract static class PizzaDecorator implements Pizza {
        protected Pizza pizza;

        PizzaDecorator(Pizza pizza) {
            this.pizza = pizza;
        }
    }

    static class Margherita implements Pizza {
        @Override
        public String getDescription() {
            return "Margherita Pizza";
        }

        @Override
        public int cost() {
            return 200;
        }
    }

    static class CheeseDecorator extends PizzaDecorator {
        CheeseDecorator(Pizza pizza) {
            super(pizza);
        }

        @Override
        public String getDescription() {
            return pizza.getDescription() + ", Cheese";
        }

        @Override
        public int cost() {
            return pizza.cost() + 40;
        }
    }

    static class MushroomDecorator extends PizzaDecorator {
        MushroomDecorator(Pizza pizza) {
            super(pizza);
        }

        @Override
        public String getDescription() {
            return pizza.getDescription() + ", Mushroom";
        }

        @Override
        public int cost() {
            return pizza.cost() + 50;
        }
    }

    public static void main(String[] args) {
        Pizza pizza = new Margherita();

        pizza = new CheeseDecorator(pizza);
        pizza = new MushroomDecorator(pizza);

        System.out.println(pizza.getDescription());
        System.out.println(pizza.cost());
    }
}
