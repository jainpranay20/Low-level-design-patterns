package CoreDesignPattern.Structural.Facade;

public class DVDPlayer {
    public void on() {
        System.out.println("DVD Player ON");
    }

    public void off() {
        System.out.println("DVD Player OFF");
    }

    public void play(String movie) {
        System.out.println("Playing: " + movie);
    }

    public void stop() {
        System.out.println("DVD stopped");
    }
}
