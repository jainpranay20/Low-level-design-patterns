package CoreDesignPattern.Structural.Decorator.coffee;

public class Main {
    public static void main(String[] args) {

        // Plain espresso
        Coffee order = new SimpleCoffee();
        order = new MilkDecorator(order);
        order = new SugarDecorator(order);
        order = new WhipDecorator(order);
        print(order);

        // Double milk — just wrap twice, no special code needed
        Coffee special = new WhipDecorator(new MilkDecorator(new MilkDecorator(new SimpleCoffee())));
        print(special); // Simple Coffee, Milk, Milk, Whip = $2.70
    }

    static void print(Coffee c) {
        System.out.printf("%s = $%.2f%n", c.getDescription(), c.getCost());
    }
}