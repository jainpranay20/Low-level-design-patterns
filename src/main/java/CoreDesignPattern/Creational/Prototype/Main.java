package CoreDesignPattern.Creational.Prototype;

import java.util.HashMap;
import java.util.Map;

public class Main {

    abstract static class Shape implements Cloneable {
        private final String id;
        protected String type;

        protected Shape(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public abstract void draw();

        @Override
        public Shape clone() {
            try {
                return (Shape) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException("Unable to clone shape: " + id, e);
            }
        }
    }

    static class Circle extends Shape {
        private int radius;

        public Circle(String id, int radius) {
            super(id);
            this.radius = radius;
            this.type = "Circle";
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }

        @Override
        public void draw() {
            System.out.println("Drawing Circle [id=" + getId() + ", radius=" + radius + "]");
        }
    }

    static class Rectangle extends Shape {
        private int width;
        private int height;

        public Rectangle(String id, int width, int height) {
            super(id);
            this.width = width;
            this.height = height;
            this.type = "Rectangle";
        }

        public void resize(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw() {
            System.out.println("Drawing Rectangle [id=" + getId() + ", width=" + width + ", height=" + height + "]");
        }
    }

    static class ShapeCache {
        private static final Map<String, Shape> cache = new HashMap<>();

        static {
            cache.put("circle", new Circle("circle-prototype", 10));
            cache.put("rectangle", new Rectangle("rectangle-prototype", 5, 8));
        }

        public static Shape getShape(String type) {
            Shape prototype = cache.get(type);
            if (prototype == null) {
                throw new IllegalArgumentException("Shape type not found: " + type);
            }
            return prototype.clone();
        }
    }

    public static void main(String[] args) {
        Shape circle1 = ShapeCache.getShape("circle");
        Shape circle2 = ShapeCache.getShape("circle");

        System.out.println("Original circle clone:");
        circle1.draw();
        circle2.draw();

        ((Circle) circle2).setRadius(25);

        System.out.println("\nAfter modifying only circle2:");
        circle1.draw();
        circle2.draw();

        Shape rectangle1 = ShapeCache.getShape("rectangle");
        Shape rectangle2 = ShapeCache.getShape("rectangle");

        System.out.println("\nRectangle prototypes:");
        rectangle1.draw();
        rectangle2.draw();

        ((Rectangle) rectangle2).resize(12, 15);

        System.out.println("\nAfter modifying only rectangle2:");
        rectangle1.draw();
        rectangle2.draw();
    }
}
