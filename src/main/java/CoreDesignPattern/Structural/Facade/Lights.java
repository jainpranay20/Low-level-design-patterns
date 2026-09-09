package CoreDesignPattern.Structural.Facade;

public class Lights {
    public void dim(int pct) {
        System.out.println("Lights dimmed to " + pct + "%");
    }

    public void on() {
        System.out.println("Lights ON (100%)");
    }
}
