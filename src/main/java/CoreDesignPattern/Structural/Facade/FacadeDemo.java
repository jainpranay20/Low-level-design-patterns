package CoreDesignPattern.Structural.Facade;

public class FacadeDemo {

    public static void main(String[] args) {

        // Create subsystem objects
        Projector projector = new Projector();
        Amplifier amplifier = new Amplifier();
        DVDPlayer dvdPlayer = new DVDPlayer();
        Lights lights = new Lights();

        // Create Facade
        HomeTheaterFacade homeTheater =
                new HomeTheaterFacade(
                        projector,
                        amplifier,
                        dvdPlayer,
                        lights
                );

        // Client uses only the Facade
        homeTheater.watchMovie("Inception");

        System.out.println("\nEnjoy the Movie...\n");

        homeTheater.endMovie();
    }
}