package CoreDesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

// Observer
interface Subscriber {
    void update(String newVideoUploaded);
}

// Subject
interface Channel {
    void subscribe(Subscriber s);
    void unsubscribe(Subscriber s);
    void notifySubscribers();
}

// Concrete Subject
class YouTubeChannel implements Channel {

    private List<Subscriber> subscribers = new ArrayList<>();
    private String latestVideo;

    @Override
    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    @Override
    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber s : subscribers) {
            s.update(latestVideo);
        }
    }

    public void uploadVideo(String title) {
        latestVideo = title;
        notifySubscribers();
    }


}
public class Main {
    public static void main(String[] args) {

        YouTubeChannel channel = new YouTubeChannel();

        channel.subscribe(new User("Pranay"));
        channel.subscribe(new User("Rahul"));
        channel.subscribe(new User("Amit"));

        channel.uploadVideo("Observer Design Pattern");
    }
}
