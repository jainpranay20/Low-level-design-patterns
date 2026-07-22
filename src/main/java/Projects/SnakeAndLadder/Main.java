package Day1.SnakeAndLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("ALICE");
        Player player12= new Player("BOB");

        List<Player> players = Arrays.asList(player1,player12);
        Game game = new Game(players);
        game.start();
    }
}