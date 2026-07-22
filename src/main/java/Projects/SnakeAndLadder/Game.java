package Day1.SnakeAndLadder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Game {

    private final Board board;
    private final Dice dice;
    private final Queue<Player> playersQueue;
    private boolean gameOver;

    public Game(List<Player> playerNames) {
        this.board = new Board();
        this.dice = new Dice();
        this.playersQueue = new LinkedList<>();
        this.gameOver = false;

        // Add players to queue
        playersQueue.addAll(playerNames);
    }

    public void start() {
        System.out.println("🎲 Game Started! 🎲");
        System.out.println("Players in order: " + playersQueue);

        while (!isGameOver()) {
            Player currentPlayer = getCurrentPlayer();
            boolean won = playTurn(currentPlayer);

            if (won) {
                announceWinner(currentPlayer);
                gameOver = true;
            } else {
                nextPlayer();
            }
        }
    }

    private boolean playTurn(Player player) {
        System.out.println("\n--- " + player.getName() + "'s turn ---");
        System.out.println(player.getName() + " is at position " + player.getPosition());

        int roll = dice.roll();
        System.out.println(player.getName() + " rolled " + roll);

        int newPosition = player.getPosition() + roll;

        // Check if move is valid (not beyond board)
        if (!board.isValidMove(newPosition)) {
            System.out.println("❌ " + roll + " is too high! Need exact number to win.");
            System.out.println(player.getName() + " stays at " + player.getPosition());
            return false;
        }

        // Check for snakes or ladders
        int finalPosition = board.getFinalPosition(newPosition);

        // Detect if it was a snake or ladder
        if (finalPosition < newPosition) {
            System.out.println("🐍 Oh no! Snake bit you! Slid down from " + newPosition + " to " + finalPosition);
        } else if (finalPosition > newPosition) {
            System.out.println("🪜 Yay! Ladder climbed from " + newPosition + " to " + finalPosition);
        } else {
            System.out.println("➡️ Moved to " + finalPosition);
        }

        player.setPosition(finalPosition);

        // Check win condition
        if (board.hasWon(finalPosition)) {
            return true;
        }

        return false;
    }
    private void nextPlayer() {
        // Move current player to back of queue
        Player currentPlayer = playersQueue.poll();
        if (currentPlayer != null) {
            playersQueue.add(currentPlayer);
        }
    }

    private boolean isGameOver() {
        return gameOver;
    }

    private Player getCurrentPlayer() {
        return playersQueue.peek();
    }

    private void announceWinner(Player player) {
        System.out.println("\n🏆🏆🏆 " + player.getName() + " WON THE GAME! 🏆🏆🏆");
        System.out.println("Final position: " + player.getPosition());
    }

    // Optional: Method to get game status
    public void displayGameStatus() {
        System.out.println("\n📊 Game Status:");
        System.out.println("Game Over: " + gameOver);
        System.out.println("Next player: " + (playersQueue.peek() != null ? playersQueue.peek().getName() : "None"));
        System.out.println("Players waiting: " + playersQueue.size());
    }
}