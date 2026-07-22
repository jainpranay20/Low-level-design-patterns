package CoreDesignPattern.Facade;

public class HomeTheaterFacade {

    private final Projector projector;
    private final Amplifier amplifier;
    private final DVDPlayer dvdPlayer;
    private final Lights    lights;

    public HomeTheaterFacade(Projector p, Amplifier a,
                              DVDPlayer d, Lights l) {
        this.projector = p;
        this.amplifier = a;
        this.dvdPlayer = d;
        this.lights    = l;
    }

    /** One method hides 7 subsystem steps. */
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
