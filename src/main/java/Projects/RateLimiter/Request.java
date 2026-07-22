package RateLimiter;

public class Request {

    private final String clientId;

    private final long timestamp;

    public Request(String clientId, long timestamp) {
        this.clientId = clientId;
        this.timestamp = timestamp;
    }

    String getClientId(){
        return clientId;
    }

    long getTimestamp(){
        return timestamp;
    }
}
