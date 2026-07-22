package Day2.TicTacToe;

public class Game {
    private final Board board;
    private final Player[] players;
    private int currentPlayerIndex;
    private GameStatus status;
    private int movesPlayed;

    public Game(int size, Player player1, Player player2) {
        this.board = new Board(size);
        this.players = new Player[]{player1, player2};
        this.currentPlayerIndex = 0;
        this.status = GameStatus.IN_PROGRESS;
        this.movesPlayed = 0;
    }

    public void play(int row, int col) {

        if (status != GameStatus.IN_PROGRESS) {
            System.out.println("Game already finished!");
            return;
        }

        Player currentPlayer = players[currentPlayerIndex];
        Move move = new Move(row, col, currentPlayer);

        boolean placed = board.placeMove(move);

        if (!placed) {
            System.out.println("Invalid move. Try again.");
            return;
        }

        movesPlayed++;
        board.printBoard();

        if (board.checkWinner(move)) {
            status = GameStatus.WIN;
            System.out.println(currentPlayer.getName() + " wins!");
            return;
        }

        if (movesPlayed == board.getSize() * board.getSize()) {
            status = GameStatus.DRAW;
            System.out.println("Game is a Draw!");
            return;
        }

        // Switch Player
        currentPlayerIndex = 1 - currentPlayerIndex;
    }

    public GameStatus getStatus() {
        return status;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }
}
