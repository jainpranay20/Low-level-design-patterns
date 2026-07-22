package Day1.SnakeAndLadder;

import java.util.Random;

public class Dice {

    private final int faces = 6;

    private final Random random = new Random();

    int roll(){
        return random.nextInt(faces) + 1;
    }
}
