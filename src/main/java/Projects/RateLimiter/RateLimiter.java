package RateLimiter;

import java.util.HashMap;
import java.util.Map;

class RateLimiter {

    private final int maxRequests;
    private final long windowSizeInSeconds;

    // client id , Client
    private final Map<String, Client> clients;
    private final TimeProvider timeProvider;

    RateLimiter(int maxRequests, long windowSizeInSeconds) {
        this.maxRequests = maxRequests;
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.clients = new HashMap<>();
        this.timeProvider = new TimeProvider();
    }
    boolean allow(Request request) {
        String clientId = request.getClientId();
        long currentTime = request.getTimestamp();

        Client client = clients.get(clientId);

        if (client == null) {
            client = new Client(currentTime);
            clients.put(clientId, client);
        }

        long windowStart = client.getWindowStartTime();

        // Window expired → reset
        if (currentTime - windowStart >= windowSizeInSeconds) {
            client.resetWindow(currentTime);
        }

        // Check limit
        if (client.getRequestCount() < maxRequests) {
            client.incrementRequestCount();
            return true;
        }

        return false;
    }
}
