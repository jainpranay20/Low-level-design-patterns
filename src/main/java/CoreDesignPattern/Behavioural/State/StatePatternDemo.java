package CoreDesignPattern.Behavioural.State;

// ================= State Interface =================

interface State {
    void play(MediaPlayer player);
    void pause(MediaPlayer player);
    void stop(MediaPlayer player);
}

// ================= Concrete States =================

class StoppedState implements State {

    @Override
    public void play(MediaPlayer player) {
        System.out.println("Starting music...");
        player.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Cannot pause. Music is already stopped.");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Music is already stopped.");
    }
}

class PlayingState implements State {

    @Override
    public void play(MediaPlayer player) {
        System.out.println("Music is already playing.");
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Pausing music...");
        player.setState(new PausedState());
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Stopping music...");
        player.setState(new StoppedState());
    }
}

class PausedState implements State {

    @Override
    public void play(MediaPlayer player) {
        System.out.println("Resuming music...");
        player.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Music is already paused.");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Stopping music...");
        player.setState(new StoppedState());
    }
}

// ================= Context =================

class MediaPlayer {

    private State currentState;

    public MediaPlayer() {
        currentState = new StoppedState();
    }

    public void setState(State state) {
        currentState = state;
    }

    public void play() {
        currentState.play(this);
    }

    public void pause() {
        currentState.pause(this);
    }

    public void stop() {
        currentState.stop(this);
    }
}

public class StatePatternDemo {

    public static void main(String[] args) {

        MediaPlayer player = new MediaPlayer();

        player.play();
        player.pause();
        player.play();
        player.stop();
        player.pause();
    }
}