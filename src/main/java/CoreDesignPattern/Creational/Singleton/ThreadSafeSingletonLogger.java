package CoreDesignPattern.Creational.Singleton;

public class ThreadSafeSingletonLogger {
    private static volatile ThreadSafeSingletonLogger instance;

    private ThreadSafeSingletonLogger() {
        System.out.println("Logger object created...");
    }

    public static ThreadSafeSingletonLogger getInstance() {

        if (instance == null) {
            synchronized (ThreadSafeSingletonLogger.class) {
                if(instance == null){
                    instance = new ThreadSafeSingletonLogger();
                }
            }
        }

        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    public static void main(String[] args) {
        ThreadSafeSingletonLogger logger1 = ThreadSafeSingletonLogger.getInstance();
        logger1.log("Application Started");
        ThreadSafeSingletonLogger logger2 = ThreadSafeSingletonLogger.getInstance();
        logger2.log("Loading Users");

        System.out.println("logger1 HashCode : " + logger1.hashCode());
        System.out.println("logger2 HashCode : " + logger2.hashCode());

        System.out.println("logger1 == logger2 : " + (logger1 == logger2));
    }

}
