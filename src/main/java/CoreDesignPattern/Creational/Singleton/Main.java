package CoreDesignPattern.Creational.Singleton;

public class Main {
    static class Logger {
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
    }

    static class ThreadSafeSingletonLogger {
        private static volatile ThreadSafeSingletonLogger instance;

        private ThreadSafeSingletonLogger() {
            System.out.println("Thread-safe logger object created...");
        }

        public static ThreadSafeSingletonLogger getInstance() {
            if (instance == null) {
                synchronized (ThreadSafeSingletonLogger.class) {
                    if (instance == null) {
                        instance = new ThreadSafeSingletonLogger();
                    }
                }
            }
            return instance;
        }

        public void log(String message) {
            System.out.println("[THREAD SAFE LOG] " + message);
        }
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Application Started");

        Logger logger2 = Logger.getInstance();
        logger2.log("Loading Users");

        System.out.println("logger1 HashCode : " + logger1.hashCode());
        System.out.println("logger2 HashCode : " + logger2.hashCode());
        System.out.println("logger1 == logger2 : " + (logger1 == logger2));

        System.out.println();

        ThreadSafeSingletonLogger safeLogger1 = ThreadSafeSingletonLogger.getInstance();
        safeLogger1.log("Application Started");

        ThreadSafeSingletonLogger safeLogger2 = ThreadSafeSingletonLogger.getInstance();
        safeLogger2.log("Loading Users");

        System.out.println("safeLogger1 HashCode : " + safeLogger1.hashCode());
        System.out.println("safeLogger2 HashCode : " + safeLogger2.hashCode());
        System.out.println("safeLogger1 == safeLogger2 : " + (safeLogger1 == safeLogger2));
    }
}
