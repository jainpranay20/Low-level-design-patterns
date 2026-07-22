package Day1.SnakeAndLadder;

public class Player {

    private String name;

    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    int move(int steps){
        return position = position + steps;
    }
    int getPosition(){
        return position;
    }
    void setPosition(int position){
        this.position = position;
    }

    String getName(){
        return name;
    }


}
