package CoreDesignPattern.Creational.Singleton;

public class Logger {
    private static Logger instance;

    private Logger() {
        System.out.println("Logger object created...");
    }

    public static Logger getInstance() {

        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Application Started");
        Logger logger2 = Logger.getInstance();
        logger2.log("Loading Users");

        System.out.println("logger1 HashCode : " + logger1.hashCode());
        System.out.println("logger2 HashCode : " + logger2.hashCode());

        System.out.println("logger1 == logger2 : " + (logger1 == logger2));
    }
}