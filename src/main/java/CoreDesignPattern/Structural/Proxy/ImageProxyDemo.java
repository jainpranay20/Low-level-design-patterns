package CoreDesignPattern.Structural.Proxy;

public class ImageProxyDemo {

    // Subject
    interface Image {
        void display();
    }

    // Real Subject
    static class RealImage implements Image {

        private String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromDisk();
        }

        private void loadFromDisk() {
            System.out.println("Loading image from disk: " + fileName);
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + fileName);
        }
    }

    // Proxy
    static class ProxyImage implements Image {

        private String fileName;
        private RealImage realImage; // Cached object

        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void display() {

            // Load image only once
            if (realImage == null) {
                System.out.println("Cache Miss! Creating RealImage...");
                realImage = new RealImage(fileName);
            } else {
                System.out.println("Cache Hit! Using cached image...");
            }

            realImage.display();
        }
    }

    // Client
    public static void main(String[] args) {

        Image image = new ProxyImage("nature.jpg");

        System.out.println("Image object created.\n");

        System.out.println("First Request:");
        image.display();

        System.out.println("\nSecond Request:");
        image.display();

        System.out.println("\nThird Request:");
        image.display();
    }
}