package CoreDesignPattern.Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    interface Subscriber {
        void update(String newVideoUploaded);
    }

    interface Channel {
        void subscribe(Subscriber s);
        void unsubscribe(Subscriber s);
        void notifySubscribers();
    }

    static class YouTubeChannel implements Channel {
        private final List<Subscriber> subscribers = new ArrayList<>();
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

    static class User implements Subscriber {
        private final String name;

        User(String name) {
            this.name = name;
        }

        @Override
        public void update(String newVideoUploaded) {
            System.out.println(name + " received new video: " + newVideoUploaded);
        }
    }

    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        channel.subscribe(new User("Pranay"));
        channel.subscribe(new User("Rahul"));
        channel.subscribe(new User("Amit"));

        channel.uploadVideo("Observer Design Pattern");
    }
}
