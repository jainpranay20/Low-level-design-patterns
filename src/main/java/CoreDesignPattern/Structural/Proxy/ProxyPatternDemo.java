package CoreDesignPattern.Structural.Proxy;

public class ProxyPatternDemo {

    // Subject Interface
    interface FileAccess {
        void deleteFile(String fileName);
    }

    // Real Subject
    static class RealFileAccess implements FileAccess {

        @Override
        public void deleteFile(String fileName) {
            System.out.println("Deleting file: " + fileName);
        }
    }

    // Proxy
    static class FileAccessProxy implements FileAccess {

        private String role;
        private RealFileAccess realFileAccess;

        public FileAccessProxy(String role) {
            this.role = role;
            this.realFileAccess = new RealFileAccess();
        }

        @Override
        public void deleteFile(String fileName) {

            System.out.println("\nRequest received to delete: " + fileName);

            // Access Control
            if ("ADMIN".equalsIgnoreCase(role)) {
                System.out.println("Access Granted.");
                realFileAccess.deleteFile(fileName);
            } else {
                System.out.println("Access Denied! Only ADMIN can delete files.");
            }
        }
    }

    // Client
    public static void main(String[] args) {

        FileAccess user = new FileAccessProxy("USER");
        FileAccess admin = new FileAccessProxy("ADMIN");

        System.out.println("===== USER =====");
        user.deleteFile("EmployeeDetails.pdf");

        System.out.println("\n===== ADMIN =====");
        admin.deleteFile("EmployeeDetails.pdf");
    }
}