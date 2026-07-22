package Day2.TicTacToe;

public class Board {
    private final int size;
    private final Symbol[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Symbol[size][size];
    }

    public int getSize() {
        return size;
    }

    public boolean placeMove(Move move) {
        int row = move.getRow();
        int col = move.getCol();

        if (row < 0 || col < 0 || row >= size || col >= size) {
            return false;
        }

        if (grid[row][col] != null) {
            return false;
        }

        grid[row][col] = move.getPlayer().getSymbol();
            return true;
    }

    public boolean checkWinner(Move move) {
        int row = move.getRow();
        int col = move.getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        boolean win;

        // Check Row
        win = true;
        for (int i = 0; i < size; i++) {
            if (grid[row][i] != symbol) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check Column
        win = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][col] != symbol) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check Main Diagonal
        if (row == col) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (grid[i][i] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check Anti-Diagonal
        if (row + col == size - 1) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (grid[i][size - i - 1] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        return false;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
