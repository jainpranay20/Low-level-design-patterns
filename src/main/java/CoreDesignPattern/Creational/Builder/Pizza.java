package CoreDesignPattern.Creational.Builder;

public class Pizza {

    private String size;
    private boolean cheese;
    private boolean mushrooms;
    private boolean olives;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.mushrooms = builder.mushrooms;
        this.olives = builder.olives;
    }

    @Override
    public String toString() {
        return "Pizza [size=" + size +
                ", cheese=" + cheese +
                ", mushrooms=" + mushrooms +
                ", olives=" + olives + "]";
    }

    // Builder Class
    public static class Builder {

        private String size; // Required
        private boolean cheese;
        private boolean mushrooms;
        private boolean olives;

        // this refers to the current Builder object
        public Builder(String size) {
            this.size = size;
        }

        public Builder cheese() {
            this.cheese = true;
            return this;
        }

        public Builder mushrooms() {
            this.mushrooms = true;
            return this;
        }

        // this refers to the current Builder object
        public Builder olives() {
            this.olives = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    // Main method
    public static void main(String[] args) {

        Pizza pizza = new Pizza.Builder("Large")
                .cheese()
                .mushrooms()
                .olives()
                .build();

        System.out.println(pizza);
    }
}