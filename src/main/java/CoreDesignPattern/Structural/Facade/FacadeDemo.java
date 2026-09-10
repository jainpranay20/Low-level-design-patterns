package CoreDesignPattern.Structural.Facade;

public class FacadeDemo {
    static class Amplifier {
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

    static class DVDPlayer {
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

    static class Projector {
        public void on() {
            System.out.println("Projector ON");
        }

        public void off() {
            System.out.println("Projector OFF");
        }

        public void setInput(String src) {
            System.out.println("Projector input: " + src);
        }
    }

    static class Lights {
        public void dim(int pct) {
            System.out.println("Lights dimmed to " + pct + "%");
        }

        public void on() {
            System.out.println("Lights ON (100%)");
        }
    }

    static class HomeTheaterFacade {
        private final Projector projector;
        private final Amplifier amplifier;
        private final DVDPlayer dvdPlayer;
        private final Lights lights;

        HomeTheaterFacade(Projector projector, Amplifier amplifier, DVDPlayer dvdPlayer, Lights lights) {
            this.projector = projector;
            this.amplifier = amplifier;
            this.dvdPlayer = dvdPlayer;
            this.lights = lights;
        }

        public void watchMovie(String movie) {
            System.out.println("--- Setting up movie night ---");
            lights.dim(10);
            projector.on();
            projector.setInput("DVD");
            amplifier.on();
            amplifier.setSurroundSound();
            amplifier.setVolume(5);
            dvdPlayer.on();
            dvdPlayer.play(movie);
        }

        public void endMovie() {
            System.out.println("--- Shutting down ---");
            dvdPlayer.stop();
            dvdPlayer.off();
            amplifier.off();
            projector.off();
            lights.on();
        }
    }

    public static void main(String[] args) {
        Projector projector = new Projector();
        Amplifier amplifier = new Amplifier();
        DVDPlayer dvdPlayer = new DVDPlayer();
        Lights lights = new Lights();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, amplifier, dvdPlayer, lights);

        homeTheater.watchMovie("Inception");
        System.out.println("\nEnjoy the Movie...\n");
        homeTheater.endMovie();
    }
}
