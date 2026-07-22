package RateLimiter;

class Client {
    private long windowStartTime;
    private int requestCount;

    Client(long windowStartTime) {
        this.windowStartTime = windowStartTime;
        this.requestCount = 0;
    }

    long getWindowStartTime() {

        return windowStartTime;
    }

    void resetWindow(long newStartTime) {
        this.windowStartTime = newStartTime;
        this.requestCount = 0;
    }

    int getRequestCount() {
        return requestCount;
    }

    void incrementRequestCount() {
        requestCount++;
    }
}
