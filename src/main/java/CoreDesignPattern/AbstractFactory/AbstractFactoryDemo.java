package CoreDesignPattern.AbstractFactory;

public class AbstractFactoryDemo {

    // ===== Product A =====
    interface Chair {
        void sitOn();
    }

    // ===== Product B =====
    interface Sofa {
        void lieOn();
    }

    // ===== Modern Chair =====
    static class ModernChair implements Chair {

        @Override
        public void sitOn() {
            System.out.println("Sitting on Modern Chair");
        }
    }

    // ===== Victorian Chair =====
    static class VictorianChair implements Chair {

        @Override
        public void sitOn() {
            System.out.println("Sitting on Victorian Chair");
        }
    }

    // ===== Modern Sofa =====
    static class ModernSofa implements Sofa {

        @Override
        public void lieOn() {
            System.out.println("Lying on Modern Sofa");
        }
    }

    // ===== Victorian Sofa =====
    static class VictorianSofa implements Sofa {

        @Override
        public void lieOn() {
            System.out.println("Lying on Victorian Sofa");
        }
    }

    // ===== Abstract Factory =====
    interface FurnitureFactory {

        Chair createChair();

        Sofa createSofa();
    }

    // ===== Modern Factory =====
    static class ModernFurnitureFactory implements FurnitureFactory {

        @Override
        public Chair createChair() {
            return new ModernChair();
        }

        @Override
        public Sofa createSofa() {
            return new ModernSofa();
        }
    }

    // ===== Victorian Factory =====
    static class VictorianFurnitureFactory implements FurnitureFactory {

        @Override
        public Chair createChair() {
            return new VictorianChair();
        }

        @Override
        public Sofa createSofa() {
            return new VictorianSofa();
        }
    }

    // ===== Client =====
    public static void main(String[] args) {

        // Choose a factory
        FurnitureFactory factory = new ModernFurnitureFactory();

        Chair chair = factory.createChair();
        Sofa sofa = factory.createSofa();

        chair.sitOn();
        sofa.lieOn();

        System.out.println();

        // Switch to another family
        factory = new VictorianFurnitureFactory();

        chair = factory.createChair();
        sofa = factory.createSofa();

        chair.sitOn();
        sofa.lieOn();
    }
}