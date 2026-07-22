package RateLimiter;

public class TimeProvider {

    long now(){
        // gives the value in seconds
        return System.currentTimeMillis()/1000;
    }
}
