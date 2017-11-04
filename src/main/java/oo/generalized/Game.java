package oo.generalized;

import java.util.Scanner;
import oo.Cell;
import oo.GameState;
import oo.Seed;

public class Game {

    private static Scanner in = new Scanner(System.in);
    private Board board;
    private GameState currentState;
    private Seed currentPlayer;
    private int rows;
    private int cols;

    public void start() {
        init();
        do {
            Cell nextCell = playerMove(currentPlayer);
            board.show();
            updateGame(nextCell);
            notifyIfGameFinished();
            switchPlayer();
        } while (currentState == GameState.PLAYING);
    }

    private void init() {
        System.out.println("Enter board size and win condition: m n k: ");
        rows = in.nextInt();
        cols = in.nextInt();
        int winLength = in.nextInt();
        board = new Board(rows, cols, winLength);
        currentPlayer = Seed.CROSS;
        currentState = GameState.PLAYING;
    }

    private Cell playerMove(Seed seed) {
        while (true) {
            requestMove(seed);

            int row = in.nextInt() - 1;
            int col = in.nextInt() - 1;
            Cell nextCell = new Cell(row, col, seed);
            if (isMoveValid(row, col)) {
                updateBoard(row, col, seed);
                return nextCell;
            } else {
                System.out.println("This move at (" + (row + 1) + "," + (col + 1) + ") is not valid. Try again...");
            }
        }
    }

    private void requestMove(Seed seed) {
        if (seed == Seed.CROSS) {
            System.out.print("Player 'X', enter your move: ");
        } else {
            System.out.print("Player 'O', enter your move: ");
        }
    }

    private boolean isMoveValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols && board.getCells()[row][col].getSeed() == Seed.EMPTY;
    }

    private void updateBoard(int row, int col, Seed seed) {
        board.getCells()[row][col].setSeed(seed);
    }

    private void updateGame(Cell cell) {
        if (board.isWon(cell)) {
            currentState = (cell.getSeed() == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
        } else if (board.isDraw()) {
            currentState = GameState.DRAW;
        }
    }

    private void notifyIfGameFinished() {
        if (currentState == GameState.CROSS_WON) {
            System.out.println("'X' won! Bye!");
        } else if (currentState == GameState.NOUGHT_WON) {
            System.out.println("'O' won! Bye!");
        } else if (currentState == GameState.DRAW) {
            System.out.println("It's Draw! Bye!");
        }
    }

    private void switchPlayer() {
        if (currentState == GameState.PLAYING) {
            currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
        }
    }
}