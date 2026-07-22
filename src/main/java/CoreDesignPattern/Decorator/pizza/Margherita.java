package CoreDesignPattern.Decorator.pizza;

class Margherita implements Pizza {

    public String getDescription() {
        return "Margherita Pizza";
    }

    public int cost() {
        return 200;
    }
}


