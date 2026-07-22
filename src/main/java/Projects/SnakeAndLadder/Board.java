package Day1.SnakeAndLadder;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private final int size = 100;

    private final Map<Integer, Integer> snakesAndLadders = new HashMap<>();

    Board(){
        snakesAndLadders.put(2, 38);
        snakesAndLadders.put(7, 14);
        snakesAndLadders.put(8, 31);

        // Snakes
        snakesAndLadders.put(16, 6);
        snakesAndLadders.put(49, 11);
        snakesAndLadders.put(62, 19);

    }
    int getFinalPosition(int position){
        return snakesAndLadders.getOrDefault(position, position);
    }

    boolean isValidMove(int position){
        return position<=size;
    }

    boolean hasWon(int position){
        return position == size;
    }
}
