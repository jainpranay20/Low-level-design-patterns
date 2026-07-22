package Day2.TicTacToe;

import java.util.Scanner;

public class TicTacToeApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Player player1 = new Player("Player1", Symbol.X);
        Player player2 = new Player("Player2", Symbol.O);

        Game game = new Game(3, player1, player2);

        while (game.getStatus() == GameStatus.IN_PROGRESS) {

            Player current = game.getCurrentPlayer();
            System.out.println(current.getName() + "'s turn (" + current.getSymbol() + ")");

            System.out.print("Enter row: ");
            int row = scanner.nextInt();

            System.out.print("Enter col: ");
            int col = scanner.nextInt();

            game.play(row, col);
        }

        scanner.close();
    }
}
