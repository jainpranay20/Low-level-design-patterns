package CoreDesignPattern.Structural.Facade;

public class Amplifier {
    public void on() {
        System.out.println("Amplifier ON");
    }

    public void off() {
        System.out.println("Amplifier OFF");
    }

    public void setVolume(int level) {
        System.out.println("Volume: " + level);
    }

    public void setSurroundSound() {
        System.out.println("Surround sound ON");
    }
}
