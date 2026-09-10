package CoreDesignPattern.Structural.Proxy;

public class ProxyPatternDemo {
    interface FileAccess {
        void deleteFile(String fileName);
    }

    static class RealFileAccess implements FileAccess {
        @Override
        public void deleteFile(String fileName) {
            System.out.println("Deleting file: " + fileName);
        }
    }

    static class FileAccessProxy implements FileAccess {
        private final String role;
        private final RealFileAccess realFileAccess;

        FileAccessProxy(String role) {
            this.role = role;
            this.realFileAccess = new RealFileAccess();
        }

        @Override
        public void deleteFile(String fileName) {
            System.out.println("\nRequest received to delete: " + fileName);

            if ("ADMIN".equalsIgnoreCase(role)) {
                System.out.println("Access Granted.");
                realFileAccess.deleteFile(fileName);
            } else {
                System.out.println("Access Denied! Only ADMIN can delete files.");
            }
        }
    }

    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private final String fileName;

        RealImage(String fileName) {
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

    static class ProxyImage implements Image {
        private final String fileName;
        private RealImage realImage;

        ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void display() {
            if (realImage == null) {
                System.out.println("Cache Miss! Creating RealImage...");
                realImage = new RealImage(fileName);
            } else {
                System.out.println("Cache Hit! Using cached image...");
            }

            realImage.display();
        }
    }

    public static void main(String[] args) {
        FileAccess user = new FileAccessProxy("USER");
        FileAccess admin = new FileAccessProxy("ADMIN");

        System.out.println("===== USER =====");
        user.deleteFile("EmployeeDetails.pdf");

        System.out.println("\n===== ADMIN =====");
        admin.deleteFile("EmployeeDetails.pdf");

        System.out.println("\n===== IMAGE PROXY =====");
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
