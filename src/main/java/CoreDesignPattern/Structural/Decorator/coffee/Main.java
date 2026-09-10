package CoreDesignPattern.Structural.Decorator.coffee;

public class Main {
    interface Coffee {
        double getCost();
        String getDescription();
    }

    abstract static class CoffeeDecorator implements Coffee {
        protected final Coffee coffee;

        CoffeeDecorator(Coffee coffee) {
            this.coffee = coffee;
        }

        @Override
        public double getCost() {
            return coffee.getCost();
        }

        @Override
        public String getDescription() {
            return coffee.getDescription();
        }
    }

    static class SimpleCoffee implements Coffee {
        @Override
        public double getCost() {
            return 1.00;
        }

        @Override
        public String getDescription() {
            return "Simple Coffee";
        }
    }

    static class MilkDecorator extends CoffeeDecorator {
        MilkDecorator(Coffee coffee) {
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

    static class SugarDecorator extends CoffeeDecorator {
        SugarDecorator(Coffee coffee) {
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

    static class WhipDecorator extends CoffeeDecorator {
        WhipDecorator(Coffee coffee) {
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

    static void print(Coffee c) {
        System.out.printf("%s = $%.2f%n", c.getDescription(), c.getCost());
    }

    public static void main(String[] args) {
        Coffee order = new SimpleCoffee();
        order = new MilkDecorator(order);
        order = new SugarDecorator(order);
        order = new WhipDecorator(order);
        print(order);

        Coffee special = new WhipDecorator(new MilkDecorator(new MilkDecorator(new SimpleCoffee())));
        print(special);
    }
}
