package RateLimiter;

public class RateLimiterMain {
    public static void main(String[] args) throws InterruptedException {

        RateLimiter rateLimiter = new RateLimiter(5, 10);

        String clientId = "client-1";

        for (int i = 1; i <= 6; i++) {
            long time = System.currentTimeMillis() / 1000;
            Request request = new Request(clientId, time);
            System.out.println("Request " + i + " allowed: " + rateLimiter.allow(request));
        }

        // Wait for window reset
        Thread.sleep(11000);

        Request newRequest = new Request(clientId, System.currentTimeMillis() / 1000);
        System.out.println("After window reset allowed: " + rateLimiter.allow(newRequest));
    }
}
