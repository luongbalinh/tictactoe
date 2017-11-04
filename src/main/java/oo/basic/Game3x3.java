package oo.basic;

import java.util.Scanner;
import oo.GameState;
import oo.Seed;

public class Game3x3 {

    private static Scanner in = new Scanner(System.in);
    private Board3x3 board;
    private GameState currentState;
    private Seed currentPlayer;

    public Game3x3() {
        board = new Board3x3();
        currentPlayer = Seed.CROSS;
        currentState = GameState.PLAYING;
    }

    public void start() {
        do {
            playerMove(currentPlayer);
            board.show();
            updateGame(currentPlayer);
            notifyIfGameFinished();
            switchPlayer();
        } while (currentState == GameState.PLAYING);
    }

    private void playerMove(Seed seed) {
        while (true) {
            requestMove(seed);

            int row = in.nextInt() - 1;
            int col = in.nextInt() - 1;

            if (isSelectedCellValid(row, col)) {
                updateBoard(row, col, seed);
                break;
            } else {
                System.out.println("This move at (" + (row + 1) + "," + (col + 1) + ") is not valid. Try again...");
            }
        }
    }

    private void requestMove(Seed seed) {
        if (seed == Seed.CROSS) {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
        } else {
            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
        }
    }

    private boolean isSelectedCellValid(int row, int col) {
        return row >= 0 && row < Board3x3.ROWS && col >= 0 && col < Board3x3.COLS && board.cells[row][col].getSeed() == Seed.EMPTY;
    }

    private void updateBoard(int row, int col, Seed seed) {
        board.currentRow = row;
        board.currentCol = col;
        board.cells[row][col].setSeed(seed);
    }

    private void updateGame(Seed seed) {
        if (board.isWon(seed)) {
            currentState = (seed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
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